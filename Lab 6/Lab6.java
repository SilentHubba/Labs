package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lab6 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		// build the graph
		int[][] graph = new int[numCourses][numCourses];
		for(int i = 0; i < prerequisites.length; i++)
		{
			graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
		}
		
		// find a node with in-degree 0 to start
		int startRowNum = -1;
		
		for(int i = 0; i < numCourses; i++)
		{
			if(sumOfRow(graph[i]) == 0)
			{
				startRowNum = i;
				break;
			}
		}
		
		if(startRowNum == -1)
		{
			return false;
		}
		
		Queue<Integer> nodeQueue = new LinkedList<>();
		List<Integer> visited = new ArrayList<>();
		nodeQueue.add(startRowNum);
		// BFS
		while(!nodeQueue.isEmpty())
		{
			int currNode = nodeQueue.remove();
			if(visited.contains(currNode))
			{
				return false;
			}
			
			visited.add(currNode);
			for(int i = 0; i < numCourses; i++)
			{
				if(graph[currNode][i] == 1)
				{
					nodeQueue.add(i);
				}
			}
		}
		
		return true;
    }
	
	private int sumOfRow(int[] row)
	{
		int sum = 0;
		for(int i = 0; i < row.length; i++)
		{
			sum += row[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		Lab6 lab = new Lab6();
		
		int[][] prereqs = {{1, 0}};
		System.out.println(lab.canFinish(2, prereqs));
		
		int[][] prereqs2 = {{1, 0}, {0, 1}};
		System.out.println(lab.canFinish(2, prereqs2));
		
		int[][] prereqs3 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
		System.out.println(lab.canFinish(4, prereqs3));
		

		int[][] prereqs4 = {};
		System.out.println(lab.canFinish(1, prereqs4));
		
	}
}
