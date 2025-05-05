public class Character {
    private String name;
    private int health;
    private int strength;
    private int defense;
    private String race;
    Private String characterClass;

    public Character(String name, int health, int defense, String race, String characterClass) {
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

    public int attack(character opponent){
        int randomBonus = (int) (Math.random() * 6); //between 0 - 5
        int damage = (this.strength - opponent.defense) + randomBonus;
        if (damage < 1) damage = 1; //minimum 1 damage

        opponent.takeDamage(damage);
        return damage;
    }
    public void takeDamage(int damage) {
        this.health -= damage;
        if (health < 0) health = 0;
    }


    public String getName() { return name; }
    public int getHealth() { return health; }
    public String getRace() { return race; }
    public String getCHaracterClass () { return characterClass; }