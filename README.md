# Java-leader-in-int-array

<h2>Purpose/Description: </h2>
This program contains a method named leader that determines if a number 
is present more than half of the time in an array of numbers.
<br>
This algorithm goes through the list once, starting at position '0' and choosing a possible candidate as the "Leader" of the array. While algorithm moves through the list a counter is updated and increased  by one every time the candidate is found again, or is decreased every time a number which is not a candidate is found. Whenever the counter reaches zero, a new candidate is chosen and the process is repeated until the end of the array is reached.
<br><br>
The second part of this algorithm checks if the candidate chosen is really a leader. If the counter is Zero, then there was not a real candidate. Which can happen in a typical case when the candidate is spread in a way which makes it be <b>0</b> and<b> 1</b> alternating until the end is reached, ex: <b>int [] array = {1,2,1,2,1,2}; </b> Will reach the end of the list with counter being zero. As the algorithm will add and subtract from counter and will reach the end of the loop with counter being unaffected, that is with counter equal to zero.
<br>
If the previous case is not triggered, the algorithm does a final search and ensures that the chosen candidate is indeed present more than half of the time in the array. <br> The running complexity for this algorithm is is at its worse case, in which it goes through the array once to choose a candidate, and then a second time to prove that the candidate was indeed a leader is <b>O(n+n)</b> which is <b>O(n)</b>.
