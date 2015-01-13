package tests;

import java.util.ArrayList;
import mazeSolver.Coordinate;
import mazeSolver.Maze;
import mazeSolver.Navigator;
import mazeSolver.Space;
import org.junit.BeforeClass;
import org.junit.Test;

public class NavigatorTest {
	
	public static Maze maze = null;
	
	public static Navigator nav = null;

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
		
		Coordinate initialLocation = new Coordinate( 1, 0 );
		
		nav = new Navigator(maze, initialLocation);
		
	}

	@Test
	public void testMove() {
		
		ArrayList<Coordinate> mazeSolution = new ArrayList<Coordinate>();
		ArrayList<Coordinate> expectedMazeSolution = new ArrayList<Coordinate>();
		
		expectedMazeSolution.add(new Coordinate(1, 1));
		expectedMazeSolution.add(new Coordinate(1, 2));
		expectedMazeSolution.add(new Coordinate(2, 2));
		expectedMazeSolution.add(new Coordinate(3, 2));
		expectedMazeSolution.add(new Coordinate(3, 1));
		expectedMazeSolution.add(new Coordinate(3, 0));
		
		for (int i = 0; i < 6; i++) {
			nav.Move();
			
			mazeSolution.add(nav.getPosition());
		}
		
		org.junit.Assert.assertEquals(expectedMazeSolution, mazeSolution);
		
	}

}
