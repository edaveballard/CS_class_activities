public class StockMarket
{
  private final int NUM_STOCKS = 5;
  
  private final String[] nameBank = {"Red","Blue","Green","Pizza","Bottle","Zap","Digital","Glass","Ghost","Zillion","Bob's","Mars","Solar","Frequency","Paper","Forever","16","2000","Enterprise","Corporate","Optimize","Velocity","Pow","Water","Bright","Stooge","Whatever","Tree","Speedy","Brilliant","Word","Z","Solution","Magpie","Howl","Retina","Spleen","Slice"};
  
  private int[] stockPrices;
  private String[] stockNames;
  
  private int money;
  private int[] holdings;
  
  //Only one constructor
  public StockMarket()
  {
    //Initialize money, stocks, holdings
    money = 1000;
    stockPrices = new int[NUM_STOCKS];
    stockNames = new String[NUM_STOCKS];
    holdings = new int[NUM_STOCKS]; //okay to leave this all zeroes!
    
    //Initialize names and prices of all 5 stocks
    for(int i = 0; i < NUM_STOCKS; i++)
    {
      //choose two random words for each stock name
      //it will be great
      String first = nameBank[(int)(Math.random()*nameBank.length)];
      String second = nameBank[(int)(Math.random()*nameBank.length)];
      
      stockNames[i] = first+" "+second;
      
      
      //now the price: 10-60
      stockPrices[i] = (int)(Math.random()*50+10);
    }
    
  }
  
  
  
  //randomly change all stock prices
  public void updatePrices()
  {
    //for each price
    for(int i = 0; i < NUM_STOCKS; i++)
    {
      int newPrice = stockPrices[i] + Math.round(5-Math.random()*10);
      
      //check to see if below 1, set to 1 if it is
      if(newPrice < 1)
      {
        newPrice = 1;
      }
      stockPrices[i] = newPrice;
      
    }
  }
  
  
  //this will buy stocks
  public boolean buyStock(int num, int stock)
  {
    //check to see if it is too expensive
    if(money < num*stockPrices[stock])
    {
      //too expensive, return false to indicate the buy did not go through
      return false;
    }
    
    //we have enough, deduct money and add that num of stocks to holdings
    money -= num*stockPrices[stock];
    holdings[stock] += num;
    
    return true;
  }
  
  
  //this will sell stocks
  public boolean sellStock(int num, int stock)
  {
    //check to see if we have that many of the stock
    if(holdings[stock] < num)
    {
      //too much, return false to indicate the sell did not go through
      return false;
    }
    
    //we have enough, add money and subtract that num of stocks from holdings
    money += num*stockPrices[stock];
    holdings[stock] -= num;
    
    return true;
  }
  
  
  public String getStocks()
  {
    String out = "";
    
    for(int i = 0; i < NUM_STOCKS; i++)
    {
      out = out + (i+1) + ": " + stockNames[i] + " -- $" + stockPrices[i] + "\n";
    }
    
    return out;
  }
  
  public String getMoney()
  {
    return "$"+money;
  }
  
  
  
}