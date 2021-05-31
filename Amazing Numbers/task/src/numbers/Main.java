package numbers;
import java.util.Locale;
import java.util.LongSummaryStatistics;
import java.util.Scanner;
import java.util.Arrays;


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
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");

        long num = 1;
        long secondNum;
        String inputProperty;
        String[] properties = new String[] { "even", "odd", "buzz", "duck", "palindromic", "gapful", "spy" };

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
                int choice = input.length;
                switch (choice) {
                    case 1:
                        singleNum(num);
                        break;
                    case 2:
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
                    case 3:
                        inputProperty = input[2].toLowerCase();
                        boolean result = Arrays.asList(properties).contains(inputProperty);
                        if (!result) {
                            System.out.printf("The property [%s] is wrong.%n", inputProperty);
                            System.out.println("Available properties: " +
                                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
                            continue;
                        } else {
                            int propertyIndex = 0;
                            for (int i = 0; i < properties.length; i++) {
                                if (properties[i].equals(inputProperty)) {
                                    propertyIndex = i;
                                }
                            }
                            byProperties(input, propertyIndex);
                        }
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
        System.out.println("         spy: " + checkSpy(num));
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
            properties.append(checkSpy(bigNum) ? "spy, " : "");
            properties.setLength(properties.length() - 2);
            System.out.println(bigNum + properties.toString());
            bigNum++;
        }
    }

    public static void byProperties(String[] input, int propertyIndex){
        long bigNum = Long.parseLong(input[0]);
        long smallNum = Long.parseLong(input[1]);
        switch (propertyIndex) {
            case 0: //even
                break;
            case 1: //odd
                break;
            case 2: //buzz
                break;
            case 3: //duck
                break;
            case 4: //palindromic
                break;
            case 5: //gapful
                break;
            case 6: //spy
                break;
        }

    }

    public static boolean checkParity(long num) {
        return num % 2 == 0;
    }

    public static boolean checkBuzz(long num) {
        return num % 7 == 0 || num % 10 == 7;
    }

    public static boolean checkDuck(long num) {
        String numStr = Long.toString(num);
        return numStr.contains("0");
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
        return numStr.length() > 2 && num % gapNum == 0;
    }

    public static boolean checkSpy(long num) {
        String numStr = Long.toString(num);
        long product = 1;
        long sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            product *= Character.getNumericValue(numStr.charAt(i));
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return product == sum;
    }
}
