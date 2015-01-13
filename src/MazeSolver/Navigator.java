package MazeSolver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Navigator {

	
	private Coordinate position;
	
	private Maze maze;
	
	private HashMap<Coordinate, Integer> numberOfVisits = new HashMap<Coordinate, Integer>();
	
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
		
		ArrayList<Coordinate> openSpaces = maze.getAdjacentOpenSpaces(this.position);
		ArrayList<Integer> visits = new ArrayList<Integer>();
		
		for (int i = 0; i < openSpaces.size(); i++) {
			
			Coordinate openSpace = openSpaces.get(i);
			
			Integer visitCount = this.numberOfVisits.get(openSpace);
			
			if( visitCount == null ){
				visitCount = 0;
			}
			
			visits.add(visitCount);
		}
		
		ArrayList<Integer> minVisitIndices = new ArrayList<Integer>();
		
		int minNumberOfVisits = Collections.min(visits);
		
		for (int i = 0; i < visits.size(); i++) {
			if ( visits.get(i) == minNumberOfVisits ){
				minVisitIndices.add(i);
			}
		}
		
		this.position = openSpaces.get(minVisitIndices.get((int)Math.round((minVisitIndices.size()-1)*Math.random())));
		
		
		int prevNumberOfVisits = 0;
		
		if ( this.numberOfVisits.get(this.position) != null ){
			prevNumberOfVisits = this.numberOfVisits.get(this.position);
		}
		
		this.numberOfVisits.put(this.position, prevNumberOfVisits+1);
		
	}


}
