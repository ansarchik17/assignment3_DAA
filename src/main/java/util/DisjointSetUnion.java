package util;

public class DisjointSetUnion {
    private final int[] parent;
    private final int[] rank;
    public long unionOps = 0;
    public long findOps = 0;
    public long comparisons = 0;

    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        findOps++;
        if (parent[x] != x) {
            comparisons++; // Count comparison
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int a, int b) {
        unionOps++;
        a = find(a);
        b = find(b);
        comparisons++; // Count comparison
        if (a == b) return false;

        comparisons++; // Count rank comparison
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }
        return true;
    }

    public long totalOps() {
        return unionOps + findOps + comparisons;
    }
}