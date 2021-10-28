package search;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckInput {


    public static Scanner scanner = new Scanner(System.in);

    public static int checkNum() {

        int option = -1;

        while (true) {


            try {

                option = Integer.parseInt(scanner.next());
                break;


            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Try: 1, 2 or 0");
            }
        }

        return option;

    }


}
