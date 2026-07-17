void main(String[] args) {
    List<String> randomNumbers = Arrays.asList("1", "0", "2", "2", "7", "8", "9", "5", "5");

    System.out.println("Printing all numbers in the array: ");
    randomNumbers.forEach(System.out::println);

    System.out.println("\nPutting all numbers in a set: ");
    randomNumbers.stream()
            .limit(5)
            .collect(Collectors.toSet())
            .forEach(System.out::println);

    System.out.println("\nTransforming the list strings in numbers");
    randomNumbers
            .stream()
            .mapToInt(Integer::valueOf)
            .forEach(System.out::println);

    System.out.println("\nGet even numbers higher than 2 and add it into a List");
    List<Integer> higherThan2 = randomNumbers.stream()
            .map(Integer::valueOf)
            .filter((a) -> a%2 == 0 && a > 2)
            .toList();
    higherThan2.forEach(System.out::println);

    System.out.println("\nShow the average of these numbers");
    randomNumbers.stream()
            .mapToInt(Integer::valueOf)
            .average()
            .ifPresent(System.out::println);

    randomNumbers.stream()
            .mapToInt(Integer::valueOf)
            .filter(a -> a%2 == 0)
            .forEach(System.out::println);

}

