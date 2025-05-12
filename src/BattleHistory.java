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