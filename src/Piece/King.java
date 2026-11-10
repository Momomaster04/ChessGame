/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import Board.Board_Boundries;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author mohan
 */

//The King can move one square in any direction and can perform castling.
public class King extends Piece {
    
    // the coordinate to which the king goes after castling King side
    private Coordinate castleCoordinateKingK;
    // the coordinate to whcih the king goes after castling Queen side
    private Coordinate castleCoordinateKingQ;
    // the coordinate through which the king goes when castling King side
    private Coordinate transitionCoordinateKingK;
    // the coordinate through which the king goes when castling Queen side
    private Coordinate transitionCoordinateKingQ;
    // the rook on the King side
    private Rook rookKing;
    // the rook on the Queen side
    private Rook rookQueen;
    // The icon representing the king piece
    private ImageIcon icon;


    //Constructs a King with the specified color and original coordinate.
    public King(COLOUR colour, Coordinate OGcoord) {
        super(PieceID.KING, colour, OGcoord);
        if (getColour() == COLOUR.B)
            icon = new ImageIcon("BKing.png");
        else if (getColour() == COLOUR.W)
            icon = new ImageIcon("WKing.png");
    }

    public King(King original) {
        super(original);
    }

     // Getters for castle and transition coordinates
    public Coordinate getCastleCoordinateKingK() {
        return castleCoordinateKingK;
    }

    public Coordinate getCastleCoordinateKingQ() {
        return castleCoordinateKingQ;
    }

    public Coordinate getTransitionCoordinateKingK() {
        return transitionCoordinateKingK;
    }

    public Coordinate getTransitionCoordinateKingQ() {
        return transitionCoordinateKingQ;
    }

    public Rook getRookKing() {
        return rookKing;
    }

    public Rook getRookQueen() {
        return rookQueen;
    }

    // Attempts to perform castling on the King side
    public boolean CastleKing (Pieces pieces) {

        if (pieces.isCheck(getColour())) // Check if the king is in check, if so, castling is not allowed
            return false;

         // Get all pieces of the same color
        HashMap<Coordinate, Piece> colouredPieces = pieces.getColourPieces(getColour());

        // Find the rook on the King side
        for (Piece value : colouredPieces.values()) {
            if (value.getName() == PieceID.ROOK && value.getColumn() == Board_Boundries.END_COLUMN.getColumnVal())
                rookKing = (Rook) value;
        }

        int distanceRookKing = 2;
        ArrayList<Coordinate> castleCoords;

         // Determine available coordinates for castling based on color
        if (getColour() == COLOUR.B)
            castleCoords = Move.leftFree(pieces, this, dimension);
        else
            castleCoords = Move.rightFree(pieces, this, dimension);

        boolean isSpace = castleCoords.size() == distanceRookKing;

         // Check if castling conditions are met
        boolean canCastle = rookKing != null &&
                !rookKing.getHasMoved() &&
                !getHasMoved() &&
                isSpace;

        // Perform the castling
        if (canCastle) {
            castleCoordinateKingK = castleCoords.get(1); // Set castle coordinate for King
            transitionCoordinateKingK = castleCoords.get(0);
            rookKing.setCastleCoordRook(castleCoords.get(0));  // Set rook's castle coordinate
            return true; // Successful castling
        }
        return false;// failed castling
    }

    // Attempts to perform castling on the Queen side. (basically the same as the kings side castling)
    public boolean CastleQueen (Pieces pieces) {
 // Check if the king is in check, if so, castling is not allowed
        if (pieces.isCheck(getColour()))
            return false;

        HashMap<Coordinate,Piece> colouredPieces = pieces.getColourPieces(getColour());

        for (Piece value : colouredPieces.values()) {
            if (value.getName() == PieceID.ROOK && value.getColumn() == Board_Boundries.START_COLUMN.getColumnVal())
                rookQueen = (Rook) value;
        }

        int distanceRookQueen = 3;
        ArrayList<Coordinate> castleCoords;

        if (getColour() == COLOUR.W) {
            castleCoords = Move.leftFree(pieces, this, dimension);
        }
        else {
            castleCoords = Move.rightFree(pieces, this, dimension);
        }

        boolean isSpace = castleCoords.size() == distanceRookQueen;


        boolean canCastle = rookQueen != null &&
                !rookQueen.getHasMoved() &&
                !getHasMoved() &&
                isSpace;

        if (canCastle) {
            castleCoordinateKingQ = castleCoords.get(1);
            transitionCoordinateKingQ = castleCoords.get(0);
            rookQueen.setCastleCoordRook(castleCoords.get(0));
            return true;
        }
        return false;
    }

    @Override
    public King makeCopy() {
        return new King(this);
    }
    
    @Override
    public ArrayList<Coordinate> getRawMoves(Pieces pieces) {
        //get and add all raw moves (reachable from position)
        ArrayList<Coordinate> front = Move.frontFree(pieces,this,single);
        ArrayList<Coordinate> right = Move.rightFree(pieces,this,single);
        ArrayList<Coordinate> back = Move.backFree(pieces,this,single);
        ArrayList<Coordinate> left = Move.leftFree(pieces,this,single);
        ArrayList<Coordinate> frontRDig = Move.frontRDigFree(pieces, this,single);
        ArrayList<Coordinate> backRDig = Move.backRDigFree(pieces, this, single);
        ArrayList<Coordinate> backLDig = Move.backLDigFree(pieces, this,single);
        ArrayList<Coordinate> frontLDig = Move.frontLDigFree(pieces, this, single);

        front.addAll(right);
        back.addAll(left);
        front.addAll(back);

        frontRDig.addAll(backRDig);
        backLDig.addAll(frontLDig);
        frontRDig.addAll(backLDig);

        front.addAll(frontRDig);

        // if can castle, add coordinates
        if (CastleKing(pieces))
            front.add(castleCoordinateKingK);  // Add King-side castling coordinate
        if (CastleQueen(pieces))
            front.add(castleCoordinateKingQ); // Add Queen-side castling coordinate


        return front; // Return all possible moves
    }

    @Override
    public ImageIcon getImageIcon() {
        return icon;
    }

    
}
