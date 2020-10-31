package leetcodeanswer;

import java.util.LinkedList;
import java.util.List;

public class _103二叉树的锯齿形层次遍历 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode103 root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null)
			return res;
		// 存储层次的节点，按顺序遍历
		LinkedList<TreeNode103> queue = new LinkedList<>();
		queue.add(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			LinkedList<Integer> level = new LinkedList<Integer>();
			while (size > 0) {
				TreeNode103 curr = queue.poll();

				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
				if (depth % 2 == 0) {
					level.add(curr.val);
				} else {
					level.add(0, curr.val);
				}
				size--;

			}
			depth++;
			res.add(level);
		}
		return res;
	}
}

class TreeNode103 {
	int val;
	TreeNode103 left;
	TreeNode103 right;

	TreeNode103(int x) {
		val = x;
	}
}