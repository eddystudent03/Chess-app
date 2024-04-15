package chess.domein;

public class Piece {
    private String type;
    private boolean isComputer;
    private int movement;
    private int team;
    private int importance;
    
    public Piece(String type, boolean isComputer, int movement, int team, int importance){
        setType(type);
        setComputer(isComputer);
        setMovement(movement);
        setTeam(team);
        setImportance(importance);
    }
    private boolean isKing(){
        return type.equals("king")?true:false;
    }
    private void setImportance(int importance) {
        this.importance = importance;
    }

    public int getImportance(){
        return importance;
    }

    private void setTeam(int team) {
        this.team = team;
    }

    public int getTeam(){
        return this.team;
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
    public void setType(String type) {
        this.type = type;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }
}
