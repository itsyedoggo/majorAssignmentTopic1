import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;


public class BattleTest{
    @Test
    public void testBattleBetweenTwoAliveCharacters(){
        Character a = new Character("A", 100, 20, 10, "Human", "Warrior");
        Character b = new Character("B", 100, 15, 5, "Human", "Mage");

        Battle battle = new Battle(a, b);
        String result = battle.startFight();

        assertTrue(result.contains("attacked"));
    }

    @Test
    public void testBattleWithDeadCharacter() {
        Character a = new Character("A", 0, 20, 10, "Human", "Warrior");
        Character b = new Character("B", 100, 15, 5, "Human", "Mage");

        Battle battle = new Battle(a, b);
        String result = battle.startFight();

        assertTrue(result.contains("is already dead"));
    }
}