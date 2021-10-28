package search;

import java.util.*;

public class FindNone implements FindPeople {


    @Override
    public void findPeople(InvertedIndex data) {

        Scanner scanner = new Scanner(System.in);
        Set<Integer> index = new TreeSet<>();

        Menus.subMenu();
        String[] line = scanner.nextLine().split("\\s");

        for (var currentWord : line) {
            for (var compare : data.wordIndexing.entrySet()) {
                if (currentWord.equalsIgnoreCase(compare.getKey())) {
                    index.addAll(compare.getValue());
                }
            }
        }

        Map<Integer, String> copy = new TreeMap<>(data.fullLines);
        index.forEach(copy.keySet()::remove);

        int personsFound = data.fullLines.size() - index.size();

        if (index.size() != 0) {
            System.out.println(personsFound + " persons found:");
            for (var i : copy.values()) {
                System.out.println(i);
            }
        } else {
            System.out.println("Nothing has found");
        }

    }



}
