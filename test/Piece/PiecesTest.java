/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mohan
 */
public class PiecesTest {
    
    public PiecesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPieces method, of class Pieces.
     */
    @Test
    public void testGetPieces() {
        System.out.println("getPieces");
        Pieces instance = new Pieces();
        HashMap<Coordinate, Piece> expResult = new HashMap<>();
        HashMap<Coordinate, Piece> result = instance.getPieces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPieces method, of class Pieces.
     */
    @Test
    public void testSetPieces() {
        System.out.println("setPieces");
        HashMap<Coordinate, Piece> pieces = new HashMap<>();
        Pieces instance = new Pieces();
        instance.setPieces(pieces);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIsCapture method, of class Pieces.
     */
    @Test
    public void testGetIsCapture() {
        System.out.println("getIsCapture");
        Pieces instance = new Pieces();
        boolean expResult = true;
        boolean result = instance.getIsCapture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIsCapture method, of class Pieces.
     */
    @Test
    public void testSetIsCapture() {
        System.out.println("setIsCapture");
        boolean captureStatus = true;
        Pieces instance = new Pieces();
        instance.setIsCapture(captureStatus);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPreviousPieces method, of class Pieces.
     */
    @Test
    public void testGetPreviousPieces() {
        System.out.println("getPreviousPieces");
        Pieces instance = new Pieces();
        HashMap<Coordinate, Piece> expResult = new HashMap<>();
        HashMap<Coordinate, Piece> result = instance.getPreviousPieces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPreviousPieces method, of class Pieces.
     */
    @Test
    public void testSetPreviousPieces() {
        System.out.println("setPreviousPieces");
        HashMap<Coordinate, Piece> previousPieces = new HashMap<>();
        Pieces instance = new Pieces();
        instance.setPreviousPieces(previousPieces);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getGameProgress method, of class Pieces.
     */
    @Test
    public void testGetGameProgress() {
        System.out.println("getGameProgress");
        Pieces instance = new Pieces();
        ArrayList<HashMap<Coordinate, Piece>> expResult = new ArrayList<>();
        ArrayList<HashMap<Coordinate, Piece>> result = instance.getGameProgress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addPiece method, of class Pieces.
     */
    @Test
    public void testAddPiece() {
        System.out.println("addPiece");
        Coordinate coordinate = new Coordinate((char)1,1);
        Piece piece = null;
        Pieces instance = new Pieces();
        instance.addPiece(coordinate, piece);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findPiece method, of class Pieces.
     */
    @Test
    public void testFindPiece() {
        System.out.println("findPiece");
        Piece piece = null;
        Pieces instance = new Pieces();
        Coordinate expResult = new Coordinate((char)2, 4);
        Coordinate result = instance.findPiece(piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findKing method, of class Pieces.
     */
    @Test
    public void testFindKing() {
        System.out.println("findKing");
        COLOUR colour = COLOUR.B;
        Pieces instance = new Pieces();
        Coordinate expResult = new Coordinate((char)3, 4);;
        Coordinate result = instance.findKing(colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPiece method, of class Pieces.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Coordinate coordinate = new Coordinate((char)1, 6);;
        Pieces instance = new Pieces();
        Piece expResult = Piece.emptyPiece;
        Piece result = instance.getPiece(coordinate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getColourPieces method, of class Pieces.
     */
    @Test
    public void testGetColourPieces() {
        System.out.println("getColourPieces");
        COLOUR colour = COLOUR.W;
        Pieces instance = new Pieces();
        HashMap<Coordinate, Piece> expResult = new HashMap<>();
        HashMap<Coordinate, Piece> result = instance.getColourPieces(colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of allColouredPotentials method, of class Pieces.
     */
    @Test
    public void testAllColouredPotentials() {
        System.out.println("allColouredPotentials");
        COLOUR colour = COLOUR.B;
        Pieces instance = new Pieces();
        HashSet<Coordinate> expResult = new HashSet<>();
        HashSet<Coordinate> result = instance.allColouredPotentials(colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of allColouredRaws method, of class Pieces.
     */
    @Test
    public void testAllColouredRaws() {
        System.out.println("allColouredRaws");
        COLOUR colour = COLOUR.W;
        Pieces instance = new Pieces();
        HashSet<Coordinate> expResult = new HashSet<>();
        HashSet<Coordinate> result = instance.allColouredRaws(colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updatePreviousMovePawns method, of class Pieces.
     */
    @Test
    public void testUpdatePreviousMovePawns() {
        System.out.println("updatePreviousMovePawns");
        Pieces instance = new Pieces();
        instance.updatePreviousMovePawns();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of pieceInSameFile method, of class Pieces.
     */
    @Test
    public void testPieceInSameFile() {
        System.out.println("pieceInSameFile");
        Piece piece = Piece.emptyPiece;
        Pieces instance = new Pieces();
        boolean expResult = true;
        boolean result = instance.pieceInSameColumn(piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of pieceInSameRank method, of class Pieces.
     */
    @Test
    public void testPieceInSameRank() {
        System.out.println("pieceInSameRank");
        Piece piece = Piece.emptyPiece;
        Pieces instance = new Pieces();
        boolean expResult = false;
        boolean result = instance.pieceInSameRow(piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of pieceToSameCoordinate method, of class Pieces.
     */
    @Test
    public void testPieceToSameCoordinate() {
        System.out.println("pieceToSameCoordinate");
        Coordinate coordinate = new Coordinate((char)1,1);
        Piece piece = Piece.emptyPiece;
        Pieces instance = new Pieces();
        boolean expResult = false;
        boolean result = instance.pieceToSameCoordinate(coordinate, piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isCheck method, of class Pieces.
     */
    @Test
    public void testIsCheck() {
        System.out.println("isCheck");
        COLOUR colour = COLOUR.B;
        Pieces instance = new Pieces();
        boolean expResult = false;
        boolean result = instance.isCheck(colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isMate method, of class Pieces.
     */
    @Test
    public void testIsMate() {
        System.out.println("isMate");
        COLOUR colour = COLOUR.B;
        Pieces instance = new Pieces();
        boolean expResult = false;
        boolean result = instance.isMate(colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of pieceMove method, of class Pieces.
     */
    @Test
    public void testPieceMove() {
        System.out.println("pieceMove");
        Coordinate coordinate = new Coordinate((char)2, 5);
        Piece piece = Piece.emptyPiece;
        Pieces instance = new Pieces();
        instance.pieceMove(coordinate, piece);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of makeMove method, of class Pieces.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        Coordinate coordinate = new Coordinate((char)2 ,3);
        Piece piece = Piece.emptyPiece;
        Pieces instance = new Pieces();
        instance.makeMove(coordinate, piece);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updatePotentials method, of class Pieces.
     */
    @Test
    public void testUpdatePotentials() {
        System.out.println("updatePotentials");
        Pieces instance = new Pieces();
        instance.updatePotentials();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class Pieces.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Object();
        Pieces instance = new Pieces();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class Pieces.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Pieces instance = new Pieces();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
