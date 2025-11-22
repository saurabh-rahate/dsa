package leetcode.range0_100;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();

        System.out.println(obj.maxArea(new int[]{1, 1}));
    }

    private static int maxWater;

    private void initialize() {
        maxWater = Integer.MIN_VALUE;
    }

    public int maxArea(int[] height) {
        initialize();
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                storeMaxWaterArea(height[i], height[j], j - i);
            }
        }
        return maxWater;
    }

    private void storeMaxWaterArea(int h1, int h2, int hLength) {
        int area = Math.min(h1, h2) * hLength;
        if (area > maxWater) maxWater = area;
    }
}
