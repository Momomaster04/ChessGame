/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Board;

import Piece.Coordinate;
import Piece.COLOUR;
import Piece.Piece;
import Piece.Pieces;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.nio.file.Paths;
import java.util.HashSet;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author mohan
 */
public final class GUI extends JFrame{
    
    // the pieces used for the game
    private final Pieces pieces;
    private final int dimension = Board_Boundries.END_ROW.getRowVal();
    private final int firstRow = Board_Boundries.START_ROW.getRowVal();
    private final char firstColumn = Board_Boundries.START_COLUMN.getColumnVal();
    private final char lastColumn = Board_Boundries.END_COLUMN.getColumnVal();
    private final char charColumn = (char) (firstColumn - 1);
    // the turn of the game being played
    private static COLOUR turn = COLOUR.W;
    // text pane containing the moves of a game
    private final JTextPane movePane = new JTextPane();
    // text pane containing the message at the end of the game (mate or draw)
    private final JTextPane matePane = new JTextPane();
    // the board on which the game is played
    private final JButton[][] board = new JButton[dimension][dimension];
    // the button used to save a game
    private final JButton saveButton = new JButton("Save Game");
    private final JButton restartButton = new JButton("Restart");
    private final JButton exitButton = new JButton("Exit");
    // colours for the board
    private final Color oliveGreen  = new Color(122, 148, 81); 
    private final Color paleCream  = new Color(241, 241, 212); 
    private final Color intermediate = new Color(255, 255, 153);
    public static final Color infoColour = new Color(51,51,51);
    // size of a square in board
    private static final int tileSize = 88;
    // icon for squares without pieces
    private final BufferedImage invisible = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
    private final ImageIcon invisibleIcon = new ImageIcon(invisible);
    // used to determine number of clicks
    private int counter = 0;
    // number of turns used for game saving
    private int numberOfTurns = 0;
    // build up the game save file
    private static final StringBuilder str = new StringBuilder();
    // piece selected to move
    private Piece movingPiece;
    // ActionHandler used in GUIBoard construcotr
    ButtonHandle gameClick = new ButtonHandle();

    public GUI(Pieces p) {
        setTitle("Chess Game"); // Set up the main window
        setBackground(Color.black);
        Container contents = getContentPane();
        contents.setLayout(new BorderLayout());
        
        pieces = p; // Store the pieces
        
         // Create the chessboard
        JPanel boardPanel = new JPanel(new GridLayout(dimension, dimension));
        for (int row = dimension; row >= firstRow; row--) { // Loop through rows and columns to create the board
            for (int column = 1; column <= dimension; column++) {
                char columnChar = (char) (charColumn + column);
                Coordinate tileCoord = new Coordinate(columnChar, row);
                board[row - 1][column - 1] = setButton(tileCoord, p); // Set button for the tile
                board[row - 1][column - 1].addActionListener(gameClick);
                boardPanel.add(board[row - 1][column - 1]); // Add button to board panel
            }
        }

        // Add components to the main layout
        contents.add(matePane, BorderLayout.SOUTH); // Add matePane at the bottom
        contents.add(boardPanel, BorderLayout.CENTER); // Add boardPanel in the center
        JPanel fullBoardPanel = new JPanel(new BorderLayout());
        fullBoardPanel.add(createColumnLabelsTop(), BorderLayout.NORTH);
        fullBoardPanel.add(createRowLabelsLeft(), BorderLayout.WEST);
        fullBoardPanel.add(boardPanel, BorderLayout.CENTER);
        fullBoardPanel.add(createRowLabelsRight(), BorderLayout.EAST);
        fullBoardPanel.add(createColumnLabelsBottom(), BorderLayout.SOUTH);
        contents.add(fullBoardPanel, BorderLayout.WEST);
        contents.add(createInfoPanel(), BorderLayout.EAST);

        // Finalize the frame settings
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
        turn = PlayerColor();  // Prompt user to select player color
        TurnIndicator();
        
        
    }


    // Method to create row labels on the left side of the board
    public JPanel createRows() {
        JPanel rows = new JPanel(new GridLayout(dimension, 0)); // Vertical grid layout for rows
        rows.setBackground(paleCream);

        int rowPad = 4; // Padding for the row labels

         // Create labels for each row (1 to 8)
        for (int row = dimension; row >= firstRow; row--) {
            JLabel rowLabel = new JLabel(String.valueOf(row));
            rowLabel.setFont(new Font("TimesRoman", Font.BOLD, 23));
            rowLabel.setForeground(oliveGreen);
            rowLabel.setBorder(new EmptyBorder(0, rowPad, 0, rowPad));
            rows.add(rowLabel);
        }

        return rows;
    }
    
    // Creates and returns a JPanel containing column labels for the chessboard.
    public JPanel createColumns() {
        JPanel columns = new JPanel(new GridLayout(0, dimension));
        columns.setBackground(paleCream);

        int columnPad = 42;

        for (char column = firstColumn; column <= lastColumn; column++) {
            JLabel columnLabel = new JLabel(String.valueOf(column));

            columnLabel.setFont(new Font("TimesRoman", Font.BOLD, 23));
            columnLabel.setForeground(oliveGreen);
            columnLabel.setBorder(new EmptyBorder(0, columnPad, 0, columnPad));
            columns.add(columnLabel);
        }
        return columns;
    }

    // Creates and returns a JPanel for the borders of the board.
    public JPanel createBorder() {
        JPanel border = new JPanel();
        border.setBackground(oliveGreen);

        return border;
    }

   // Creates a border with padding for the corners of the chessboard.
    public Border createCorner() {
        int borderPad = 20;
        return new MatteBorder(0,borderPad,0,borderPad,paleCream);
    }

    // Creates and returns a JPanel containing left row labels for the chessboard.
    public JPanel createRowLabelsLeft() {
        JPanel rowLabels = new JPanel(new BorderLayout());

        rowLabels.add(createRows(), BorderLayout.WEST);
        rowLabels.add(createBorder(), BorderLayout.EAST);

        return rowLabels;
    }

    // creates and returns a JPanel containing right row labels for the chessboard.
    public JPanel createColumnLabelsBottom() {
        JPanel ColumnLabels = new JPanel(new BorderLayout());

        ColumnLabels.add(createColumns(), BorderLayout.SOUTH);
        ColumnLabels.add(createBorder(), BorderLayout.NORTH);

        ColumnLabels.setBorder(createCorner());

        return ColumnLabels;
    }

   // Creates and returns a JPanel containing top column labels for the chessboard
    public JPanel createRowLabelsRight() {
        JPanel rowLabels = new JPanel(new BorderLayout());

        rowLabels.add(createRows(), BorderLayout.EAST);
        rowLabels.add(createBorder(), BorderLayout.WEST);

        return rowLabels;
    }

     //Creates and returns a JPanel containing bottom column labels for the chessboard.
    public JPanel createColumnLabelsTop() {
        JPanel ColumnLabels = new JPanel(new BorderLayout());

        ColumnLabels.add(createColumns(), BorderLayout.NORTH);
        ColumnLabels.add(createBorder(), BorderLayout.SOUTH);

        ColumnLabels.setBorder(createCorner());

        return ColumnLabels;
    }

    private void backgroundSetter (Coordinate coordinate, JButton b){
        int signature = coordinate.getColumn() - charColumn + coordinate.getRow();
        if (signature % 2 == 0) {
            b.setBackground(oliveGreen);
        } else {
            b.setBackground(paleCream);
        }
    }
    
    // Creates and returns a JButton configured for a specific coordinate on the board.
    private JButton setButton (Coordinate coordinate, Pieces pieces){
        JButton b = new JButton(); // Create a button for the square

        Piece piece;

        backgroundSetter(coordinate, b);

        if (pieces.getPieces().get(coordinate) == null) {
            piece = null;
        } else {
            piece = pieces.getPiece(coordinate);
        }

        if (piece != null)
            b.setIcon(piece.getImageIcon());
        else
            b.setIcon(invisibleIcon);

        formatButton(b);

        return b;
    }

    //Formats the button for use on the chessboard.
    private void formatButton (JButton b) {
        b.setSize(tileSize, tileSize);
        b.setOpaque(true);
        b.setContentAreaFilled(true);
        b.setBorderPainted(false);
        b.setVisible(true);
    }

    //Formats an invisible button to be used for tiles without pieces
    public static void formatInvisibleButton (JButton b) {
        b.setSize(tileSize, tileSize);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setVisible(true);
    }

    //Disables all buttons on the chessboard to prevent user interaction.
    private void disableBoardButtons() {
         // Iterate through each button on the board
        for (int row = 0; row < dimension; row++) {
            for (int file = 0; file < dimension; file++) {
                board[row][file].removeActionListener(gameClick);
            }
        }
    }

    // Creating and configuring an information panel for the chess game.
    private JPanel createInfoPanel() {

        JPanel movePanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        movePanel.setBackground(infoColour);
        movePanel.setVisible(true);

        movePanel.setPreferredSize(new Dimension(300,800));

        // Configure the moves text area
        movePane.setEditable(false);
        movePane.setForeground(Color.white);
        movePane.setBackground(infoColour);
        movePane.setFont(new Font("Arial", Font.BOLD, 14));
        movePane.setBorder(new EmptyBorder(40,20,40,20));
        JScrollPane scrollMoves = new JScrollPane(movePane);

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.4;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;

        movePanel.add(scrollMoves,gbc); // show the moves being played
        
        // Configure the save button
        saveButton.setBackground(Color.orange);
        saveButton.setForeground(Color.black);
        saveButton.setOpaque(true);
        saveButton.setContentAreaFilled(true);
        saveButton.setBorderPainted(false);
        SaveHandle saver = new SaveHandle();
        saveButton.addActionListener(saver);
        
         // Configure the restart button    
        restartButton.setBackground(Color.orange);
        restartButton.setForeground(Color.black);
        restartButton.setOpaque(true);
        restartButton.setBorderPainted(false);
        restartButton.addActionListener(e -> restartGame());
        
        // Configure the exit button
        exitButton.setBackground(Color.orange);
        exitButton.setForeground(Color.black);
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        exitButton.addActionListener(e -> System.exit(0));

        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.NONE;
        
         // Add the buttons to the panel
        movePanel.add(saveButton,gbc); 
        movePanel.add(restartButton, gbc);
        movePanel.add(exitButton, gbc);

        // Configure the checkmate/draw information pane
        matePane.setEditable(false);
        matePane.setForeground(Color.white);
        matePane.setBackground(infoColour);
        matePane.setFont(new Font("Arial", Font.BOLD, 20));
        matePane.setBorder(new EmptyBorder(0,80,40,80));

        gbc.fill = GridBagConstraints.HORIZONTAL;

        movePanel.add(matePane,gbc); // add information on check mate / draw

        return movePanel;
    }
   
    private void restartGame() {
        dispose(); // Close the current GUI window
        new GUI(new Pieces()); // Create a new GUI instance with a fresh set of pieces
    }
    private COLOUR PlayerColor() {

        Object[] options = {"White", "Black"}; // Options for player color selection
        int choice = JOptionPane.showOptionDialog(
            null,
            "Select the  Colour that you want to be Player 1:",
            "Playe 1 Selection",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0] // Default option
    );

    if (choice == JOptionPane.YES_OPTION) {
        return COLOUR.W; // Player chooses White
    } else {
        return COLOUR.B; // Player chooses Black
    }
}
    
    private void TurnIndicator() {
    matePane.setText(turn.toString() + " is Player 1 and will start first");
}

    private void setTurn() {
        turn = COLOUR.not(turn); // Switch the turn to the other player
    }

    private void clearCounter() {
        counter = 0; // Reset the click counter
    }

    private void processClick(HashSet<Coordinate> potentials) {

        for (int Row = 1; Row <= dimension; Row++) {
            for (char Column = firstColumn; Column <= lastColumn; Column++) {
                int processedRow = Row - firstRow;
                int processedColumn = Column - firstColumn;
                Coordinate potentialCoord = new Coordinate(Column, Row);
                if (potentials.contains(potentialCoord))
                    board[processedRow][processedColumn].setBackground(intermediate);
                else
                    backgroundSetter(potentialCoord, board[processedRow][processedColumn]);
            }
        }
    }


    private class ButtonHandle implements ActionListener {

        private void selectPiece(Piece piece) {
            processClick(piece.getPotentialMoves()); // Highlight possible moves for the selected piece
            counter++;
            movingPiece = piece; // Store the currently selected piece
        }

        private Coordinate toCoordinate(int row, int column) {
            int Row = row + firstRow;
            char Column = (char) (column + firstColumn);

            return new Coordinate(Column, Row);
        }


        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Coordinate coordinate = null;

            JButton source = (JButton) actionEvent.getSource(); // Get the source of the action event

            // Find the coordinate of the clicked button
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (board[i][j].equals(source)) {
                        coordinate = toCoordinate(i, j);
                    }
                }
            }

            Piece originPiece = pieces.getPieces().get(coordinate);

            if (coordinate != null && Coordinate.inBoard(coordinate)) {
                if (counter == 0) {
                    if (originPiece != null && originPiece.getColour() == turn) {
                        selectPiece(originPiece); // Select the piece if it's the player's turn
                    }
                } else {
                    Piece piece = movingPiece;

                     // Validate and process the move
                    if (piece.isValidMove(coordinate, turn)) {
                        pieces.makeMove(coordinate, piece); // Move the piece on the game state
                        if (turn == COLOUR.W) {
                            numberOfTurns++;
                            str.append(numberOfTurns).append(". ").append(ChessIO.moveString(pieces, coordinate, piece)).append(" ");
                        } else
                            str.append(ChessIO.moveString(pieces, coordinate, piece)).append(" ");
                        movePane.setText(str.toString()); // Update the move history display
                        
                         // Refresh the board's appearance after the move
                        for (int Row = 1; Row <= dimension; Row++) {
                            for (char Column = firstColumn; Column <= lastColumn; Column++) {
                                int processedRow = Row - firstRow;
                                int processedColumn = Column - firstColumn;
                                Coordinate potentialCoord = new Coordinate(Column, Row);
                                backgroundSetter(potentialCoord, board[processedRow][processedColumn]);
                                board[processedRow][processedColumn].setIcon(invisibleIcon); // Clear the icon
                                if (pieces.getPieces().get(potentialCoord) != null) {
                                    Piece updatePiece = pieces.getPiece(potentialCoord);
                                    board[processedRow][processedColumn].setIcon(updatePiece.getImageIcon()); // Set the updated piece icon
                                }
                            }
                        }

                        clearCounter(); // Reset the counter for the next move
                        setTurn(); // Switch turns

                         // Check for checkmate
                        if (pieces.isMate(turn)) {
                            matePane.setText(COLOUR.not(turn).toString() + " won by checkmate.");
                            disableBoardButtons();
                        } 
                        
                    } else {
                        if (originPiece != null && originPiece.getColour() == turn) { // If the move is invalid, try to reselect the piece
                            selectPiece(originPiece);
                        }
                    }
                }
            }
        }
    }

    // this is to handle the game saving file
    public static class SaveHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            ImageIcon icon = new ImageIcon("WKing.png");

             // Set the background colors for the option pane
            UIManager.put("OptionPane.background", infoColour);
            UIManager.put("Panel.background", infoColour);
            UIManager.put("OptionPane.messageForeground", Color.white);

            // Prompt the user for a filename to save the game
            String fileSave = (String) JOptionPane.showInputDialog(null,
                    "Enter a file name to save the game:",
                    "Save Game",
                    JOptionPane.INFORMATION_MESSAGE,
                    icon,null,null);

            if (fileSave != null) { // Check if user provided a filename

                String filePath = ChessIO.toTxt(fileSave); // Convert the filename to a file path


                if (ChessIO.isErrorSave(filePath)) { // Check if the filename is valid
                    JOptionPane.showMessageDialog(null,
                            fileSave + " is an incorrect file name.",
                            "Failed Saving",
                            JOptionPane.ERROR_MESSAGE,
                            icon);
                } else {
                     // Attempt to save the game
                    if (ChessIO.saveGame(str.toString(), Paths.get(filePath)))
                        JOptionPane.showMessageDialog(null,
                                "Game saved succesfuly on path " + filePath,
                                "Save Succesful",
                                 JOptionPane.INFORMATION_MESSAGE,
                                 icon);
                    else
                        JOptionPane.showMessageDialog(null,
                                "There was an error saving the file on the path " + filePath + ". The name provided might be a duplicate.",
                                "Failed Saving",
                                JOptionPane.ERROR_MESSAGE,
                                icon);

                }
            }
        }
    }
    
    
}
