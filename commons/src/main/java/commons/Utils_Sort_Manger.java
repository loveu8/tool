package commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public enum Utils_Sort_Manger {
	
	singleton;
	
	
	/**
	 * 產生亂數整數陣列
	 * @param range  範圍0~xxxx
	 * @param length 陣列長度.
	 * @return int[] 整數陣列
	 */
	public int[] genRandomIntArray(int range , int length){
		int[] intArray = new int[length];
		for(int index  = 0 ; index < length ; index ++){
			intArray[index] = (int)(Math.random()*range)+1;
		}
		return intArray;
	}
	
	/**
	 * 產生亂數整數List
	 * @param range  範圍0~xxxx
	 * @param length 陣列長度.
	 * @return List<Integer> 整數List
	 */
	public List<Integer> genRandomIntList(int range , int length){
		List<Integer>intList = new ArrayList<Integer>();
		for(int index  = 0 ; index < length ; index ++){
			intList.add((int)(Math.random()*range)+1);
		}
		return intList;
	}
	
	/**
	 * <pre>
	 * 	整數陣列的泡沫排序 
	 *	sort before : 4 , 8 , 9 , 1 , 5
	 *	sort after  : 1 , 4 , 5 , 8 , 9
	 * </pre>
	 * @param intArray
	 */
	public void bubbleSort(int[] intArray){
		Date startTime = new Date();
		int swapValue  , length = intArray!=null ? intArray.length : 0;
		if(intArray!= null && length > 0){
			System.out.println("排序前");
			for(int index = 0 ; index < length ; index ++){
				System.out.println(intArray[index]);
			}
			for(int index = 0 ; index < length - 1 ; index ++){
				System.out.println("index = " + index);
				for(int tag = 0 ; tag < length - 1 - index ; tag ++){
					System.out.println("tag = " + tag  + " , tag value = " + intArray[tag] + ", tag + 1 = " + intArray[tag+1]);
					if(intArray[tag] > intArray[tag+1]){
						swapValue 	  	= intArray[tag] ;
						intArray[tag] 	= intArray[tag+1];
						intArray[tag+1] = swapValue;
					}
				}
			}
			System.out.println("排序後");
			for(int index = 0 ; index < length ; index ++){
				System.out.println(intArray[index]);
			}
		} else {
			System.out.println("無排序資料");
		}
		Date endTime = new Date();
		System.out.println("耗費時間 = " + (endTime.getTime() - startTime.getTime()) + " ms");
	}
	
	
	/**
	 * <pre>
	 * 	整數陣列的泡沫排序 
	 *	sort before : 4 , 8 , 9 , 1 , 5
	 *	sort after  : 1 , 4 , 5 , 8 , 9
	 * </pre>
	 * @param intArray
	 */
	public void bubbleSort(List<Integer> intList){
		Date startTime = new Date();
		Integer swapValue  , length = intList != null ? intList.size() : 0;
		if(intList!= null && length > 0){
			System.out.println("排序前");
			for(int index = 0 ; index < length ; index ++){
				System.out.println(intList.get(index));
			}
			for(int index = 0 ; index < length - 1 ; index ++){
				System.out.println("index = " + index);
				for(int tag = 0 ; tag < length - 1 - index ; tag ++){
					System.out.println("tag = " + tag  + " , tag value = " + intList.get(tag) + ", tag + 1 = " + intList.get(tag+1));
					if(intList.get(tag) > intList.get(tag+1)){
						swapValue 	  	 = intList.get(tag) ;
						intList.set(tag, intList.get(tag+1));
						intList.set(tag+1 , swapValue);
					}
				}
			}
			System.out.println("排序後");
			for(int index = 0 ; index < length ; index ++){
				System.out.println(intList.get(index));
			}
		} else {
			System.out.println("無排序資料");
		}
		Date endTime = new Date();
		System.out.println("耗費時間 = " + (endTime.getTime() - startTime.getTime()) + " ms");
	}
	
}
