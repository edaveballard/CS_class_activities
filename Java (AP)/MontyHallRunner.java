import java.util.Scanner;

public class MontyHallRunner
{
    
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("How many times would you like to try the Monty Hall problem?");
        int trials = keyboard.nextInt();
        
        System.out.println("For each try, would you like to (1) stay with your original guess or\n (2) switch to the other door after the host opens a door to reveal a goat?");
        boolean stay = keyboard.nextInt() == 1;
        
        MontyHall mh = new MontyHall();
        
        mh.runTrials(trials, stay);
        
        if(stay)
        {
            System.out.println("The staying strategy won the game "+String.format("%.2f",mh.stayWinPercentage())+"% of the time.");
        }
        else
        {
            System.out.println("The switching strategy won the game "+String.format("%.2f",mh.switchWinPercentage())+"% of the time.");
        }
        
        
    }
    
    
}