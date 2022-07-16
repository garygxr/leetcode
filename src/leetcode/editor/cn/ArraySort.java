package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @Author garygan
 * @Date 2022/7/14 20:13
 * @Description
 */
public class ArraySort {
    public static void main(String[] args) {
        int time = 10;
        int maxSize = 6;
        int minValue = 0;
        int maxValue = 10;
        for (int i = 0; i < time; i++) {
            int[] ints = generateRandomArray(maxSize, minValue, maxValue);
            try {
                int[] ints1 = Arrays.copyOf(ints, ints.length);
                int[] ints2 = Arrays.copyOf(ints, ints.length);
                quickSort(ints1);
                officeSort(ints2);
                boolean compare = isEqual(ints1, ints2);
                if (!compare) {
                    for (int anInt : ints) {
                        System.out.print(anInt + ",");
                    }
                    System.out.println("排序后：");
                    for (int anInt : ints1) {
                        System.out.print(anInt + ",");
                    }
                    break;
                }
            } catch (Exception e) {
                for (int anInt : ints) {
                    System.out.print(anInt + ",");
                }
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        System.out.println("success");
    }

    // 冒泡排序
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void chickSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, min, i);
        }
    }

    // 插入排序
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] > a[j - 1]) {
                    break;
                }
                swap(a, j, j - 1);
            }
        }
    }

    public static void megersSort(int[] a) {
        int count = 0;
        if (a.length <= 1) {
            return;
        }
        process(a, 0, a.length - 1);
    }

    public static int count = 0;

    // 迭代版归并排序
    public static void iterateMegers(int[] a) {
        int total = 0;
        int step = 1;
        while (step < a.length) {
            int L = 0;
            while (L < a.length) {
                int M = L + step - 1;
                if (M >= a.length) {
                    break;
                }
                int R = Math.min(M + step, a.length - 1);
                int megers = megers(a, L, M, R);
                total += megers;
                L = R + 1;
            }
            if (step > a.length / 2) {
                break;
            }
            step <<= 1;
        }
        System.out.println(total);
    }

    // 递归归并排序
    public static void process(int[] a, int l, int r) {

        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(a, l, mid);
        process(a, mid + 1, r);
        megers(a, l, mid, r);
    }

    public static int megers(int[] a, int l, int mid, int r) {
        int ans = 0;
        int windows = mid + 1;
        for (int i = 0; i <= mid; i++) {
            while (windows <= r && a[i] > (a[windows] * 2)) {
                windows++;
            }
            ans += windows - mid - 1;
        }
        int temp[] = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (a[p1] < a[p2]) {
                //  count += a[p1]*((r-p2)+1);
                temp[i++] = a[p1++];
            } else {
                temp[i++] = a[p2++];
            }
        }
        while (p1 > mid && p2 <= r) {
            temp[i++] = a[p2++];
        }

        while (p1 <= mid && p2 > r) {
            temp[i++] = a[p1++];
        }

        for (int j = 0; j < temp.length; j++) {
            a[l + j] = temp[j];
        }
        return ans;
    }

    public static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static int[] generateRandomArray(int maxSize, int minValue, int maxValue) {
       /* int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) + (int) (minValue * Math.random());
        }
        return arr;*/
        return new int[]{1, 9, 5, 7, 5, 6};
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void quickSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int l = 0;
        int r = a.length - 1;
        quickSortProcess(a, l, r);
    }

    public static void quickSortProcess(int[] a, int l, int r) {
        int indexL = l;
        int indexR = r;
        if (indexL >= indexR) {
            return;
        }
        int flag = a[l];

        while (indexL < indexR) {
            while (a[indexR] >= flag && indexR > indexL) {
                indexR--;
            }
            while (a[indexL] <= flag && indexL < indexR) {
                indexL++;
            }
            swap(a, indexL, indexR);
        }
        swap(a,l,indexL);

        quickSortProcess(a, l, indexL - 1);
        quickSortProcess(a, indexL + 1, r);
    }

    public static void officeSort(int[] a) {
        Arrays.sort(a);
    }
}
