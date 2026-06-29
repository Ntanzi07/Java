import interfaces.Tree;
import utils.AVLTree;
import utils.BinTree;

record TestCase(String name, Runnable action) {
}

void main() {
    long[] binTree = testeTree(new BinTree<>(), 100);
    long[] avlTree = testeTree(new AVLTree<>(), 100);
    TestCase[] tests = createTests(new AVLTree<>());

    printResults(tests, new String[]{"Binary Tree", "AVL Tree"}, binTree, avlTree);

}

private static TestCase[] createTests(Tree<Integer> tree) {
    final int theChosenNumber = 324;
    final int length = 1000;
    return new TestCase[]{
            new TestCase("add 1000", () -> {
                for (int i = 0; i < length; i++) {
                    Random rand = new Random();
                    tree.add(rand.nextInt(length * 10));
                }
            }),
            new TestCase(String.format("add %s", theChosenNumber), () -> {
                tree.add(theChosenNumber);
            }),
            new TestCase(String.format("searching %s after add", theChosenNumber), () -> {
                tree.contains(theChosenNumber);
            }),
            new TestCase(String.format("remove %s", theChosenNumber), () -> {
                tree.remove(theChosenNumber);
            }),
            new TestCase(String.format("searching %s after remove", theChosenNumber), () -> {
                tree.contains(theChosenNumber);
            }),
            new TestCase("inOrder", tree::inOrder),
            new TestCase("preOrder", tree::preOrder),
            new TestCase("postOrder", tree::postOrder),
            new TestCase("size", tree::size),
            new TestCase("isEmpty", tree::isEmpty),
            new TestCase("clear", tree::clear)
    };
}

long[] testeTree(Tree<Integer> treeType, int amount) {
    TestCase[] tests = createTests(treeType);

    long[] medians = new long[tests.length];
    long start;
    long end;

    for (int i = 0; i < tests.length; i++) {
        long result = 0;
        for (int j = 0; j < amount; j++) {
            start = System.nanoTime();
            tests[i].action().run();
            end = System.nanoTime();
            result += end - start;
        }
        medians[i] = result / amount;
    }
    return medians;
}

public static void printResults(TestCase[] tests, String[] labels, long[]... results) {
    if (labels.length != results.length) {
        throw new IllegalArgumentException("labels e results devem ter o mesmo tamanho");
    }

    int nameWidth = 27;
    int colWidth = 24;

    StringBuilder header = new StringBuilder();
    header.append(String.format("%-" + nameWidth + "s|", "Method"));
    for (String label : labels) {
        header.append(String.format("%-" + colWidth + "s |", label));
    }
    header.append(String.format("%-" + colWidth + "s|", "Fastest"));

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



