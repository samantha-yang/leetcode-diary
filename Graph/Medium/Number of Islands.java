class Solution {
    public int numIslands(char[][] grid) {
        // Keep track of islands and which ones were visited
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();

        // Keep track of directions possible to travel
        // Down, up, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Iterate through the islands
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If it is an island and it has not been visited
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    // Increase number of islands
                    islands++;
                    // Explore the entire connected component
                    bfs(grid, r, c, visited, directions, rows, cols);
                }
            }
        }

        return islands;        
    }

    // Helper function to run BFS
    private void bfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
        // Initialize queue
        Queue<int[]> q = new LinkedList<>();
        // Mark the starting cell as visited and add it
        visited.add(r + "," + c);
        q.add(new int[]{r, c});

        // Keep exploring until the connected land is processed
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1];

            // For each direction
            for (int[] direction : directions) {
                int nr = row + direction[0], nc = col + direction[1];
                // Validate the neighbor: if it is inside bounds, it is land, and it has not been visited
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
                    // Add it to visited
                    q.add(new int[]{nr, nc});
                    visited.add(nr + "," + nc);
                }
            }
        }
    }    
}