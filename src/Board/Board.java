/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Board;

import Piece.Bishop;
import Piece.COLOUR;
import Piece.Coordinate;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import java.util.HashMap;

/**
 *
 * @author mohan
 */
public class Board {
    
    /*
    *this Board Class will represent the setup for the Chess Game.
    *so this will initialize all the places of the pieces on the board and thier starting position
    */
    public static HashMap<Coordinate, Piece> ChessBoard() {

        HashMap <Coordinate, Piece> pieces = new HashMap<>();
        //thos method will return a HashMap with the coordinates as keys and the pieces as values
        // it will also hold all the pieces and thier coordinates

        // this will define the row numbers for pawns and major pieces for both black and white
        int pawnBRow = 7; // this is the Black Pawn row
        int bRow = 8; // this is the black piece row (not includeing the black pawn)
        int pawnWRow = 2;// this is the white pawm row
        int wRow = 1; // this is the white piece row (not including the white pawn)


        //Place all the black pawns on row 7 of the board
        Pawn pawnBa = new Pawn(COLOUR.B, new Coordinate('a', pawnBRow));
        Pawn pawnBb = new Pawn(COLOUR.B, new Coordinate('b', pawnBRow));
        Pawn pawnBc = new Pawn(COLOUR.B, new Coordinate('c', pawnBRow));
        Pawn pawnBd = new Pawn(COLOUR.B, new Coordinate('d', pawnBRow));
        Pawn pawnBe = new Pawn(COLOUR.B, new Coordinate('e', pawnBRow));
        Pawn pawnBf = new Pawn(COLOUR.B, new Coordinate('f', pawnBRow));
        Pawn pawnBg = new Pawn(COLOUR.B, new Coordinate('g', pawnBRow));
        Pawn pawnBh = new Pawn(COLOUR.B, new Coordinate('h', pawnBRow));

        // places all black rooks on a8 and h8
        Rook rookBa = new Rook(COLOUR.B, new Coordinate('a', bRow));
        Rook rookBh = new Rook(COLOUR.B, new Coordinate('h', bRow));

        // places all the black knights on b8 and g8
        Knight knightBb = new Knight(COLOUR.B, new Coordinate('b', bRow));
        Knight knightBg = new Knight(COLOUR.B, new Coordinate('g', bRow));

        // places all the balck bishops on c8 and f8
        Bishop bishopBc = new Bishop(COLOUR.B, new Coordinate('c', bRow));
        Bishop bishopBf = new Bishop(COLOUR.B, new Coordinate('f', bRow));

        //places the queen on d8 
        Queen queenB = new Queen(COLOUR.B, new Coordinate('d', bRow));

        //places the King on e8
        King kingB = new King(COLOUR.B, new Coordinate('e', bRow));

        //Place all the white pawns on row 2 of the board
        Pawn pawnWa = new Pawn(COLOUR.W, new Coordinate('a', pawnWRow));
        Pawn pawnWb = new Pawn(COLOUR.W, new Coordinate('b', pawnWRow));
        Pawn pawnWc = new Pawn(COLOUR.W, new Coordinate('c', pawnWRow));
        Pawn pawnWd = new Pawn(COLOUR.W, new Coordinate('d', pawnWRow));
        Pawn pawnWe = new Pawn(COLOUR.W, new Coordinate('e', pawnWRow));
        Pawn pawnWf = new Pawn(COLOUR.W, new Coordinate('f', pawnWRow));
        Pawn pawnWg = new Pawn(COLOUR.W, new Coordinate('g', pawnWRow));
        Pawn pawnWh = new Pawn(COLOUR.W, new Coordinate('h', pawnWRow));

        // places all white rooks on a1 and h1
        Rook rookWa = new Rook(COLOUR.W, new Coordinate('a', wRow));
        Rook rookWh = new Rook(COLOUR.W, new Coordinate('h', wRow));

        // places all the white knights on b1 and g1
        Knight knightWb = new Knight(COLOUR.W, new Coordinate('b', wRow));
        Knight knightWg = new Knight(COLOUR.W, new Coordinate('g', wRow));

        // places all the white bishops on c1 and f1
        Bishop bishopWc = new Bishop(COLOUR.W, new Coordinate('c', wRow));
        Bishop bishopWf = new Bishop(COLOUR.W, new Coordinate('f', wRow));

        //places the queen on d1
        Queen queenW = new Queen(COLOUR.W, new Coordinate('d', wRow));

        //places the King on e1
        King kingW = new King(COLOUR.W, new Coordinate('e', wRow));

        // this will add all the black pieces to the hashmap using thier coordinates as keys
        pieces.put(pawnBa.getCoords(), pawnBa);
        pieces.put(pawnBb.getCoords(), pawnBb);
        pieces.put(pawnBc.getCoords(), pawnBc);
        pieces.put(pawnBd.getCoords(), pawnBd);
        pieces.put(pawnBe.getCoords(), pawnBe);
        pieces.put(pawnBf.getCoords(), pawnBf);
        pieces.put(pawnBg.getCoords(), pawnBg);
        pieces.put(pawnBh.getCoords(), pawnBh);

        pieces.put(rookBa.getCoords(), rookBa);
        pieces.put(rookBh.getCoords(), rookBh);

        pieces.put(knightBb.getCoords(), knightBb);
        pieces.put(knightBg.getCoords(), knightBg);

        pieces.put(bishopBc.getCoords(), bishopBc);
        pieces.put(bishopBf.getCoords(), bishopBf);

        pieces.put(queenB.getCoords(), queenB);

        pieces.put(kingB.getCoords(), kingB);

         // this will add all the white pieces to the hashmap using thier coordinates as keys
        pieces.put(pawnWa.getCoords(), pawnWa);
        pieces.put(pawnWb.getCoords(), pawnWb);
        pieces.put(pawnWc.getCoords(), pawnWc);
        pieces.put(pawnWd.getCoords(), pawnWd);
        pieces.put(pawnWe.getCoords(), pawnWe);
        pieces.put(pawnWf.getCoords(), pawnWf);
        pieces.put(pawnWg.getCoords(), pawnWg);
        pieces.put(pawnWh.getCoords(), pawnWh);

        pieces.put(rookWa.getCoords(), rookWa);
        pieces.put(rookWh.getCoords(), rookWh);

        pieces.put(knightWb.getCoords(), knightWb);
        pieces.put(knightWg.getCoords(), knightWg);

        pieces.put(bishopWc.getCoords(), bishopWc);
        pieces.put(bishopWf.getCoords(), bishopWf);

        pieces.put(queenW.getCoords(), queenW);

        pieces.put(kingW.getCoords(), kingW);

        return pieces; // returns the hashmap with the complete set of starting pieces
    }

}

