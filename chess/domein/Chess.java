package chess.domein;
import chess.domein.Board;

public class Chess{

    private Board board;

    public Chess(){
        board = new Board();
    }

    public Board getBoard(){
        return this.board;
    }
    
}