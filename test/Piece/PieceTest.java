/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Piece;

import java.util.ArrayList;
import java.util.HashSet;
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
public class PieceTest {
    
    public PieceTest() {
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
     * Test of getCoords method, of class Piece.
     */
    @Test
    public void testGetCoords() {
        System.out.println("getCoords");
        Piece instance = null;
        Coordinate expResult = new Coordinate((char)1, 1);
        Coordinate result = instance.getCoords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getColumn method, of class Piece.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Piece instance = null;
        char expResult = 'A';
        char result = instance.getColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRow method, of class Piece.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Piece instance = null;
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getColour method, of class Piece.
     */
    @Test
    public void testGetColour() {
        System.out.println("getColour");
        Piece instance = null;
        COLOUR expResult = COLOUR.W;
        COLOUR result = instance.getColour();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getName method, of class Piece.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Piece instance = null;
        PieceID expResult = PieceID.ROOK;
        PieceID result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getOGcoord method, of class Piece.
     */
    @Test
    public void testGetOGcoord() {
        System.out.println("getOGcoord");
        Piece instance = null;
        Coordinate expResult = new Coordinate((char)2, 2);
        Coordinate result = instance.getOGcoord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPieceID method, of class Piece.
     */
    @Test
    public void testGetPieceID() {
        System.out.println("getPieceID");
        Piece instance = null;
        String expResult = "B";
        String result = instance.getPieceID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCoords method, of class Piece.
     */
    @Test
    public void testSetCoords() {
        System.out.println("setCoords");
        Coordinate coords = new Coordinate((char)4, 4);
        Piece instance = null;
        instance.setCoords(coords);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHasMoved method, of class Piece.
     */
    @Test
    public void testGetHasMoved() {
        System.out.println("getHasMoved");
        Piece instance = null;
        boolean expResult = true;
        boolean result = instance.getHasMoved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setHasMoved method, of class Piece.
     */
    @Test
    public void testSetHasMoved() {
        System.out.println("setHasMoved");
        Piece instance = null;
        instance.setHasMoved();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addMoves method, of class Piece.
     */
    @Test
    public void testAddMoves() {
        System.out.println("addMoves");
        ArrayList<Coordinate> someMoves = new ArrayList<>();
        Piece instance = null;
        instance.addMoves(someMoves);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of clearMoves method, of class Piece.
     */
    @Test
    public void testClearMoves() {
        System.out.println("clearMoves");
        Piece instance = null;
        instance.clearMoves();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPotentialMoves method, of class Piece.
     */
    @Test
    public void testGetPotentialMoves() {
        System.out.println("getPotentialMoves");
        Piece instance = null;
        HashSet<Coordinate> expResult = new HashSet<>();
        HashSet<Coordinate> result = instance.getPotentialMoves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeOwnCheck method, of class Piece.
     */
    @Test
    public void testRemoveOwnCheck() {
        System.out.println("removeOwnCheck");
        Pieces pieces = new Pieces();
        Piece instance = null;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = instance.removeOwnCheck(pieces);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updatePotentialMoves method, of class Piece.
     */
    @Test
    public void testUpdatePotentialMoves() {
        System.out.println("updatePotentialMoves");
        Pieces pieces = new Pieces();
        Piece instance = null;
        instance.updatePotentialMoves(pieces);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isValidMove method, of class Piece.
     */
    @Test
    public void testIsValidMove() {
        System.out.println("isValidMove");
        Coordinate destination = null;
        COLOUR colour = COLOUR.B;
        Piece instance = null;
        boolean expResult = true;
        boolean result = instance.isValidMove(destination, colour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class Piece.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Piece instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class Piece.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Piece instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRawMoves method, of class Piece.
     */
    @Test
    public void testGetRawMoves() {
        System.out.println("getRawMoves");
        Pieces pieces = new Pieces();
        Piece instance = null;
        ArrayList<Coordinate> expResult = new ArrayList<>();
        ArrayList<Coordinate> result = instance.getRawMoves(pieces);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getImageIcon method, of class Piece.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        Piece instance = null;
        ImageIcon expResult = null;
        ImageIcon result = instance.getImageIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of makeCopy method, of class Piece.
     */
    @Test
    public void testMakeCopy() {
        System.out.println("makeCopy");
        Piece instance = null;
        Piece expResult = null;
        Piece result = instance.makeCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    public class PieceImpl extends Piece {

        public PieceImpl() {
            super(null);
        }

        public ArrayList<Coordinate> getRawMoves(Pieces pieces) {
            return null;
        }

        public ImageIcon getImageIcon() {
            return null;
        }

        public Piece makeCopy() {
            return null;
        }
    }
    
}
