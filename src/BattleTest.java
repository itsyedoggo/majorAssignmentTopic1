import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;


public class BattleTest{
    @Test
    public void testBattleBetweenTwoAliveCharacters(){
        GameCharacter a = new GameCharacter("A", 100, 20, 10, "Human", "Warrior");
        GameCharacter b = new GameCharacter("B", 100, 15, 5, "Human", "Mage");

        Battle battle = new Battle(a, b);
        String result = battle.startFight();

        assertTrue(result.contains("attacked"));
    }

    @Test
    public void testBattleWithDeadCharacter() {
        GameCharacter a = new GameCharacter("A", 0, 20, 10, "Human", "Warrior");
        GameCharacter b = new GameCharacter("B", 100, 15, 5, "Human", "Mage");

        Battle battle = new Battle(a, b);
        String result = battle.startFight();

        assertTrue(result.contains("is already dead"));
    }
}