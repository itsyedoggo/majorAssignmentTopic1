/**
 * Represents a battle between two characters.
 */
public class Battle {
    private GameCharacter attacker1;
    private GameCharacter attacker2;

    /**
     * Constructs a new Battle.
     * @param attacker1 The first attacker.
     * @param attacker2 The second attacker.
     */
    public Battle(GameCharacter attacker1, GameCharacter attacker2) {
        this.attacker1 = attacker1;
        this.attacker2 = attacker2;
    }

    /**
     * Starts the fight between the two characters.
     * @return A string describing the outcome of the fight.
     */
    public String startFight() {
        if (!attacker1.isAlive() || !attacker2.isAlive()) {
            return "One of the fighters is already dead!!"; // test 
        }

        int damage = attacker1.attack(attacker2);
        return attacker1.getName() + " attacked " + attacker2.getName() + " for " + damage + " damage!";
    }
}