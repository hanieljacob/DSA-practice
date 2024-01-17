class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count += 1;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    void DFS(char[][] grid, int i, int j){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        DFS(grid, i+1, j);
        DFS(grid, i-1, j);
        DFS(grid, i, j+1);
        DFS(grid, i, j-1);
    }
}