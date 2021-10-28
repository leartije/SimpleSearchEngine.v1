package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class InvertedIndex {


    protected Map<String, ArrayList<Integer>> wordIndexing;
    protected Map<Integer, String> fullLines;
    protected ArrayList<Integer> index;
    protected File source;

    public InvertedIndex(String[] args) {

        this.wordIndexing = new TreeMap<>();
        this.fullLines = new TreeMap<>();
        this.index = new ArrayList<>();

        if ("--data".equals(args[0])) {
            this.source = new File(args[1]);
            invertedIndex();
        }
    }


    protected void invertedIndex() {

        int numOfLine = 0;

        try(Scanner scanner = new Scanner(this.source)) {

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] splitLine = line.split("\\s");

                for (var currentWord : splitLine) {
                    for (var compare : this.wordIndexing.entrySet()) {
                        if (currentWord.equalsIgnoreCase(compare.getKey())) {
                            this.index.addAll(compare.getValue());
                            this.wordIndexing.put(currentWord.toLowerCase(Locale.ROOT), this.index);
                            this.fullLines.put(numOfLine, line);

                        }
                    }

                    this.index.add(numOfLine);
                    this.wordIndexing.put(currentWord.toLowerCase(Locale.ROOT), this.index);
                    this.fullLines.put(numOfLine, line);
                    this.index = new ArrayList<>();

                }

                numOfLine++;

            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }


    protected void printAll() {

        System.out.println(this.fullLines.size() + " persons found:");
        for (var s : this.fullLines.values()) {
            System.out.println(s);
        }
    }

}
