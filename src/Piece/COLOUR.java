/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Piece;

/**
 *
 * @author mohan
 */

//  Enumeration representing the colors used in the game.
// This enum defines two constants: Black (B) and White (W).
public enum COLOUR {
    
    // Represents the color Black.
    B {
        @Override
        public String toString() {
            return "Black";
        }

        @Override
        public String toSmallString() {
            return "B";
        }
    },
    // Represents the color White.
    W {
        @Override
        public String toString() {
            return "White";
        }

        @Override
        public String toSmallString() {
            return "w";
        }
    };

    public abstract String toSmallString();

    // Returns the opposite color of the given COLOUR.
    public static COLOUR not(COLOUR colour) {
        if (colour == COLOUR.W) // Check if the color is White
            return COLOUR.B; // Return Black if input is White
        else
            return COLOUR.W; // Return White if input is Black

    }
    
}
