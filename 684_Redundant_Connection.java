class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        // Initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Both nodes already belong to the same set
            if (find(u) == find(v)) {
                return edge;
            }

            // Union the two sets
            union(u, v);
        }

        return new int[0];
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu != pv) {
            parent[pu] = pv;
        }
    }
}
