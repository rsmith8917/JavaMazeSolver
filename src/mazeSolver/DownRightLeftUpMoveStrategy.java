package mazeSolver;

import java.util.ArrayList;
import java.util.Collections;

public class DownRightLeftUpMoveStrategy implements IMoveStrategy{

	// Find the index of the open space with the min number of visits
	public Integer findNextPositionIndex(Maze maze, Coordinate currentPosition) {
		ArrayList<Integer> minVisitIndices = new ArrayList<Integer>();
		
		int minNumberOfVisits = Collections.min(maze.getVisits());
		
		for (int i = 0; i < maze.getVisits().size(); i++) {
			if ( maze.getVisits().get(i) == minNumberOfVisits ){
				minVisitIndices.add(i);
			}
		}
		
		// Select from min visit indices in this order: Down, Right, Left, Up
		Integer minVisitIndex = 0;
		int score = -100;
		
		for (int i = 0; i < minVisitIndices.size(); i++) {
			Coordinate c = maze.getOpenSpace(minVisitIndices.get(i));
			
			int newScore = -2*(currentPosition.getX() - c.getX()) + 1*(c.getY() - currentPosition.getY());
			if ( newScore > score ){
				score = newScore;
				minVisitIndex = minVisitIndices.get(i);
			}
		}
		
		// Integer minVisitIndex = minVisitIndices.get((int)Math.round((minVisitIndices.size()-1)*Math.random()));
		return minVisitIndex;
	}
	
}
