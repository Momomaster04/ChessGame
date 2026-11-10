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
// the queen can move in every direction across the board
public class Queen extends Piece {
    /// this part is the same as all the other pieces
    private ImageIcon icon;

    public Queen(COLOUR colour, Coordinate OGcoord) {
        super(PieceID.QUEEN, colour, OGcoord);
        if (getColour() == COLOUR.B)
            icon = new ImageIcon("BQueen.png");
        else if (getColour() == COLOUR.W)
            icon = new ImageIcon("WQueen.png");
    }

    public Queen(Queen original) {
        super(original);
    }

    @Override
    public Queen makeCopy() {
        return new Queen(this);
    }

    @Override
    public ArrayList<Coordinate> getRawMoves(Pieces pieces) {

        // Retrieve all potential moves in different directions simce the queen is allowed to move in all directions
        ArrayList<Coordinate> front = Move.frontFree(pieces,this,dimension);
        ArrayList<Coordinate> right = Move.rightFree(pieces,this,dimension);
        ArrayList<Coordinate> back = Move.backFree(pieces,this,dimension);
        ArrayList<Coordinate> left = Move.leftFree(pieces,this,dimension);
        ArrayList<Coordinate> frontRDig = Move.frontRDigFree(pieces, this,dimension);
        ArrayList<Coordinate> backRDig = Move.backRDigFree(pieces, this, dimension);
        ArrayList<Coordinate> backLDig = Move.backLDigFree(pieces, this,dimension);
        ArrayList<Coordinate> frontLDig = Move.frontLDigFree(pieces, this, dimension);

         // Combine all potential moves into one list
        front.addAll(right);
        back.addAll(left);
        front.addAll(back);
        frontRDig.addAll(backRDig);
        backLDig.addAll(frontLDig);
        frontRDig.addAll(backLDig);

        front.addAll(frontRDig);

        return front;

    }

    @Override
    public ImageIcon getImageIcon() {
        return icon;
    }
    
}
