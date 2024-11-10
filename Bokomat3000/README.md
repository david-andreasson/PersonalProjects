# Bokomat3000

## Översikt
Bokomat3000 är ett Java-baserat backend-system för att hantera bokningar av tvättider i en hyreshusmiljö. Projektet är designat som en konsollösning där hyresgäster kan boka och avboka tvättider. Backend-systemet är byggt med OOP-principer och inkluderar grundläggande SQL-databasanslutning. På sikt kan systemet utökas med ett webbgränssnitt.

## Funktionalitet
- **Registrering av användare**: Hyresgäster kan registrera sig med namn och lägenhetsnummer.
- **Bokning av tvättider**: Registrerade användare kan boka lediga tider.
- **Avbokning av tvättider**: Användare kan avboka sina bokade tider.
- **Visning av bokningar**: Användare kan se sina bokade tider.

## Projektstruktur
```
Bokomat3000  
├── src  
│   ├── main  
│   │   ├── java  
│   │   │   └── se  
│   │   │       └── davand  
│   │   │           ├── app              # Innehåller Main.java som startpunkt för applikationen  
│   │   │           ├── model            # Innehåller dataobjekt som User och Booking  
│   │   │           ├── service          # Innehåller tjänstklasser, som BookingService  
│   │   │           └── repository       # Innehåller databasklasser, som BookingRepository  
│   └── resources                        # Innehåller SQL-skript och dokumentation  
│       └── docs  
│           ├── Bokomat3000_ClassDiagram.md  
│           └── Bokomat3000_SequenceDiagram.md  
└── README.md
```

## Diagram
De centrala diagrammen för systemets klasser och bokningsprocessen finns som separata Markdown-filer i dokumentationsmappen.

- [Klassdiagram för Bokomat3000](src/main/resources/docs/Bokomat3000_ClassDiagram.md): Visar systemets klasser och deras relationer, inklusive `User`, `Booking`, `BookingRepository`, och `BookingService`.
- [Sekvensdiagram för Bokningsprocessen](src/main/resources/docs/Bokomat3000_SequenceDiagram.md): Visar flödet när en användare initierar en bokning, inklusive steg som kontroll av tillgänglighet och bekräftelse.

## Databasdesign
Projektet använder en H2-databas med följande tabeller:

- **User**: Lagrar användarinformation som `id`, `name`, och `apartmentNumber`.
- **Booking**: Lagrar bokningsinformation med `id`, `userId`, `date`, och `timeslot`.

SQL-skript för att skapa tabellerna finns i projektets `docs`-mapp.

## Installation
TODO: Lägg till installationsinstruktioner för att skapa databasen och ansluta till den.

## Beroenden
- Java 11 eller senare
- H2-databas
- JDBC-drivrutin för H2

## Att köra projektet
1. Kör `Main.java` från ditt IDE (finns i `src/main/java/se/davand/app`).
2. Följ instruktionerna i konsollen för att registrera en användare, boka, visa eller avboka tider.

## Framtida Utveckling
Projektet är byggt för att enkelt kunna utökas för ett framtida webbgränssnitt. I detta gränssnitt ska användare kunna logga in, boka och hantera bokningar via en webbplats.

## Kontakt
För frågor om projektet, kontakta David.
