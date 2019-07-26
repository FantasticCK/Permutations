package com.CK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.permute(nums).toString());
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        List<Integer> dfsList= new ArrayList<>();
        permuteHelper(nums, visited,dfsList);
        return res;
    }

    private void permuteHelper(int[] nums, boolean[] visited, List<Integer> dfsList) {
        if (dfsList.size() >= nums.length) {
            res.add(new ArrayList<>(dfsList));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]){
                dfsList.add(nums[i]);
                visited[i] = true;
                permuteHelper(nums,visited,dfsList);
                dfsList.remove(dfsList.size()-1);
                visited[i] = false;
            }
        }
    }
}