class Solution {
    private boolean dfs(int node, List<List<Integer>> graph, int state[]){
        if(state[node] == 1) return false;
        
        if(state[node] == 2) return true;

        state[node] = 1;
        for(int neighbor : graph.get(node)){
            if(!dfs(neighbor, graph, state)) return false;
        }
        state[node] = 2;
        return true; 
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
        }

        int state[] = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, graph, state)) return false;
        }

        return true;
    }
}
