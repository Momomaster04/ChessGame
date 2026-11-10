/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author mohan
 */
//the rook can only move in straigt lines so vertical and horizontal for any number of squares
public class Rook extends Piece{
    // same as other pieces
    private Coordinate castleCoordRook;

    private ImageIcon icon;

    public Rook(COLOUR colour, Coordinate OGcoord) {
        super(PieceID.ROOK, colour, OGcoord);
        if (getColour() == COLOUR.B)
            icon = new ImageIcon("BRook.png");
        else if (getColour() == COLOUR.W)
            icon = new ImageIcon("WRook.png");
    }

    public Rook (Rook original) {
        super(original);
    }
// Gets the coordinate for castling with the Rook.
    public Coordinate getCastleCoordRook() {
        return castleCoordRook;
    }
// Sets the coordinate for castling with the Rook.
    public void setCastleCoordRook(Coordinate castleCoordRook) {
        this.castleCoordRook = castleCoordRook;
    }

    @Override
    public Rook makeCopy() {
        return new Rook(this);
    }

    @Override
    public ArrayList<Coordinate> getRawMoves(Pieces pieces) {
         //Gets all possible moves for the Rook piece.
        ArrayList<Coordinate> front = Move.frontFree(pieces,this,dimension);
        ArrayList<Coordinate> right = Move.rightFree(pieces,this,dimension);
        ArrayList<Coordinate> back = Move.backFree(pieces,this,dimension);
        ArrayList<Coordinate> left = Move.leftFree(pieces,this,dimension);

        front.addAll(right);
        back.addAll(left);
        front.addAll(back);

        return front;
    }

    @Override
    public ImageIcon getImageIcon() {
        return icon;
    }
    
}
