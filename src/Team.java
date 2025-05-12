import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<GameCharacter> members;

    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }
    public void addCharacter (GameCharacter character) {
        members.add(character);
    }

    public boolean hasLivingMembers() {
        for (GameCharacter c: members) {
            if (c.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public GameCharacter getNextAliveCharacter () {
        for (GameCharacter c: members) {
            if (c.isAlive()){
                return c;
            }
        }
        return null; // No living characters left
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<GameCharacter> getMembers() { // Return a copy of the members list // to meet criteria
        return members;
    }

    public void battle(Team attackingTeam, Team defendingTeam) {
    GameCharacter attacker = attackingTeam.getNextAliveCharacter();
    GameCharacter defender = defendingTeam.getNextAliveCharacter();
    if (attacker == null || defender == null) {
        declareWinner();
        return;
        }
    }

    private void declareWinner() {
        // Implementation for declaring the winner
    }
}