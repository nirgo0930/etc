public class GCD {
    public static void main(String[] args) {
        int[] array = {30, 22, 13, 27, 12, 10, 20, 25};
        partition(0, array.length-1, 1, array);
    }

    public static void partition(int low, int high, int point, int[] arr) {
        int i, j, pivotitem, cnt;
        cnt = 1;
        pivotitem = arr[low];
        j = low;
        for (i = low + 1; i <= high; i++) {
            if (arr[i] < pivotitem) {
                System.out.println("교환발생");
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            System.out.print(cnt++ + " : " + (j + 1) + " " + (i + 1) + " ");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
        point = j;
        int temp = arr[low];
        arr[low] = arr[point];
        arr[point] = temp;
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}
