package mazeSolver;

import java.util.ArrayList;
import java.util.HashMap;

public class MazeSpaces {
	
	private ArrayList<Coordinate> openSpaces;
	private ArrayList<Integer> visits;
	private HashMap<Coordinate, Integer> numberOfVisits = new HashMap<Coordinate, Integer>();
	private Maze maze;
	
	public ArrayList<Coordinate> getOpenSpaces() {
		return openSpaces;
	}
	public ArrayList<Integer> getVisits() {
		return visits;
	}
	public HashMap<Coordinate, Integer> getNumberOfVisits() {
		return numberOfVisits;
	}

	
	public MazeSpaces(Maze maze, Coordinate initialLocation){
		this.maze = maze;
		this.numberOfVisits.put(initialLocation, 1);
	}
	
	public void getAdjacentOpenSpaces(Coordinate position){
		
		this.openSpaces = maze.getAdjacentOpenSpaces(position);

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
}
