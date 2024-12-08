# QuizApp

## Översikt

**QuizApp** är ett Java-baserat konsolprojekt designat för att hjälpa mig och mina klasskamrater att öva på frågor inför tentor. Applikationen innehåller flervalsfrågor från olika kurser och låter användaren välja en kurs, ställa frågor i olika ordningar (sekventiellt, slumpmässigt eller omvänt) samt hålla koll på rätt svar och felprocent.

Projektet är byggt för att förbättra vår förståelse av kursmaterialet och göra studierna mer interaktiva.

---

## Funktionalitet

- **Välj kurs:** Användaren kan välja mellan olika kurser att quizza sig i.
- **Frågeordning:** Ställ frågor i nummerordning, slumpmässig ordning eller omvänd ordning.
- **Svara på frågor:** Svara på flervalsfrågor och få omedelbar feedback.
- **Statistik:** Programmet visar antal rätta svar och aktuell felprocent efter varje fråga.

---

## Projektstruktur

```bash
QuizApp
├── src  
│   ├── main  
│   │   ├── java  
│   │   │   └── se  
│   │   │       └── davand  
│   │   │           ├── Main.java               # Startpunkt för applikationen  
│   │   │           ├── database                # Databasanslutning och frågehämtning  
│   │   │           │   └── QuizDatabase.java  
│   │   │           ├── models                  # Dataobjekt för frågor  
│   │   │           │   └── Question.java  
│   │   │           ├── services                # Tjänstklass för quizlogik  
│   │   │           │   └── QuizService.java  
│   │   │           └── ui                      # Användargränssnitt och menyhantering  
│   │   │               ├── MenuHandler.java  
│   │   │               └── InputHandler.java  
├── data  
│   └── quiz.db                                 # SQLite-databas med frågor  
└── README.md
```

---

## Installation

Klona projektet från GitHub:

```bash
git clone https://github.com/david-andreasson/QuizApp.git
```

Importera projektet i ditt IDE (t.ex. IntelliJ IDEA).

Se till att du har följande installerat:

- **Java 21** eller senare
- **SQLite JDBC-drivrutin** (finns med som Maven-dependency)

Bygg projektet med Maven:

```bash
mvn clean compile
```

---

## Att köra projektet

Kör **Main.java** från ditt IDE eller terminal:

```bash
java -cp target/classes;path/to/sqlite-jdbc.jar se.davand.Main
```

Följ instruktionerna i konsollen för att:

1. Välja en kurs.
2. Ställa frågor i olika ordningar.
3. Svara på frågorna och se statistik.

---

## Exempel på menyflöde

```text
=== MAIN MENU ===
1. OOP Basics
2. Databases and Design
3. OOP Advanced
4. Test
0. Exit
Enter your choice (0-4): 4

=== COURSE MENU: Test ===
1. Ask questions in order
2. Ask questions randomly
3. Ask questions in reverse order
0. Back to main menu
Enter your choice (0-3): 1

1. What is unit testing?
A) Testing individual units of code
B) Testing the entire system
C) Testing the user interface
D) Testing the database
Enter your answer (A, B, C, D), or type E to exit to the main menu: B
Correct!
Right answers so far: 1
Error rate: 0.00%
```

---

## Beroenden

- **Java 21** eller senare
- **SQLite** för datalagring
- **JDBC** för databasanslutning

---

## Framtida Utveckling

- **Lägg till fler kurser och frågor.**
- **Statistikloggning:** Spara användarens resultat för att spåra framsteg över tid.
- **Grafiskt gränssnitt:** Utveckla en JavaFX- eller webbversion för en bättre användarupplevelse.

---

## Kontakt

För frågor om projektet, kontakta mig via GitHub:

- **GitHub:** [david-andreasson](https://github.com/david-andreasson)
