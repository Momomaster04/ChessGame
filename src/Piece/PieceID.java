/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Piece;

/**
 *
 * @author mohan
 */

// PieceID Enumeration representing different types of chess pieces.
//  Each piece is associated with a unique string identifier used in the game.
public enum PieceID {
    
    KING {
        @Override
        public String toString() {
            return "K";
        }
        
    },
    QUEEN {
        @Override
        public String toString() {
            return "Q";
        }
        
    },
    ROOK {
        @Override
        public String toString() {
            return "R";
        }
       
    },
    BISHOP {
        @Override
        public String toString() {
            return "B";
        }
       
    },
    KNIGHT {
        @Override
        public String toString() {
            return "N";
        }
        
    },
    PAWN {
        @Override
        public String toString() {
            return "";  //Note: Pawns typically do not have a letter notation associated with them.d
        }
       
    };
    
}
