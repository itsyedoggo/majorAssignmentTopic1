import java.util.ArrayList;
import java.util.List;

/**
 * Represents a team of game characters.
 */
public class Team {
    private String teamName;
    private List<GameCharacter> members;

    /**
     * Constructs a new Team object.
     * @param teamName The name of the team.
     */
    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }

    /**
     * Adds a character to the team.
     * @param character The character to add.
     */
    public void addCharacter(GameCharacter character) {
        members.add(character);
    }

    /**
     * Checks if the team has any living members.
     * @return True if the team has at least one living member, false otherwise.
     */
    public boolean hasLivingMembers() {
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the next alive character on the team.
     * @return The next alive character on the team, or null if there are no alive characters.
     */
    public GameCharacter getNextAliveCharacter() {
        for (GameCharacter c : members) {
            if (c.isAlive()) {
                return c;
            }
        }
        return null; // No living characters left
    }

    /**
     * Gets the name of the team.
     * @return The name of the team.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Gets a list of the team's members.
     * @return A list of the team's members.
     */
    public List<GameCharacter> getMembers() { // Return a copy of the members list // to meet criteria
        return new ArrayList<>(members);
    }
}