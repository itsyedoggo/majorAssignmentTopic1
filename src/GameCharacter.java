/**
 * Represents a character in the game.
 */
public class GameCharacter {
    private static RandomNumberGenerator rng = new RandomNumberGenerator();

    private String name;
    private int health;
    private int strength;
    private int defense;
    private String race;
    private String characterClass;

    /**
     * Constructs a new GameCharacter.
     * @param name The name of the character.
     * @param health The health of the character.
     * @param strength The strength of the character.
     * @param defense The defense of the character.
     * @param race The race of the character.
     * @param characterClass The class of the character.
     */
    public GameCharacter(String name, int health, int strength, int defense, String race, String characterClass) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.race = race;
        this.characterClass = characterClass;
    }

    /**
     * Checks if the character is alive.
     * @return True if the character's health is greater than 0, false otherwise.
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Attacks another character.
     * @param target The character to attack.
     * @return The amount of damage dealt.
     */
    public int attack(GameCharacter target) {
        int diceRoll = rng.rollDice(); // 1-6
        int baseDamage = this.strength - target.defense;
        int damage;

        if (diceRoll == 6) {
            damage = (int)(baseDamage * 2); // supercharged attack
        } else if (diceRoll == 1) {
            damage = (int)(baseDamage * 0.5); // weak attack
        } else {
            damage = baseDamage; // normal attack
        }

        if (damage < 1) damage = 1; // minimum 1 damage

        target.takeDamage(damage);

        System.out.println(this.name + " rolled a " + diceRoll + "!");
        return damage;
    }

    /**
     * Reduces the character's health by the specified amount.
     * @param damage The amount of damage to take.
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        if (health < 0) health = 0;
    }

    /**
     * Gets the name of the character.
     * @return The name of the character.
     */
    public String getName() { return name; }

    /**
     * Gets the health points of the character.
     * @return The health points of the character.
     */
    public int getHealthPoints() { return health; }

    /**
     * Gets the race of the character.
     * @return The race of the character.
     */
    public String getRace() { return race; }

    /**
     * Gets the class of the character.
     * @return The class of the character.
     */
    public String getCharacterClass() { return characterClass; }
}