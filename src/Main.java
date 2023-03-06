import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(0,101);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;

        while (right<5){
            System.out.println("Enter your guess : ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99){
                System.out.println("Please enter a number between 0-100.");
                if (isWrong){
                    right++;
                    System.out.println("You made a mistake. Remaining right : "+(5-right));
                }else {
                    isWrong=true;
                    System.out.println("Another mistake will be resulted in loss of right.");
                }
                continue;
            }
            if ( selected == number ){
                System.out.println("Congrats, You guessed it right : "+number);
                isWin = true;
                break;
            }else{
                System.out.println("Your guess is wrong");
                if ( selected > number){
                    System.out.println(selected+" is bigger than the hidden number.");
                }else {
                    System.out.println(selected+" is smaller than the hidden number");
                }
                wrong[right++] = selected;
                System.out.println("Remaining rights : "+(5-right));
            }
        }
        System.out.println(number);
        if(!isWin){
            System.out.println("You lost the game !");
            if (!isWrong){
                System.out.println("Your guesses were : "+ Arrays.toString(wrong));
            }
        }

    }
}
