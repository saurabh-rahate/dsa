package leetcode;

public class ReshapeTheMatrix {

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) return mat;

        int[][] newMat = new int[r][c];
        int a = 0, b = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newMat[i][j] = mat[a][b++];
                if (b == mat[0].length) {
                    a++;
                    b = 0;
                }
            }
        }

        return newMat;
    }
}
