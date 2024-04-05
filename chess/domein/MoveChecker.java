import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import chess.domein.Piece;

public class MoveChecker {
    private static final int PAWNMOVE = 1;
    private static final int KNIGHTMOVE = 2;
    private static final int BISHOPMOVE = 3;
    private static final int ROOKMOVE = 4;
    private static final int QUEENMOVE = 5;
    private static final int KINGMOVE = 6; 

    public String giveMove(Boolean isComputer,String from, Piece[][] board, Piece piece){
        int rowFrom =  from.charAt(0) - 'a';
        int columnFrom = from.charAt(1) - '1';
        switch(piece.getMovement()){
            case PAWNMOVE:
                return getPawnmove(isComputer,rowFrom, columnFrom, board);
            case KNIGHTMOVE:
                return getKnightmove(isComputer,rowFrom, columnFrom, board);
            case BISHOPMOVE:
                return getBishopmove(isComputer,rowFrom, columnFrom, board);
            case ROOKMOVE:
                return getRookmove(isComputer,rowFrom, columnFrom, board);
            case QUEENMOVE:
                return getQueenmove(isComputer,rowFrom, columnFrom, board);
            case KINGMOVE:
                return getKingmove(isComputer,rowFrom, columnFrom, board);
            default:
                return new ArrayList<>();
        }
    }

    private String getKingmove(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        List<String>moves= new ArrayList<>();
        String move1;
        String move2;
        String move3;
        String move4;
        move1 = (columnFrom-1) + rowFrom + "";
        move2 = columnFrom + (rowFrom-1) + "";
        move3 = (columnFrom+1) + rowFrom + "";
        move4 = columnFrom + (rowFrom+1) + "";
        moves.add(move1);
        moves.add(move2);
        moves.add(move3);
        moves.add(move4);
        if(columnFrom == 0){
            moves.remove(0);
        }
        if(rowFrom == 0){
            moves.remove(1);
        }
        if(columnFrom == 7){
            moves.remove(2);
        }
        if(rowFrom == 7){
            moves.remove(3);
        }
        return moves;
    }

    private String getQueenmove(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
    }

    private String getRookmove(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        List<String>moves = new ArrayList<>();
        List<Piece> pieces = new ArrayList<>();
        boolean stop = false;
        for(int i = 0; i<4; i++){
            int counter = 0;
            while(!stop){
            int currentrow = i==0?rowFrom+counter:i==1?rowFrom+(counter * -1):rowFrom;
            int currentcolumn = i==2?columnFrom+counter:i==3?columnFrom+(counter * -1):columnFrom;
            if(currentrow == 0 || currentrow == 7 || currentcolumn == 0 || currentrow == 7){
                stop = true;
            }
            counter++;
            moves.add((i==0?rowFrom+counter:i==1?rowFrom + (counter * -1):rowFrom) + (i==2?columnFrom+counter:i==3?columnFrom+(counter * -1):columnFrom) + "");
            Object potpiece = board[i==0?rowFrom+counter:i==1?rowFrom + (counter * -1):rowFrom][i==2?columnFrom+counter:i==3?columnFrom+(counter * -1):columnFrom];
            if(potpiece instanceof Piece){
                stop = true;
                pieces.add((Piece)potpiece);
            }
         }
        }
    }
    //filteren op de best methode ideale zet in if anders gewoon random zet 
    private String getBishopmoves(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        List<String>moves = new ArrayList<>();
        List<Piece> pieces = new ArrayList<>();
        for(int i = 0; i<4; i++){
            boolean stop = false;
            int counter = 0;
            while(!stop){
                counter++;
                moves.add((i<2?rowFrom+counter:rowFrom+(counter*-1)) + (i%2==0?columnFrom+counter:columnFrom+(counter*-1)) + "");
                if(i==0){
                if(rowFrom + counter - 1 == 7 || columnFrom + counter -1 == 7){
                    stop = true;
                }
                }
                else if(i==1){
                    if(rowFrom + counter - 1 == 7 || columnFrom + (counter * -1) + 1 == 0){
                        stop = true;
                    }
                }
                else if(i==2){
                    if(rowFrom + (counter * -1) + 1 == 0 || columnFrom + counter -1 == 7){
                        stop = true;
                    }
                }
                else{
                    if(rowFrom + (counter * -1) + 1 == 0 || columnFrom + (counter * -1) + 1 == 0){
                        stop = true;
                    }
                }
                if(board[i<2?rowFrom+counter:rowFrom+(counter*-1)][i%2==0?columnFrom+counter:columnFrom+(counter*-1)] instanceof Piece){
                    moves.remove(moves.size()-1);
                    pieces.add(board[i<2?rowFrom+counter:rowFrom+(counter*-1)][i%2==0?columnFrom+counter:columnFrom+(counter*-1)]);
                    stop = true;
                }
            }
        }
    }

    private List<String> getKnightmove(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        List<String>moves = new ArrayList<>();
        for(int i = 0; i<4; i++){
            if()
        }
    }

    private List<String> getPawnmove(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPawnmoves'");
    }

}
