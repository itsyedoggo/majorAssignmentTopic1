/**
 * Represents an entry in the battle log.
 */
public class BattleLogEntry {
    private String battleLog;
    private BattleLogEntry next;

    /**
     * Constructs a new BattleLogEntry.
     * @param battleLog The log message for this entry.
     */
    public BattleLogEntry(String battleLog) {
        this.battleLog = battleLog;
        this.next = null;
    }

    /**
     * Adds a new log entry to the history.
     * @param log The log message to add.
     */
    public void addLog(String log) {
        if (next == null) {
            next = new BattleLogEntry(log);
        } else {
            next.addLog(log);
        }
    }

    /**
     * Gets the battle log message.
     * @return The battle log message.
     */
    public String getBattleLog() {
        return battleLog;
    }

    /**
     * Gets the next battle log entry.
     * @return The next battle log entry.
     */
    public BattleLogEntry getNext() {
        return next;
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

    /**
     * Counts the number of logs in the history.
     * @return The number of logs in the history.
     */
    public int countLogs() {
        if (next == null) {
            return 1;
        }
        return 1 + next.countLogs();
    }

    /**
     * Gets all logs in the history as a single string.
     * @return All logs in the history as a single string.
     */
    public String getAllLogs() {
        if (next == null) {
            return battleLog;
        }
        return battleLog + "\n" + next.getAllLogs();
    }

    /**
     * Clears the battle history.
     */
    public void clearHistory() {
        if (next != null) {
            next.clearHistory();
        }
        next = null;
        battleLog = null;
    }
}