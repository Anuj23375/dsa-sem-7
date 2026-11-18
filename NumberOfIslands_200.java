class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null) return 0;

        int count =0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0; i< r; i++){
            for(int j = 0 ; j < c; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i , int j){
        if(i < 0 || j<0 || i>=grid.length || j >=grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
