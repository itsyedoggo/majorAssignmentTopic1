import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<Character> members;

    public Team (String teamName) {
        this.teemName = teamName;
        this.members = new ArrayList<>();
    }
    public voic addCharacter (character character) {
        members.add(character);
    }
    public boolean hasLivingMembers() {
        for (Chaaracter c: members) {
            if (c.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public Character getNextAliveCharacter () {
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
    public ArrayList<Character> getMembers() { // Return a copy of the members list // to meet criteria
        return members;
    }
}