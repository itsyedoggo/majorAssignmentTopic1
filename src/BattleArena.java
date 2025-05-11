import java.ioFileWriter;
import java.io.IOException;

public class BattleArena {
    private Team team1;
    private Team team2;
    privateFileWriter battleLog;

    public BattleArena (Team team1, Team team2) throws IOException {
        this.team1 = team1;
        this.team2 = team2;
        this.battleLog = new FileWriter("BattleLog.txt");
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
        Character attacker = attackingTeam.getNextAliveCharacter();
        Character defender = defendingTeam.getNextAliveCharacter();

        Battle battle = new Battle (attacker, defeder);
        String result = battle.startFight();
        system.out.println(result);
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
}