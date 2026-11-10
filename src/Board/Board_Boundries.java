/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Board;

/**
 *
 * @author mohan
 */

// Enum representing the boundaries of a chess board.
// It defines the start and end positions for both columns and rows.
public enum Board_Boundries {
    
    START_COLUMN('a'), // Starting column on the chess board
    END_COLUMN('h'), // Ending column on the chess board
    START_ROW(1), // Starting row on the chess board
    END_ROW(8); // Ending row on the chess board

    private char ColumnVal;
    private int RowkVal;
    
    // constructor for defining a column boundary.
    Board_Boundries(char Column) {
        ColumnVal = Column;
    }
    //  Constructor for defining a row boundary.
    Board_Boundries(int Row) {
        RowkVal = Row;
    }

    // Gets the column value.
    public char getColumnVal() {
        return ColumnVal;
    }

    //  Gets the row value.
    public int getRowVal() {
        return RowkVal;
    }
    
}
