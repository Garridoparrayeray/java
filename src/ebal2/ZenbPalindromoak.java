/*
 * 9.Palindrome Number
	 * Given an integer x, return true if x is a 
	palindrome
	, and false otherwise.
	
	 
	
	Example 1:
	
	Input: x = 121
	Output: true
	Explanation: 121 reads as 121 from left to right and from right to left.
	Example 2:
	
	Input: x = -121
	Output: false
	Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
	Example 3:
	
	Input: x = 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
	 */
package ebal2;

public class ZenbPalindromoak {
	static class Solution {
    public boolean isPalindrome(int x) {
        int numberReversed = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        while (x > numberReversed) {
            numberReversed = numberReversed * 10 + x % 10;
            x /= 10;
        }
       return x == numberReversed || x == numberReversed / 10;
    }

	}
	public static void main(String[]args){
	  Solution soluzioa = new Solution();//objetua soluzioa. Hartzen du class Solution-tik, sortzen du objetua eta erabiltzen du bere funtzio bat.
	  System.out.println(soluzioa.isPalindrome(123));
	}
}
