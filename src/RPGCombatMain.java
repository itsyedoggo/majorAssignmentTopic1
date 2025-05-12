import java.io.IOException;

public class RPGCombatMain {
    public static void main(Strinf [] args) {
        // Create characters
        //creating heroes 
        Character batman = new Character("Batman", 100, 20, 10, "Human", "Warrior");
        Character superman = new Character("Superman", 120, 25, 15, "Kryptonian", "Tank");
        Character ironMan = new Character("Iron Man", 90, 18, 8, "Human", "Mage");
        Character wonderWoman = new Character("Wonder Woman", 110, 22, 12, "Amazon", "Paladin");
        

        //creating villains
        Character joker = new Character("Joker", 90, 18, 8, "Human", "Assassin");
        Character lexLuthor = new Character("Lex Luthor", 95, 20, 10, "Human", "Mage");
        Character obadiahStane = new Character("Obadiah Stane", 85, 15, 5, "Human", "Warrior");
        Character Ares = new Character("Ares", 120, 25, 15, "God", "Tank");

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
        villains.addCharacter(Ares);

        // Start Battle
        try {
            BattleArena arena = new BattleArena(heroes, villains);
            arena.startBattle();
        } catch (IOException e) {
            System.out.println("An error occured during battle: " + e.getMessage());
        }
     }
}