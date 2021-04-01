package com.callor.search;

import java.util.LinkedList;
import java.util.Queue;

/*
 * BFS(너비우선탐색)로 최단거리를 구하기
 * BFS의 경우 특정위치를 기준으로 인접한 노드를 모두 방문하며 한 번 방문했던 노드는
 * 방문 이력을 저장해가면서 다음 노드, 다음노드로 넘어가 전체를 검색한다.
 * 
 * BFS는 QUEUE를 활용해서 구현한다
 * 
 * 특정위치의 인접한 노드를 먼저 모두 확인해야되기 때문에 
 * 인접한 노드를 모두 큐에 넣고 
 * 인접노드를 모두 큐에 넣었을때 꺼내면서 방문여부를 기록해주면된다
 * 
 */
public class BfsDepth {

	private int ROW = 0; // 행
	private int COL = 0; // 열
	private int[][] value;
	private boolean[][] visited;

	public BfsDepth(int ROW, int COL, int[][] value, boolean[][] visited) {
		super();
		this.ROW = ROW;
		this.COL = COL;
		this.value = value;
		this.visited = visited;
	}

	public void bfs(int start, int end) {

		Queue<Node> q = new LinkedList<>();
		// 최초 queue 삽입
		q.offer(new Node(start, end, 1));

		while (!q.isEmpty()) {

			Node node = q.poll();
			visited[node.x][node.y] = true;
			System.out.println(node.x + "," + node.y);
			
			
			// 상하좌우 이동 가능여부를 확인해본다.

			// 좌
			if (node.y - 1 >= 0 && node.y - 1 < COL && value[node.x][node.y - 1] == 1
					&& visited[node.x][node.y - 1] == false) {
				q.add(new Node(node.x, node.y - 1, node.depth + 1));
			}

			// 우
			if (node.y + 1 >= 0 && node.y + 1 < COL && value[node.x][node.y + 1] == 1
					&& visited[node.x][node.y + 1] == false) {
				q.add(new Node(node.x, node.y + 1, node.depth + 1));
			}

			// 위
			if (node.x - 1 >= 0 && node.x - 1 < ROW && value[node.x - 1][node.y] == 1
					&& visited[node.x - 1][node.y] == false) {
				q.add(new Node(node.x - 1, node.y, node.depth + 1));
			}

			// 아래
			if (node.x + 1 >= 0 && node.x + 1 < ROW && value[node.x + 1][node.y] == 1
					&& visited[node.x + 1][node.y] == false) {
				q.add(new Node(node.x + 1, node.y, node.depth + 1));
			}

			if (visited[ROW - 1][COL - 1]) {
				System.out.println("완료");
				System.out.println(node.depth);
				break;
			}

		}
	}
}

class Node {
	int x;
	int y;
	int depth;

	Node(int _x, int _y, int _depth) {
		this.x = _x;
		this.y = _y;
		this.depth = _depth;
	}
}
