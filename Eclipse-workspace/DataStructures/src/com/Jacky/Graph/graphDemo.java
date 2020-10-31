package com.Jacky.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class graphDemo {

	private ArrayList<String> vertexList; // ���㼯��
	private int[][] edges;// �ڽӾ���
	private int numOfEdges;// �߸���

	// ��������boolean[],��¼ĳ�ڵ��Ѿ�������
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

	// ������������㷨
	private void BFS(boolean[] isVisited, int i) {
		int u;// �ڽӵ���±�
		int w;
		// ���д洢�´η��ʵĽڵ�
		LinkedList queue = new LinkedList();
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;
		// �ڵ�������
		queue.addLast(i);
		while (!queue.isEmpty()) {
			// ȡ����ͷ�ڵ�
			u = (Integer) queue.removeFirst();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!isVisited[w]) {
					isVisited[w] = true;
					System.out.print(getValueByIndex(w) + "->");
					queue.addLast(w);
				}
				w = getNextNeighbor(u, w);// �������
			}
		}

	}

	// �������еĽڵ�
	public void BFS(int n) {
		isVisited = new boolean[n];
		// �������нڵ㣬dfs����
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				BFS(isVisited, i);
			}
		}
	}

////////////////////////////////////////////////////////////
	// ������������㷨
	private void DFS(boolean[] isVisited, int i) {
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;

		// ��һ���ڽӽڵ�
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				DFS(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}

	}

	// DFS���أ��������нڵ㲢����DFS
	public void DFS(int n) {
		isVisited = new boolean[n];
		// �������нڵ㣬dfs����
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
	 * �õ���һ���ڽӽڵ���±��
	 * 
	 * @param index
	 * @return ���ڷ������꣬���򷵻�-1
	 */
	public int getFirstNeighbor(int index) {
		for (int i = 0; i < vertexList.size(); i++) {
			if (edges[index][i] > 0) {
				return i;
			}
		}
		return -1;
	}

	// ����ǰһ���ڽӽڵ���±��ȡ�¸��ڽӽڵ�
	public int getNextNeighbor(int v1, int v2) {
		for (int i = v2 + 1; i < vertexList.size(); i++) {
			if (edges[v1][i] > 0) {
				return i;
			}
		}
		return -1;
	}

//////////////////////////////////////////////////////////////////////
	// ��ȡ�ڵ���
	public int getNumOfVertex() {
		return vertexList.size();
	}

	// ��ȡ����
	public int getNumOfEdges() {
		return numOfEdges;
	}

	// �����±��Ӧ�����ݵ�
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}

	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	// ��ʾͼ����Ӧ�ľ���
	public void showGraph() {
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}

	// ���붥��
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	/**
	 * 
	 * @param v1     ����±�
	 * @param v2     ��֮��ϵ����һ������±�
	 * @param weight v1���v2��֮���Ƿ������� 1������ 0������
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

}
