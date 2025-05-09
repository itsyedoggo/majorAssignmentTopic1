public class Equipment {
    String name;
    int sM; //strength modifier
    int dM; // defense modifier
    int iM; // intelligence modifier
    
    public Equipment(String name, int sM, int dM, int iM){
        this.name = name;
        this.sM = sM;
        this.dM = dM;
        this.iM = iM;
    }

    public int getStrengthModifier(){
        return sM;
    }

    public int getDefenceModifier(){
        return dM;
    }

    public int getIntelligenceModifier(){
        return iM;
    }

    public String getName(){
        return name;
    }
}