package MazeSolver;

public class ConsoleInterface {

	public static void main(String[] args) {
		
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
		
		Maze maze = new Maze(grid);
		
		Coordinate initialLocation = new Coordinate( 1, 0 );
		
		Navigator navigator = new Navigator(maze, initialLocation);
		
		for (int i = 0; i < 6; i++) {
			
			navigator.Move();
			
			Coordinate currentPosition = navigator.getPosition();
			
			System.out.println(currentPosition.getX() + "," + currentPosition.getY());
			
		}

	}

}
