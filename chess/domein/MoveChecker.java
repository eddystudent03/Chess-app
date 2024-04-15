import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import chess.domein.Board;
import chess.domein.Piece;

public class MoveChecker {
    private static final int PAWNMOVE = 1;
    private static final int KNIGHTMOVE = 2;
    private static final int BISHOPMOVE = 3;
    private static final int ROOKMOVE = 4;
    private static final int QUEENMOVE = 5;
    private static final int KINGMOVE = 6; 

    public List<String> giveMoves(Boolean isComputer,String from, Piece[][] board){
        int rowFrom =  from.charAt(0);
        int columnFrom = from.charAt(1);
        switch(board[rowFrom][columnFrom].getMovement()){
            case PAWNMOVE:
                return getPawnmoves(isComputer,rowFrom, columnFrom, board);
            case KNIGHTMOVE:
                return getKnightmoves(isComputer,rowFrom, columnFrom, board);
            case BISHOPMOVE:
                return getBishopmoves(isComputer,rowFrom, columnFrom, board);
            case ROOKMOVE:
                return getRookmoves(isComputer,rowFrom, columnFrom, board);
            case QUEENMOVE:
                return getQueenmoves(isComputer,rowFrom, columnFrom, board);
            case KINGMOVE:
                return getKingmoves(isComputer,rowFrom, columnFrom, board);
            default:
                return new ArrayList<>();
        }
    }

    public List<String> getKingmoves(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
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

    public List<String> getQueenmoves(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        List<String>moves = new ArrayList<>(getBishopmoves(isComputer, rowFrom, columnFrom, board));
        moves.addAll(getRookmoves(isComputer, rowFrom, columnFrom, board));
        return moves;
    }

    public List<String> getRookmoves(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
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

    public List<String> getBishopmoves(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
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

    public List<String> getKnightmoves(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        List<Piece>pieces = new ArrayList<>();
        List<String>moves = new ArrayList<>();
        for(int i = 0; i<4; i++){
            String move1;
            String move2;
            if(i==0 && rowFrom + 1 < 8 && rowFrom - 1 > 0 && columnFrom + 2 < 8){
                move1 = (rowFrom + 1) + (columnFrom + 2) + "";
                move2 = (rowFrom - 1) + (columnFrom + 2) + "";
                moves.add(move1);
                moves.add(move2);
                if(board[(rowFrom + 1)][(columnFrom + 2)] instanceof Piece && board[(rowFrom + 1)][(columnFrom + 2)].isComputer() = isComputer)
                {
                    
                }
            }
            else if(i==1 && rowFrom + 2 < 8 && columnFrom + 1 < 8 && columnFrom > 0){
                move1 = (rowFrom + 2) + (columnFrom + 1) + "";
                move2 = (rowFrom + 2) + (columnFrom - 1) + "";
                moves.add(move1);
                moves.add(move2);
            }
            else if(i==2 && rowFrom + 1 < 8 && rowFrom - 1 > 0 && columnFrom - 2 > 0){
                move1 = (rowFrom + 1) + (columnFrom - 2) + "";
                move2 = (rowFrom - 1) + (columnFrom - 2) + "";
                moves.add(move1);
                moves.add(move2);
            }
            else{
                move1 = (rowFrom - 2) + (columnFrom + 1) + "";
                move2 = (rowFrom - 2) + (columnFrom - 1) + "";
                moves.add(move1);
                moves.add(move2);
            }
        }
    }

    public List<String> getPawnmoves(Boolean isComputer, int rowFrom, int columnFrom, Piece[][] board) {
        List<String>moves = new ArrayList<>();
        if(isComputer){
            if(columnFrom == 7){
                moves.add( rowFrom + (columnFrom - 2) +"");
            }
            if(board[columnFrom - 1][rowFrom+1] instanceof Piece){
                moves.add((rowFrom+1) + (columnFrom - 1) + "");
            }
            if(board[columnFrom - 1][rowFrom-1] instanceof Piece){
                moves.add((rowFrom-1) + (columnFrom - 1) + "");
            }
            moves.add((rowFrom-1) + columnFrom + "");

        }
        if(!isComputer){
        if(columnFrom == 0){
            moves.add((columnFrom + 2) + rowFrom + "");
        }
        if(board[columnFrom + 1][rowFrom+1] instanceof Piece){
            moves.add((columnFrom - 1) + rowFrom+1 + "");
        }
        if(board[columnFrom + 1][rowFrom-1] instanceof Piece){
            moves.add((columnFrom - 1) + (rowFrom-1) + "");
        }
        moves.add((rowFrom+1) + columnFrom + "");
    }

    }

    private Piece getPiece(String from, Piece[][]board){
        return board[(int) from.charAt(0)][(int) from.charAt(1)];
    }

    public List<String> giveKingThreats(Piece[][]board, int rowFrom, int columnFrom, Boolean isComputer){
        List<String>moves = new ArrayList<>();
        moves.add(getBishopmoves(isComputer, rowFrom, columnFrom, board).stream().filter(x -> getPiece(x, board) instanceof Piece).filter(x -> getPiece(x, board).isComputer() == isComputer).filter(x -> board[Integer.parseInt(x.charAt(0))][Integer.parseInt(x.charAt(1))].getType.equals("bishop")).collect(Collectors.toList()););
        moves.add(getKingpmoves(isComputer, rowFrom, columnFrom, board).stream().filter(x -> getPiece(x, board) instanceof Piece).filter(x -> getPiece(x, board).isComputer() == isComputer).filter(x -> board[Integer.parseInt(x.charAt(0))][Integer.parseInt(x.charAt(1))].getType.equals("king")).collect(Collectors.toList()););
        moves.add(getPawnpmoves(isComputer, rowFrom, columnFrom, board).stream().filter(x -> getPiece(x, board) instanceof Piece).filter(x -> getPiece(x, board).isComputer() == isComputer).filter(x -> board[Integer.parseInt(x.charAt(0))][Integer.parseInt(x.charAt(1))].getType.equals("pawn")).collect(Collectors.toList()););
        moves.add(getRookpmoves(isComputer, rowFrom, columnFrom, board).stream().filter(x -> getPiece(x, board) instanceof Piece).filter(x -> getPiece(x, board).isComputer() == isComputer).filter(x -> board[Integer.parseInt(x.charAt(0))][Integer.parseInt(x.charAt(1))].getType.equals("rook")).collect(Collectors.toList()););
        return moves;
    }
    

    public List<String> giveAllthreats( int rowFrom, int columnFrom, Piece[][]board, Boolean isComputer){
        //kijken of de moves (alle pieces die koning kunnen pakken => (logica erachter is, koning get moves voor elke mogelijke piece dan gefiltered of die plaats een piece is van de tegenpartij)) 
        //kunnen worden bereikt door een van onze pieces. dus checken voor elke piece of die mogelijks de plaatsen in moves kan bereiken
        List<String>moves1 = new ArrayList<>();
        List<String>kingThreats = giveKingThreats(board, rowFrom, columnFrom, isComputer);
        for(int i = 0; i < 8 ; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] instanceof Piece && board[i][j].isComputer() == isComputer){
                    List<String> plays = giveMoves(isComputer, i + j + "", board);
                        for(int z = 0; z<kingThreats.size(); z++){
                             if(plays.contains(kingThreats.get(z)))
                                moves1.add(kingThreats.get(z) + i + j + "");
                        }            
                }
            }
        }
        //ordenen dat de piece met minste relevantie van voor staat
        for(int i = 0; i<moves1.size();i++){
            for(int j = 0; j < moves1.size() - i -1; j++){
                if(board[(int) moves1.get(j).charAt(0)][(int) moves1.get(j).charAt(1)].getMovement() > board[(int) moves1.get(j + 1).charAt(0)][(int) moves1.get(j + 1).charAt(1)].getMovement()) {
                    String temp = moves1.get(j + 1);
                    moves1.set(j+1, moves1.get(j));
                    moves1.set(j, temp);
            }
            }
        }

        return moves1;

    }

    public boolean doesMoveExposeKing(int rowFrom, int columnFrom, Piece[][]board, boolean isComputer){
        return giveAllthreats(rowFrom, columnFrom, board, isComputer).size() == 0?true:false;
    }

}
