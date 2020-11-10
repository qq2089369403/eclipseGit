package sort;

import java.util.Arrays;

public class bubbleSort {

	public static void main(String[] args) {
		int nums[]= {1,2,3,1,5};
		System.out.println(Arrays.toString(nums));
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void sort(int[] nums) {
		int temp;
		for (int i = 0; i < nums.length-1; i++) {//控制循环的轮数
			for (int j = 0; j < nums.length-1-i; j++) {//控制每一轮循环的次数
				if(nums[j]>nums[j+1]) {
					temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		}
	}

}
