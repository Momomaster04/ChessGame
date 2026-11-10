# Chess Game (Java Swing)

A two-player chess game with a graphical board, built in Java as a Year 2 university project (Semester 2, 2024).

## Features

- Swing GUI board with piece images
- Full piece movement rules: pawn, knight, bishop, rook, queen, king
- Move handling and validation (`Piece/Move.java`)
- Game and move history saved to an Apache Derby database (`GAMES` and `MOVES` tables)
- JUnit 4 tests for the board, pieces and moves

## Project structure

```
src/
  Board/   GUI, board state, Derby database access, file I/O, entry point (Main)
  Piece/   Piece classes, colours, coordinates and move logic
test/      JUnit 4 tests
lib/       Derby JDBC drivers (derby.jar, derbyclient.jar)
*.png      Piece images
```

## Running

Requires JDK 11+.

**NetBeans:** open the folder as a project and run it. The main class is `Board.Main`.

**Command line** (from the repo root, so the piece images load):

```bash
javac -cp "lib/*" -d build src/Board/*.java src/Piece/*.java
java -cp "build;lib/*" Board.Main
```

On macOS or Linux, use `build:lib/*` instead of `build;lib/*`.

Saving games needs a Derby network server on `localhost:1527`. The connection settings are in `src/Board/DBManager.java`.
