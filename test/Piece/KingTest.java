/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Piece;

import java.util.ArrayList;
import javax.swing.ImageIcon;
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
public class KingTest {
    
    public KingTest() {
        
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
     * Test of getCastleCoordinateKingK method, of class King.
     */
    @Test
    public void testGetCastleCoordinateKingK() {
        System.out.println("getCastleCoordinateKingK");
        King instance = null;
        Coordinate expResult = new Coordinate((char)1,0);
        Coordinate result = instance.getCastleCoordinateKingK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCastleCoordinateKingQ method, of class King.
     */
    @Test
    public void testGetCastleCoordinateKingQ() {
        System.out.println("getCastleCoordinateKingQ");
        King instance = null;
        Coordinate expResult = new Coordinate((char)7,4);
        Coordinate result = instance.getCastleCoordinateKingQ();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTransitionCoordinateKingK method, of class King.
     */
    @Test
    public void testGetTransitionCoordinateKingK() {
        System.out.println("getTransitionCoordinateKingK");
        King instance = null;
        Coordinate expResult = new Coordinate((char)4,4);
        Coordinate result = instance.getTransitionCoordinateKingK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTransitionCoordinateKingQ method, of class King.
     */
    @Test
    public void testGetTransitionCoordinateKingQ() {
        System.out.println("getTransitionCoordinateKingQ");
        King instance = null;
        Coordinate expResult = new Coordinate((char)1,7);
        Coordinate result = instance.getTransitionCoordinateKingQ();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRookKing method, of class King.
     */
    @Test
    public void testGetRookKing() {
        System.out.println("getRookKing");
        King instance = null;
        Rook expResult = new Rook(COLOUR.W, new Coordinate((char)0, 0));
        Rook result = instance.getRookKing();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRookQueen method, of class King.
     */
    @Test
    public void testGetRookQueen() {
        System.out.println("getRookQueen");
        King instance = null;
        Rook expResult = new Rook(COLOUR.W, new Coordinate((char)7, 1));
        Rook result = instance.getRookQueen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of CastleKing method, of class King.
     */
    @Test
    public void testCastleKing() {
        System.out.println("CastleKing");
        Pieces pieces = new Pieces();
        King instance = null;
        boolean expResult = false;
        boolean result = instance.CastleKing(pieces);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of CastleQueen method, of class King.
     */
    @Test
    public void testCastleQueen() {
        System.out.println("CastleQueen");
        Pieces pieces = new Pieces();
        King instance = null;
        boolean expResult = false;
        boolean result = instance.CastleQueen(pieces);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of makeCopy method, of class King.
     */
    @Test
    public void testMakeCopy() {
        System.out.println("makeCopy");
        King instance = null;
        King expResult = null;
        King result = instance.makeCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRawMoves method, of class King.
     */
    @Test
    public void testGetRawMoves() {
        System.out.println("getRawMoves");
        Pieces pieces = new Pieces();
        King instance = null;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = instance.getRawMoves(pieces);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getImageIcon method, of class King.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        King instance = null;
        ImageIcon expResult = new ImageIcon();
        ImageIcon result = instance.getImageIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
