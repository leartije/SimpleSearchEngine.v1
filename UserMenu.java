package search;

import java.util.Locale;
import java.util.Scanner;

public class UserMenu {


    private final InvertedIndex index;
    private final Scanner scanner;

    public UserMenu(InvertedIndex index) {
        this.index = index;
        this.scanner = new Scanner(System.in);

    }

    public void menu() {

        while (true) {

            Menus.menu();
            int options = CheckInput.checkNum();

            switch (options) {
                case 1:
                    Menus.select();
                    subMenu();
                    break;
                case 2:
                    index.printAll();
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
                    break;

            }
        }

    }

    public void subMenu() {

        String options = scanner.nextLine().toUpperCase(Locale.ROOT);

        switch (options) {
            case "ALL":
                FindPeople findPeople = new FindAll();
                findPeople.findPeople(index);
                break;
            case "ANY":
                findPeople = new FindAny();
                findPeople.findPeople(index);
                break;
            case "NONE":
                findPeople = new FindNone();
                findPeople.findPeople(index);
                break;
            default:
                System.out.println("Wrong input, try: ALL, ANY, NONE");
                break;
        }

    }



}
