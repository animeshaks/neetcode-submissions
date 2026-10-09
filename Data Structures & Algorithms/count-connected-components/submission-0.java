class Solution {

    public void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        for(int neighbour: adj.get(node)) {
            if(!visited[neighbour]) {
                dfs(adj, neighbour, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {

        // Create Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int result = 0;

        for (int node=0; node<n; node++) {
            if(!visited[node]) {
                dfs(adj, node, visited);
                result++;
            }
        }

        return result;
    }
}
