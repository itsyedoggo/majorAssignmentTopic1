import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

public class TeamTest {

    @Test 
    public void testAddCharacterAndRetrieve() {
        Team team = new Team ("Heroes");
        Character ironman = new Character("Ironman", 100, 20, 10, "Human", "Warrior");
        team.addCharacter(ironman);

        assertTrue(team.getMembers().contains(ironman));
    }

    @Test
    public void testHassLivingMembers() {
        Team team = new Team ("Group");
        Character alive = new Character ("Alive", 100, 20, 10, "Human", "Warrior");
        Character dead = new Character ("Dead", 0, 20, 10, "Human", "Warrior");

        team.addCharacter(dead);
        assertFalse(team.hasLivingMembers());

        team.addCharacter(alive);
        assertTrue(team.hasLivingMambers());
    }

    @Test
    public void testGetNextAliveCharacter() {
        Team team = new Team ("Squad");
        Character c1 = new Character("Dead1", 0, 10, 5, "Human", "Warrior");
        Character c2 = new Character("Alive", 100, 20, 10, "Human", "Warrior");

        team.addCharacter(c1);
        team.addCharacter(c2);

        asserEquals("Alive", team.getNextAliveCharacter().getName());
    }

}