/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author mohan
 */

/*
* this class contains methods to calculate the possible moves for the chess pieces based on
* the current board conditions
*/
public class Move {
   
    /*
    *  Checks if the piece at a destination coordinate is not the same color
    *  as the moving piece, to ensure legal capturing.
    */
    public static boolean isNotTileColour(Pieces pieces, Coordinate destination, COLOUR colour) {
  
        // this will return true if the destination piece is of the opposite colour, otherwise its false
        return !(pieces.getPieces().get(destination).getColour() == (colour));
    }

    /*
    * this method checks if a specific tile is occupied
    */
    public static boolean tileFull (Pieces pieces, Coordinate destination) {

        // returns true if a place occupies the tile, otherwise its false
        return pieces.getPieces().get(destination) != null;
    }

    /*
    * this calculates the available forward moves for a piece, so it will stop at the first available tile
    * or if the limit is reached for the piece
    * Pieces is the the Pieces object with all the pieces
    * we need the Piece class in order to calculate the moves
    * the limit is used for the maximum number of tiles it can advance
    */
    public static ArrayList<Coordinate> frontFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;

        if (piece.getColour().equals(COLOUR.B))
            factor = -1;
        else
            factor = 1;

        for (int advance = 1; advance <= limit; advance++) {
            int change = factor*advance;
            Coordinate checkCoord = new Coordinate(piece.getColumn(), piece.getRow() + change);
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves; // this stops at the first enemy piece for capturing
                }
                else if (occupiedTile)
                    return moves; // this stops if the tile is occupied by the same colour piece
                else
                    moves.add(checkCoord);
            }
        }

        return moves;
    }
    

    // similar to FrontFree but checks the backward moves behind

    public static ArrayList<Coordinate> backFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;

        if (piece.getColour().equals(COLOUR.B))
            factor = 1;
        else
            factor = -1;

        for (int advance = 1; advance <= limit; advance++) {
            int change = factor*advance;
            Coordinate checkCoord = new Coordinate(piece.getColumn(),piece.getRow()+change);
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves;
                }
                else if (occupiedTile)
                    return moves;
                else
                    moves.add(checkCoord);
            }
        }
        return moves;
    }

     // similar to FrontFree but checks the moves to the right horizontally

    public static ArrayList<Coordinate> rightFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;

        if (piece.getColour().equals(COLOUR.B))
            factor = -1;
        else
            factor = 1;

        for (int advance = 1; advance <= limit; advance++) {
            int change = factor*advance;
            Coordinate checkCoord = new Coordinate((char) (piece.getColumn()+change),piece.getRow());
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves;
                }
                else if (occupiedTile)
                    return moves;
                else
                    moves.add(checkCoord);
            }
        }
        return moves;
    }

    // similar to FrontFree but checks the moves to the left horizontally

    public static ArrayList<Coordinate> leftFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;

        if (piece.getColour().equals(COLOUR.B))
            factor = 1;
        else
            factor = -1;

        for (int advance = 1; advance <= limit; advance++) {
            int change = factor*advance;
            Coordinate checkCoord = new Coordinate((char) (piece.getColumn()+change),piece.getRow());
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves;
                }
                else if (occupiedTile)
                    return moves;
                else
                    moves.add(checkCoord);
            }
        }
        return moves;
    }

    // similar to FrontFree but this time it checks the moves to the front right diagnol position

    public static ArrayList<Coordinate> frontRDigFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factorV;
        int factorH;

        if (piece.getColour().equals(COLOUR.B)) {
            factorV = -1;
            factorH = -1;
        }
        else {
            factorV = 1;
            factorH = 1;
        }

        for (int advance = 1; advance <= limit; advance++) {
            int changeV = factorV*advance;
            int changeH = factorH*advance;
            Coordinate checkCoord = new Coordinate((char) (piece.getColumn()+changeV),piece.getRow()+changeH);
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves;
                }
                else if (occupiedTile)
                    return moves;
                else if (!tileFull(pieces, checkCoord))
                    moves.add(checkCoord);
            }
        }
        return moves;
    }

     // similar to FrontFree but this time it checks the moves to the back right diagnol position

    public static ArrayList<Coordinate> backRDigFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factorV;
        int factorH;

        if (piece.getColour().equals(COLOUR.B)) {
            factorV = -1;
            factorH = 1;
        }
        else {
            factorV = 1;
            factorH = -1;
        }

        for (int advance = 1; advance <= limit; advance++) {
            int changeV = factorV*advance;
            int changeH = factorH*advance;
            Coordinate checkCoord = new Coordinate((char) (piece.getColumn()+changeV),piece.getRow()+changeH);
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves;
                }
                else if (occupiedTile)
                    return moves;
                else
                    moves.add(checkCoord);
            }
        }
        return moves;
    }

     // similar to FrontFree but this time it checks the moves to the back left diagnol position

    public static ArrayList<Coordinate> backLDigFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factorV;
        int factorH;

        if (piece.getColour().equals(COLOUR.B)) {
            factorV = 1;
            factorH = 1;
        }
        else {
            factorV = -1;
            factorH = -1;
        }

        for (int advance = 1; advance <= limit; advance++) {
            int changeV = factorV*advance;
            int changeH = factorH*advance;
            Coordinate checkCoord = new Coordinate((char) (piece.getColumn()+changeV),piece.getRow()+changeH);
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves;
                }
                else if (occupiedTile)
                    return moves;
                else
                    moves.add(checkCoord);
            }
        }
        return moves;
    }

    // similar to FrontFree but this time it checks the moves to the front left diagnol position

    public static ArrayList<Coordinate> frontLDigFree(Pieces pieces, Piece piece, int limit) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factorV;
        int factorH;

        if (piece.getColour().equals(COLOUR.B)) {
            factorV = 1;
            factorH = -1;
        }
        else {
            factorV = -1;
            factorH = 1;
        }

        for (int advance = 1; advance <= limit; advance++) {
            int changeV = factorV*advance;
            int changeH = factorH*advance;
            Coordinate checkCoord = new Coordinate((char) (piece.getColumn()+changeV),piece.getRow()+changeH);
            if (Coordinate.inBoard(checkCoord)) {
                boolean occupiedTile = tileFull(pieces, checkCoord);
                if (occupiedTile && isNotTileColour(pieces, checkCoord, piece.getColour())) {
                    moves.add(checkCoord);
                    return moves;
                }
                else if (occupiedTile)
                    return moves;
                else
                    moves.add(checkCoord);
            }
        }
        return moves;
    }

    // since a knight moves in an L shape and so is different to all the other pieces 
    // the knight is the only piec that can jump over pieces which is why it has a special moves calculation
    //the knight moves in an L shape in all direction so in short tewrm (2 squares vertically forward and 1 horrizontally)

    public static ArrayList<Coordinate> frontKnight(Pieces pieces, Piece piece) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;
        int sideDistance = 1; // this indicates that it moves horrizontally by 1 square

        if (piece.getColour().equals(COLOUR.B)) {
            factor = -1;
        }
        else {
            factor = 1;
        }

        int changeV = 2*factor; // this moves the knight vertically by 2 squares
        int newRow = piece.getRow() + changeV; // this will calculate the new row based on where the knight moved

        //right and left taken with reference to white pieces
        Coordinate frontRight = new Coordinate((char) (piece.getColumn() + sideDistance),newRow);
        Coordinate frontLeft = new Coordinate((char) (piece.getColumn() - sideDistance),newRow);

        //this checks if the moves are within the boundries
        if (Coordinate.inBoard(frontLeft)) {
            boolean occupiedTile = tileFull(pieces, frontLeft);
            if (!occupiedTile || isNotTileColour(pieces, frontLeft, piece.getColour()))
                moves.add(frontLeft);
        }

        if (Coordinate.inBoard(frontRight)) {
            boolean occupiedTile = tileFull(pieces, frontRight);
            if (!occupiedTile || isNotTileColour(pieces, frontRight, piece.getColour()))
                moves.add(frontRight);
        }
        return moves; //returns the moves of all possible moves of the knight
    }

    // similar to FrontKnight but moves 2 squares vertically behind and 1 horizontal move

    public static ArrayList<Coordinate> backKnight(Pieces pieces, Piece piece) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;
        int sideDistance = 1;

        if (piece.getColour().equals(COLOUR.B)) {
            factor = 1;
        }
        else {
            factor = -1;
        }

        int changeV = 2*factor;
        int newRank = piece.getRow() + changeV;

        Coordinate backRight = new Coordinate((char) (piece.getColumn() + sideDistance),newRank);
        Coordinate backLeft = new Coordinate((char) (piece.getColumn() - sideDistance),newRank);

        if (Coordinate.inBoard(backLeft)) {
            boolean occupiedTile = tileFull(pieces, backLeft);
            if (!occupiedTile || isNotTileColour(pieces, backLeft, piece.getColour()))
                moves.add(backLeft);
        }

        if (Coordinate.inBoard(backRight)) {
            boolean occupiedTile = tileFull(pieces, backRight);
            if (!occupiedTile || isNotTileColour(pieces, backRight, piece.getColour()))
                moves.add(backRight);
        }
        return moves;
    }

    // similar to FrontKnight but moves 2 squares horrizontally right and 1 vertical move

    public static ArrayList<Coordinate> rightKnight(Pieces pieces, Piece piece) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;
        int sideDistance = 1;

        if (piece.getColour().equals(COLOUR.B)) {
            factor = -1;
        }
        else {
            factor = 1;
        }

        int changeH = 2*factor;
        char newFile = (char) (piece.getColumn() + changeH);

        Coordinate rightTop = new Coordinate(newFile,piece.getRow() + sideDistance);
        Coordinate rightBottom = new Coordinate(newFile, piece.getRow() - sideDistance);

        if (Coordinate.inBoard(rightTop)) {
            boolean occupiedTile = tileFull(pieces, rightTop);
            if (!occupiedTile || isNotTileColour(pieces, rightTop, piece.getColour()))
                moves.add(rightTop);
        }

        if (Coordinate.inBoard(rightBottom)) {
            boolean occupiedTile = tileFull(pieces, rightBottom);
            if (!occupiedTile || isNotTileColour(pieces, rightBottom, piece.getColour()))
                moves.add(rightBottom);
        }
        return moves;
    }

    // similar to FrontKnight but moves 2 squares horizontally left and 1 vertical move

    public static ArrayList<Coordinate> leftKnight(Pieces pieces, Piece piece) {

        ArrayList<Coordinate> moves = new ArrayList<>();
        int factor;
        int sideDistance = 1;

        if (piece.getColour().equals(COLOUR.B)) {
            factor = 1;
        }
        else {
            factor = -1;
        }

        int changeH = 2*factor;
        char newFile = (char) (piece.getColumn() + changeH);

        //right and left taken with reference to white pieces
        Coordinate leftTop = new Coordinate(newFile,piece.getRow() + sideDistance);
        Coordinate leftBottom = new Coordinate(newFile, piece.getRow() - sideDistance);

        if (Coordinate.inBoard(leftBottom)) {
            boolean occupiedTile = tileFull(pieces, leftBottom);
            if (!occupiedTile || isNotTileColour(pieces, leftBottom, piece.getColour()))
                moves.add(leftBottom);
        }

        if (Coordinate.inBoard(leftTop)) {
            boolean occupiedTile = tileFull(pieces, leftTop);
            if (!occupiedTile || isNotTileColour(pieces, leftTop, piece.getColour()))
                moves.add(leftTop);
        }
        return moves;
    }

}
