package mazeSolver;

import java.util.ArrayList;
import java.util.HashMap;


public class Navigator {

	private Coordinate position;
	private Maze maze;
	private HashMap<Coordinate, Integer> numberOfVisits = new HashMap<Coordinate, Integer>();
	private ArrayList<Coordinate> openSpaces;
	private ArrayList<Integer> visits;
	private IMoveStrategy moveStrategy;
	
	private MazeSpaces mazeSpaces = new MazeSpaces();
	
	public Coordinate getPosition() {
		return position;
	}
	public void setPosition(Coordinate position) {
		this.position = position;
	}
	public HashMap<Coordinate, Integer> getNumberOfVisits() {
		return numberOfVisits;
	}
	public ArrayList<Coordinate> getOpenSpaces() {
		return openSpaces;
	}
	public ArrayList<Integer> getVisits() {
		return visits;
	}
	public Navigator(Maze maze, Coordinate initialLocation, IMoveStrategy moveStrategy){
		this.maze = maze;
		this.position = initialLocation;
		this.numberOfVisits.put(initialLocation, 1);
		this.moveStrategy = moveStrategy;
	}
	
	
	// Move to next position as specified in Tremaux's algorithm
	public void Move(){
		
		this.openSpaces = maze.getAdjacentOpenSpaces(this.position);
		
		this.visits = new ArrayList<Integer>();
		
		findVisitsPerOpenSpace();

		Integer nextPositionIndex = moveStrategy.findNextPositionIndex(this);
		
		this.position = this.openSpaces.get(nextPositionIndex);
		
		this.numberOfVisits.put(this.position, incrementCurrentPositionVisits());
		
	}
	
	// Increment the value in the numberOfVisits HashMap to 
	// keep track of the number of times the current position
	// was visited.
	private int incrementCurrentPositionVisits() {
		int prevNumberOfVisits = 0;
		
		if ( this.numberOfVisits.get(this.position) != null ){
			prevNumberOfVisits = this.numberOfVisits.get(this.position);
		}
		
		int currentPositionNumberOfVisits = prevNumberOfVisits+1;
		return currentPositionNumberOfVisits;
	}
	
	
	// Find the number of visits for each open space
	private void findVisitsPerOpenSpace() {
		
		for (int i = 0; i < this.openSpaces.size(); i++) {
			
			Coordinate openSpace = this.openSpaces.get(i);
			
			Integer visitCount = this.numberOfVisits.get(openSpace);
			
			if( visitCount == null ){
				visitCount = 0;
			}
			
			this.visits.add(visitCount);
		}
		
	}


}
