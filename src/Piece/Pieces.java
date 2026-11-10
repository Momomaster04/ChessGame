/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import Board.Board;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author mohan
 */
/*
* the pieces class is responsible fpr managing all the pieces in the chess game
* this includes the positions, possible moves, and game state for eg. chack and capture
* this class will aslso track moves of the board allowing moves to be copied
*/
public class Pieces {
    
    
    
    private HashMap<Coordinate, Piece> pieces; // this is the current state of the pieces on the board
    private HashMap<Coordinate, Piece> previousPieces; //the same as above but the previous move instead
    private boolean isCapture; // indicates if the last move was a capture
    private ArrayList<HashMap<Coordinate,Piece>> gameProgress = new ArrayList<>(); // keeps terack of the board status

    public Pieces() {
        pieces = Board.ChessBoard(); //sets up the pieces in thier starting positions
        previousPieces = copyHashMap(pieces);// copies the starting position
        gameProgress.add(copyHashMap(pieces));// adds it to the move history
        updatePotentials(); // when we instantiate Pieces, we immediately calculte the potential moves to begin the game
    }

    public Pieces(HashMap<Coordinate, Piece> newBoard) {
        pieces = newBoard;
        previousPieces = copyHashMap(pieces);
        gameProgress.add(copyHashMap(pieces));
        updatePotentials();
    }

    public Pieces (Pieces original) { // we create a copy constructor to help calculate potential moves
        this.pieces = copyHashMap(original.getPieces());
        this.previousPieces = original.previousPieces;
        this.isCapture = original.isCapture;
        this.gameProgress = copyArrayHash(original.getGameProgress());
    }

    private HashMap<Coordinate, Piece> copyHashMap (HashMap<Coordinate, Piece> original) { // creates a copy of a pieces HashMap
        // Original os the original HashMap to copy
        HashMap<Coordinate, Piece> copyMap = new HashMap<>();
        for (Coordinate key : original.keySet()) {
            Coordinate newKey = new Coordinate(key);
            Piece newPiece = original.get(key).makeCopy(); // creates a copy of each piece to avoid modifying the original
            copyMap.put(newKey,newPiece);
        }

        return copyMap;
    }

    private ArrayList<HashMap<Coordinate,Piece>> copyArrayHash (ArrayList<HashMap<Coordinate,Piece>> original) { // creates a copy of a gameProgress ArrayList
        ArrayList<HashMap<Coordinate,Piece>> copyList = new ArrayList<>();
        for (HashMap<Coordinate,Piece> game : original) {
            copyList.add(copyHashMap(game));
        }

        return copyList; //this will return a new ArrayList containing copies 
    }

    public HashMap<Coordinate, Piece> getPieces() {  //retireves teh current board state
        return pieces;
    }

    // sets the board state with a new configuration of pieces
    public void setPieces(HashMap<Coordinate,Piece> pieces) {this.pieces = pieces;}

    //retrievs the capture status of the last move
    public boolean getIsCapture() {
        return isCapture;
    }

    // updates the capture status
    public void setIsCapture(boolean captureStatus) {
        this.isCapture = captureStatus;
    }

    //retrieves the previous oard state before the last move
    public HashMap<Coordinate, Piece> getPreviousPieces() {
        return previousPieces;
    }

    //sets the previous board
    public void setPreviousPieces(HashMap<Coordinate, Piece> previousPieces) {
        this.previousPieces = copyHashMap(previousPieces);
    }

    // retrieves teh game progress history
    public ArrayList<HashMap<Coordinate, Piece>> getGameProgress() {
        return gameProgress;
    }

    // adds a piece to the board at the specific coordinate
    public void addPiece(Coordinate coordinate, Piece piece) {
        pieces.put(coordinate,piece);
    }

    // finds the coordinate of a specific piece
    public Coordinate findPiece(Piece piece) {

        for (Coordinate key : pieces.keySet()) {
            if (pieces.get(key).equals(piece))
                return key;
        }
        return Coordinate.emptyCoordinate; // returns the coordinates of the piece if found otherwise an empty coordinate
    }

    // Finds the coordinate of the king of a given color.
    public Coordinate findKing(COLOUR colour) {
        for (Coordinate key : pieces.keySet()) {
            Piece potentialKing = pieces.get(key);
            if (potentialKing.getName().equals(PieceID.KING) && (potentialKing.getColour() == colour))
                return key;
        }
        return Coordinate.emptyCoordinate;
    }
    
    // Retrieves a piece at a given coordinate.
    public Piece getPiece(Coordinate coordinate) {

        for (Coordinate key : pieces.keySet()) {
            if (key.equals(coordinate))
                return pieces.get(key);
        }
        return Piece.emptyPiece; //returns the pieca at the coordinate or an empty piece if none exists
    }
    
    // Retrieves all pieces of a specified color.
    public HashMap<Coordinate, Piece> getColourPieces(COLOUR colour) {
        HashMap<Coordinate,Piece> colours = new HashMap<>();
        for (Coordinate key : pieces.keySet()) {
            Piece piece = pieces.get(key);
            if (piece.getColour() == colour)
                colours.put(key,piece);
        }
        return colours;
    }

    //  Calculates all the potential moves for pieces of a specified color.
    public HashSet<Coordinate> allColouredPotentials (COLOUR colour) {
        HashSet<Coordinate> allMoves = new HashSet<>();
        HashMap<Coordinate, Piece> allColoured = getColourPieces(colour);
        for (Piece piece : allColoured.values()){
            allMoves.addAll(piece.getPotentialMoves());
        }
        return allMoves; //returns a Hashset of coordinates representing all the potential moves
    }


    /*Calculates all raw moves for pieces of a given color. Raw moves include all possible
    * moves without considering the effects on the king
    */
    public HashSet<Coordinate> allColouredRaws (COLOUR colour) {
        HashSet<Coordinate> allMoves = new HashSet<>();
        HashMap<Coordinate, Piece> allColoured = getColourPieces(colour);
        for (Piece piece : allColoured.values()){
            allMoves.addAll(piece.getRawMoves(this));
        }
        return allMoves; // returns a hashset of coordinates representing all the raw moves for the specified colour
    }


    // Updates the previous coordinate of all pawns
    public void updatePreviousMovePawns () {
        for (Piece potentialPawn : pieces.values()){
            if (potentialPawn.getName() == PieceID.PAWN) {
                Pawn pawn = (Pawn) potentialPawn;
                pawn.setPreviousCoordinate(pawn.getCoords());
            }
        }
    }

    //checks if there are any pieces of the same type as `piece` in the same Column
    public boolean pieceInSameColumn (Piece piece) {

        if (piece.getName() == PieceID.KING)
            return false;

        HashMap <Coordinate, Piece> coloured = getColourPieces(piece.getColour());
        for (Piece value : coloured.values()) {
            if (value.getName() == piece.getName() && value.getColumn() == piece.getColumn() && !value.equals(piece))
                return true; // returns true if another peice of teh same type and colour is in the same column
        }
        return false;
    }


    //  Checks if there are any pieces of the same type as `piece` in the same row
    public boolean pieceInSameRow (Piece piece) {

        if (piece.getName() == PieceID.KING)
            return false;

        HashMap <Coordinate, Piece> coloured = getColourPieces(piece.getColour());
        for (Piece value : coloured.values()) {
            if (value.getName() == piece.getName() && value.getRow() == piece.getRow() && !value.equals(piece))
                return true;// returns true if another peice of teh same type and colour is in the same row
        }
        return false;
    }


    //Checks if another piece of the same type and color can move to the same coordinate.
    public boolean pieceToSameCoordinate (Coordinate coordinate, Piece piece) {
        assert piece.getPotentialMoves().contains(coordinate);

        if (piece.getName() == PieceID.KING)  // Kings are unique and do not share coordinates
            return false;

        HashMap <Coordinate, Piece> coloured = getColourPieces(piece.getColour()); // Gets all pieces of the same color
        for (Piece value : coloured.values()) {
            if (value.getName() == piece.getName() && value.getPotentialMoves().contains(coordinate) && !value.equals(piece))
                return true;
        }
        return false;
    }


    // Checks if the king of the specified color is in check.
    public boolean isCheck(COLOUR colour) { 
        Coordinate kingPosition = findKing(colour); // Find the king's position
        
        HashSet<Coordinate> dangerMoves = allColouredPotentials(COLOUR.not(colour));
        return (dangerMoves.contains(kingPosition)); // true if the king is in check otherwise its false
    }


    // Checks if the specified color is in checkmate.
    public boolean isMate(COLOUR colour) {
        HashSet<Coordinate> allMoves = allColouredPotentials(colour);
        return isCheck(colour) && (allMoves.size() == 0); //true if the color is in checkmate; false otherwise.
    }

    // Moves a piece to a new coordinate on the board, updating its position and internal state.
    public void pieceMove (Coordinate coordinate, Piece piece) {
        Coordinate pieceCoord = findPiece(piece); // Find the current position of the piece
        addPiece(coordinate, piece);              // Placea the piece at the new coordinate
        piece.setCoords(coordinate);              // Update the piece’s coordinates
        piece.setHasMoved();                      // Mark the piece as having moved
        pieces.remove(pieceCoord);                // Remove the piece from its original position
    }


    // Executes a move if valid
    // also it handles moves such as castling and promotion
    public void makeMove (Coordinate coordinate, Piece piece) {

        if (piece.isValidMove(coordinate, piece.getColour())) {  // Ensure move is valid
            setPreviousPieces(this.getPieces());             // Save the current state before moving
            isCapture = Move.tileFull(this, coordinate) && Move.isNotTileColour(this,coordinate, piece.getColour()); 
            if (piece.getName() == PieceID.KING) {     // Handle castling for kings
                King castleKing = (King) piece;
                 // Check for queenside castle
                if (castleKing.CastleQueen(this) && coordinate.equals(castleKing.getCastleCoordinateKingQ()) && !isCheck(castleKing.getColour())) {  
                    assert !findPiece(castleKing.getRookQueen()).equals(Coordinate.emptyCoordinate);  //also Ensure rook exists
                    pieceMove(coordinate,castleKing); // moves king
                    pieceMove(castleKing.getRookQueen().getCastleCoordRook(),castleKing.getRookQueen()); // moves teh rook
                   
                }// Check for kingside castle
                else if (castleKing.CastleKing(this) && coordinate.equals(castleKing.getCastleCoordinateKingK()) && !isCheck(castleKing.getColour())) {
                    assert !findPiece(castleKing.getRookKing()).equals(Coordinate.emptyCoordinate);
                    pieceMove(coordinate,castleKing);
                    pieceMove(castleKing.getRookKing().getCastleCoordRook(),castleKing.getRookKing());
                }
                else {
                    pieceMove(coordinate, castleKing);
                }
            }
            else if (piece.getName() == PieceID.PAWN) {  // Handles pawn promotion
                Pawn pawn = (Pawn) piece;

                updatePreviousMovePawns();

                if (pawn.canPromoteBlack(coordinate) || pawn.canPromoteWhite(coordinate)) { // Check for promotion
                    Piece toPromote;
                        pawn.PromotionQuery(coordinate);// Replace with promoted piece
                        toPromote = pawn.getPromotedPiece();
                    
                    
                    
                    Coordinate pieceCoord = findPiece(piece);
                    addPiece(coordinate, toPromote);
                    pieces.remove(pieceCoord);
                }
                
               
 
                else {
                    
                    pieceMove(coordinate, pawn);// Regular pawn move
                }
            }
            else {
                pieceMove(coordinate, piece);
            }
        }
        

        gameProgress.add(copyHashMap(pieces));  // Log move history for the board state
        updatePotentials();  // Update all potential moves after a move is made

    }

    //Updates all the potential moves for each piece on the board.
    public void updatePotentials() {

        for (Piece value : pieces.values()) {
            value.clearMoves();
            value.updatePotentialMoves(this);
        }
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pieces pieces1 = (Pieces) o;
        return Objects.equals(pieces, pieces1.pieces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieces);
    }
    
}
