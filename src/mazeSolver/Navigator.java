package mazeSolver;

public class Navigator {

	private Coordinate position;
	private IMoveStrategy moveStrategy;
	private MazeSpaces mazeSpaces;
	
	public Coordinate getPosition() {
		return position;
	}
	public void setPosition(Coordinate position) {
		this.position = position;
	}

	
	public Navigator(Maze maze, Coordinate initialLocation, IMoveStrategy moveStrategy){
		this.position = initialLocation;
		this.moveStrategy = moveStrategy;
		this.mazeSpaces = new MazeSpaces(maze, initialLocation);
	}
	
	
	// Move to next position as specified in Tremaux's algorithm
	public void Move(){
		
		this.mazeSpaces.getAdjacentOpenSpaces(this.position);
		
		this.mazeSpaces.findVisitsPerOpenSpace();

		Integer nextPositionIndex = this.moveStrategy.findNextPositionIndex(this.mazeSpaces, this.position);
		
		this.position = this.mazeSpaces.getOpenSpace(nextPositionIndex);
		
		this.mazeSpaces.incrementCurrentPositionVisits(this.position);
		
	}
	

	
	



}
