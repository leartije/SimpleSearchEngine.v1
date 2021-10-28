package search;

public class Menus {

    static void menu() {
        System.out.println("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all persons\n" +
                "0. Exit");
    }

    static void select() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
    }

    static void subMenu() {
        System.out.println("Enter a name or email to search all suitable people.");
    }
}
