package leetcode.range100_200;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            if (area > maxArea) maxArea = area;

            if (height[start] > height[end]) end--;
            else start++;
        }
        return maxArea;
    }
}
