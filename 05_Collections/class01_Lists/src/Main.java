
 record Students(String name, int age, List<Double> notes) implements Comparable<Students> {
    @Override
    public int compareTo(Students students) {
        return this.name.compareToIgnoreCase(students.name);
    }

     @Override
     public String toString() {
         return "{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 ", notes=" + notes +
                 '}';
     }
 }

class compareStudentsAge implements Comparator<Students>{

    @Override
    public int compare(Students s1, Students s2) {
        return Integer.compare(s1.age, s2.age);
    }
}

void main() {
    //creating the list
    List<Students> myClass = new ArrayList<>() {{
        add(new Students("Felipe", 19, new ArrayList<>(List.of(8d, 8.8, 5.8, 6d))));
        add(new Students("Victor", 20, new ArrayList<>(List.of(6d, 4.8, 7.8, 3d))));
        add(new Students("Nathan", 23, new ArrayList<>(List.of(10d, 6.8, 5.8, 10d))));
        add(new Students("Guilherme", 25, new ArrayList<>(List.of(7.6, 8.8, 8.8, 5d))));
        add(new Students("Hiro", 22, new ArrayList<>(List.of(4.6, 7.8, 7.6, 7d))));
    }};

    //Getting the first student
    Students firstStudent = myClass.getFirst();

    //adding a new note adding a new note from the first student
    firstStudent.notes.add(10d); // add a new value in the list
    System.out.printf("\nadding %.2f to %s", firstStudent.notes.getLast(), firstStudent.name);

    //removing note from the first student
    System.out.printf("\nremoving: %.2f", myClass.getFirst().notes.remove(2));

    for(Students student : myClass){
        System.out.printf("\n----------- %s -----------",  student.name.toUpperCase());

        //Showing the lowest note
        System.out.printf("\nlowest note: %.2f",Collections.min(myClass.getFirst().notes));

        //Showing the highest note
        System.out.printf("\nhighest note: %.2f",Collections.max(myClass.getFirst().notes));

        //showing the seconde position
        System.out.printf("\nshowing the seconde position: %.2f", student.notes.get(1));

        //showing the sum of notes
        Iterator<Double> iterator = student.notes.iterator();
        Double sum = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            sum += next;
        }
        System.out.printf("\nsum all notes: %.2f", sum);

        //media
        System.out.printf("\tmedia: %.2f", sum / student.notes.size());

    }

    System.out.println("\n\n");
    //Showing all Students in insertion order
    System.out.println(myClass.toString());

    //Showing all Students in random order
    Collections.shuffle(myClass);
    System.out.println(myClass.toString());

    //Showing all Students in normal order (name)
    Collections.sort(myClass);
    System.out.println(myClass.toString());

    //Showing all Students in age order
    // Collections.sort(myClass, new compareStudentsAge());  //<- this is a old option
    myClass.sort(new compareStudentsAge());
    System.out.println(myClass.toString());

}
