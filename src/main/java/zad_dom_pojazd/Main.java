package zad_dom_pojazd;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Predicate<String> checkCommandDB = (rawUserResponse)
                    -> rawUserResponse.length() == 1
                    && "avsdu".contains(rawUserResponse.toLowerCase());

            String respons = TerminalUserInterface.getResponse("Podaj komende:" +
                    "a - add, v - view list, s - search, d - delete, u - update: ", checkCommandDB);



            if (respons.equals("a")){
                PojazdRepository.persist(getPojazdData());
            }
            if (respons.equals("v")){
                PojazdRepository.view();
            }
            if (respons.equals("s")){
                PojazdRepository.search(getId());
            }
            if (respons.equals("d")){

                PojazdRepository.del(getId());
            }
            if (respons.equals("u")){
                Pojazd pojazd = getPojazdData();
                pojazd.setId(getId());
                PojazdRepository.merge(pojazd);
            }
        }
    }

    private static Pojazd getPojazdData() {

        Predicate<String> checkCommandDB = (rawUserResponse) -> true;
        String marka = TerminalUserInterface.getResponse("Podaj markę: ", checkCommandDB);
        String kolor = TerminalUserInterface.getResponse("Podaj kolor: ", checkCommandDB);

        checkCommandDB = (rawUserResponse) -> {
            try {
                Double.parseDouble(rawUserResponse);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        String moc = TerminalUserInterface.getResponse("Podaj moc: ", checkCommandDB);

        checkCommandDB = (rawUserResponse) -> {
            try {
                int rokPojazdu = Integer.parseInt(rawUserResponse);
                return rokPojazdu >= 1990 && rokPojazdu <= 2020;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        String rokProdukcji = TerminalUserInterface.getResponse("Podaj rok produkcji: ", checkCommandDB);


        checkCommandDB = (rawUserResponse) ->
                rawUserResponse
                        .equalsIgnoreCase("true")
                        || rawUserResponse
                        .equalsIgnoreCase("false");
        String czyElektryk = TerminalUserInterface.getResponse("Podaj informację czy samochód jest elektryczny: ",
                checkCommandDB);

        return Pojazd.builder()
                .marka(marka)
                .kolor(kolor)
                .moc(Double.parseDouble(moc))
                .rokProdukcji(Integer.parseInt(rokProdukcji))
                .elektryczny(Boolean.parseBoolean(czyElektryk))
                .build();
    }

    private static long getId(){

        Predicate<String> checkCommandDB = (rawUserResponse) -> {
            try {
                int idPojazdu = Integer.parseInt(rawUserResponse);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        String respons = TerminalUserInterface.getResponse("Podaj id pojazdu:", checkCommandDB);
        return Long.parseLong(respons);
    }

}

