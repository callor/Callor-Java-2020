package com.callor.exec;

import java.io.FileInputStream;
import java.util.Scanner;

import com.callor.search.BfsDepth;

public class BfsDepthExec {

	
	public static void main(String[] args) {
		
		int ROW =0; //행
	    int COL =0; //열
	    int[][] value;
	    boolean[][] visited;	
		
	    try{

	         Scanner sc = new Scanner(new FileInputStream("src/com/callor/exec/bfs-data.txt"));

	         ROW = sc.nextInt();
	         COL = sc.nextInt();
	         sc.nextLine();

	         
	         System.out.printf("ROW : %d, COL : %d\n",ROW,COL);
	         value = new int[ROW][COL];
	         visited = new boolean[ROW][COL];

	         for (int i = 0; i < ROW; i++) {
	             String str = sc.nextLine();
	             for (int j = 0; j < COL; j++) {
	                 value[i][j] = str.charAt(j)-'0';
	                 visited[i][j] = false;
	             }
	         }

	         visited[0][0] = true;
	         BfsDepth bfs = new BfsDepth(ROW,COL,value,visited);
	         bfs.bfs(0, 0);

	         sc.close();

	     }catch (Exception e){
	         System.out.println(e.toString());
	         e.printStackTrace();
	     }
		
	}
	
}
