package No33;

public class Search {
    public static void main(String[] args) {
        Search s = new Search();
        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {3,5,1};
        System.out.println(s.search(nums, 3));
    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + ((end - begin) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[end]) { // 后半部分有序
                if (nums[mid] < target && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else { // 前半部分有序
                if (nums[begin] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }
        }
        return -1;
    }
}
