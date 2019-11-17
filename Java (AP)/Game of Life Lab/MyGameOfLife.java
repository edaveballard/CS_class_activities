public class MyGameOfLife extends GameOfLife
{
  //The current state of the Game of Life grid
  //"Living" cells are true, "Dead" cells are false
  private boolean[][] state;
  
  //The next (upcoming) state of the Game of Life grid
  //"Living" cells are true, "Dead" cells are false
  //Create this by looking at each cell's neighbors in the CURRENT state
  private boolean[][] nextState;
  
  public MyGameOfLife()
  {
    
  }
  
  //step() method replaces the current state with the next state
  //and clears the next state  (moves the simulation one interval forward in time)
  public void step()
  {
    nextState = new boolean[state.length][state[0].length];
  
    for(int i = 0; i < state.length; i++)
    {
      for(int j = 0; j < state[0].length; j++)
      {
        //count living neighbors
        int living = 0;
        for(int x = -1; x <= 1; x++ )
        {
          for(int y = -1; y <= 1; y++)
          {
            int xr = i+x;
            int yr = j+y;
            
            if(xr < 0)
            {
              xr += state.length;
            }
            else if(xr >= state.length)
            {
              xr -= state.length;
            }
            
            if(yr < 0)
            {
              yr += state[0].length;
            }
            else if(yr >= state[0].length)
            {
              yr -= state[0].length;
            }
            
            if(!(x==0 && y==0) && state[xr][yr])
            {
              living += 1;
            }
          }
        }
        
        if(!state[i][j] && living == 3)
        {
          nextState[i][j] = true;
        }
        else if(state[i][j] && (living < 2 || living > 3) )
        {
          nextState[i][j] = false;
        }
        else
        {
         nextState[i][j] = state[i][j];
        }
        
      }
    }
  
    state = nextState;
  }
  
  
  //setGame(boolean[][]) method reads in a matrix of booleans and replaces the internal state with the given matrix
  public void setGame(boolean[][] newState)
  {
    state = newState;
  }
  
  //getGame() method returns the current state of the game as a boolean[][] matrix
  public boolean[][] getGame()
  {
    return state;
  }
  
}