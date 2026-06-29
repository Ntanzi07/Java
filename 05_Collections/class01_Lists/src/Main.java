void main() {
    //creating the list
    List<Double> notes = new ArrayList<>(List.of(8.6,7.5,5.8,7.43,3.0));


    //adding a new note
    notes.add(7.7); // add a new value in the list
    System.out.println("adding: " + notes);

    //getting the position
    System.out.println("position of 7.7: " + notes.indexOf(22));

    //removing note
    notes.remove(notes.indexOf(7.7)); // remove a new value in the list
    System.out.println("removing: " + notes);

    //replacing note
    notes.set(notes.indexOf(5.8), 8.5);
    System.out.println("replacing 5.8 to 8.5: " + notes);

    //showing the total size
    System.out.println("notes size: " + notes.size());

    // Printing all notes
    for (int i = 0; i < notes.size(); i++){
        System.out.println("showing the value of the index " + i + ": " + notes.get(i));
    }

    //
    System.out.println("lowest note: " + Collections.min(notes));

    //
    System.out.println("highest note: " + Collections.max(notes));

    //
    System.out.println("highest note: " + Collections.max(notes));


}
