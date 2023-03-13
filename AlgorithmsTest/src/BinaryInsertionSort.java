public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] data = {3, 7, 5, 9, 2, 4, 1};

        binaryInsertionSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

    }

    public static void binaryInsertionSort(int[] a) {
        binaryInsertionSort(a, a.length);
    }

    private static void binaryInsertionSort(int[] a, int size) {
        for (int i = 1; i < size; i++) {
            // 타겟 넘버
            int target = a[i];

            // 이분탐색을 통해 target이 들어가야 할 위치를 얻는다.
            int location = binarySearch(a, target, 0, i);

            int j = i - 1;

            // 시프팅 작업
            while (j >= location) {
                a[j + 1] = a[j];    // 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }
            a[location] = target;
        }
    }

    // 이분 탐색
    private static int binarySearch(int[] a, int key, int lo, int hi) {
        int mid;
        while (lo < hi) {
            // 좀 더 빠르게 하기 위해서 /2 대신 >>> 1을 사용해도 된다.
            mid = lo + ((hi - lo) / 2);

            if (key < a[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

}
