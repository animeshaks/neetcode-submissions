
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited, order)) {
                    return new int[0]; // Cycle detected
                }
            }
        }

        // Reverse postorder to get a valid course order
        Collections.reverse(order);

        return order.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }

    private boolean dfs(
        int node,
        List<List<Integer>> adj,
        boolean[] visited,
        boolean[] pathVisited,
        List<Integer> order
    ) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited, order)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                return true; // Cycle detected
            }
        }

        pathVisited[node] = false;

        order.add(node);
        return false;
    }
}
