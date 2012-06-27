/* The Litre Problem Solver
 * Author: Jenny Kinahan
 * Date: 6-26-2012
 * 
 * Litre Problem Solver:
 * There are three containers which have different capacities: 
 * 8L, 5L, and 3L, respectively.  
 * 
 * The initial state: The 8L jug contains 8L of water and both the 5L 
 * and 3L containers are empty.  The Litre Problem Solver will continue 
 * to dump water until the final state reaches a point where the 8L 
 * and 5L jug both contain 4L of water each.
 */

import java.util.ArrayList;

public class LitreProblemSolver {
	
	final static int a = 8;
	final static int b = 5;
	final static int c = 3;
	public static int spaceLeft = 0;
	public static int visitedA,visitedB,visitedC,visitedD = 0;
	public static ArrayList listOfMoves = new ArrayList();
	public static int[] tempCurrentLevelArray = new int[3];
	
	public static void main(String [ ] args)
	{
		//declaring and initializing current (initial) water levels	

		int currentLevelA, currentLevelB, currentLevelC;
		currentLevelA = 8;
		currentLevelB = 0;
		currentLevelC = 0;
		
		int[] currentLevelArray = new int[]{currentLevelA,
				currentLevelB, currentLevelC};
		System.out.print(currentLevelArray[0]+" "+currentLevelArray[1]+" "+currentLevelArray[2]+"\n");

		System.out.println("A B C \n------");
		solve(currentLevelArray);
	}
	
	public static int[] solve(int[] currentLevelArray)
	{	
		//System.out.print(currentLevelArray[0]+" "+currentLevelArray[1]+" "+currentLevelArray[2]+"\n");
		// returns the solution array when the capacities of the jugs
		// reach their final state
				
		

		// moving from A to B
		if ((currentLevelArray[1] < b)&&(currentLevelArray[0] > 0)){
			tempCurrentLevelArray = currentLevelArray;
			spaceLeft = b - currentLevelArray[1]; 
			if (spaceLeft >= currentLevelArray[0]){
				currentLevelArray[1] += currentLevelArray[0];
				currentLevelArray[0] = 0;
			}
			else{
				currentLevelArray[0] -= spaceLeft; 
				currentLevelArray[1] += spaceLeft;
			}
			
			if(!listOfMoves.contains(currentLevelArray)){
				listOfMoves.add(currentLevelArray);
			}
			else{currentLevelArray = tempCurrentLevelArray;}
			System.out.println("Moving A to B:");
			System.out.print(currentLevelArray[0]+" "+currentLevelArray[1]+" "+currentLevelArray[2]+"\n");

			if(currentLevelArray[0] == 4 && currentLevelArray[1]== 4 &&
					currentLevelArray[2]== 0)
				return currentLevelArray;
			
		}
		//moving from B to C
		
		if(( currentLevelArray[2] < c)&& (currentLevelArray[1] > 0) ){
			tempCurrentLevelArray = currentLevelArray;
			spaceLeft = c - currentLevelArray[2];
			
			if (spaceLeft >= currentLevelArray[1]){
				currentLevelArray[2] += currentLevelArray[1];
				currentLevelArray[1] = 0;
			}
			else{
				currentLevelArray[1] -= spaceLeft; 
				currentLevelArray[2] += spaceLeft;
			}	
			
			if(!listOfMoves.contains(currentLevelArray)){
				listOfMoves.add(currentLevelArray);
			}
			else{currentLevelArray = tempCurrentLevelArray;}
			System.out.println("Moving B to C:");
			System.out.print(currentLevelArray[0]+" "+currentLevelArray[1]+" "+currentLevelArray[2]+"\n");

			if(currentLevelArray[0] == 4 && currentLevelArray[1]== 4 &&
					currentLevelArray[2]== 0)
				return currentLevelArray;
		}

			//moving from C to A
			if(( currentLevelArray[0] < a)&&(currentLevelArray[2] > 0) ){
				tempCurrentLevelArray = currentLevelArray;
				spaceLeft = a - currentLevelArray[0];
				if (spaceLeft >= currentLevelArray[2]){
					currentLevelArray[0] += currentLevelArray[2];
					currentLevelArray[2] = 0;
				}
				else{
					currentLevelArray[0] += spaceLeft; 
					currentLevelArray[2] -= spaceLeft;
				}
				
				if(!listOfMoves.contains(currentLevelArray)){
					listOfMoves.add(currentLevelArray);
				}
				else{currentLevelArray = tempCurrentLevelArray;}
				System.out.println("Moving C to A:");
				System.out.print(currentLevelArray[0]+" "+currentLevelArray[1]+" "+currentLevelArray[2]+"\n");

				if(currentLevelArray[0] == 4 && currentLevelArray[1]== 4 &&
						currentLevelArray[2]== 0)
					return currentLevelArray;
			}
			//moving from B to C
			
			if(( currentLevelArray[2] < c)&& (currentLevelArray[1] > 0) ){
				tempCurrentLevelArray = currentLevelArray;
				spaceLeft = c - currentLevelArray[2];
				
				if (spaceLeft >= currentLevelArray[1]){
					currentLevelArray[2] += currentLevelArray[1];
					currentLevelArray[1] = 0;
				}
				else{
					currentLevelArray[1] -= spaceLeft; 
					currentLevelArray[2] += spaceLeft;
				}	
				
				if(!listOfMoves.contains(currentLevelArray)){
					listOfMoves.add(currentLevelArray);
				}
				else{currentLevelArray = tempCurrentLevelArray;}
				System.out.println("Moving B to C:");
				System.out.print(currentLevelArray[0]+" "+currentLevelArray[1]+" "+currentLevelArray[2]+"\n");

				if(currentLevelArray[0] == 4 && currentLevelArray[1]== 4 &&
						currentLevelArray[2]== 0)
					return currentLevelArray;
			}

			solve(currentLevelArray);			
			return currentLevelArray;
	}	
}