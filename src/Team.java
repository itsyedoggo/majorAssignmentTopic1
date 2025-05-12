import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List<GameCharacter> members;

    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {
        members.add(character);
    }

    public void addMember(GameCharacter character) {
        if (character != null) {
            members.add(character);
        }
    }

    public boolean hasLivingMembers() {
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public GameCharacter getNextAliveCharacter() {
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                return c;
            }
        }
        return null; // No living characters left
    }

    public String getTeamName() {
        return teamName;
    }

    public List<GameCharacter> getMembers() { // Return a copy of the members list // to meet criteria
        return new ArrayList<>(members);
    }
}