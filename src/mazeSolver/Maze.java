package mazeSolver;

import java.util.ArrayList;
import java.util.HashMap;


public class Maze {
	
	private Space[][] grid = null;
	private ArrayList<Coordinate> openSpaces = new ArrayList<Coordinate>();
	private ArrayList<Integer> visits = new ArrayList<Integer>();
	private HashMap<Coordinate, Integer> numberOfVisits = new HashMap<Coordinate, Integer>();
	
	public ArrayList<Coordinate> getOpenSpaces() {
		return openSpaces;
	}
	public ArrayList<Integer> getVisits() {
		return visits;
	}
	public HashMap<Coordinate, Integer> getNumberOfVisits() {
		return numberOfVisits;
	}
	
	
	
	
	public Maze(Space[][] grid, Coordinate initialLocation){
		this.grid = grid;
		this.numberOfVisits.put(initialLocation, 1);
	}
	
	// Find the number of visits for each open space
	public void findVisitsPerOpenSpace() {
		
		this.visits = new ArrayList<Integer>();
		
		for (int i = 0; i < this.openSpaces.size(); i++) {
			
			Coordinate openSpace = this.openSpaces.get(i);
			
			Integer visitCount = this.numberOfVisits.get(openSpace);
			
			if( visitCount == null ){
				visitCount = 0;
			}
			
			this.visits.add(visitCount);
		}
		
	}
	
	public Coordinate getOpenSpace(Integer index){
		
		return this.openSpaces.get(index);
		
	}
	
	// Increment the value in the numberOfVisits HashMap to 
	// keep track of the number of times the current position
	// was visited.
	public void incrementCurrentPositionVisits(Coordinate position) {
		int prevNumberOfVisits = 0;
		
		if ( this.numberOfVisits.get(position) != null ){
			prevNumberOfVisits = this.numberOfVisits.get(position);
		}
		
		this.numberOfVisits.put(position, prevNumberOfVisits+1);
	}
	
	public ArrayList<Coordinate> getAdjacentOpenSpaces(Coordinate location){

		int[][] adjacentSpaces = findAdjacentSpaces(location);
		
		return findOpenSpaces(adjacentSpaces);
		
	}

	private ArrayList<Coordinate> findOpenSpaces(int[][] Spaces) {
		
		this.openSpaces = new ArrayList<Coordinate>();
		
		for (int i = 0; i < Spaces.length; i++) {
				
			int x = Spaces[i][0];
			int y = Spaces[i][1];
			
				try {
					if( this.grid[x][y] == Space.OPEN ){
						this.openSpaces.add( new Coordinate( x, y ) );
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					// Outside of grid - Don't Add
				} catch (Exception e) {
					e.printStackTrace();
				}	
		}

		return this.openSpaces;
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
