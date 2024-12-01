# WatchlistApp

## Översikt
WatchlistApp är ett Java-baserat konsolprojekt designat för att hantera en personlig filmlista. Användaren kan lägga till filmer, ta bort filmer och lista alla filmer i sin "watchlist". Projektet är byggt för att träna på Java-grunderna, inklusive objektorienterad programmering, datahantering och API-integration. I framtiden planeras integrering av TMDB API för att automatiskt hämta filminformation.

## Funktionalitet
- **Lägga till filmer**: Användare kan lägga till filmer i sin watchlist med titel och år.
- **Ta bort filmer**: Användare kan ta bort filmer från sin watchlist baserat på titel.
- **Lista alla filmer**: Visar en lista över alla filmer i watchlisten med titel och år.
- **Framtida funktioner**: Integration med TMDB API för att hämta filminformation automatiskt.

## Projektstruktur
```
WatchlistApp
├── src  
│   ├── main  
│   │   ├── java  
│   │   │   └── se  
│   │   │       └── davand  
│   │   │           ├── models           # Innehåller dataobjekt, som Movie  
│   │   │           └── services         # Innehåller tjänstklasser, som WatchlistService  
│   └── resources                        # Resurser som kan behövas för framtida API-konfiguration  
└── README.md
```

## Projektklasser
- **`Movie`**: Representerar en film med titel och år.
- **`WatchlistService`**: Hanterar alla operationer för watchlisten, inklusive att lägga till, ta bort och lista filmer.

## Installation
1. Klona projektet från GitHub:  
   ```bash
   git clone https://github.com/david-andreasson/WatchlistApp.git
   ```
2. Importera projektet till ditt IDE, t.ex. IntelliJ IDEA.
3. Se till att du har Java 21 eller senare installerat.

## Att köra projektet
1. Kör `Main.java` från ditt IDE (finns i `src/main/java/se/davand/app`).
2. Följ instruktionerna i konsollen för att:
   - Lägga till filmer.
   - Ta bort filmer.
   - Lista alla filmer.

## Framtida Utveckling
WatchlistApp är byggt för att kunna utökas med fler funktioner:
- **TMDB API-integration**: Använda TMDB (The Movie Database) för att hämta filminformation, inklusive affischer, beskrivningar och genrer.
- **Databaslagring**: Lagra watchlisten i en databas (t.ex. SQLite eller MySQL) för att bevara data mellan körningar.
- **Användargränssnitt**: Bygga ett JavaFX- eller webbgränssnitt för att förbättra användarupplevelsen.

## Kontakt
För frågor om projektet, kontakta David:
- **GitHub**: [david-andreasson](https://github.com/david-andreasson)
