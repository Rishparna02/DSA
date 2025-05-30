/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        return traversal(root, k, -1);
        
    }
    public int traversal(Node node, int k, int max){
        if(node == null) return max;
        if(node.data <= k) max = Math.max(node.data, max);
        if(k > node.data) return traversal(node.right, k, max);
        else return traversal(node.left, k, max);
    }
}