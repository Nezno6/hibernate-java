package zad_dom_pojazd;

import java.util.Scanner;
import java.util.function.Predicate;

public class TerminalUserInterface {

    public static String getResponse(String question, Predicate<String> checkCommandDB) {
        Scanner scanner = new Scanner(System.in);
        String fromUser;
        do {
            System.out.println(question);
            fromUser = scanner.nextLine();
        }while(!checkCommandDB.test(fromUser));
        return fromUser;
    }
}
