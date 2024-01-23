import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> [] adjMatrix = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adjMatrix[i] = new ArrayList<>();
        }
        for(int[] prerequisite : prerequisites) {
              adjMatrix[prerequisite[0]].add(prerequisite[1]);
        }
        int [] visited = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!dfs(i,visited, adjMatrix)){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int i, int[]visited, ArrayList<Integer> [] adjMatrix){
        if(visited[i] == 1){
          return false;
        }
        if(visited[i] == 2){
          return true;
        }
        visited[i] = 1;
        for(int num: adjMatrix[i]){
            if(!dfs(num, visited, adjMatrix)){
              return false;
            }
        }
        visited[i] = 2;
        return true;
    }
  }