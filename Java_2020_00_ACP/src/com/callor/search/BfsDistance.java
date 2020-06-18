package com.callor.search;

import java.util.LinkedList;

public class BfsDistance {

	// 최단거리 구하기
    private int rows = 0;    // 행수
    private int cols = 0;    // 열수    
    private int[][] map = null;    // 맵정보
    private String path = "";        // 이동경로
    

	public BfsDistance(int[][] map) {
		super();
		this.map = map;
		
		this.rows = map.length;
		this.cols = map[0].length;
		
	}
	
	public String getPath() {
		return this.path;
	}

	public int bfs() {
		int ret = 0;

		int curRow = 0; // 현재 row
		int curCol = 0; // 현재 col
		int curDist = 1; // 현재 이동한 거리
		String curPath = ""; // 현재까지 이동경로

		// BFS에서는 큐에 시작정보(0,0) 세팅
		LinkedList<Coord> queue = new LinkedList<Coord>();
		queue.add(new Coord(curRow, curCol, curDist, curPath));

		// 큐가 empty일 때까지 루핑
		while (!queue.isEmpty()) {
			Coord coord = (Coord) queue.poll();
			curRow = coord.row;
			curCol = coord.col;
			curDist = coord.dist;
			curPath = coord.path;
			path = curPath;
			ret = curDist;
			map[curRow][curCol] = 0;

			// 목적지에 도착하면 루핑 종료
			if (curRow == rows - 1 && curCol == cols - 1) {
				break;
			}

			// 위로 갈수 있으면
			if (curRow - 1 >= 0 && map[curRow - 1][curCol] == 1) {
				queue.add(new Coord(curRow - 1, curCol, curDist + 1, curPath));
			}
			// 아래로 갈수 있으면
			if (curRow + 1 < rows && map[curRow + 1][curCol] == 1) {
				queue.add(new Coord(curRow + 1, curCol, curDist + 1, curPath));
			}
			// 왼쪽으로 갈수 있으면
			if (curCol - 1 >= 0 && map[curRow][curCol - 1] == 1) {
				queue.add(new Coord(curRow, curCol - 1, curDist + 1, curPath));
			}
			// 오른쪽으로 갈수 있으면
			if (curCol + 1 < cols && map[curRow][curCol + 1] == 1) {
				queue.add(new Coord(curRow, curCol + 1, curDist + 1, curPath));
			}
		}

		// 큐 클리어
		queue.clear();

		return ret;
	}

}

//이동하는 위치정보 및 거리정보 저장
class Coord {
	int row, col, dist;
	String path;

	public Coord(int row, int col, int dist, String oldPath) {
		this.row = row;
		this.col = col;
		this.dist = dist;
		if ("".equals(oldPath)) {
			this.path = "(" + row + ", " + col + ")";
		} else {
			this.path = oldPath + " -> " + "(" + row + ", " + col + ")";
		}
		
	}
}
