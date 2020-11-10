package sort;

import java.util.Arrays;

public class insertSortDemo {

	public static void main(String[] args) {
		int nums[] = { 8, 9, 7, 5, 3, 6, 4, 1 };
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void sort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int insertValue = nums[i];

			int insertIndex = i - 1;
			while (insertIndex >= 0 && insertValue < nums[insertIndex]) {
				nums[insertIndex + 1] = nums[insertIndex];
				insertIndex--;
			}
			nums[insertIndex + 1] = insertValue;
		}
	}
}
