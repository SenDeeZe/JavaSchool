public class BinarySearch {

    public static int binarySearch(int[] srtdArr, int key) {
        int index = -1;
        int low = 0;
        int high = srtdArr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (srtdArr[mid] < key) {
                low = mid + 1;
            } else if (srtdArr[mid] > key) {
                high = mid - 1;
            } else if (srtdArr[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,2,4,6,8,10,12,14};
        int key = 8;
        System.out.println(binarySearch(a, key));
    }
}
