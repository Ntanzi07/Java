record Users(String email, String name, Double height) implements Comparable<Users>{
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(email, users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() {
        return "{'" + name + "', " +
                "\'" + email + "', " +
                "\'" + height + "'}";
    }

    @Override
    public int compareTo(Users user) {
        int nameCmp = this.name.compareToIgnoreCase(user.name);
        if(nameCmp != 0)
            return nameCmp;
        return Double.compare(this.height, user.height);
    }
}

void main() {

    //Creating a hashSet
    Set<Users> users = new HashSet<>() {{
        add(new Users("Isabela@gmail.com", "Isabela", 1.60));
        add(new Users("nathan@gmail.com", "Nathan", 1.80));
        add(new Users("Otavio@gmail.com", "Otavio", 1.76));
        add(new Users("nathanteste@gmail.com", "Nathan", 1.8));
    }};
    System.out.println(users);

    //media of the heights
    Iterator<Users> iterator = users.iterator();
    Double sum = 0d;
    while (iterator.hasNext()){
        sum += iterator.next().height;
    }
    System.out.printf("\nthe media of the heights is: %.2f", sum/users.size());

    //the lowest value comparing height
    Users min = Collections.min(users, Comparator.comparing(Users::height));
    System.out.printf("\nThe smallest is: %s", min.toString());

    //the highest value comparing height
    Users max = Collections.min(users, Comparator.comparing(Users::height));
    System.out.printf("\nThe smallest is: %s", max.toString());

    System.out.printf("\n");
    //Showing in the random order
    System.out.println(users);

    //Showing in the insertion order
    Set<Users> users2 = new LinkedHashSet<>() {{
        add(new Users("Isabela@gmail.com", "Isabela", 1.60));
        add(new Users("nathan@gmail.com", "Nathan", 1.80));
        add(new Users("Otavio@gmail.com", "Otavio", 1.76));
        add(new Users("nathanteste@gmail.com", "Nathan", 1.8));
    }};
    System.out.println(users2);

    //Showing in the height order
    Set<Users> users3 = new TreeSet<>() {{
        add(new Users("Isabela@gmail.com", "Isabela", 1.60));
        add(new Users("nathan@gmail.com", "Nathan", 1.8));
        add(new Users("Otavio@gmail.com", "Otavio", 1.76));
        add(new Users("nathanteste@gmail.com", "Nathan", 1.82));
    }};
    System.out.println(users3);
}
