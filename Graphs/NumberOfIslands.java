class Solution {
    public static int numberIslands(int[][] grid) {

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    seen(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void seen(int[][] grid, int i, int j) {
        if (!(outOfBounds(grid, i, j) || grid[i][j] == 0)) {
            grid[i][j] = 0;
            seen(grid, i - 1, j);
            seen(grid, i + 1, j);
            seen(grid, i, j - 1);
            seen(grid, i, j + 1);
        }
    }

    public static boolean outOfBounds(int[][] grid, int i, int j) {
        if (i >= grid.length || i < 0) {
            return true;
        } else if (j >= grid[i].length || j < 0) {
            return true;
        } else {
            return false;
        }
    }
}

// time: O(n * m)
// space: O(n * m) worst case for recursion stack if island fills whole grid

// char version
/*
class Solution {
    public int numIslands(char[][] grid) {

        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    seen(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void seen(char[][] grid, int i, int j) {
        if (!(outOfBounds(grid, i, j) || grid[i][j] == 0)) {
            grid[i][j] = '0';
            seen(grid, i - 1, j);
            seen(grid, i + 1, j);
            seen(grid, i, j - 1);
            seen(grid, i, j + 1);
        }
    }

    public boolean outOfBounds(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0) {
            return true;
        } else if (j >= grid[i].length || j < 0) {
            return true;
        } else {
            return false;
        }
    }
}

// time: O(n * m)
// space: O(n * m) worst case for recursion stack if island fills whole grid
*/

/*
given: 2D grid of 1s (land) and 0s (water)

count how many distinct islands there are
return int islands

0 1 1 0
1 0 1 0
0 0 0 1
output: 3

[[0, 1, 1, 0][1, 0, 1, 0][0, 0, 0, 1]]

graph traversal
DFS/BFS

for
    for
        if '1', island found
        need way to find if island has any other components

        if (!seen) then increment counter by 1

return counter

seen method:
takes the index i, j
then we need to check: up down left right
i, j - 1
i, j + 1
i - 1, j
i + 1, j
if any of these contain a 1, then set them to 0 and recurse seen
return true if seen and false if not seen

actually don't need to return anything
- just need to mark the entire island as visited

Can track visited cells, so if we have seen a nearby cell, then don't double count

so final psuedocode:

for
    for 
        if island found
        seen (i, j)
        counter++

return counter

seen(i, j)
    if (!(out of bounds or 0))
        set this to 0
        recurse on left right up down
*/