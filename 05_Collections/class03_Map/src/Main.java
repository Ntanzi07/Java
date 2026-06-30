void main() {
    Map<Double, String> scores = new HashMap<>() {{
        put(40d, "NTZ");
        put(23d, "SKT");
        put(100d, "SKY");
        put(44d, "TPP");
    }};
    System.out.println(scores);

    //adding a new value
    scores.put(55.5, "NTZ");

    //showing the player with 40 points
    System.out.println(scores.get(40d));

    //showing all points
    Set<Double> scoresKeys = scores.keySet();
    System.out.println("all scores" + scoresKeys);

    //showing all players
    Collection<String> values = scores.values();
    System.out.println("all players" + values);

    //showing the highest score
    Double max = Collections.max(scores.keySet());
    System.out.println("highest score: " + max);

    //showing the lowest score
    Double min = Collections.min(scores.keySet());
    System.out.println("lowest score:" + min);

    //changing to Set
    Set<Map.Entry<Double, String>> entries = scores.entrySet();

    System.out.println("NTZ points:");
    scores.forEach((k, v) -> {
        if (v.compareToIgnoreCase("NTZ") == 0)
            System.out.println(k);
    });

    //score media
    Iterator<Double> iterator = scores.keySet().iterator();
    Double sum = 0d;
    while (iterator.hasNext()) {
        sum += iterator.next();
    }
    System.out.println("media: " + sum / scores.size());

    //showing in order by key
    Map<Double, String> scores1 = new TreeMap<>() {{
        put(40d, "NTZ");
        put(23d, "SKT");
        put(100d, "SKY");
        put(44d, "TPP");
    }};
    System.out.println(scores1);

    //showing in order by value
    Set<Map.Entry<Double, String>> scores2 = new TreeSet<>(new CompareName());
    scores2.addAll(scores.entrySet());
    System.out.println(scores2);

}

class CompareName implements Comparator<Map.Entry<Double, String>>{

    @Override
    public int compare(Map.Entry<Double, String> o1, Map.Entry<Double, String> o2) {
        return o1.getValue().compareToIgnoreCase(o2.getValue());
    }
}
