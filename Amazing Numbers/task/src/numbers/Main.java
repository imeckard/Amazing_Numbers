package numbers;
import java.util.LongSummaryStatistics;
import java.util.Scanner;

// this is a comment
// this is also a comment. your comment was lovely
// no, this is a comment. your comment sucks ass! It's really fuckin terrible. Worst comment of the year.

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameters show how many consecutive numbers are to be processed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");

        long num = 1;
        long secondNum;

        do {
            System.out.println();
            System.out.println("Enter a request:");
            System.out.println();
            String[] input = scan.nextLine().split(" ");
            try {
                num = Long.parseLong(input[0]);
            } catch (Exception e) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            }
            if (num < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (num == 0) {
                System.out.println();
                System.out.println("Goodbye!");
            } else {
                int choice = (input.length == 2) ? 0 : 1;
                switch (choice) {
                    case 0:
                        try {
                            secondNum = Long.parseLong(input[1]);
                        } catch (Exception e) {
                            System.out.println("The second parameter should be a natural number.");
                            continue;
                        }
                        if (secondNum <= 0) {
                            System.out.println("The second parameter should be a natural number.");
                        } else {
                            twoNum(input);
                        }
                        break;
                    case 1:
                        singleNum(num);
                        break;
                }
            }
        } while (num != 0);
    }
    public static void singleNum(long num) {
        System.out.printf("Properties of %d\n", num);
        System.out.println("        even: " + checkParity(num));
        System.out.println("         odd: " + !checkParity(num));
        System.out.println("        buzz: " + checkBuzz(num));
        System.out.println("        duck: " + checkDuck(num));
        System.out.println(" palindromic: " + checkPalin(num));
        System.out.println("      gapful: " + checkGapful(num));
    }

    public static void twoNum(String[] input) {
        long bigNum = Long.parseLong(input[0]);
        long smallNum = Long.parseLong(input[1]);

        for (int i = 0; i < smallNum; i++) {
            StringBuilder properties = new StringBuilder(" is ");
            properties.append(checkParity(bigNum) ? "even, " : "odd, ");
            properties.append(checkBuzz(bigNum) ? "buzz, " : "");
            properties.append(checkDuck(bigNum) ? "duck, " : "");
            properties.append(checkPalin(bigNum) ? "palindromic, " : "");
            properties.append(checkGapful(bigNum) ? "gapful, " : "");
            properties.setLength(properties.length() - 2);
            System.out.println(bigNum + properties.toString());
            bigNum++;
        }

    }

    public static boolean checkParity(long num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkBuzz(long num) {
        if (num % 7 == 0 || num % 10 == 7) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDuck(long num) {
        String numStr = Long.toString(num);
        if (numStr.contains("0")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPalin(long num) {
        String numStr = Long.toString(num);
        boolean isPalin = true;
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) != numStr.charAt(numStr.length() - 1 - i)) {
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }

    public static boolean checkGapful(long num) {
        String numStr = Long.toString(num);
        long gapNum = Long.parseLong(numStr.charAt(0) + "" + numStr.charAt(numStr.length() - 1));
        boolean isGapful = false;
        if (numStr.length() > 2 && num % gapNum == 0) {
            isGapful = true;
        }
        return isGapful;
    }
}
