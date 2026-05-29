# Stacks

The proposal of this project is the implementation of a **Stack** (LIFO *Last In, First Out*) backed by a singly linked structure (`LinkedStack`), with a small *benchmark* that measures the execution time of each operation.

## Project structure

```
src/
├── Main.java                   # Benchmark
├── interfaces/
│   ├── Stack.java              # Stack contract
│   └── Node.java               # Node contract
└── utils/
    ├── LinkedStack.java        # Linked stack implementation
    └── LinkedNode.java         # Linked node implementation
```

## `Stack<T>` interface

| Method           | Description                                      |
|------------------|--------------------------------------------------|
| `push(T value)`  | Inserts a value at the top of the stack          |
| `pop()`          | Removes and returns the value at the top         |
| `peek()`         | Returns the value at the top without removing it |
| `isEmpty()`      | Indicates whether the stack is empty             |
| `size()`         | Returns the current size                         |

## How to run

From the project root:

```bash
javac -d out --source 21 --enable-preview $(find src -name "*.java")
java --enable-preview -cp out Main
```

## Benchmark output

`Main` pushes 10000 elements, queries the top, checks the size, and then pops all 10000 elements, printing the elapsed time (in nanoseconds) for each operation:

```
Method         |Stack (ns)     |
---------------|---------------|
push 10000     |...         ns |
peek           |...         ns |
isEmpty        |...         ns |
size           |...         ns |
pop 10000      |...         ns |
```
