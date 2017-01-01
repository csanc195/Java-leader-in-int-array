
public class Problem2a {

	public static void main(String[] args) {
		int [] arr1 = {1,2,1,1,7,1,6,1,2,1,1};
		int [] arr2 = {1,2,1,1,7,9,6,1,2,6,3};
		
		System.out.println((leader(arr1)<0) 
				? "There is no leader ":"There is a leader at pos " + leader(arr1));
		
		System.out.println((leader(arr2)<0) 
				? "There is no leader ":"There is a leader at pos " + leader(arr2));
	}

	

	/** 
	 * @param a
	 * @return The index of the element that appears 
	 * 		more than half of the time in the array, or -1 if there is no such element.
	 * 		Notice that the index may not be the index of the first occurrence.
	 */
	public static int leader(int [] a){
		
		int counter = 0;
		int candidate = 0;
		int indexOffirstOccurrence =0;
		
		// Step 1, find the most frequent element.
		for(int i=0; i< a.length; i++){
			if(counter==0){
				candidate = a[i];
				indexOffirstOccurrence = i;
				counter++;
			}
			else{
				if(candidate==a[i])
					counter++;
				
				else
					counter--;
			}
		}
		// Step 2, verify that the most frequent element occurs more than half of the time.
		if(counter == 0){
			return -1;
		}
		//good case where elements were consecutive. Saves to go through the array again.
		else if(counter > a.length/2){
			return indexOffirstOccurrence;
		}
		counter = 0;
		for(int i=0; i< a.length; i++){
			if(candidate == a[i]){
				counter ++;
			}
		}
		//If the max did indeed happen more than half of the time then print the index of 
		//first occurrence else print -1.
		return (counter > a.length/2) ? indexOffirstOccurrence : -1;
	}

}
