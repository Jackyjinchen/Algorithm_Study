package com.Jacky.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class graphDemo {

	private ArrayList<String> vertexList; // 顶点集合
	private int[][] edges;// 邻接矩阵
	private int numOfEdges;// 边个数

	// 定义数组boolean[],记录某节点已经被访问
	private boolean[] isVisited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 8;
		String vertexValue[] = { "1", "2", "3", "4", "5","6","7","8" };
		graphDemo graph = new graphDemo(n);
		for (String vertex : vertexValue) {
			graph.insertVertex(vertex);
		}

		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);

		graph.showGraph();
		System.out.println("DFS");
		graph.DFS(n);
		System.out.println();
		System.out.println("BFS");
		graph.BFS(n);

	}

///////////////////////////////////////////////////////////////////////////////

	// 广度优先搜索算法
	private void BFS(boolean[] isVisited, int i) {
		int u;// 邻接点的下标
		int w;
		// 队列存储下次访问的节点
		LinkedList queue = new LinkedList();
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;
		// 节点加入队列
		queue.addLast(i);
		while (!queue.isEmpty()) {
			// 取队列头节点
			u = (Integer) queue.removeFirst();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					isVisited[w] = true;
					System.out.print(getValueByIndex(w) + "->");
					queue.addLast(w);
				}
				w = getNextNeighbor(u, w);// 广度优先
			}
		}

	}

	// 遍历所有的节点
	public void BFS(int n) {
		isVisited = new boolean[n];
		// 遍历所有节点，dfs回溯
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				BFS(isVisited, i);
			}
		}
	}

////////////////////////////////////////////////////////////
	// 深度优先搜索算法
	private void DFS(boolean[] isVisited, int i) {
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;

		// 第一个邻接节点
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				DFS(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}

	}

	// DFS重载，遍历所有节点并进行DFS
	public void DFS(int n) {
		isVisited = new boolean[n];
		// 遍历所有节点，dfs回溯
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				DFS(isVisited, i);
			}
		}
	}

	public graphDemo(int n) {
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		
	}

	/**
	 * 得到第一个邻接节点的下标记
	 * 
	 * @param index
	 * @return 存在返回坐标，否则返回-1
	 */
	public int getFirstNeighbor(int index) {
		for (int i = 0; i < vertexList.size(); i++) {
			if (edges[index][i] > 0) {
				return i;
			}
		}
		return -1;
	}

	// 根据前一个邻接节点的下标获取下个邻接节点
	public int getNextNeighbor(int v1, int v2) {
		for (int i = v2 + 1; i < vertexList.size(); i++) {
			if (edges[v1][i] > 0) {
				return i;
			}
		}
		return -1;
	}

//////////////////////////////////////////////////////////////////////
	// 获取节点数
	public int getNumOfVertex() {
		return vertexList.size();
	}

	// 获取边数
	public int getNumOfEdges() {
		return numOfEdges;
	}

	// 返回下标对应的数据点
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}

	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	// 显示图所对应的矩阵
	public void showGraph() {
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}

	// 插入顶点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	/**
	 * 
	 * @param v1     点的下标
	 * @param v2     与之关系的另一个点的下标
	 * @param weight v1点和v2点之间是否有连接 1有连接 0无连接
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

}
