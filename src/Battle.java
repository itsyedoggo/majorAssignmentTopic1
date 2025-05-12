public class Battle {
    private GameCharacter attacker1;
    private GameCharacter attacker2;

    public Battle(GameCharacter attacker1, GameCharacter attacker2) {
        this.attacker1 = attacker1;
        this.attacker2 = attacker2;
    }

    public String startFight() {
        if (!attacker1.isAlive() || !attacker2.isAlive()) {
            return "One of the fighters is already dead!!";
        }

        int damage = attacker1.attack(attacker2);
        return attacker1.getName() + " attacked " + attacker2.getName() + " for " + damage + " damage!";
    }
}
// fixed hopefully