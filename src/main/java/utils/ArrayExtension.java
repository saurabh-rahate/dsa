package utils;

public class ArrayExtension {

    public static boolean areEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }
//    public static <T> boolean areEqual(T[] array1, T[] array2) {
//        if (array1.length != array2.length)
//            return false;
//        for (int i = 0; i < array1.length; i++) {
//            if (array1[i] != array2[i]) return false;
//        }
//        return true;
//    }

}
