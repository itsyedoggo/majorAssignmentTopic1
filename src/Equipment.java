/**
 * Represents an item of equipment that can be used by a character.
 
 * this class is currently not used
 * Represents a piece of equipment that can be used by a character, possiblly with newer versions of the game or when characters unlock new levels in the future. 
 */

public class Equipment {
    String name;
    int strengthModifier; //strength modifier
    int defenseModifier; // defense modifier
    int intelligenceModifier; // intelligence modifier

    /**
     * Constructs a new Equipment object.
     * @param name The name of the equipment.
     * @param strengthModifier The strength modifier of the equipment.
     * @param defenseModifier The defense modifier of the equipment.
     * @param intelligenceModifier The intelligence modifier of the equipment.
     */
    public Equipment(String name, int strengthModifier, int defenseModifier, int intelligenceModifier){
        this.name = name;
        this.strengthModifier = strengthModifier;
        this.defenseModifier = defenseModifier;
        this.intelligenceModifier = intelligenceModifier;
    }

    /**
     * Gets the strength modifier of the equipment.
     * @return The strength modifier of the equipment.
     */
    public int getStrengthModifier(){
        return strengthModifier;
    }

    /**
     * Gets the defence modifier of the equipment.
     * @return The defense modifier of the equipment.
     */
    public int getDefenceModifier(){
        return defenseModifier;
    }

    /**
     * Gets the intelligence modifier of the equipment.
     * @return The intelligence modifier of the equipment.
     */
    public int getIntelligenceModifier(){
        return intelligenceModifier;
    }

    /**
     * Gets the name of the equipment.
     * @return The name of the equipment.
     */
    public String getName(){
        return name;
    }
}
