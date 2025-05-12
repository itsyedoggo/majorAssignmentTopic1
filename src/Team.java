import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<GameCharacter> members;

    public Team (String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }
    public void addCharacter (Character character) {
        members.add(character);
    }
    public boolean hasLivingMembers() {
        for (Character c: members) {
            if (c.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public GameCharacter getNextAliveCharacter () {
        for (character c: members) {
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
        Character attacker = attackingTeam.getNextAliveCharacter();
        Character defender = defendingTeam.getNextAliveCharacter();
        if (attacker == null || defender == null) {
            declareWinner();
            return;
        }
    }

    private void declareWinner() {
        // Implementation for declaring the winner
    }
}