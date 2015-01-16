package mazeSolver;

public interface IMoveStrategy {
	
	public Integer findNextPositionIndex(MazeSpaces mazeSpaces, Coordinate currentPosition);
	
}
