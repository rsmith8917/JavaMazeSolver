package mazeSolver;

public interface IMoveStrategy {
	
	public Integer findNextPositionIndex(Maze maze, Coordinate currentPosition);
	
}
