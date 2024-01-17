import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = mat.length;
        int n = mat[0].length;
        boolean [][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] temp = queue.poll();
                for(int[] dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && visited[x][y] == false){
                        visited[x][y] = true;
                        mat[x][y] = step;
                        queue.add(new int[]{x,y});
                    }
                }         
            }
            step++;
        }
        return mat;
    }
}