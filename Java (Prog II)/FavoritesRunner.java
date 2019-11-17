import java.util.Scanner;

public class FavoritesRunner
{
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        
        Favorites test = new Favorites();
        
        int n = test.numberOfFavorites();
        
        System.out.println("Let's store your "+n+" favorite things in an array!");
        for(int i = 0; i < n; i++)
        {
            System.out.print("\nFavorite thing "+(i+1)+": ");
            String thing = keyboard.nextLine();
            //store favorite thing in test
            test.setThing(i,thing);
        }
        System.out.prinln("\n" + test.toString());
    }
}