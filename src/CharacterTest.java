import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for GameCharacter.
 */
public class CharacterTest {

    /**
     * Tests that the attack deals a reasonable amount of damage.
     */
    @Test
    public void testAttackDealsReasonableDamage() {
        GameCharacter attacker = new GameCharacter("Attacker", 100, 20, 10, "Human", "Warrior");
        GameCharacter defender = new GameCharacter("Defender", 100, 10, 5, "Human", "Mage");

        int originalHP = defender.getHealthPoints();
        int damage = attacker.attack(defender);

        assertTrue(damage >= 0 && damage <= 15);
        assertEquals(originalHP - damage, defender.getHealthPoints());
    }

    /**
     * Tests that the attacker cannot reduce the defender's health below zero.
     */
    @Test
    public void testAttackerCannotReduceBelowZero() {
        GameCharacter attacker = new GameCharacter("StrongGuy", 100, 100, 5, "Human", "Warrior");
        GameCharacter defender = new GameCharacter("WeakGuy", 10, 5, 1, "Human", "Rogue");

        attacker.attack(defender);
        assertEquals(0, defender.getHealthPoints());
    }

    /**
     * Tests that the isAlive method returns the correct value.
     */
    @Test
    public void testIsAlive() {
        GameCharacter character = new GameCharacter("Test", 100, 20, 10, "Human", "Warrior");
        assertTrue(character.isAlive());

        character.takeDamage(100);
        assertFalse(character.isAlive());
    }

    /**
     * Tests that the takeDamage method correctly reduces the character's health.
     */
    @Test
    public void testTakeDamage() {
        GameCharacter character = new GameCharacter("Test", 100, 20, 10, "Human", "Warrior");
        character.takeDamage(20);
        assertEquals(80, character.getHealthPoints());
    }

    /**
     * Tests that the attack method returns a value greater than 0.
     */
    @Test
    public void testAttack() {
        GameCharacter attacker = new GameCharacter("Attacker", 100, 20, 10, "Human", "Warrior");
        GameCharacter defender = new GameCharacter("Defender", 100, 10, 5, "Human", "Mage");

        int damage = attacker.attack(defender);
        assertTrue(damage > 0);
    }
}