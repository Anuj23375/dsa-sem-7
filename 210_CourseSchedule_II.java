class Solution {
    public int[] findOrder(int numCourses, int[][] arr) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int a[] : arr){
            graph.get(a[1]).add(a[0]);
            indegree[a[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int res[] = new int[numCourses];
        int idx=0;
        while(!q.isEmpty()){
            int node = q.poll();
            res[idx++] = node;
            for(int nei : graph.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }   
        }
        if(idx != numCourses) return new int[0];
        return res;

    }
}
