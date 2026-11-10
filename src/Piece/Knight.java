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

// the knight moves in an L-shape so 2 squares vertically and then 1 square horizontally
public class Knight extends Piece {
    // the format is the same as all other pieces just different raw moves
     private ImageIcon icon;

    public Knight(COLOUR colour, Coordinate OGcoord) {
        super(PieceID.KNIGHT, colour, OGcoord);
        if (getColour() == COLOUR.B)
            icon = new ImageIcon("BKnight.png");
        else if (getColour() == COLOUR.W)
            icon = new ImageIcon("WKnight.png");
    }

    public Knight(Knight original) {
        super(original);
    }

    public Knight makeCopy() {
        return new Knight(this);
    }

    @Override
    public ArrayList<Coordinate> getRawMoves(Pieces pieces) {
        ArrayList<Coordinate> front = Move.frontKnight(pieces,this);// Moves 2 squares forward and 1 to the side
        ArrayList<Coordinate> right = Move.backKnight(pieces,this);// Moves 2 squares back and 1 to the side
        ArrayList<Coordinate> back = Move.rightKnight(pieces,this);// Moves 1 square forward and 2 to the side
        ArrayList<Coordinate> left = Move.leftKnight(pieces,this);// Moves 1 square backward and 2 to the side

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
