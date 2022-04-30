import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
class StonePaperScissors {
    HashMap <Integer, String> itemMapping = new HashMap <>();
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    StonePaperScissors(){
        itemMapping.put(1,"stone");
        itemMapping.put(2,"paper");
        itemMapping.put(3,"scissors");
    }

    private boolean didPlayerWin(int playerMove,int machineMove){
        if (playerMove == 1 && machineMove==3 ) return true;
        if (playerMove == 3 && machineMove==2 ) return true;
        if (playerMove == 2 && machineMove==1 ) return true;
        return false;
    }

    private int playerMove(int turnNumber) {
        System.out.println("Select Your Option for Turn: "+(turnNumber+1));
        for (int itemSymbol: itemMapping.keySet()){
            System.out.println(itemSymbol+" -> "+itemMapping.get(itemSymbol));
        }
        int machineMove = random.nextInt(1,4);
        int option = scanner.nextInt();
        if (option<1 || option>3) return -1;
        System.out.println("Player chose: "+itemMapping.get(option)+", Machine chose: "+itemMapping.get(machineMove));
        if (machineMove==option){
            System.out.println("DRAW!!!");
            return 0;
        }
        boolean playerVictory = didPlayerWin(option, machineMove);
        System.out.println(playerVictory?"Player Won!!!":"Machine Won!!!");
        return playerVictory ? 1 : 0;
    }
    void startGame(){
        System.out.println("Welcome to Stone-Paper-Scissors");
        System.out.println("How many turns do you want to take?");
        int turns = scanner.nextInt();
        int runs  = playGame(turns);
        float score = (float) runs / turns;
        System.out.println("===========================");
        System.out.println("You won "+ runs + " number of times, final score "+score*100+" %" );
        System.out.println("===========================");
    }
    private int playGame(int turns){
        int score = 0;
        for(int turn=0;turn<turns;turn++) {
            while (true){
                int currentScore = playerMove(turn);
                if (currentScore==-1){
                    System.out.println("You chose an invalid option, repeating your turn...");
                    continue;
                }
                score += currentScore;
                break;
            }
        }
        return score;
    }
}


