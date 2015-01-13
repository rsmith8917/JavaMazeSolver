package MazeSolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Navigator {

	private Coordinate position;
	private Maze maze;
	private HashMap<Coordinate, Integer> numberOfVisits = new HashMap<Coordinate, Integer>();
	private ArrayList<Coordinate> openSpaces;
	private ArrayList<Integer> visits;
	public Coordinate getPosition() {
		return position;
	}
	public void setPosition(Coordinate position) {
		this.position = position;
	}
	
	
	public Navigator(Maze maze, Coordinate initialLocation){
		this.maze = maze;
		this.position = initialLocation;
		this.numberOfVisits.put(initialLocation, 1);
	}
	
	public void Move(){
		
		this.openSpaces = maze.getAdjacentOpenSpaces(this.position);
		this.visits = new ArrayList<Integer>();
		
		findVisitsPerOpenSpace();

		Integer minVisitIndex = findMinVisitIndex();
		
		this.position = this.openSpaces.get(minVisitIndex);
		
		this.numberOfVisits.put(this.position, incrementCurrentPositionVisits());
		
	}
	
	private int incrementCurrentPositionVisits() {
		int prevNumberOfVisits = 0;
		
		if ( this.numberOfVisits.get(this.position) != null ){
			prevNumberOfVisits = this.numberOfVisits.get(this.position);
		}
		
		int currentPositionNumberOfVisits = prevNumberOfVisits+1;
		return currentPositionNumberOfVisits;
	}
	
	private Integer findMinVisitIndex() {
		ArrayList<Integer> minVisitIndices = new ArrayList<Integer>();
		
		int minNumberOfVisits = Collections.min(this.visits);
		
		for (int i = 0; i < this.visits.size(); i++) {
			if ( this.visits.get(i) == minNumberOfVisits ){
				minVisitIndices.add(i);
			}
		}
		
		Integer minVisitIndex = minVisitIndices.get((int)Math.round((minVisitIndices.size()-1)*Math.random()));
		return minVisitIndex;
	}
	
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
