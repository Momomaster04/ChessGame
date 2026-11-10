/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import Board.Board_Boundries;
import Board.GUI;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author mohan
 */
// the pawn moves forward 1 square withthe option to move 2 squares if it hasnt moved already from its starting position
// it also captures diagnolly and can get promoted
public class Pawn extends Piece {
    
     // whether the pawn has moved 2 squares forward
    private boolean hasMovedTwo = false;
    // the coordinate previously occupied by the pawn
    private Coordinate previousCoordinate = new Coordinate();
    // the piece to which the pawn will be promoted
    private Piece promotedPiece;
    private ImageIcon icon;

    public Pawn(COLOUR colour, Coordinate OGcoord) {
        super(PieceID.PAWN, colour, OGcoord);
        if (getColour() == COLOUR.B)
            icon = new ImageIcon("BPawn.png");
        else if (getColour() == COLOUR.W)
            icon = new ImageIcon("WPawn.png");
    }

    public Pawn(Pawn original) {
        super(original);
    }

    public void setPreviousCoordinate(Coordinate previousCoordinate) {
        this.previousCoordinate = previousCoordinate;
    }

    public Coordinate getPreviousCoordinate() {
        return previousCoordinate;
    }

    public void setHasMovedTwo() {
        this.hasMovedTwo = true;
    }

    public boolean getHasMovedTwo() {
        return hasMovedTwo;
    }

    // Checks if the Pawn can capture a piece diagonally to the left.
    private boolean canEatLeftDig(Pieces pieces) {

        int factorV;
        int factorH;

        if (getColour().equals(COLOUR.B)) {
            factorV = -1;
            factorH = 1;
        } else {
            factorV = 1;
            factorH = -1;
        }

        char newFile = (char) (getColumn() + factorH);
        int newRank = getRow() + factorV;
        Coordinate leftDig = new Coordinate(newFile, newRank);

        // Check if the capture coordinate is occupied by an opponent's piece
        return Move.tileFull(pieces, leftDig) && Move.isNotTileColour(pieces, leftDig, getColour());
    }

    // Checks if the Pawn can capture a piece diagonally to the right.
    private boolean canEatRightDig(Pieces pieces) {

        int factorV; 
        int factorH; 

        // Determine factors based on pawn color
        if (getColour().equals(COLOUR.B)) {
            factorV = -1;
            factorH = -1;
        } else {
            factorV = 1;
            factorH = 1;
        }

        char newFile = (char) (getColumn() + factorH);
        int newRank = getRow() + factorV;
        Coordinate rightDig = new Coordinate(newFile, newRank);

         // Check if the capture coordinate is occupied by an opponent's piece
        return Move.tileFull(pieces, rightDig) && Move.isNotTileColour(pieces, rightDig, getColour());
    }

    // Gets the potential forward moves for the Pawn.
    private ArrayList<Coordinate> pawnForward(Pieces pieces) {

        ArrayList<Coordinate> potentialForward = Move.frontFree(pieces, this, 2);
        ArrayList<Coordinate> actualForward = new ArrayList<>();

         // If potential forward moves are available
        if (potentialForward.size() > 0) {

            Coordinate front1 = potentialForward.get(0);
            Coordinate front2 = Coordinate.emptyCoordinate;

            // Check if a second forward move is available
            if (potentialForward.size() == 2) {
                front2 = potentialForward.get(1);
            }

            // Check if the first move is blocked
            if (Move.tileFull(pieces, front1))
                return actualForward;
            else {
                actualForward.add(front1);
            }

             // If the pawn is at its starting position, check for a second move
            if (pieces.findPiece(this).equals(getOGcoord()) && front2 != Coordinate.emptyCoordinate) {
                if (Move.tileFull(pieces, front2))
                    return actualForward; // Return if the second move is blocked
                else
                    actualForward.add(front2); // Add second move if not blocked
            }
        }
        return actualForward; // Return all valid forward moves
    }

    // Prompts the user to choose a piece for promotion when the Pawn reaches the last row.
     public void PromotionQuery (Coordinate promotionSquare) {

        JButton queenOption;
        JButton rookOption;
        JButton bishopOption;
        JButton knightOption;
        ImageIcon icon;

        // Create buttons and set the promoted piece based on pawn color
        if (this.getColour() == COLOUR.B) {
            queenOption = new JButton(new ImageIcon("BQueen.png"));
            rookOption = new JButton(new ImageIcon("BRook.png"));
            bishopOption = new JButton(new ImageIcon("BBishop.png"));
            knightOption = new JButton(new ImageIcon("BKnight.png"));
            promotedPiece = new Queen(COLOUR.B,promotionSquare); // Default promotion to Queen
            icon = new ImageIcon("BPawn.png");
        }
        else {
            queenOption = new JButton(new ImageIcon("WQueen.png"));
            rookOption = new JButton(new ImageIcon("WRook.png"));
            bishopOption = new JButton(new ImageIcon("WBishop.png"));
            knightOption = new JButton(new ImageIcon("WKnight.png"));
            promotedPiece = new Queen(COLOUR.W,promotionSquare); // Default promotion to Queen
            icon = new ImageIcon("WPawn.png");
        }

        // Format buttons to be invisible
        GUI.formatInvisibleButton(queenOption);
        GUI.formatInvisibleButton(rookOption);
        GUI.formatInvisibleButton(bishopOption);
        GUI.formatInvisibleButton(knightOption);

        //these are the Options to display in the dialog
        Object[] options = {"OK",knightOption,bishopOption,rookOption,queenOption};

        // Add action listeners for each promotion option
        queenOption.addActionListener(actionEvent -> promotedPiece = new Queen(getColour(),promotionSquare));

        rookOption.addActionListener(actionEvent -> promotedPiece = new Rook(getColour(),promotionSquare));

        bishopOption.addActionListener(actionEvent -> promotedPiece = new Bishop(getColour(),promotionSquare));

        knightOption.addActionListener(actionEvent -> promotedPiece = new Knight(getColour(),promotionSquare));

        // Customizins the appearance of the dialog
        UIManager.put("OptionPane.background", GUI.infoColour);
        UIManager.put("Panel.background", GUI.infoColour);
        UIManager.put("OptionPane.messageForeground", Color.white);

        // Show the promotion dialog
        JOptionPane.showOptionDialog(null,
                "Choose a piece to promote. A queen is the default:",
                "Promotion Query",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                options,options[0]);
    }

     // Checks if a black Pawn can be promoted.
    public boolean canPromoteBlack (Coordinate coordinate) {
        return this.getColour() == COLOUR.B && coordinate.getRow() == Board_Boundries.START_ROW.getRowVal();
    }

    // Checks if a white Pawn can be promoted.
    public boolean canPromoteWhite (Coordinate coordinate) {
        return this.getColour() == COLOUR.W && coordinate.getRow() == Board_Boundries.END_ROW.getRowVal();
    }

    // Get the promoted piece
    public Piece getPromotedPiece() {
        return promotedPiece;
    }

    @Override
    public Pawn makeCopy() {
        return new Pawn(this);
    }

    @Override
    public ArrayList<Coordinate> getRawMoves(Pieces pieces) {

        ArrayList<Coordinate> pawnMoves = new ArrayList<>();

        if (canEatLeftDig(pieces))
            pawnMoves.addAll(Move.frontLDigFree(pieces, this, 1));

        pawnMoves.addAll(pawnForward(pieces));

        if (canEatRightDig(pieces))
            pawnMoves.addAll(Move.frontRDigFree(pieces, this, 1));

        return pawnMoves;
    }

    @Override
    public ImageIcon getImageIcon() {
        return icon;
    }
    
}
