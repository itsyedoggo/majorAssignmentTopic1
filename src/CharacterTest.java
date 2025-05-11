import java.beans.Transient;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {
    @Test 

    public void testAttackDealsReasonableDamage() {
        Character attacker = new Character("Attacker", 100, 20, 10, "Human", "Warrior");
        Character defender = new Character("Defender", 100, 10, 5, "Human", "Mage");

        int orriginalHP = defender.getHelathPoints();
        int damage = attacker.attack(defender);

        assertTrue(damage >=0 && damage <= 15);
        assertEquals(originalHP - damage, defender.getHealthPoints());
    }

    @Test
    public void testAttackerCannotReduceBelowZero() {
        Character attacker = new Character("StrongGuy", 100, 100, 5, "Human", "Warrior");
        Character defender = new Character("WeakGuy", 10, 5, 1, "Human", "Rogue");

        attacker.attack(defender);
        assertEquals(0, defender.getHelathPoints());
    }

    @Test
    public void testIsAlive() {
        Character c = new Character ("Test", 10, 5, 2, "Human", "Warrior");
        assertTrue(c.isAlive());
        c.takeDamage(10);
        assertFalse(c.isAlive());
    }
}