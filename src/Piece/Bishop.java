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
public class Bishop extends Piece{
    // the bishop class extends Piece defines the movement of a bishop which is daignol movements
    private ImageIcon icon;
 // Stores the graphical icon for the bishop, set based on its color
   // Constructs a bishop with the specified color and starting coordinate,
    public Bishop(COLOUR colour, Coordinate Icoord) {
        super(PieceID.BISHOP, colour, Icoord); // Initializes bishop with its ID, color, and initial coordinate
        if (getColour() == COLOUR.B)
            icon = new ImageIcon("BBishop.png");
        else if (getColour() == COLOUR.W)
            icon = new ImageIcon("WBishop.png");
    }

    public Bishop(Bishop original) {
        super(original);
    }

    @Override
    public Bishop makeCopy() {
        return new Bishop(this);
    }
    
    // Calculates all possible raw moves for the bishop, which moves diagonally
    // also moves in any direction until it encounters an obstacle or edge of the board
    @Override
    public ArrayList<Coordinate> getRawMoves(Pieces pieces) {
        ArrayList<Coordinate> frontRDig = Move.frontRDigFree(pieces, this,dimension); // Moves diagonally to front-right
        ArrayList<Coordinate> backRDig = Move.backRDigFree(pieces, this, dimension); // Moves diagonally to back-right
        ArrayList<Coordinate> backLDig = Move.backLDigFree(pieces, this,dimension); // Moves diagonally to back-left
        ArrayList<Coordinate> frontLDig = Move.frontLDigFree(pieces, this, dimension); // Moves diagonally to front-left

         // Combines all diagonal moves into a single list of potential moves
        frontRDig.addAll(backRDig);
        backLDig.addAll(frontLDig);
        frontRDig.addAll(backLDig);

        return frontRDig; //Returns a comprehensive list of all bishop moves
    }

    @Override
    public ImageIcon getImageIcon() {
        return icon;
    }
    
}
