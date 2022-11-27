# hibernate-java

## Getting started
Every task and test for it are created in its own package.

## Zadanie domowe 1:
Na wzór aplikacji z zajęć stwórz własną aplikację.

### Przygotowanie projektu:
 * stwórz projekt maven'owy 
 * dodaj do niego gitignore 
 * stwórz repozytorium

### Konfiguracja hibernate:
  * dodaj dependencje do projektu (pom.xml)
  * dodaj plik konfiguracyjny (baza danych powinna nazywać się: zad_dom_pojazd)
  * dodaj plik hibernate util 
  * dodaj model (snippet z opisem modelu):
    * Model "Pojazd":
      - marka
      - moc (double)
      - kolor
      - rok produkcji (nie data!)
      - elektryczny (boolean!)
  * nie zapomnij dodać wpisu "mapping" w pliku konfiguracyjnym hibernate.cfg.xml

### Main 
Stwórz main'a, a w nim zadaj pytania o to co chce zrobić użytkownik:
 * co chcesz zrobić? 
   * dodaj 
   * podaj markę 
   * podaj moc 
   * podaj kolor 
   * podaj rok produkcji (musi być między 1990-2020)
   * czy jest elektryczny 
   * lista
   * (wyświetl listę wszystkich samochodów)
   * szukaj 
   * podaj identyfikator szukanego pojazdu
   * (wyświetl pojazd o podanym id)
   * usun 
   * podaj identyfikator usuwanego pojazdu 
   * jeśli pojazd istnieje napisz komunikat o usunięciu po usunięciu 
   * jeśli pojazd nie istnieje wyświetl komunikat o błędzie z powodu nie istnienia pojazdu 
   * aktualizuj:
   * podaj identyfikator szukanego pojazdu 
   * podaj markę 
   * podaj moc 
   * podaj kolor 
   * podaj rok produkcji (musi być między 1990-2020)
   * czy jest elektryczny
