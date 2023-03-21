package leetcode.range600_700;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers obj = new CanPlaceFlowers();
        System.out.println(obj.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(obj.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(obj.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0 ? n <= 1 : n < 1;
        }
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (canPlantFlower(i, flowerbed)) {
                n--;
                plantFlower(i, flowerbed);
            }
        }
        return n == 0;
    }

    private boolean canPlantFlower(int i, int[] flowerbed) {
        if (i == 0) return flowerbed[i] == 0 && flowerbed[i + 1] == 0;
        if (i == flowerbed.length - 1) return flowerbed[i - 1] == 0 && flowerbed[i] == 0;
        return flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0;
    }

    private void plantFlower(int i, int[] flowerbed) {
        flowerbed[i] = 1;
    }
}
