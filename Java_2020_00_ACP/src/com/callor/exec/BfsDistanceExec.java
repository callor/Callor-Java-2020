package com.callor.exec;

import com.callor.search.BfsDistance;

public class BfsDistanceExec {
	
	
	
    public static void main(String[] args) {

    	int[][] map = null;
        int mapSize = 8;
    	
    	// 트리의 인접정보
        map = new int[][] {
            // col  :    0  1  2  3  4  5  6  7 
            /*row : 0*/    {0, 1, 1, 1, 1, 1, 1, 0},
            /*row : 1*/    {1, 0, 0, 1, 1, 0, 0, 0},
            /*row : 2*/    {1, 0, 0, 1, 1, 1, 0, 0},
            /*row : 3*/    {0, 1, 0, 0, 0, 1, 1, 1},
            /*row : 4*/    {0, 1, 0, 0, 0, 1, 0, 0},
            /*row : 5*/    {0, 0, 1, 0, 0, 1, 1, 0},
            /*row : 6*/    {0, 0, 0, 1, 0, 1, 1, 1},
            /*row : 7*/    {0, 0, 0, 1, 0, 1, 1, 1}
            };
        
        long begin = System.currentTimeMillis();
            
        BfsDistance bfs = new BfsDistance(map);
        int dap = bfs.bfs();
        System.out.println( dap + " " + bfs.getPath());
 
        long end = System.currentTimeMillis();
        System.out.printf("\n%.3f (secs)\n", (end-begin)/1000.0);
    }
}
