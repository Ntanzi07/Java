import interfaces.lists.List;
import utils.lists.DoubleLinkedList;
import utils.lists.LinkedList;

record TestCase(String name, Runnable action) {}

void main() {
    long[] linked = testeList(new LinkedList<>(), 100);
    long[] doubleLinked = testeList(new DoubleLinkedList<>(), 100);
    TestCase[] tests = createTests(new LinkedList<>());

    System.out.printf("\n%s%s%s|\n"," ".repeat(32 - 6), "Average time", " ".repeat(32 - 6));
    System.out.printf("%-15s|%-10s   |%-15s   |%-15s|\n", "Method", "Linked", "DoubleLinked", "result");
    System.out.printf("%s|\n", "-".repeat(64));
    for (int i = 0; i < linked.length; i++) {
        String fasted = linked[i] < doubleLinked[i] ? "linked" : "doubleLinked";
        System.out.printf("%-15s|%-10sns |%-15sns |%-15s|\n",tests[i].name, linked[i], doubleLinked[i], fasted);
    }
    System.out.printf("%s|\n", "-".repeat(64));
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
            new TestCase("toArray", list::toArray),
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