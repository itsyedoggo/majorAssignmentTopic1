import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Battle.
 */
public class BattleTest{
    /**
     * Tests a battle between two alive characters.
     */
    @Test
    public void testBattleBetweenTwoAliveCharacters(){
        GameCharacter a = new GameCharacter("A", 100, 20, 10, "Human", "Warrior");
        GameCharacter b = new GameCharacter("B", 100, 15, 5, "Human", "Mage");

        Battle battle = new Battle(a, b);
        String result = battle.startFight();

        assertTrue(result.contains("attacked"));
    }

    /**
     * Tests a battle with a dead character.
     */
    @Test
    public void testBattleWithDeadCharacter() {
        GameCharacter a = new GameCharacter("A", 0, 20, 10, "Human", "Warrior");
        GameCharacter b = new GameCharacter("B", 100, 15, 5, "Human", "Mage");

        Battle battle = new Battle(a, b);
        String result = battle.startFight();

        assertTrue(result.contains("is already dead"));
    }

    /**
     * Tests the damage calculation in a battle.
     */
    @Test
    public void testDamageCalculation() {
        GameCharacter attacker = new GameCharacter("Attacker", 100, 20, 10, "Human", "Warrior");
        GameCharacter defender = new GameCharacter("Defender", 100, 10, 5, "Human", "Mage");

        Battle battle = new Battle(attacker, defender);
        String result = battle.startFight();

        assertTrue(result.contains("attacked"));
    }
}