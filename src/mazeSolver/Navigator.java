package mazeSolver;

public class Navigator {

	private Coordinate position;
	private IMoveStrategy moveStrategy;
	private Maze maze;
	
	public Coordinate getPosition() {
		return position;
	}
	public void setPosition(Coordinate position) {
		this.position = position;
	}

	
	public Navigator(Maze maze, Coordinate initialLocation, IMoveStrategy moveStrategy){
		this.position = initialLocation;
		this.moveStrategy = moveStrategy;
		this.maze = maze;
	}
	
	
	// Move to next position as specified in Tremaux's algorithm
	public void Move(){
		
		this.maze.getAdjacentOpenSpaces(this.position);
		
		this.maze.findVisitsPerOpenSpace();

		Integer nextPositionIndex = this.moveStrategy.findNextPositionIndex(this.maze, this.position);
		
		this.position = this.maze.getOpenSpace(nextPositionIndex);
		
		this.maze.incrementCurrentPositionVisits(this.position);
		
	}
	

	
	



}
