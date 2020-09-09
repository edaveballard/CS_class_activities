/*
Extend the abstract class GameOfLife to create your own
Conway's Game of Life implementation.

This class is fed a matrix of booleans, and must store, modify, and return the
state of the matrix based on the rules of Conway's Game of Life


Conway's Game of Life Rules:
-Each cell has 8 neighbors (adjacent and diagonally-adjacent cells)
-A live cell with fewer than two live neighbors dies (underpopulation/extinction)
-A live cell with two or three live neighbors stays alive (sustainable population density)
-A live cell with more than three neighbors dies (overpopulation)
-A dead cell with EXACTLY three live neighbors comes to life (reproduction)
-A cell that is at the edge of the grid (with fewer than 8 neighbors) behaves as if the "missing" neighbor cells are dead


Challenge Rules (possible replacements for the final rule):
-Cylinder topology: cells at the side (left/right) edges are neighbors with cells at the opposite side's edges
-Toroid (donut) topology: cells at the side edges AND top and bottom edges are neighbors with cells at the opposite edge
-Klein bottle: like toroid, the cells at the edges are neighbors with cells on the opposite edge, but reversed (cell in the top second-to-left position is neighbor with cell in the top second-to-right position)

*/

public abstract class GameOfLife
{
  //The current state of the Game of Life grid
  //"Living" cells are true, "Dead" cells are false
  private boolean[][] state;
  
  //The next (upcoming) state of the Game of Life grid
  //"Living" cells are true, "Dead" cells are false
  //Create this by looking at each cell's neighbors in the CURRENT state
  private boolean[][] nextState;
  
  
  //step() method replaces the current state with the next state
  //and clears the next state  (moves the simulation one interval forward in time)
  public abstract void step();
  
  
  //setGame(boolean[][]) method reads in a matrix of booleans and replaces the internal state with the given matrix
  public abstract void setGame(boolean[][] newState);
  
  //getGame() method returns the current state of the game as a boolean[][] matrix
  public abstract boolean[][] getGame();
  
}