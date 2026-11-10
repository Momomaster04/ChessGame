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
public class RookTest {
    
    public RookTest() {
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
     * Test of getCastleCoordRook method, of class Rook.
     */
    @Test
    public void testGetCastleCoordRook() {
        System.out.println("getCastleCoordRook");
        Rook instance = null;
        Coordinate expResult = new Coordinate((char) 0, 0);
        Coordinate result = instance.getCastleCoordRook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCastleCoordRook method, of class Rook.
     */
    @Test
    public void testSetCastleCoordRook() {
        System.out.println("setCastleCoordRook");
        Coordinate castleCoordRook = new Coordinate((char)1, 1);
        Rook instance = null;
        instance.setCastleCoordRook(castleCoordRook);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of makeCopy method, of class Rook.
     */
    @Test
    public void testMakeCopy() {
        System.out.println("makeCopy");
        Rook instance = null;
        Rook expResult = null;
        Rook result = instance.makeCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRawMoves method, of class Rook.
     */
    @Test
    public void testGetRawMoves() {
        System.out.println("getRawMoves");
        Pieces pieces = new Pieces();
        Rook instance = null;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = instance.getRawMoves(pieces);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getImageIcon method, of class Rook.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        Rook instance = null;
        ImageIcon expResult = new ImageIcon();
        ImageIcon result = instance.getImageIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
