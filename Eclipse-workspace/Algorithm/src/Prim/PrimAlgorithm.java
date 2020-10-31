package Prim;

import java.util.Arrays;

public class PrimAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int verxs = data.length;
		int[][] weight = new int[][] { { 10000, 5, 7, 10000, 10000, 10000, 2 }, { 5, 10000, 10000, 9, 10000, 10000, 3 },
				{ 7, 10000, 10000, 10000, 8, 10000, 10000 }, { 10000, 9, 10000, 10000, 10000, 4, 10000 },
				{ 10000, 10000, 8, 10000, 10000, 5, 4 }, { 10000, 10000, 10000, 4, 5, 10000, 6 },
				{ 2, 3, 10000, 10000, 4, 6, 18000 } };

		MGrap graph = new MGrap(verxs);
		MinTree minTree = new MinTree();
		minTree.createGraph(graph, verxs, data, weight);

		minTree.showGrape(graph);
		minTree.Prim(graph, 0);
		
	}
}

//创建最小生成树
class MinTree {

	/**
	 * 
	 * @param grap   图对象
	 * @param verxs  图顶点个数
	 * @param data   图顶点的值
	 * @param weight 图的邻接矩阵
	 */
	public void createGraph(MGrap grap, int verxs, char data[], int[][] weight) {
		int i, j;
		for (i = 0; i < verxs; i++) {
			grap.data[i] = data[i];
			for (j = 0; j < verxs; j++) {
				grap.weight[i][j] = weight[i][j];
			}
		}
	}

	public void showGrape(MGrap graph) {
		for (int[] link : graph.weight) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	public void Prim(MGrap graph,int v) {
		int visited[]=new int[graph.verxs];
		
		visited[v]=1;
		int h1=-1;
		int h2=-1;
		int minWeight = 10000; //初始最大值，遍历过程中赋值最小Weight
		
		for (int k = 1; k < graph.verxs; k++) {
			
			for (int i = 0; i < graph.verxs; i++) {
				for (int j = 0; j < graph.verxs; j++) {
					if(visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minWeight) {
						minWeight=graph.weight[i][j];
						h1=i;
						h2=j;
					}
				}
			}
		
		System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">:"+minWeight);
		visited[h2]=1;
		minWeight=10000;
		
		}
	}
	

}

class MGrap {
	int verxs;// 节点个数
	char[] data;
	int[][] weight;

	public MGrap(int verxs) {
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}

}
