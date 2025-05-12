import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Team.
 */
public class TeamTest {

    /**
     * Tests that a character can be added to the team and retrieved.
     */
    @Test
    public void testAddCharacterAndRetrieve() {
        Team team = new Team("Heroes");
        GameCharacter ironman = new GameCharacter("Ironman", 100, 20, 10, "Human", "Warrior");
        team.addCharacter(ironman);

        assertTrue(team.getMembers().contains(ironman));
    }

    /**
     * Tests that the hasLivingMembers method returns the correct value.
     */
    @Test
    public void testHasLivingMembers() {
        Team team = new Team("Group");
        GameCharacter alive = new GameCharacter("Alive", 100, 20, 10, "Human", "Warrior");
        GameCharacter dead = new GameCharacter("Dead", 0, 20, 10, "Human", "Warrior");

        team.addCharacter(dead);
        assertFalse(team.hasLivingMembers());

        team.addCharacter(alive);
        assertTrue(team.hasLivingMembers());
    }

    /**
     * Tests that the getNextAliveCharacter method returns the correct character.
     */
    @Test
    public void testGetNextAliveCharacter() {
        Team team = new Team("Squad");
        GameCharacter c1 = new GameCharacter("Dead1", 0, 10, 5, "Human", "Warrior");
        GameCharacter c2 = new GameCharacter("Alive", 100, 20, 10, "Human", "Warrior");

        team.addCharacter(c1);
        team.addCharacter(c2);

        assertEquals("Alive", team.getNextAliveCharacter().getName());
    }
}