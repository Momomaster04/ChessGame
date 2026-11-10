/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Board;

import Piece.COLOUR;
import Piece.Coordinate;
import Piece.King;
import Piece.Pawn;
import Piece.Piece;
import Piece.PieceID;
import Piece.Pieces;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author mohan
 */

//  ChessIO class handles saving and loading game data.
// It also includes methods for creating move strings and validating filenames,
public class ChessIO {
    // representation of what an error is
    private static final String errorSave = "$$$";

    
    //Generates a string representation of a move.
    public static String moveString (Pieces pieces, Coordinate coordinate, Piece piece) {

        boolean isCastle = false; // Flag to determine if the move is a castling move.

        StringBuilder str = new StringBuilder();
        Pieces previousBoard = new Pieces(pieces.getPreviousPieces()); // Create a previous board state for comparison.
        Coordinate previousCoordinate = previousBoard.findPiece(piece);
        Piece previousPiece = previousBoard.getPiece(previousCoordinate);

         // Append piece identifier unless it's a King.
        if (piece.getName() != PieceID.KING) {
            str.append(piece.getName().toString());
        }
        else {
            King king = (King) piece;
            King previousKing = (King) previousPiece;

             // Check for castling moves.
            if (coordinate.equals(king.getCastleCoordinateKingQ()) && previousKing.CastleQueen(previousBoard)) {
                str.append("O-O-O");
                isCastle = true;
            }
            else if (coordinate.equals(king.getCastleCoordinateKingQ()) && previousKing.CastleKing(previousBoard)) {
                str.append("O-O");
                isCastle = true;
            }
            else
                str.append(piece.getName().toString());
        }

        // Remove ambiguity from the move if necessary.
        str.append(removeAmbiguous(previousBoard, coordinate, previousPiece));

         // Append capture notation if the move involves capturing a piece.
        if (pieces.getIsCapture()) {
            if (piece.getName() == PieceID.PAWN) {
                assert piece instanceof Pawn;
                Pawn pawn = (Pawn) piece;
                str.append(pawn.getPreviousCoordinate().getColumn()).append("x");
            }
            else
                str.append("x"); // Generic capture notation for non-pawn pieces.
        }

         // Append destination coordinate unless it is a castling move.
        if (!isCastle) {
            str.append(coordinate.toString());
        }

        // Check for pawn promotion and append the promoted piece.
        if (piece.getName() == PieceID.PAWN) {
            Pawn pawn = (Pawn) piece;
            if (pawn.canPromoteBlack(coordinate) || pawn.canPromoteWhite(coordinate))
                str.append("=").append(pawn.getPromotedPiece().getName().toString());
        }

        // Append check/mate notations.
        if (pieces.isMate(COLOUR.not(piece.getColour())))
            str.append("#");
        else if (pieces.isCheck(COLOUR.not(piece.getColour())))
            str.append("+");

        return str.toString();
    }

    // Removes ambiguous move information.
    public static String removeAmbiguous (Pieces pieces, Coordinate coordinate, Piece piece) {
        // Check if there are pieces that can occupy the target coordinate.
        if (pieces.pieceToSameCoordinate(coordinate, piece)) {
            // If there are pieces in the same row, append the column.
            if (pieces.pieceInSameRow(piece))
                return piece.getColumn() + ""; // e.g. "Ra5" for rook on a5
            // If there are pieces in the same column, append the row.
            else if (pieces.pieceInSameColumn(piece)) //e.g. "R3: for rook on row 3
                return piece.getRow() + "";
            else
                return "";
        }
        else
            return "";
    }

    // ensure it is a valid text file path.
    public static String toTxt (String filePath) {

        // Remove all whitespace from the filename.
        filePath = filePath.replaceAll("\\s","");

        // Return an error marker if the filename is empty.
        if (filePath.length() == 0)
            return errorSave;

        int periodCheck = filePath.lastIndexOf(".");

         // If there is no period, append .txt extension.
        if (periodCheck == -1)
            return filePath + ".txt";
        // If it's already a .txt file, return it as is.
        else if (filePath.substring(periodCheck).length() == 4)
            return filePath;
        else
            return errorSave; // If it has an invalid extension, return an error marker.
    }

    //  Checks if a given filename is an error.
    public static boolean isErrorSave (String potentialFile) {
        return errorSave.equals(potentialFile);
    }

    // Saves the game state to a specified file path.
    public static boolean saveGame(String game, Path saveFile) {

        String path = String.valueOf(saveFile);
        File gameFile = new File(path); // we create an instance of a file with the given path
        if (!gameFile.exists()) { // ensures that we don't overwrite an existing file
            try {
                FileWriter writer = new FileWriter(path);
                writer.write(game); // Write the game state to the file.
                writer.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace(); // Print the stack trace for debugging in case of an IOException.
            }
        }
        return false; // Return false if the file already exists or an error occurred.
    }
    
}
