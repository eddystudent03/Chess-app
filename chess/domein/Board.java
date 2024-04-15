package chess.domein;

import java.util.List;

import chess.domein.Piece;

public class Board {
    private Piece[][] board = new Piece[8][8];
    private String kingPlace = "04";
    private String kingPlaceComputer = "74";
    private MoveChecker mc;
    private List<Piece> userPieces;
    private List<Piece> pcPieces;

    public Board(){
        initializeBoard();
    }

    private void initializeBoard() {
        board[0][0] = new Piece("rook", true, 4);
        board[0][1] = new Piece("knight", true, 2);
        board[0][2] = new Piece("bishop", true, 3);
        board[0][3] = new Piece("queen", true, 5);
        board[0][4] = new Piece("king", true, 1);
        board[0][5] = new Piece("bishop", true, 3);
        board[0][6] = new Piece("knight", true, 2);
        board[0][7] = new Piece("rook", true, 4);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Piece("pawn", true, 1);
        }

        for (int i = 0; i < 8; i++) {
            board[6][i] = new Piece("pawn", false, 1);
        }
        board[7][0] = new Piece("rook", false, 4);
        board[7][1] = new Piece("knight", false, 2);
        board[7][2] = new Piece("bishop", false, 3);
        board[7][3] = new Piece("queen", false, 5);
        board[7][4] = new Piece("king", false, 1);
        board[7][5] = new Piece("bishop", false, 3);
        board[7][6] = new Piece("knight", false, 2);
        board[7][7] = new Piece("rook", false, 4);
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void movePiece(String from, String to){
        List<String>moves = mc.giveMoves(false, from, this.board)
        if(moves.contains(to)){
            if(this.board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))] instanceof Piece){
                userPieces.add(board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))])
            }
               if(this.board[Integer.parseInt(from.charAt(0))][Integer.parseInt(from.charAt(1))].isKing()){
                    kingPlace = board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))];
               }
               this.board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))] = board[Integer.parseInt(from.charAt(0))][Integer.parseInt(from.charAt(1))];
        }
        this.board = board;
    }

    public void computerMove(String from, String to){
        List<String>moves = mc.giveMoves(true, from, board)
        if(moves.contains(to)){
            if(board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))] instanceof Piece){
                pcPieces.add(board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))])
            }
               if(board[Integer.parseInt(from.charAt(0))][Integer.parseInt(from.charAt(1))].isKing()){
                kingPlaceComputer = board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))];
                     }
               board[Integer.parseInt(to.charAt(0))][Integer.parseInt(to.charAt(0))] = board[Integer.parseInt(from.charAt(0))][Integer.parseInt(from.charAt(1))];
        }
        this.board = board;
    }

    public boolean isKingThreatened(int rowFrom, int columnFrom, boolean isComputer) {
        return mc.isKingThreatened(board, rowFrom, columnFrom, isComputer).size() == 0? false: true;
    }
    
    public String getKingPos(){
        return this.kingPlace;
    }

    public String getComputerKingPos(){
        return this.kingPlaceComputer;
    }

    public List<String> protectKingMoves(){
        int row = Integer.parseInt(kingPlaceComputer.charAt(0));
        int column = Integer.parseInt(kingPlaceComputer.charAt(1));
        mc.protectKing(row, column, board, true);
    }

    public boolean computerProtectKing(){
        String move = protectKingMoves().get(0);
        int rowTo = Integer.parseInt(move.charAt(0));
        int columnTo = Integer.parseInt(move.charAt(1));
        int rowFrom = Integer.parseInt(move.charAt(2));
        int columnFrom = Integer.parseInt(move.charAt(3));
        String from = rowTo + columnTo + "";
        String to = rowFrom + columnFrom + "";
        if(!mc.doesMoveExposeKing(rowFrom, columnFrom, board, false)){
             computerMove(from, to);
             return true;
        }
        return false;
    }

    public void protectMove(String from, String to){
        int row = Integer.parseInt(kingPlaceComputer.charAt(0));
        int column = Integer.parseInt(kingPlaceComputer.charAt(1));
        String fullmove = from + to + "";
        if(mc.protectKing(row, column, board, false).contains(fullmove) && !mc.doesMoveExposeKing(row, column, board, false)){
            movePiece(from, to);
            return true;
        }
        return false;
    }
    }



