public class BattleLogEntry {
    private String battleLog;
    private BattleLogEntry next;

    public BattleLogEntry(String battleLog) {
        this.battleLog = battleLog;
        this.next = null;
    }

    public void addLog(String log) {
        if (next == null) {
            next = new BattleLogEntry(log);
        } else {
            next.addLog(log);
        }
    }

    public String getBattleLog() {
        return battleLog;
    }

    public BattleLogEntry getNext() {
        return next;
    }

    public void printHistory() {
        System.out.println(battleLog);
        if (next != null) {
            next.printHistory();
        }
    }

    public int countLogs() {
        if (next == null) {
            return 1;
        }
        return 1 + next.countLogs();
    }

    public String getAllLogs() {
        if (next == null) {
            return battleLog;
        }
        return battleLog + "\n" + next.getAllLogs();
    }

    public void clearHistory() {
        if (next != null) {
            next.clearHistory();
        }
        next = null;
        battleLog = null;
    }
}