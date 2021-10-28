package search;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FindAny implements FindPeople {


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

        if (index.size() != 0) {
            System.out.println(index.size() + " persons found:");
            for (var i : index) {
                System.out.println(data.fullLines.get(i));
            }
        } else {
            System.out.println("Nothing has found");
        }

    }
}
