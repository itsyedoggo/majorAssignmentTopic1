import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {

    @Test
    public void testAttackDealsReasonableDamage() {
        GameCharacter attacker = new GameCharacter("Attacker", 100, 20, 10, "Human", "Warrior");
        GameCharacter defender = new GameCharacter("Defender", 100, 10, 5, "Human", "Mage");

        int originalHP = defender.getHealthPoints();
        int damage = attacker.attack(defender);

        assertTrue(damage >= 0 && damage <= 15);
        assertEquals(originalHP - damage, defender.getHealthPoints());
    }

    @Test
    public void testAttackerCannotReduceBelowZero() {
        GameCharacter attacker = new GameCharacter("StrongGuy", 100, 100, 5, "Human", "Warrior");
        GameCharacter defender = new GameCharacter("WeakGuy", 10, 5, 1, "Human", "Rogue");

        attacker.attack(defender);
        assertEquals(0, defender.getHealthPoints());
    }

    @Test
    public void testIsAlive() {
        GameCharacter c = new GameCharacter("Test", 10, 5, 2, "Human", "Warrior");
        assertTrue(c.isAlive());
        c.takeDamage(10);
        assertFalse(c.isAlive());
    }
}