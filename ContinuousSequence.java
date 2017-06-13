/*
 * ContinuousSequence.java
 * 
 * Copyright 2017 Jorge <JPolanco@Emmthias>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
 
public class ContinuousSequence    {
/*
* Problem: Given a sequence of positive integers A
* and an Integer T, return whether there is a 
* continuous sequence of A that sums up exactly T.
* 
* Examples: 
* [23,5,4,7,2,11],20
*     return true, because 7+2+11 = 20
* [1,3,5,23,2],8
*     return true because 3+5 = 8
* [1,3,5,23,2],7
*     return false because no sequence in this arrays adds u to 7
*/
    public static void main(String args[]){
        /*
         * Questions
         *     1) It will be valid the element itself(if it will be there)?
         *     2) the array it's sorted (little optimice starting to the biggest side)?
         *     3) the flow it's 0 ... n or if its not, should I start from the end to the beginning?
         *         since the Math property [Asociation] shoul be present, maybe this questions it's not
         *         relevant, maybe a dump question.
         *     4) what's about empty elements (which should be the expected result)
         * */
         
        /*
         * Complexity:
         * Accumulate values, so for current element saved to the next iteration.
         * 0(n²)
         * */ 
        
        int [] input = new int[]//{1,3,5,23,2};//
        {23,5,4,7,2,11};
        int numberToFind = //7;//
        20;
        
        boolean isValidTest = hasContinuousSum(input,numberToFind);
        
        System.out.println(
            String.format("The evaluation of the Array Found match %1S for number %2d",isValidTest,numberToFind) 
            );
    }
    
    /*
     * Method used to calculate the continuous sum from a given array
     * @Param arrayToEvaluated the Integer array.
     * @Param sumToEvaluated the value to match
     * @return boolean flag, true if the SumToEvaluated  {23,5,4,7,2,11}
     * =================================================================
     * ||    i    ||    j    ||    tmp[j]    ||    arr[i]   ||   sum  ||
     * =================================================================
     * ||    0    ||    0    ||    0         ||      23     ||   23   ||
     * ||    1    ||    0    ||    23        ||       5     ||    -   ||
     * ||         ||    1    ||    0         ||       5     ||    5   ||
     * ||    2    ||    1    ||    5         ||       4     ||    9   ||
     * ||         ||    2    ||    0         ||       4     ||    4   ||
     * ||    3    ||    1    ||    9         ||       7     ||   16   ||
     * ||         ||    2    ||    4         ||       7     ||   11   ||
     * ||         ||    3    ||    0         ||       7     ||   18   ||
     * ||    4    ||    1    ||    16        ||       2     ||    7   ||
     * ||         ||    2    ||    11        ||       2     ||   13   ||
     * ||         ||    3    ||    7         ||       2     ||    9   ||
     * ||         ||    4    ||    0         ||       2     ||    2   ||
     * ||    5    ||    2    ||   13         ||      11     ||    -   ||
     * ||         ||    3    ||    9         ||      11     ||   20   ||<--
     * ||         ||    4    ||    2         ||      11     ||   13   ||
     * ||         ||    5    ||    0         ||      11     ||   11   ||
     * */
    static boolean hasContinuousSum(int [] arrayToEvaluated,int sumToEvaluated) {
        boolean hasContinousSum = false;
        
        //reserve space in the array for possible match 
        // accumulative values for each starting index
        int [] temporalCombinationSumMatch = new int [arrayToEvaluated.length]; 
        
        for(int i=0;i<arrayToEvaluated.length;i++) {
            for(int j = 0;j<i;j++){
                if(temporalCombinationSumMatch[j]+arrayToEvaluated[i]>sumToEvaluated) {
                    continue;
                } else if(temporalCombinationSumMatch[j]+arrayToEvaluated[i] == sumToEvaluated) {
                    System.out.println(String.format("Find it at index %d ***********",j));
                    System.out.print(String.format(" %1d + %2d\n",temporalCombinationSumMatch[j],arrayToEvaluated[i]));
                    hasContinousSum = true;
                    break;
                } else {
                    System.out.print(String.format("[%1d] = ... + %2d = ",j,arrayToEvaluated[i]));
                    temporalCombinationSumMatch[j]+=arrayToEvaluated[i];
                    System.out.println(String.format("%d ",temporalCombinationSumMatch[j]));
                }
            }
        }
        return hasContinousSum;
    }
}
