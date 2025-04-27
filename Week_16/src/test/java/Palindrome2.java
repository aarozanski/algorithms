public class Palindrome2 {
        public boolean isPalindrome(int x) {
            // Step 1: Negative numbers are NEVER palindrome
            if (x < 0) {
                return false;
            }

            int original = x; // Save the original number
            int reversed = 0; // We will build the reversed number here

            while (x != 0) {
                int lastDigit = x % 10;          // Get the last digit
                reversed = reversed * 10 + lastDigit; // Build the reversed number
                x = x / 10;                      // Remove the last digit
            }

            return original == reversed; // Check if the original is the same as reversed
        }
    }

