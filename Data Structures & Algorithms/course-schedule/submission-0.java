
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 1. Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Build graph: prerequisite -> course
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        // 3. Track visited nodes
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        // 4. Check for cycles
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(
        int node,
        List<List<Integer>> adj,
        boolean[] visited,
        boolean[] pathVisited
    ) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                // Cycle detected
                return true;
            }
        }

        // Backtrack: remove node from current DFS path
        pathVisited[node] = false;

        return false;
    }
}
