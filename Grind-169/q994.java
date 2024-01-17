import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int step = 0;
        int m = grid.length;
        int n = grid[0].length;
        int [][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean [][] visited = new boolean[m][n];
        Queue<int[]> rotten = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        while(!rotten.isEmpty()){
            int size = rotten.size();
            boolean changed = false;
            for(int i=0; i<size; i++){
                int [] temp = rotten.poll();
                for(int [] direction: directions){
                    int x = temp[0] + direction[0];
                    int y = temp[1] + direction[1];
                    if(x>=0 && x<m && y>=0 && y<n && visited[x][y] == false && grid[x][y] == 1){
                        changed = true;
                        grid[x][y] = 2;
                        visited[x][y] = true;
                        rotten.offer(new int[]{x,y});
                    }
                }
            }
            if(changed)
                step++;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return step;
    }
}