class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new List[n + 1];

        for(int i = 1; i <=n; i++)graph[i] = new ArrayList<>();

        for(int time[] : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u].add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            // pq[(0,2)]  2- node, 0 time
            int time = curr[0];
            int node = curr[1];

            if(time > dist[node]) continue;

            for(int[] edge : graph[node]){
                int next = edge[0];
                int weight = edge[1];

                int newTime = time + weight;

                if(newTime < dist[next]){
                    dist[next] = newTime;

                    pq.offer(new int[]{newTime, next});
                }
            }
        }

        int ans =0;
        for(int i = 1; i <=n ; i++ ){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        
        return ans;



    }
}
