public class MontyHall
{
    
    private int stayTotal;
    private int stayWins;
    private int switchTotal;
    private int switchWins;
    
    
    //Constructor - only need one
    public MontyHall()
    {
        stayTotal = 0;
        stayWins = 0;
        switchTotal = 0;
        switchWins = 0;
    }
    
    
    
    //Modifier Methods ("Setters")
    public void reset()
    {
        stayTotal = 0;
        stayWins = 0;
        switchTotal = 0;
        switchWins = 0;
    }
    
    
    
    //Accessor Methods ("Getters")
    public int getStayTotal()
    {
        return stayTotal;
    }
    
    public int getStayWins()
    {
        //modify this to return the right instance variable
        return 0;
    }
    
    public int getSwitchTotal()
    {
        //modify this to return the right instance variable
        return 0;
    }
    
    public int getSwitchWins()
    {
        //modify this to return the right instance variable
        return 0;
    }
    
    
    //Accessors to get win percentages
    public double stayWinPercentage()
    {
        if(stayTotal > 0)
        {
            return 100*(double)stayWins/stayTotal;
        }
        else
        {
            return 0.0;
        }
    }
    
    
    public double switchWinPercentage()
    {
        //modify this to work like stayWinPercentage(), but with "switch" numbers
        return 0.0;
    }
    
    
    
    //Private "utility" method to run one game (one set of 3 doors)
    //Takes a boolean: true to stay with first choice, false to switch to the other choice
    //This is completely implemented, do not worry about modifying it, but take a look at the
    //  code to see if you can figure out how it works!
    private boolean runGame(boolean stay)
    {
        //randomly place the car (1, 2, or 3)
        int car = Math.floor(Math.random()*3)+1;
        
        //randomly guess a door (1, 2, or 3)
        int choice = Math.floor(Math.random()*3)+1;
        
        //host opens a door
        int open;
        if(choice != car)
        {
            //if the initial guess is not correct, host only has one choice
            //sneaky trick: 1+2+3 = 6, so if I subtract the choice door and car door from six, I'll get the number of the remaining door!
            //e.g. choice = 1, car = 3, 6-1-3 = 2 (the remaining door)
            open = 6 - choice - car;
            
        }
        else
        {
            //the initial guess was right, so host randomly chooses between the other (goat-containing) doors
            
            //high and low are the possible doors
            int high;
            int low;
            
            //set high and low depending on the choice (they should be the other two doors)
            if(choice == 1)
            {
                high = 3;
                low = 2;
            }
            else if(choice == 2)
            {
                high = 3;
                low = 1;
            }
            else
            {
                high = 2;
                low = 1;
            }
            
            //now randomly choose high or low
            if(Math.random() > 0.5)
            {
                open = high;   
            }
            else
            {
                open = low;   
            }
            
            
            
        }
        
        //If the person did NOT decide to stay, switch to the other available door
        if(!stay)
        {
            //same subtract-from-6 trick from before
            choice = 6 - open - choice;
        }
        
        //Now, the moment of truth!  Return whether the choice matches the car
        return car == choice;
    }
    
    
    
    //runTrials method: runs n games where the contestant stays (pass in 'true') or switches (pass in 'false')
    public void runTrials(int n, boolean stay)
    {
        //use a for loop to run runGame(stay) n times   
        //each time it runs, add one to the appropriate total
        //each time it runs, add one to the appropriate 'wins' variable IF it was a win
        
        
    }
    
    
    
    
}