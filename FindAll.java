package search;

import java.util.*;

public class FindAll implements FindPeople {


    @Override
    public void findPeople(InvertedIndex data) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> index = new ArrayList<>();

        Menus.subMenu();
        String[] line = scanner.nextLine().split("\\s");

        for (var currentWord : line) {
            for (var compare : data.wordIndexing.entrySet()) {
                if (currentWord.equalsIgnoreCase(compare.getKey())) {
                    index.addAll(compare.getValue());
                }
            }
        }


        Collections.sort(index);

        int foundIt = -1;
        int count = 0;

        if (index.size() > 1) {

            for (int i = 0; i < index.size(); i++) {
                if (Objects.equals(index.get(i), index.get(i + 1 < index.size() ? i + 1 : 1))) {
                    foundIt = index.get(i);
                    count++;
                }
            }

        }

        if (line.length < 4 && count + 2 != line.length && line.length != 1) {

            System.out.println(data.fullLines.get(foundIt));

        } else {
            System.out.println("Nothing has found");
        }


    }
}
