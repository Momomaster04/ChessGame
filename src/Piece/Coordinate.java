/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import Board.Board_Boundries;
import java.util.Objects;

/**
 *
 * @author mohan
 */
public class Coordinate {
    
    public char Column; //column or letter
    public int Row; //row or number
    public static Coordinate emptyCoordinate = new Coordinate((char) 0,0); // a filler coordinate that isn't in the board


    //Constructs a new Coordinate with the specified column and row.
    public Coordinate (char Column, int Row) {

        this.Column = Character.toLowerCase(Column);
        this.Row = Row;
    }

    // Copy constructor to create a new Coordinate from an existing one.
    public Coordinate (Coordinate original) {
        Column = original.Column;
        Row = original.Row;
    }

    //Constructs a new Coordinate from a string representation.
    public Coordinate (String coordinate) {

        if (coordinate.length() == 2 && Character.isLetter(coordinate.charAt(0)) && Character.isDigit(coordinate.charAt(1))) {
            Column = Character.toLowerCase(coordinate.charAt(0));
            Row = Character.getNumericValue(coordinate.charAt(1));
        }
        
    }

    public Coordinate() {
        Column = 0;
        Row = 0;
    }

    //Gets the column of the coordinate.
    public char getColumn() {
        return Column;
    }

    // Gets the row of the coordinate.
    public int getRow() {
        return Row;
    }

    // Checks if the specified coordinate is within the valid board boundaries.
    public static boolean inBoard (Coordinate coord) {
        char coordColumn = coord.getColumn();
        int coordRow = coord.getRow();
        // Check if the coordinate is within defined board boundaries
        return (coordColumn >= Board_Boundries.START_COLUMN.getColumnVal()
                && coordColumn <= Board_Boundries.END_COLUMN.getColumnVal()
                && coordRow >= Board_Boundries.START_ROW.getRowVal()
                && coordRow <= Board_Boundries.END_ROW.getRowVal());
    }

    // Returns a string representation of the coordinate for eg. a1 or e2
    @Override
    public String toString() {
        return Column + "" + Row;
    }

    //Compares this coordinate to another object for equality.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Column == that.Column &&
                Row == that.Row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Column, Row);
    }
    
}
