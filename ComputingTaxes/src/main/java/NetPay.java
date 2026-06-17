/*
 * NetPay.java
 * Author:  Caleb Vang
 * Submission Date:  6/15/2026
 *
 * Purpose: Compute the deductions from federal, state, social
 * security, and medicare tax based on the users input of worked
 * hours per week multiplied by the base pay of $7.25
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the School of Computing
 * at the University of Georgia. Any publishing or
 * posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the
 * School of Computing at the University of Georgia.
 */

import java.util.Scanner;

public class NetPay {

  int hoursPerWeek;
  double grossPay;
  double netPay;

  double FEDERAL_TAX_PERCENT = 10.00;
  double STATE_TAX_PERCENT = 4.5;
  double SS_PERCENT = 6.2;
  double MEDICARE_PERCENT = 1.45;
  double PAY_PER_HOUR = 7.25;

  public void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Hours per Week:\t\t");
    hoursPerWeek = input.nextInt();
    input.close();

    grossPay = hoursPerWeek * PAY_PER_HOUR;

    double federalDeduction = (FEDERAL_TAX_PERCENT / 100) * grossPay;
    double stateDeduction = (STATE_TAX_PERCENT / 100) * grossPay;
    double ssDeduction = (SS_PERCENT / 100) * grossPay;
    double medicareDeduction = (MEDICARE_PERCENT / 100) * grossPay;
    double deductions =
      federalDeduction + stateDeduction + ssDeduction + medicareDeduction;

    netPay = grossPay - deductions;

    System.out.println("Gross Pay:\t\t\t" + grossPay);
    System.out.println("Net Pay:\t\t\t" + netPay + "\n\nDeductions");
    System.out.println("Federal:\t\t\t" + federalDeduction);
    System.out.println("state:\t\t\t\t" + stateDeduction);
    System.out.println("Social Security:\t" + ssDeduction);
    System.out.println("Medicare:\t\t\t" + medicareDeduction);
  }
}
