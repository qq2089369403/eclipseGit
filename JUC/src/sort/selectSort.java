package sort;

import java.util.Arrays;

public class selectSort {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 2, 1,8,5,9,7,3,6 };
		System.out.println(Arrays.toString(nums));
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int min = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j] < min) {
					int temp = nums[j];
					nums[j] = min;
					min = temp;
//				System.out.println(nums[j]);
//				System.out.println(min);
				}
				nums[i] = min;
			}
		}
	}
}
