/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import Board.Board_Boundries;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author mohan
 */

/*
*  The Piece class is an abstract representation of a chess piece.
*  It defines core attributes like name, color, position, and potential moves
*/
public abstract class Piece{

    private final PieceID name;// The type of piece
    private final COLOUR colour;// Color of the piece
    private Coordinate coords; // Current coordinate of the piece
    private final Coordinate OGcoord;// Original starting coordinate
    private final String pieceID; //Unique identifier string for each piece
    private HashSet<Coordinate> potentialMoves = new HashSet<>(); // Potential valid moves for this piece
    public int dimension = Board_Boundries.END_ROW.getRowVal(); // Max row value based on board boundaries
    public int single = Board_Boundries.START_ROW.getRowVal(); // Min row value based on board boundaries
    private boolean hasMoved = false; //tracks moves
    public static Piece emptyPiece = new Rook(COLOUR.W,Coordinate.emptyCoordinate);

    public Piece (PieceID name, COLOUR colour, Coordinate OGcoord) {
//Constructor to initialize a piece
        this.name = name;
        this.colour = colour;
        this.OGcoord = OGcoord;
        coords = OGcoord;
        // Generates unique identifier string
        pieceID = "*"+name.toString()+"*"+colour.toString()+"*"+OGcoord.getColumn()+"*";
    }

    //Copy constructor to create a new instance
    public Piece (Piece original) {
        this.name = original.name;
        this.colour = original.colour;
        this.OGcoord = new Coordinate(original.OGcoord);
        this.coords = new Coordinate(original.coords);
        this.pieceID = original.pieceID;
        this.potentialMoves = new HashSet<>();

        for (Coordinate coord : original.getPotentialMoves()) {
            this.potentialMoves.add(new Coordinate(coord));
        }

        this.dimension = original.dimension;
        this.single = original.single;
        this.hasMoved = original.hasMoved;
    }

    public Coordinate getCoords() {
        return coords;
    }

    public char getColumn() {
        return getCoords().getColumn();
    }

    public int getRow() {
        return getCoords().getRow();
    }

    public COLOUR getColour() {
        return colour;
    }

    public PieceID getName() {
        return name;
    }

    public Coordinate getOGcoord() {
        return OGcoord;
    }

    public String getPieceID() {
        return pieceID;
    }

    public void setCoords(Coordinate coords) {
        this.coords = coords;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved() {
        hasMoved = true;
    }

    // Adds a list of moves to the potential moves set
    public void addMoves(ArrayList<Coordinate> someMoves) {
        potentialMoves.addAll(someMoves);
    }

    // Clears all potential moves for the piece
    public void clearMoves() {
        potentialMoves.clear();
    }
    
    // Returns the set of potential moves for the piece
    public HashSet<Coordinate> getPotentialMoves() {
        return potentialMoves;
    }

    /**
     * Removes moves that would place the king in check from the list of potential moves.
     **/
    public ArrayList<Coordinate> removeOwnCheck(Pieces pieces) {

        King potentialKing = null;
        boolean removeKingCastle = false;
        boolean removeQueenCastle = false;

        ArrayList<Coordinate> potentials = getRawMoves(pieces);// Raw moves without considering check

        if (potentials.size() == 0)
            return potentials;

        Iterator<Coordinate> it = potentials.iterator();

        while (it.hasNext()) {
            Coordinate nextMove = it.next();
            Pieces p = new Pieces(pieces);
            p.pieceMove(nextMove, this.makeCopy());
            Coordinate kingPosition = p.findKing(getColour());
            HashSet<Coordinate> dangerMoves = p.allColouredRaws(COLOUR.not(getColour()));
            if (dangerMoves.contains(kingPosition))
                if (this.getName() == PieceID.KING) { // we need to remove the possibility of castling if the King can be put in check
                    potentialKing = (King) this;
                    if (nextMove.equals(potentialKing.getTransitionCoordinateKingK())) {
                        it.remove();
                        removeKingCastle = true;
                    }
                    else if (nextMove.equals(potentialKing.getTransitionCoordinateKingQ())) {
                        it.remove();
                        removeQueenCastle = true;
                    }
                    else
                        it.remove();
                }
                else
                    it.remove();
        }
        if (potentialKing != null) { // Remove castling move if it's no longer valid
            if (removeKingCastle)
                potentials.remove(potentialKing.getCastleCoordinateKingK());
            if (removeQueenCastle)
                potentials.remove(potentialKing.getCastleCoordinateKingQ());
        }

        return potentials; // Return legal moves only
    }

    //Updates the potential moves for the piece by removing any moves that expose the king to check.
    public void updatePotentialMoves(Pieces pieces) {addMoves(removeOwnCheck(pieces));
    }

    //Checks if a move to a specific coordinate is valid.
    public boolean isValidMove(Coordinate destination, COLOUR colour) {
        return getPotentialMoves().contains(destination) && getColour() == colour;
    }

    //Checks equality of two Piece objects based on name, color, and initial position.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return name == piece.name &&
                colour == piece.colour &&
                OGcoord.equals(piece.OGcoord) &&
                pieceID.equals(piece.pieceID);
    }

    //Generates a hash code for the Piece based on name, color, and original coordinates.
    @Override
    public int hashCode() {
        return Objects.hash(name, colour, OGcoord, pieceID);
    }

 // Abstract method to be implemented by subclasses to define piece-specific moves
    public abstract ArrayList<Coordinate> getRawMoves(Pieces pieces);
// Abstract method to get the graphical icon for the piece
    public abstract ImageIcon getImageIcon();
// Abstract method to create a copy of the piece
    public abstract Piece makeCopy();
}
