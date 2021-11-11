package io.github.itamarc;

import java.util.*;

class BinaryTreesBranchSums {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.left.left = new BinaryTree(8); // left children of 4
        root.left.left.right = new BinaryTree(9); // right children of 4
        root.left.right.left = new BinaryTree(10); // left children of 5
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        System.out.println(BinaryTreesBranchSums.branchSums(root, 0));
        System.out.println(BinaryTreesBranchSums.nodeDepths(root));
    }

    public static int nodeDepths(BinaryTree root) {
        return nodeDepthsSum(root, -1);
    }

    public static int nodeDepthsSum(BinaryTree node, int parentDepth) {
        int depthsSum = parentDepth+1; // start with own depth
        if (node.left != null) {
            int leftDepthsSum = nodeDepthsSum(node.left, parentDepth+1);
            depthsSum += leftDepthsSum; // sum the left branch
        }
        if (node.right != null) {
            int rightDepthsSum = nodeDepthsSum(node.right, parentDepth+1);
            depthsSum += rightDepthsSum; // sum the right branch
        }
        return depthsSum;
    }

    public static List<Integer> branchSums(BinaryTree root) {
        return branchSums(root, 0);
    }

    public static List<Integer> branchSums(BinaryTree node, int sum) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (node.left == null && node.right == null) {
            arr.add(sum+node.value);
        } else {
            if (node.left != null) {
                List<Integer> leftArr = branchSums(node.left, sum+node.value);
                arr.addAll(leftArr);
            }
            if (node.right != null) {
                List<Integer> rightArr = branchSums(node.right, sum+node.value);
                arr.addAll(rightArr);
            }
        }
        return arr;
    }
    
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
