/*
 * AbbreviationWords.java
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

/********************************
*         DESCRIPTION
********************************
* Find all the abbreviations of string: 
*    eg 
*    ABC 
*    SOME Valid abbreviations are : 
*    1BC 
*    2C 
*    3 
*    A1C 
*    AB1 
*    A2 
*    NOT VALID 
*    11C(two numbers cannot occur continuously)
*/
public class AbbreviationWords {
    
    public static void main (String args[]) {
        /********************************
         *         Questions
         ********************************
         * the Min length of the String
         * Should I need to validate for Empty or null?
         * Should exist duplicated values?
         * 
         * UPDATE
         * 1)As 2 numbers cannot occur continously, the entry should not contains numbers.
         * 2) someone else allows combinations between letter eg. A1C1, I NEED TO PUT MORE ATTENTION
         *         TO ASK WHICH SHOULD BE THE OUTPUT (I follow the test case, but I need to check it).
         */
         
         /********************************
          *     Complexity
          ********************************
          *        O(n²)
          * Since the String.length() needs to be loop per
          * each letter (same size) the complexity it's square
          * */
          
        String test = "ABCD";
        
        //Iterate over the length of word
        String pre ="";
        for(int i=0;i<test.length();i++){
            calculateValidAbbreviation(test,pre,i);
            pre += test.charAt(i);
        } 
        
        System.out.println("Last Abbreviation " + test.length());
    }
    
    public static void calculateValidAbbreviation(String currentWord,String pre,int distance) {
        String post = "";
        System.out.println("*****************************************");
        System.out.println("*        distance ["+distance+"]        *");
        System.out.println("*****************************************");
        
        for(int i=1;i<currentWord.length();i++){

            //condition break
            //for the last one cicle exist an overflow, because expect to print n-1 but get n-2
            if((i+distance)>currentWord.length()) {
                break;
            }
            post = currentWord.substring(i+distance,currentWord.length()); 
            
            System.out.println(pre + i + post);
        } 
         
         /***************************************************************************************
          *     distance    *        i    *        pre        *        post    *        result  *
          ***************************************************************************************
          *     1            *        1    *        ""        *        BC      *        1BC     *
          *     1            *        2    *        ""        *        C       *        2C      *
          ***************************************************************************************
          *     2            *        1    *        A         *        C       *        A1C     *
          *     2            *        2    *        A         *        C       *        A2      *
          ***************************************************************************************
          *     3            *        1    *        AB        *        ""      *        AB1     *
          *     3            *        2    *        AB        *        ""      *        AB2     * X
          * */
    }
}
