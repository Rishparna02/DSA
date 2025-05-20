/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */
class Solution {
    static int res;
    static Map<Integer, List<Integer>> graph;

    public static int minTime(Node root, int target) {
        graph = new HashMap<>();
        buildGraph(root);
        res = 0;
        dfs(target, -1, 0);
        return res;
    }

    private static void buildGraph(Node node) {
        if (node == null) return;
        graph.putIfAbsent(node.data, new ArrayList<>());
        if (node.left != null) {
            graph.get(node.data).add(node.left.data);
            graph.putIfAbsent(node.left.data, new ArrayList<>());
            graph.get(node.left.data).add(node.data);
            buildGraph(node.left);
        }
        if (node.right != null) {
            graph.get(node.data).add(node.right.data);
            graph.putIfAbsent(node.right.data, new ArrayList<>());
            graph.get(node.right.data).add(node.data);
            buildGraph(node.right);
        }
    }

    private static int dfs(int node, int parent, int time) {
        res = Math.max(res, time);
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, time + 1);
            }
        }
        return res;
    }
}