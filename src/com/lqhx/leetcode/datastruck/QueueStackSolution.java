package com.lqhx.leetcode.datastruck;

public class QueueStackSolution {
    //岛屿数量
//    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
//    示例 1:
//
//    输入:
//            11110
//            11010
//            11000
//            00000
//
//    输出: 1
//    示例 2:
//
//    输入:
//            11000
//            11000
//            00100
//            00011
//
//    输出: 3
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        } else {
            int result = 0;
            int row = grid.length;
            int clown = grid[0].length;
            int[][] searchedGrid = new int[row][clown];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < clown; j++) {
                    if (searchedGrid[i][j] == 0) {
                        if (grid[i][j] == '1') {
                            BFSLands(searchedGrid, grid, i, j, row, clown);
                            result++;
                        } else {
                            searchedGrid[i][j] = 1;
                        }
                    }
                }
            }
            return result;
        }
    }

    public void BFSLands(int[][] searchedGrid, char[][] grid, int i, int j, int row, int clown) {
        if (searchedGrid[i][j] == 0) {
            searchedGrid[i][j] = 1;
            if (grid[i][j] == '1') {
                if (i + 1 < row) {
                    BFSLands(searchedGrid, grid, i + 1, j, row, clown);
                }
                if (i - 1 >= 0) {
                    BFSLands(searchedGrid, grid, i - 1, j, row, clown);
                }
                if (j - 1 >= 0) {
                    BFSLands(searchedGrid, grid, i, j - 1, row, clown);
                }
                if (j + 1 < clown) {
                    BFSLands(searchedGrid, grid, i, j + 1, row, clown);
                }
            }

        }


    }
}
