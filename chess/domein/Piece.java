package chess.domein;

public class Piece {
    private String type;
    private boolean isComputer;
    private int movement;
    private int team;
    private int importance;
    
    public Piece(String type, boolean isComputer, int movement){
        setType(type);
        setComputer(isComputer);
        setMovement(movement);
    }
    public boolean isKing(){
        return type.equals("king")?true:false;
    }

    // Getters
    public String getType() {
        return type;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public int getMovement() {
        return movement;
    }

    // Setters
    private void setType(String type) {
        this.type = type;
    }

    private void setComputer(boolean computer) {
        isComputer = computer;
    }

    private void setMovement(int movement) {
        this.movement = movement;
    }

}
