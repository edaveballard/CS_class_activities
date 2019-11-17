import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RunGameOfLife
{
  private static final int ROWS = 70;
  private static final int COLS = 150;
  private static final int SQUARE_SIZE = 8;
  
  public static void main(String args[]) throws InterruptedException
  {
    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
    
    MonoGridPanel mg = new MonoGridPanel(COLS,ROWS,SQUARE_SIZE);
    GOLControlPanel cont = new GOLControlPanel();
    
    
    
    //Add the panels to the master panel
    content.add(mg);
    content.add(cont);
    
    
    JFrame window; // The object that represents the window.
		window = new JFrame("Game of Life");  // Create a window with "Game of Life" in the title bar.
		window.setContentPane( content );  // Add the master panel to the window.
		window.pack(); // Set the size of the window based on the panel's preferred size
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
    
    
    GameOfLife gol = new MyGameOfLife();
    gol.setGame(mg.getGrid());
    
    while(true)
    {
      if(cont.isRunning())
      {
        Thread.sleep(cont.getDelay());
        gol.step();
        mg.setGrid(gol.getGame());
      }
      else
      {
        Thread.sleep(200);
        gol.setGame(mg.getGrid());
      }
    }
    
    
  }
}

class GOLControlPanel extends JPanel implements ChangeListener, ActionListener
{
  boolean run;
  int ms_delay;
  JButton start, stop;
  
  public GOLControlPanel()
  {
    run = false;
    ms_delay = 500;
    
    start = new JButton("Start");
    stop = new JButton("Stop");
    JSlider speedSlider = new JSlider(JSlider.HORIZONTAL,
                                              0, 990, 1000-ms_delay);
    speedSlider.addChangeListener(this);
    start.setActionCommand("start");
    start.addActionListener(this);
    stop.addActionListener(this);
 
    add(start);
    add(stop);
    add(speedSlider);
    //setPreferredSize( new Dimension(50, 50) );
  }
  
  public int getDelay()
  {
    return ms_delay;
  }
  
  public boolean isRunning()
  {
    return run;
  }
  
  public void stateChanged(ChangeEvent e)
  {
    JSlider source = (JSlider)e.getSource();
    if (!source.getValueIsAdjusting())
        ms_delay = 1000-(int)source.getValue();
  
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if ("start".equals(e.getActionCommand()))
    {
      run = true;
    }
    else
    {
      run = false;
    }
  }

  
}