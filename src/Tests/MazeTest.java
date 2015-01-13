package Tests;
import java.util.ArrayList;

import junit.framework.JUnit4TestAdapter;

import org.junit.BeforeClass;
import org.junit.Test;

import MazeSolver.Coordinate;
import MazeSolver.Maze;
import MazeSolver.Space;



public class MazeTest {

	public static Maze maze = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Space[][] grid = new Space[5][4];
		
		grid[0][0] = Space.WALL;
		grid[0][1] = Space.WALL;
		grid[0][2] = Space.WALL;
		grid[0][3] = Space.WALL;
		grid[1][0] = Space.OPEN;
		grid[1][1] = Space.OPEN;
		grid[1][2] = Space.OPEN;
		grid[1][3] = Space.WALL;
		grid[2][0] = Space.WALL;
		grid[2][1] = Space.WALL;
		grid[2][2] = Space.OPEN;
		grid[2][3] = Space.WALL;
		grid[3][0] = Space.OPEN;
		grid[3][1] = Space.OPEN;
		grid[3][2] = Space.OPEN;
		grid[3][3] = Space.WALL;
		grid[4][0] = Space.WALL;
		grid[4][1] = Space.WALL;
		grid[4][2] = Space.WALL;
		grid[4][3] = Space.WALL;
		
		maze = new Maze(grid);
	}

	@Test
	public void testGetAdjacentOpenSpacesr1c1() {
		
		ArrayList<Coordinate> openSpaces = new ArrayList<Coordinate>();
		
		openSpaces.add(new Coordinate(1, 0));
		openSpaces.add(new Coordinate(1, 2));		
		
		org.junit.Assert.assertEquals(openSpaces, maze.getAdjacentOpenSpaces(new Coordinate(1, 1)));
	}
	
	@Test
	public void testGetAdjacentOpenSpacesr2c2() {
		
		ArrayList<Coordinate> openSpaces = new ArrayList<Coordinate>();
		
		openSpaces.add(new Coordinate(1, 2));
		openSpaces.add(new Coordinate(3, 2));		
		
		org.junit.Assert.assertEquals(openSpaces, maze.getAdjacentOpenSpaces(new Coordinate(2, 2)));
	}
	
	@Test
	public void testGetAdjacentOpenSpacesr3c0() {
		
		ArrayList<Coordinate> openSpaces = new ArrayList<Coordinate>();
		
		openSpaces.add(new Coordinate(3, 1));	
		
		org.junit.Assert.assertEquals(openSpaces, maze.getAdjacentOpenSpaces(new Coordinate(3, 0)));
	}
	
	@Test
	public void testGetAdjacentOpenSpacesOutOfBounds() {
		
		ArrayList<Coordinate> openSpaces = new ArrayList<Coordinate>();	
		
		org.junit.Assert.assertEquals(openSpaces, maze.getAdjacentOpenSpaces(new Coordinate(0, 4)));
	}

}
