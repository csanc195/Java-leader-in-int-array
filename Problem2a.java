/********************************************************************* 
Purpose/Description: 
This program contains a method named leader that determines if a number 
is present more than half of the time in an array of numbers.

	This algorithm goes through the list once, starting at position '0' and
choosing a possible candidate as the "Leader" of the array. While algorithm
moves through the list a counter is updated and increased  by one every time
the candidate is found again, or is decreased every time a number which is 
not a candidate is found. Whenever the counter reaches zero, a new candidate 
is chosen and the process is repeated until the end of the array is reached.

 	The second part of this algorithm checks if the candidate chosen is really 
 a leader. If the counter is Zero, then there was not a real candidate. Which 
 can happen in a typical case when the candidate is spread in a way which 
 makes it be 0 and 1 alternating until the end is reached,
 	ex: int [] array = {1,2,1,2,1,2}; 
 	Will reach the end of the list with counter being zero. As the algorithm will
 	add and subtract from counter and will reach the end of the loop with counter being
 	unaffected, that is with counter equal to zero.
 
 	If the previous case is not triggered, the algorithm does a final search
 and ensures that the chosen candidate is indeed present more than half of
 the time in the array. 
 The running complexity for this algorithm is is at its worse case, in which
 it goes through the array once to choose a candidate, and then a second time 
 to prove that the candidate was indeed a leader is O(n+n) which is O(n).
 
 Author’s Panther ID: <5446178>
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/
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
