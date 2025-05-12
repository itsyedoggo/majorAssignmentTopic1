/**
 * Represents a node in the battle history linked list.
 */
public class BattleHistory {
    private String battleLog;
    private BattleHistory next;

    /**
     * Constructs a new BattleHistory entry.
     * @param battleLog The log message for this entry.
     */
    public BattleHistory(String battleLog) {
        this.battleLog = battleLog;
        this.next = null;
    }

    /**
     * Adds a new log entry to the history.
     * @param log The log message to add.
     */
    public void addLog(String log) {
        if (next == null) {
            next = new BattleHistory(log);
        } else {
            next.addLog(log);
        }
    }

    /**
     * Prints the battle history to the console.
     */
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