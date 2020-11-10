package sort;

import java.util.Arrays;

public class insertSort {

	public static void main(String[] args) {
		int[] nums = { 1, 0, 7, 8, 9, 6, 3, 2, 4 , -1 ,98 ,102};
		System.out.println(Arrays.toString(nums));
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void sort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {

			int insertValue = nums[i];// 待插入的数
			int insertIndex = i - 1;// 插入数的下标

			/**
			 * 1、insertIndex>=0 保证不越界 
			 * 2、insertValue<nums[insertIndex] 待插入的数，还没找到合适的位置
			 * 3、将nums[insertIndex]后移
			 */
			while (insertIndex >= 0 && insertValue < nums[insertIndex]) {
				nums[insertIndex + 1] = nums[insertIndex];
				insertIndex--;
			}
//			System.out.println("下标为" + insertIndex);
//			System.out.println("值为" + insertValue);
			nums[insertIndex + 1] = insertValue;
		}
	}

}
