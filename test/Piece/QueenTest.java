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
public class QueenTest {
    
    public QueenTest() {
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
     * Test of makeCopy method, of class Queen.
     */
    @Test
    public void testMakeCopy() {
        System.out.println("makeCopy");
        Queen instance = null;
        Queen expResult = null;
        Queen result = instance.makeCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRawMoves method, of class Queen.
     */
    @Test
    public void testGetRawMoves() {
        System.out.println("getRawMoves");
        Pieces pieces = new Pieces();
        Queen instance = null;
        ArrayList<Coordinate> expResult = null;
        ArrayList<Coordinate> result = instance.getRawMoves(pieces);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getImageIcon method, of class Queen.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        Queen instance = null;
        ImageIcon expResult = new ImageIcon();
        ImageIcon result = instance.getImageIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
