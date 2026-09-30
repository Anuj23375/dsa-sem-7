class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, res, new ArrayList<>(), used);

        return res;   
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used){

        if(nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
    
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            // here choosing
            used[i] = true;
            path.add(nums[i]);

            // explore
            backtrack(nums,res, path,used);

            // unchoose
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}