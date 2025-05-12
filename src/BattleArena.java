import java.io.FileWriter;
import java.io.IOException;

public class BattleArena {
    private Team team1;
    private Team team2;
    private FileWriter battleLog;

    public BattleArena(Team team1, Team team2) throws IOException {
        this.team1 = team1;
        this.team2 = team2;
        this.battleLog = new FileWriter("BattleLog.txt", true); // Append mode
    }

    public void startBattle() throws IOException {
        fightTurn(team1, team2);
        battleLog.close();
    }
    private void fightTurn(Team attackingTeam, Team defendingTeam) throws IOException {
        if (!attackingTeam.hasLivingMembers() || !defendingTeam.hasLivingMembers()){
            declareWinner();
            return;
        }
        GameCharacter attacker = attackingTeam.getNextAliveCharacter();
        GameCharacter defender = defendingTeam.getNextAliveCharacter();

        Battle battle = new Battle (attacker, defender);
        String result = battle.startFight();
        System.out.println(result);
        battleLog.write(result + "\n");

        // recursively continue fight, switch attacker and defender
        fightTurn(defendingTeam, attackingTeam);
    }

    private void declareWinner() throws IOException {
        if (team1.hasLivingMembers()) {
            System.out.println("\nTeam " + team1.getTeamName() + " wins!");
            battleLog.write("\nTeam " + team1.getTeamName() + " wins!\n");
        } else if (team2.hasLivingMembers()) {
            System.out.println("\nTeam " + team2.getTeamName() + " wins!");
            battleLog.write("\nTeam " + team2.getTeamName() + " wins!\n");
        } else {
            System.out.println("\nIt's a draw!");
            battleLog.write("\nIt's a draw!\n");
        }
    }

    public void saveGameState(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Team 1: " + team1.getTeamName() + "\n");
            for (Character c : team1.getMembers()) {
                writer.write(c.getName() + " - HP: " + c.getHealth() + "\n");
            }
            writer.write("Team 2: " + team2.getTeamName() + "\n");
            for (Character c : team2.getMembers()) {
                writer.write(c.getName() + " - HP: " + c.getHealth() + "\n");
            }
        }
    }
}