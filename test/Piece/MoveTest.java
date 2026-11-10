/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Piece;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Piece.Coordinate;
import Piece.COLOUR;

/**
 *
 * @author mohan
 */
public class MoveTest {
    
    public MoveTest() {
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
     * Test of isNotTileColour method, of class Move.
     */
    @Test
    public void testIsNotTileColour() {
        System.out.println("isNotTileColour");
        Pieces pieces = new Pieces(); 
        Coordinate coordinate = new Coordinate((char) 0,0);
        COLOUR colour = COLOUR.W;
       
        boolean expResult = true;
        boolean result = Move.isNotTileColour(pieces, coordinate, colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of tileFull method, of class Move.
     */
    @Test
    public void testTileFull() {
        System.out.println("tileFull");
        Pieces pieces = new Pieces(); 
        Coordinate destination = new Coordinate((char) 0,0);
        
        boolean expResult = true;
        boolean result = Move.tileFull(pieces, destination);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of frontFree method, of class Move.
     */
    @Test
    public void testFrontFree() {
        System.out.println("frontFree");
        Pieces pieces = new Pieces();
        Piece piece = new Rook(COLOUR.W, new Coordinate((char)1, 8));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.frontFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of backFree method, of class Move.
     */
    @Test
    public void testBackFree() {
        System.out.println("backFree");
        Pieces pieces = new Pieces();
        Piece piece = new Queen(COLOUR.W, new Coordinate((char)1, 7));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.backFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of rightFree method, of class Move.
     */
    @Test
    public void testRightFree() {
        System.out.println("rightFree");
        Pieces pieces = new Pieces();
        Piece piece = new Queen(COLOUR.W, new Coordinate((char)4, 4));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.rightFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of leftFree method, of class Move.
     */
    @Test
    public void testLeftFree() {
        System.out.println("leftFree");
        Pieces pieces = new Pieces();
        Piece piece = new King(COLOUR.W, new Coordinate((char)4, 5));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.leftFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of frontRDigFree method, of class Move.
     */
    @Test
    public void testFrontRDigFree() {
        System.out.println("frontRDigFree");
        Pieces pieces = new Pieces();
        Piece piece = new Bishop(COLOUR.W, new Coordinate((char)3, 2));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.frontRDigFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of backRDigFree method, of class Move.
     */
    @Test
    public void testBackRDigFree() {
        System.out.println("backRDigFree");
        Pieces pieces = new Pieces();
        Piece piece = new Pawn(COLOUR.W, new Coordinate((char)2, 1));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.backRDigFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of backLDigFree method, of class Move.
     */
    @Test
    public void testBackLDigFree() {
        System.out.println("backLDigFree");
        Pieces pieces = new Pieces();
        Piece piece = new Knight(COLOUR.W, new Coordinate((char)2, 2));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.backLDigFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of frontLDigFree method, of class Move.
     */
    @Test
    public void testFrontLDigFree() {
        System.out.println("frontLDigFree");
        Pieces pieces = new Pieces();
        Piece piece = new Bishop(COLOUR.B, new Coordinate((char)2, 8));
        int limit = 0;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.frontLDigFree(pieces, piece, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of frontKnight method, of class Move.
     */
    @Test
    public void testFrontKnight() {
        System.out.println("frontKnight");
        Pieces pieces = new Pieces();
        Piece piece = new Bishop(COLOUR.B, new Coordinate((char)3, 6));
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.frontKnight(pieces, piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of backKnight method, of class Move.
     */
    @Test
    public void testBackKnight() {
        System.out.println("backKnight");
        Pieces pieces = new Pieces();
        Piece piece = new Pawn(COLOUR.B, new Coordinate((char)1, 7));
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.backKnight(pieces, piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of rightKnight method, of class Move.
     */
    @Test
    public void testRightKnight() {
        System.out.println("rightKnight");
        Pieces pieces = new Pieces();
        Piece piece = new Knight(COLOUR.B, new Coordinate((char)1, 7));
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = Move.rightKnight(pieces, piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of leftKnight method, of class Move.
     */
    @Test
    public void testLeftKnight() {
        System.out.println("leftKnight");
        Pieces pieces = new Pieces();
        Piece piece = new Knight(COLOUR.W, new Coordinate((char)3, 8));
        ArrayList<Coordinate> expResult = null;
        ArrayList<Coordinate> result = Move.leftKnight(pieces, piece);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
