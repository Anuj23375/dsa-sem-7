class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, ans, new ArrayList<>(), used);

        return ans;
    }

    private void backtrack(
        int[] nums,
        List<List<Integer>> res,
        List<Integer> path,
        boolean[] used
    ) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // choose
            used[i] = true;
            path.add(nums[i]);

            // explore
            backtrack(nums, res, path, used);

            // unchoose
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
