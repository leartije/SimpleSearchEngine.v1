package search;

public class Main {
    public static void main(String[] args) {


        InvertedIndex index = new InvertedIndex(args);
        UserMenu userMenu = new UserMenu(index);
        userMenu.menu();

    }


}
