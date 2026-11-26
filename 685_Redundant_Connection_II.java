
class Solution {
    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] nodeParent = new int[n + 1];

        int[] candidate1 = null;
        int[] candidate2 = null;

        // Step 1: Detect a node having two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (nodeParent[v] == 0) {
                nodeParent[v] = u;
            } else {
                candidate1 = new int[]{nodeParent[v], v};
                candidate2 = edge;
                break;
            }
        }

        // Step 2: Initialize Union-Find
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Step 3: Detect cycle
        for (int[] edge : edges) {

            // Skip the second parent edge temporarily
            if (candidate2 != null &&
                edge[0] == candidate2[0] &&
                edge[1] == candidate2[1]) {
                continue;
            }

            int u = edge[0];
            int v = edge[1];

            int pu = find(u);
            int pv = find(v);

            // Cycle detected
            if (pu == pv) {
                if (candidate1 != null) {
                    return candidate1;
                }

                return edge;
            }

            parent[pu] = pv;
        }

        // No cycle after skipping candidate2
        return candidate2;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}
