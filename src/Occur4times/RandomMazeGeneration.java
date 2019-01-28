package Occur4times;

/**
 * Start with a grid full of walls.
 * Pick a cell, mark it as part of the maze. Add the walls of the cell to the wall list.
 * While there are walls in the list:
 *      Pick a random wall from the list. If only one of the two cells that the wall divides is visited, then:
 *          Make the wall a passage and mark the unvisited cell as part of the maze.
 *          Add the neighboring walls of the cell to the wall list.
 *      Remove the wall from the list.
 */
public class RandomMazeGeneration {
}
