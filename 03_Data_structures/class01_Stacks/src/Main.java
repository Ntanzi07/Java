import interfaces.Stack;
import utils.LinkedStack;

record TestStructure(String name, Runnable action) {
}

void main() {
    TestStructure[] testes = getTestStructures();

    System.out.printf("%-15s|%-15s|\n", "Method", "Stack (ns)");
    System.out.printf("%s|%s|\n", "-".repeat(15), "-".repeat(15));
    for (TestStructure test : testes) {
        long start = System.nanoTime();
        test.action.run();
        long end = System.nanoTime();

        long elapsed = end - start;
        String elapsedStr = String.valueOf(elapsed);
        elapsedStr = String.format("%s%sns", String.valueOf(elapsed), " ".repeat(13 - elapsedStr.length()));

        System.out.printf("%-15s|%-15s|\n", test.name, elapsedStr);
    }
}

private static TestStructure[] getTestStructures() {
    Stack<Integer> stack = new LinkedStack<>();
    TestStructure[] testes = {
            new TestStructure("push 10000", () -> {
                for (int i = 0; i < 10000; i++) {
                    stack.push(i);
                }
            }),
            new TestStructure("peek", stack::peek),
            new TestStructure("isEmpty", stack::isEmpty),
            new TestStructure("size", stack::size),
            new TestStructure("pop 10000", () -> {
                for (int i = 0; i < 10000; i++) {
                    stack.pop();
                }
            }),
    };
    return testes;
}

