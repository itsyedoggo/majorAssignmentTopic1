import java.io.IOException;

/**
 * Main class for the RPG combat simulation.
 */
public class RPGCombatMain {
    /**
     * Main method for the RPG combat simulation.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Create characters
        //creating heroes
        GameCharacter batman = new GameCharacter("Batman", 100, 20, 10, "Human", "Warrior");
        GameCharacter superman = new GameCharacter("Superman", 120, 25, 15, "Kryptonian", "Tank");
        GameCharacter ironMan = new GameCharacter("Iron Man", 90, 18, 8, "Human", "Mage");
        GameCharacter wonderWoman = new GameCharacter("Wonder Woman", 110, 22, 12, "Amazon", "Paladin");

        //creating villains
        GameCharacter joker = new GameCharacter("Joker", 90, 18, 8, "Human", "Assassin");
        GameCharacter lexLuthor = new GameCharacter("Lex Luthor", 95, 20, 10, "Human", "Mage");
        GameCharacter obadiahStane = new GameCharacter("Obadiah Stane", 85, 15, 5, "Human", "Warrior");
        GameCharacter ares = new GameCharacter("Ares", 120, 25, 15, "God", "Tank");

        // Create teams
        Team heroes = new Team("Heroes");
        heroes.addCharacter(batman);
        heroes.addCharacter(superman);
        heroes.addCharacter(ironMan);
        heroes.addCharacter(wonderWoman);

        Team villains = new Team("Villains");
        villains.addCharacter(joker);
        villains.addCharacter(lexLuthor);
        villains.addCharacter(obadiahStane);
        villains.addCharacter(ares);

        // Start Battle
        try {
            BattleArena arena = new BattleArena(heroes, villains);
            arena.startBattle();
        } catch (IOException e) {
            System.out.println("An error occurred during battle: " + e.getMessage());
        }
    }
}
