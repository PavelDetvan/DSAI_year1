import java.util.Scanner;

public class RPSLO {

    // Rock = 0, Paper = 1, Scissors = 2, Lizzard = 3, Spock = 4
    // Scissors cut Paper
    // Paper covers Rock
    // Rock crushes Lizard
    // Lizard poisons Spock
    // Spock smashes Scissors
    // Scissors decapitate Lizard
    // Lizard eats Paper
    // Paper disproves Spock
    // Spock vaporizes Rock
    // Rock crushes Scissors

    public static void main(String[] args) {
        System.out.println("Enter your play: R, P, S, L, O");
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        input = input.toUpperCase();
        //System.out.println("user gave " + input); //just for pchecking the conversion to uppercase
        
        scanner.close();

        //Checking if the user gave proper symbol
        if(input.equals("R")||input.equals("P")||input.equals("S")||input.equals("L")||input.equals("O")) {
            //user gave correct symbol, computer now have to choose the play
            
            double pick = Math.random();
        //System.out.println("computer picked" + pick); //for checking the right value of pick

            String play;
            if(pick<0.2) {
                play = "R";
                System.out.println("Computer play is " + play);
            }
            else if(pick<0.4) {
                play = "P";
                System.out.println("Computer play is " + play);
            }
            else if(pick<0.6) {
                play = "S";
                System.out.println("Computer play is " + play);
            }
            else if(pick<0.8) {
                play = "L";
                System.out.println("Computer play is " + play);
            }
            else {
                play = "O";
                System.out.println("Computer play is " + play);
            }
            
            //checking if the user input and computer choice are teh same
            if(play.equals(input)) {
                System.out.println("It is a tie!");
            }
            else{
                if(input.equals("S") && (play.equals("P")||play.equals("L"))) {
                    System.out.println("You win!");
                }
                else if(input.equals("S")){
                    System.out.println("Computer wins!");
                }
                else if(input.equals("P") && (play.equals("R")||play.equals("O"))) {
                    System.out.println("You win!");
                }
                else if(input.equals("P")) {
                    System.out.println("Computer wins!");
                }
                else if(input.equals("R") && (play.equals("L")||play.equals("S"))) {
                    System.out.println("You win!");
                }
                else if(input.equals("R")) {
                    System.out.println("Computer wins!");
                }
                else if(input.equals("L") && (play.equals("O")||play.equals("P"))) {
                    System.out.println("You win!");
                }
                else if(input.equals("L")) {
                    System.out.println("Computer wins!");
                }
                else if(input.equals("O") && (play.equals("S")||play.equals("R"))) {
                    System.out.println("You win!");
                }
                else if(input.equals("O")) {
                    System.out.println("Computer wins!");
                }
                    
            }


        }
        else{
            System.out.println("Invalid input (valid inputs: R, P, S, L, O)");
        }
    }
}