import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Monochrome Grid utility
  Instiated with rows, cols, cellsize (all ints)
  
  (setGrid) Can take and dispay a boolean[][] of matching size as a monochromatic grid
  (setPoint) Also can turn on or off individual cells
  (blankGrid) Can clear internal state
  (getGrid)Can deliver its own state as a boolean[][]
  
  State can be changed by user clicking (toggles cells black/white).  This is reflected in subsequently-retrieved states.
*/

public class MonoGridPanel extends JPanel implements MouseListener
{
  
  private int xSize, ySize, squareSize;   //size of the grid and squares in the grid
  private boolean[][] grid;               //the internally-stored state of the grid
  
  
  //Constructor: takes x (cols), y (rows), s (pixels in a cell/square)
  public MonoGridPanel(int x, int y, int s)
  {
    xSize = x;
    ySize = y;
    squareSize = s;
    
    //intialize internal state
    grid = new boolean[xSize][ySize];
    blankGrid();
    
    //All the graphics mumbo-jumbo
		setPreferredSize( new Dimension(squareSize*xSize, squareSize*ySize) );  //Size of the window
		setBackground(Color.WHITE); // Set the background color for this panel.
		addMouseListener(this);  //Listens for user mouse presses
  }
  
  //returns a ref to a COPY of the current grid state
  public boolean[][] getGrid()
  {
    boolean[][] newGrid = new boolean[xSize][ySize];
    
    for(int x = 0; x < xSize; x++)
    {
      for(int y = 0; y < ySize; y++)
      {
        newGrid[x][y] = grid[x][y];
      }
    }
    return newGrid;
  }
  
  
  //reads in a given grid (copies, does not just point to the ref given)
  public void setGrid(boolean[][] newGrid)
  {
    for(int x = 0; x < xSize; x++)
    {
      for(int y = 0; y < ySize; y++)
      {
        grid[x][y] = newGrid[x][y];
      }
    }
    repaint();
  }
  
  //Sets a single cell in the grid at x,y to val (true/black or false/white)
  public void setPoint(int x, int y, boolean val)
  {
    grid[x][y] = val;
    repaint();
  }
  
  //clears (sets all cells to false) the internal state
  public void blankGrid()
  {
    for(int x = 0; x < xSize; x++)
    {
      for(int y = 0; y < ySize; y++)
      {
        grid[x][y] = false;
      }
    }
    repaint();
  
  }
  
  //forces a refresh of the visible state of the grid.  Probably don't ever need to use, as the grid redraws in all state change methods
  public void drawGrid()
  {
    repaint();
  }
  
  //The method that actually draws the grid
  protected void paintComponent(Graphics g)
  {
    //Draw gridlines
    g.setColor(Color.GRAY);
    for(int x = 0; x <= xSize; x++)
    {
      g.drawLine(x*squareSize,0,x*squareSize,(ySize+1)*squareSize);
    }
    for(int y = 0; y <= ySize; y++)
    {
      g.drawLine(0,y*squareSize,(xSize+1)*squareSize,y*squareSize);
    }
    
    //Fill in rectangles
    for(int x = 0; x < xSize; x++)
    {
      for(int y = 0; y < ySize; y++)
      {
        if(grid[x][y] == true)
        {
          g.setColor(Color.BLACK);
          }
        else
        {
          g.setColor(Color.WHITE);
        }
        g.fillRect( x*squareSize+1, y*squareSize+1, squareSize-1, squareSize -1);
      }
    }
  
  }
  
  //If mouse is pressed, toggle (invert) the state of the pressed cell and repaint
  public void mousePressed(MouseEvent evt) {
		int y = evt.getY()/squareSize;
		int x = evt.getX()/squareSize;
      //System.out.println(x+" "+y);
		
		grid[x][y] = !grid[x][y];

		repaint(); // Causes the panel to be redrawn, by calling the paintComponent method.
	}
  
  // The following are unneeded mouse event methods.  The definitions
	// must be here even though they are not used, to satisfy the
	// "MouseListener" interface.
	public void mouseClicked(MouseEvent evt) { }
	public void mouseEntered(MouseEvent evt) {	}
	public void mouseExited(MouseEvent evt) { }
	public void mouseReleased(MouseEvent evt) { }
  
}