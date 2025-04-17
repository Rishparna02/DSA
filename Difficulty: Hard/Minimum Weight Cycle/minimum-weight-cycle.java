//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends

//import java.util.*;

class Solution {
    public int findMinCycle(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int minCycle = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            // Dijkstra from u to v, avoiding (u, v) edge
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            dist[u] = 0;
            pq.offer(new int[]{u, 0});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0], d = curr[1];

                if (d > dist[node]) continue;

                for (int[] nei : adj.get(node)) {
                    int next = nei[0], wt = nei[1];

                    // Skip the current edge being considered
                    if ((node == u && next == v && wt == w) || (node == v && next == u && wt == w)) {
                        continue;
                    }

                    if (dist[next] > dist[node] + wt) {
                        dist[next] = dist[node] + wt;
                        pq.offer(new int[]{next, dist[next]});
                    }
                }
            }

            if (dist[v] != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist[v] + w);
            }
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
};
