package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        do {

            try {

                System.out.print("\nPlease enter an integer numerator\t");

                int numerator = scanner.nextInt();
                System.out.print("\nPlease enter an integer denominator\t");

                int denominator = scanner.nextInt();

                int result = quotient(numerator, denominator);
                System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
                continueLoop = false;

            }

            catch (InputMismatchException inputMismatchException) {

                System.out.printf("Error: Input was incorretct\n");
                System.out.printf("Suggestion: You must enter integer values\n");

                System.err.printf("%s%n%n", inputMismatchException.getMessage());
                inputMismatchException.printStackTrace();

                StackTraceElement[] traceElements = inputMismatchException.getStackTrace();

                for (StackTraceElement element : traceElements) {

                    System.out.printf("%s\t", element.getClassName());
                    System.out.printf("%s\t", element.getFileName());
                    System.out.printf("%s\t", element.getLineNumber());
                    System.out.printf("%s\t", element.getMethodName());

                }

                scanner.nextLine();

            }

            catch (ArithmeticException arithmeticException) {

                System.out.printf("Error: ArithmeticExpression was thrown\n");
                System.out.printf("Suggestion: You cannot enter 0\n");

            }

            finally {

                System.out.println("This is the finally statement, cleanup can go on here");

            }

        } while (continueLoop);

    }

    public static int quotient (int numerator, int denominator) throws ArithmeticException {

        return numerator / denominator;

    }

}
