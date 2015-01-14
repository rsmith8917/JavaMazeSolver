package mazeSolver;

import java.util.ArrayList;


public class Maze {
	
	private Space[][] grid = null;
	
	public Maze(Space[][] grid){

		this.grid = grid;
		
	}
	
	public ArrayList<Coordinate> getAdjacentOpenSpaces(Coordinate location){

		int[][] adjacentSpaces = findAdjacentSpaces(location);
		
		return findOpenSpaces(adjacentSpaces);
		
	}

	private ArrayList<Coordinate> findOpenSpaces(int[][] Spaces) {
		
		ArrayList<Coordinate> openSpaces = new ArrayList<Coordinate>();
		
		for (int i = 0; i < Spaces.length; i++) {
				
			int x = Spaces[i][0];
			int y = Spaces[i][1];
			
				try {
					if( this.grid[x][y] == Space.OPEN ){
						openSpaces.add( new Coordinate( x, y ) );
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// Outside of grid - Don't Add
				} catch (Exception e) {
					e.printStackTrace();
				}	
		}

		return openSpaces;
	}

	private int[][] findAdjacentSpaces(Coordinate location) {
		int x = location.getX();
		int y = location.getY();
		
		int[][] adjacentSpaces = { 
				{ x-1 , y   },
				{ x+1 , y   },
				{ x   , y-1 },
				{ x   , y+1 }
		};
		
		return adjacentSpaces;
	}
}
