class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj[u].add(new int[]{v, w});
        }

        // Distance from source k to every node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // {node, distance}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];

            // Ignore outdated entries
            if (distance > dist[node]) {
                continue;
            }

            // Visit neighboring nodes
            for (int[] neighbor : adj[node]) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                int newDistance = distance + weight;

                if (newDistance < dist[nextNode]) {
                    dist[nextNode] = newDistance;
                    pq.offer(new int[]{nextNode, newDistance});
                }
            }
        }

        // Find the maximum shortest distance
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
