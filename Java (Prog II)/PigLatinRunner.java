import java.util.Scanner;

public class PigLatinRunner
{

    public static void main(String args[])
    {
        PigLatin pl = new PigLatin();
        
        int choice = 0;
        
        String word = "";
        
        Scanner keyboard = new Scanner(System.in);
        
        while(choice != 3) 
        {
            System.out.println("Do you want to [1] translate English to Pig Latin, [2] check to see if a word looks like Pig Latin or [3] exit?")
            choice = keyboard.nextInt();
            
            if(choice == 1) 
            {
                System.out.println("Type the English word:");
                word = keyboard.next();
                
                pl.setEnglish(word);
                
                pl.translateToPigLatin();
                
                System.out.println(pl.getPigLatin()+"\n");
            }
            else if(choice == 2)
            {
                System.out.println("Type the Pig Latin word:");
                word = keyboard.next();
                
                pl.setPigLatin(word);
                String s = "";
                
                if(!pl.verifyPigLatin())
                {
                    s = " NOT ";
                }
                
                System.out.println("The word "+pl.getPigLatin()+"does"+s+"look like valid Pig Latin \n");
            }
            
        }
    
    }

}