package interpreters;
import java.util.*;

public class ExtendedCalculator {

    private static String input;
    private static int pos;

    public static void main(String[] args) {
        // Example usage:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression:");
        input = scanner.nextLine();
        pos = 0;
        double result = parseExpression();
        System.out.println("Result: " + result);
    }

    // Parse addition and subtraction
    private static double parseExpression() {
        double value = parseTerm();
        while (true) {
            skipWhitespace();
            if (match('+')) {
                value += parseTerm();
            } else if (match('-')) {
                value -= parseTerm();
            } else {
                return value;
            }
        }
    }

    // Parse multiplication, division, modulo
    private static double parseTerm() {
        double value = parsePower();
        while (true) {
            skipWhitespace();
            if (match('*')) {
                value *= parsePower();
            } else if (match('/')) {
                value /= parsePower();
            } else if (match('%')) {
                value %= parsePower();
            } else {
                return value;
            }
        }
    }

    // Parse power `^`
    private static double parsePower() {
        double value = parseFactor();
        skipWhitespace();
        if (match('^')) {
            value = Math.pow(value, parsePower()); // right-associative
        }
        return value;
    }

    // Parse numbers and parentheses
    private static double parseFactor() {
        skipWhitespace();
        if (match('(')) {
            double value = parseExpression();
            if (!match(')')) {
                throw new RuntimeException("Missing closing parenthesis");
            }
            return value;
        }

        return parseNumber();
    }

    // Parse numbers, decimals, exponential
    private static double parseNumber() {
        skipWhitespace();
        int start = pos;
        if (peek() == '-' || peek() == '+') pos++; // allow sign
        while (Character.isDigit(peek()) || peek() == '.') pos++;

        // Check for exponent part
        if (peek() == 'e' || peek() == 'E') {
            pos++;
            if (peek() == '-' || peek() == '+') pos++;
            while (Character.isDigit(peek())) pos++;
        }

        if (start == pos) {
            throw new RuntimeException("Number expected but not found");
        }

        double num = Double.parseDouble(input.substring(start, pos));
        return num;
    }

    // Utility: skip whitespaces
    private static void skipWhitespace() {
        while (Character.isWhitespace(peek())) pos++;
    }

    // Utility: peek next character
    private static char peek() {
        if (pos >= input.length()) return '\0';
        return input.charAt(pos);
    }

    // Utility: match expected character
    private static boolean match(char expected) {
        if (peek() == expected) {
            pos++;
            return true;
        }
        return false;
    }
}

