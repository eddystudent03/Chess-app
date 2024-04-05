package chess.domein;

public class Board {
    private Piece[][] board = new Piece[8][8];

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

    public void movePiece(String from, String to, boolean isProtectMove){
        int rowFrom =  (int) from.charAt(0);
        int columnFrom = (int) from.charAt(1);
        int rowTo = (int) to.charAt(0);
        int columnTo= (int) to.charAt(1);
        if(!isProtectMove){
        if(!isKingThreatened(rowFrom, columnFrom)){
        board[rowTo][columnTo] = board[rowFrom][columnFrom];
        board[rowFrom][columnFrom] = null;
        }
        }
        if(isProtectMove){
        if(!isKingThreatened(rowTo, columnTo)){
        board[rowTo][columnTo] = board[rowFrom][columnFrom];
        board[rowFrom][columnFrom] = null;
        }
        }

    }

    public boolean isKingThreatened(int rowFrom, int columnFrom) {

    }

    
    
    public boolean doesMoveExposeKing(int rowFrom, int columnFrom){

    }

    public boolean isCheckmate(){
        
    }


    }



