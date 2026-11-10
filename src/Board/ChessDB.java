/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Board;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import Piece.Piece;
import Piece.Coordinate;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 *
 * @author mohan
 */
public class ChessDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    
    public ChessDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
        setupDatabase();

    }

        
    private void setupDatabase() {
        try (var statement = conn.createStatement()) {
            statement.execute("CREATE TABLE GAMES (GAME_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
            statement.execute("CREATE TABLE MOVES (MOVE_ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, GAME_ID INT, TURN INT, MOVE_STRING VARCHAR(255), IS_CAPTURE BOOLEAN, FOREIGN KEY (GAME_ID) REFERENCES GAMES(GAME_ID))");
        } catch (SQLException e) {
            System.out.println("Error setting up database: " + e.getMessage());
        
        }
    }
 
    
        
       public int saveNewGame() {
        int gameId = -1;
        try {
            String query = "INSERT INTO GAMES (DATE) VALUES (CURRENT_TIMESTAMP)";
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                gameId = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error creating new game: " + e.getMessage());
        }
        return gameId;
    }
    
      public void saveMove(int gameId, int turn, String moveString, boolean isCapture, boolean isCheck, boolean isMate, String promotedPiece, String castleType) {
        try {
            String query = "INSERT INTO CHESS_MOVES (GAME_ID, TURN, MOVE_STRING, IS_CAPTURE, IS_CHECK, IS_MATE, PROMOTED_PIECE, CASTLE_TYPE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, gameId);
            ps.setInt(2, turn);
            ps.setString(3, moveString);
            ps.setBoolean(4, isCapture);
            ps.setBoolean(5, isCheck);
            ps.setBoolean(6, isMate);
            ps.setString(7, promotedPiece);
            ps.setString(8, castleType);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving move: " + e.getMessage());
        }
    }
      
      public ResultSet getRecentGames() {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM GAMES ORDER BY DATE DESC";
            rs = conn.createStatement().executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error getting recent games: " + e.getMessage());
        }
        return rs;
    }
      
       public ResultSet getGameMoves(int gameId) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM MOVES WHERE GAME_ID = ? ORDER BY TURN";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, gameId);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error getting moves: " + e.getMessage());
        }
        return rs;
    }
       public void closeConnection() {
        this.dbManager.closeConnections();
    }
}
       
        



      
   
      
   
   


    

