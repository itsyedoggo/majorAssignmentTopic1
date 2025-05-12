import org.junit.Test;
import static org.junit.Assert.*;

public class TeamTest {

    @Test 
    public void testAddCharacterAndRetrieve() {
        Team team = new Team ("Heroes");
        GameCharacter ironman = new GameCharacter("Ironman", 100, 20, 10, "Human", "Warrior");
        team.addCharacter(ironman);

        assertTrue(team.getMembers().contains(ironman));
    }

    @Test
    public void testhasLivingMembers() {
        Team team = new Team ("Group");
        GameCharacter alive = new GameCharacter ("Alive", 100, 20, 10, "Human", "Warrior");
        GameCharacter dead = new GameCharacter ("Dead", 0, 20, 10, "Human", "Warrior");

        team.addCharacter(dead);
        assertFalse(team.hasLivingMembers());

        team.addCharacter(alive);
        assertTrue(team.hasLivingMembers());
    }

    @Test
    public void testGetNextAliveCharacter() {
        Team team = new Team ("Squad");
        GameCharacter c1 = new GameCharacter("Dead1", 0, 10, 5, "Human", "Warrior");
        GameCharacter c2 = new GameCharacter("Alive", 100, 20, 10, "Human", "Warrior");

        team.addCharacter(c1);
        team.addCharacter(c2);

        assertEquals("Alive", team.getNextAliveCharacter().getName());
    }

}