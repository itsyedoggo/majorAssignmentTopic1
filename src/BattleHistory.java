public class BattleHistory {
    private String battleLog;
    private BattleHistory next;

    public BattleHistory(String battleLog) {
        this.battleLog = battleLog;
        this.next = null;
    }

    public void addLog(String log) {
        if (next == null) {
            next = new BattleHistory(log);
        } else {
            next.addLog(log);
        }
    }

    public void printHistory() {
        System.out.println(battleLog);
        if (next != null) {
            next.printHistory();
        }
    }
}

public class BattleArena {
    private Team team1;
    private Team team2;
    private FileWriter battleLog;
    private BattleHistory history;

    public BattleArena(Team team1, Team team2) throws IOException {
        this.team1 = team1;
        this.team2 = team2;
        this.battleLog = new FileWriter("BattleLog.txt");
        this.history = null; // Initialize empty history
    }

    private void fightTurn(Team attackingTeam, Team defendingTeam) throws IOException {
        if (!attackingTeam.hasLivingMembers() || !defendingTeam.hasLivingMembers()) {
            declareWinner();
            return;
        }
        Character attacker = attackingTeam.getNextAliveCharacter();
        Character defender = defendingTeam.getNextAliveCharacter();
        if (attacker == null || defender == null) {
            declareWinner();
            return;
        }

        Battle battle = new Battle(attacker, defender);
        String result = battle.startFight();
        System.out.println(result);
        battleLog.write(result + "\n");

        // Add to battle history
        if (history == null) {
            history = new BattleHistory(result);
        } else {
            history.addLog(result);
        }

        // Recursively continue fight, switch attacker and defender
        fightTurn(defendingTeam, attackingTeam);
    }

    public void printBattleHistory() {
        if (history != null) {
            history.printHistory();
        } else {
            System.out.println("No battle history available.");
        }
    }
}