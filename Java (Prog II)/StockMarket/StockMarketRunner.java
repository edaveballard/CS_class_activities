import java.util.Scanner;

public class StockMarketRunner
{
  public static void main(String args[])
  {
    Scanner keyboard = new Scanner(System.in);
    StockMarket sm = new StockMarket();
    
    String choice = "";
    while(!choice.equals("quit"))
    {
      System.out.print(sm.getStocks());
      System.out.println("You have "+sm.getMoney());
      
      System.out.println("Type 'buy' to buy a stock, 'sell' to sell a stock, 'quit' to exit, or just hit enter to go to the next day.");
      
      choice = keyboard.nextLine().toLowerCase();
      if(choice.equals("buy"))
      {
        System.out.print("Which stock to buy (use number): ");
        int stock = keyboard.nextInt();
        
        
        System.out.print("How many to buy: ");
        int n = keyboard.nextInt();
        
        boolean worked = sm.buyStock(n,stock-1);
        
        if(worked)
        {
          System.out.println("Transaction successful!");
        }
        else
        {
          System.out.println("Transaction failed: not enough money!");
        }
        
        
      }
      else if(choice.equals("sell"))
      {
       
        System.out.print("Which stock to sell (use number): ");
        int stock = keyboard.nextInt();
        
        
        System.out.print("How many to sell: ");
        int n = keyboard.nextInt();
        
        boolean worked = sm.sellStock(n,stock-1);
        
        if(worked)
        {
          System.out.println("Transaction successful!");
        }
        else
        {
          System.out.println("Transaction failed: not enough of stock"+stock+"!");
        }
        
       
       
        
      }
      else if(choice.equals(""))
      {
        System.out.println("A day passes and stock prices change...");
        
        sm.updatePrices();
        
      }
      
      //if it's quit, just let the loop terminate
    }
  }
}