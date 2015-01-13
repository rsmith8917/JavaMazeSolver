package MazeSolver;
import java.util.ArrayList;


public class Maze {
	
	private Space[][] grid = new Space[5][4];
	
	public Maze(Space[][] grid){

		this.grid = grid;
		
	}
	
	public ArrayList<Coordinate> getAdjacentOpenSpaces(Coordinate location){

		int x = location.getX();
		int y = location.getY();
		
		int[][] Locations = { 
				{ x-1 , y   },
				{ x+1 , y   },
				{ x   , y-1 },
				{ x   , y+1 }
		};
		
		ArrayList<Coordinate> openSpaces = new ArrayList<Coordinate>();
		
		
		for (int i = 0; i < Locations.length; i++) {
				
			int xLocation = Locations[i][0];
			int yLocation = Locations[i][1];
			
				try {
					if( this.grid[xLocation][yLocation] == Space.OPEN ){
						openSpaces.add( new Coordinate( xLocation, yLocation ) );
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// Outside of grid - Don't Add
				} catch (Exception e) {
					e.printStackTrace();
				}	
		}
		
		
		return openSpaces;
		
	}
}
