public class GameCharacter {
    private static RandomNumberGenerator rng = new RandomNumberGenerator();

    private String name;
    private int health;
    private int strength;
    private int defense;
    private String race;
    private String characterClass;

    public GameCharacter(String name, int health, int strength, int defense, String race, String characterClass) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.race = race;
        this.characterClass = characterClass;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack(GameCharacter opponent) {
        int diceRoll = rng.rollDice(); // 1-6
        int baseDamage = this.strength - opponent.defense;
        int damage;

        if (diceRoll == 6) {
            damage = (int)(baseDamage * 2); // supercharged attack
        } else if (diceRoll == 1) {
            damage = (int)(baseDamage * 0.5); // weak attack
        } else {
            damage = baseDamage; // normal attack
        }

        if (damage < 1) damage = 1; // minimum 1 damage

        opponent.takeDamage(damage);

        System.out.println(this.name + " rolled a " + diceRoll + "!");
        return damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (health < 0) health = 0;
    }

    // Removed duplicate method getHealthPoints()

    public String getName() { return name; }
    public int getHealthPoints() { return health; }
    public String getRace() { return race; }
    public String getCharacterClass() { return characterClass; }
}
    //changed