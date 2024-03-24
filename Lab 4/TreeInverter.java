package trees;

public class TreeInverter {
	public TreeNode invertTree(TreeNode root)
	{
		// Base case: if the node is null, don't attempt to swap its children
		if(root == null)
		{
			return root;
		}
		
		// Swap the left and right children (including their subtrees)
		TreeNode tempTreeNode = root.left;
		root.left = root.right;
		root.right = tempTreeNode;
		
		// Recursively invert the children's subtrees
		invertTree(root.left);
		invertTree(root.right);
		
		// Return the node
		return root;
	}
	
	public static void main(String[] args)
	{
		/*
		 *    4
		 *  3   8
		 * 1   5 9
		 * 
		 * test 3,1 and 1,5
		 */
		TreeInverter inverter = new TreeInverter();
		
		TreeNode root = new TreeNode(4);
		TreeNode threeNode = new TreeNode(3);
		root.left = threeNode;
		root.right = new TreeNode(8);
		TreeNode oneNode = new TreeNode(1);
		root.left.left = oneNode;
		TreeNode fiveNode = new TreeNode(5);
		root.right.left = fiveNode;
		root.right.right = new TreeNode(9);
		
		inverter.invertTree(root);
		
		System.out.println(root.val);
		System.out.println(root.left.val + " " + root.right.val);
		System.out.println(root.left.left.val + " " + root.left.right.val + "   " + root.right.right.val);
		
		/*
		 *    1
		 *  2   8
		 * 3 4 5 6
		 */
		
		TreeNode nodeRoot = new TreeNode(1);
		TreeNode nodeTwo = new TreeNode(2);
		TreeNode nodeThree = new TreeNode(3);
		TreeNode nodeFour = new TreeNode(4);
		TreeNode nodeEight = new TreeNode(8);
		TreeNode nodeFive = new TreeNode(5);
		TreeNode nodeSix = new TreeNode(6);
		nodeRoot.left = nodeTwo;
		nodeRoot.right = nodeEight;
		nodeTwo.left = nodeThree;
		nodeTwo.right = nodeFour;
		nodeEight.left = nodeFive;
		nodeEight.right = nodeSix;
		inverter.invertTree(nodeRoot);
		System.out.println(nodeRoot.val);
		System.out.println(nodeRoot.left.val + " " + nodeRoot.right.val);
		System.out.println(nodeRoot.left.left.val + " " + nodeRoot.left.right.val + " " + nodeRoot.right.left.val + " " + nodeRoot.right.right.val);
		
		
	}
}
