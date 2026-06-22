import interfaces.lists.List;
import utils.lists.CircularList;
import utils.lists.DoubleLinkedList;
import utils.lists.LinkedList;

record TestCase(String name, Runnable action) {}

void main() {
    long[] linked = testeList(new LinkedList<>(), 100);
    long[] doubleLinked = testeList(new DoubleLinkedList<>(), 100);
    long[] circularList = testeList(new CircularList<>(), 100);
    TestCase[] tests = createTests(new LinkedList<>());

    printResults(tests, new String[]{"Linked", "DoubleLinked", "Circular"}, linked, doubleLinked, circularList);
}

public static void printResults(TestCase[] tests, String[] labels, long[]... results) {
    if (labels.length != results.length) {
        throw new IllegalArgumentException("labels e results devem ter o mesmo tamanho");
    }

    int nameWidth = 16;
    int colWidth = 16;

    StringBuilder header = new StringBuilder();
    header.append(String.format("%-" + nameWidth + "s |", "Method"));
    for (String label : labels) {
        header.append(String.format("%-" + colWidth + "s |", label));
    }
    header.append(String.format("%-" + colWidth + "s |", "Fastest"));

    int totalWidth = header.length();
    int pad = Math.max((totalWidth - "Average time".length()) / 2, 0);

    System.out.printf("%n%s%s%s%n", " ".repeat(pad), "Average time", " ".repeat(pad));
    System.out.println(header);
    System.out.println("-".repeat(totalWidth));

    for (int i = 0; i < tests.length; i++) {
        StringBuilder row = new StringBuilder();
        row.append(String.format("%-" + nameWidth + "s|", tests[i].name));

        long min = Long.MAX_VALUE;
        String fastest = "";

        for (int c = 0; c < results.length; c++) {
            long value = results[c][i];
            row.append(String.format("%-" + (colWidth - 2) + "sns |", value));
            if (value < min) {
                min = value;
                fastest = labels[c];
            }
        }

        row.append(String.format("%-" + colWidth + "s|", fastest));
        System.out.println(row);
    }

    System.out.println("-".repeat(totalWidth));
}

private static TestCase[] createTests(List<Integer> list) {
    return new TestCase[]{
            new TestCase("add", () -> {
                for (int i = 0; i < 10000; i++) {
                    list.add(i);
                }
            }),

            new TestCase("getFirst", list::getFirst),
            new TestCase("getLast", list::getLast),
            new TestCase("get(meio)", () -> list.get(list.size()/2)),
            new TestCase("size", list::size),
            new TestCase("isEmpty", list::isEmpty),
           // new TestCase("toArray", list::toArray),
            new TestCase("toString", list::toString),
            new TestCase("removeLast", () -> list.remove(list.size() - 1)),
            new TestCase("clear", list::clear)
    };
}


long[] testeList(List<Integer> listType, int amount) {
    List<Integer> list = listType;
    TestCase[] tests = createTests(listType);

    long[] medians = new long[tests.length];
    long start;
    long end;

    for (int i = 0; i < tests.length; i++) {
        long result = 0;
        for(int j = 0 ; j < amount; j++){
            start = System.nanoTime();
            tests[i].action().run();
            end = System.nanoTime();
            result += end - start;
        }
        medians[i] = result/amount;
    }

    return medians;
}