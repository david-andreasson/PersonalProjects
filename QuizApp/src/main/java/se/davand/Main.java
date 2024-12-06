package se.davand;

import se.davand.database.QuizDatabase;
import se.davand.ui.MenuHandler;


public class Main {
    public static void main(String[] args) {


        //Ska vi spara frågorna i en databas?
        //isf kan jag utöka appen och lägga till nya frågor när vi går mer kurser
        //och i menyn skulle man kunna välja vilken kurs man vill quizza sig själv på.

        //Funktioner:
        // Läsa in frågor och svar från SQLite-databas.
        //Presentera frågor och svarsalternativ för användaren.
        //Ta emot användarens svar och jämföra det med det rätta svaret.
        //Visa antal rätt/felprocent efter varje fråga. (personligt val)

        //Todo - klass för meny
        //Todo - klass för frågor och svar
        //Todo - klass för logik
        //Todo - metod för att räkna ut felprocent

        QuizDatabase.connect();
        MenuHandler menuHandler = new MenuHandler();
        menuHandler.startMenu(); // Start the menu system

    }
}