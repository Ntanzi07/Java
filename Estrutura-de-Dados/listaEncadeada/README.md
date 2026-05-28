# Linked List

The propose of this project is the implementation of a **Singly Linked List** (`LinkedList`) and a **Doubly Linked List** (`DoubleLinkedList`), with a *benchmark* that compares the average execution time of the operations of both structures.

## Project structure

```
src/
├── Main.java                       # Comparative benchmark
├── interfaces/
│   ├── lists/List.java             # Common list contract
│   └── nodes/
│       ├── Node.java               # Single node
│       └── DoubleNode.java         # Double node
└── utils/
    ├── lists/
    │   ├── LinkedList.java         # Singly linked implementation
    │   └── DoubleLinkedList.java   # Doubly linked implementation
    ├── nodes/
    │   ├── LNode.java
    │   └── DLNode.java
    └── verifications/
        └── Verifications.java      # Index validation
```

## `List<T>` interface

| Method              | Description                              |
|---------------------|------------------------------------------|
| `add(T value)`      | Inserts a value at the end of the list   |
| `get(int index)`    | Returns the value at the given position  |
| `getFirst()`        | Returns the first value                  |
| `getLast()`         | Returns the last value                   |
| `remove(int index)` | Removes the element at the given index   |
| `clear()`           | Empties the list                         |
| `size()`            | Returns the current size                 |
| `isEmpty()`         | Indicates whether the list is empty      |
| `toArray()`         | Converts the list into an array          |

## How to run

From the project root:

```bash
javac -d out --source 21 --enable-preview $(find src -name "*.java")
java --enable-preview -cp out Main
```

## Benchmark output

`Main` runs each operation 100 times on each implementation and prints the average time (in nanoseconds), as well as which structure was faster for each method:

```
                      Average time                           |
Method         |Linked       |DoubleLinked   |result         |
-------------------------------------------------------------|
add            |...       ns |...         ns |...            |
getFirst       |...       ns |...         ns |...            |
getLast        |...       ns |...         ns |...            |
get(meio)      |...       ns |...         ns |...            |
size           |...       ns |...         ns |...            |
isEmpty        |...       ns |...         ns |...            |
toArray        |...       ns |...         ns |...            |
toString       |...       ns |...         ns |...            |
removeLast     |...       ns |...         ns |...            |
clear          |...       ns |...         ns |...            |
-------------------------------------------------------------|
```
