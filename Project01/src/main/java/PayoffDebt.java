/*
 * PayoffDebt.java
 * Author:  Caleb Vang
 * Submission Date:  6/19/2026
 *
 * Purpose: This program calculates the number of months needed to
 * pay off credit card debt, display amounts paid, and overpayment.
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

public class PayoffDebt {

  double principal;
  double apr;
  double monthlyPayment;

  public void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Principal:\t\t\t\t\t");
    principal = input.nextDouble();
    System.out.print("Annual Interest Rate (%):\t");
    apr = input.nextDouble();
    System.out.print("Monthly Payment:\t\t\t");
    monthlyPayment = input.nextDouble();
    input.close();

    int payoffPeriod = (int) Math.ceil(calculatePayoffPeriod(principal, apr, monthlyPayment));
    double amountPaid = payoffPeriod * monthlyPayment;
    double interestPaid = Math.abs(principal - amountPaid);
    double overPaid = calculateOverpayment(principal, apr, monthlyPayment);

    System.out.println(
      "\n" +
        "Months Needed To Pay Off:\t" +
        payoffPeriod +
        "\nTotal Amount Paid:\t\t\t$" +
        roundToHundredth(amountPaid) +
        "\nTotal Interest Paid:\t\t$" +
        roundToHundredth(interestPaid) +
        "\nOverpayment:\t\t\t\t$" +
        roundToHundredth(overPaid)
    );
  }

  public double calculatePayoffPeriod(double principal, double apr, double monthlyPayment) {
    return (
      (Math.log(monthlyPayment) -
        Math.log(monthlyPayment - ((apr / 1200.0) * principal))) /
      Math.log((apr / 1200.0) + 1.0)
    );
  }

    /**
     * Calculates the overpayment.
     *
     * Use calculatePayoffPeriod to calculate both the decimal value
     * and integer ceiling.
     * Subtract the ceiling with the decimal value to get the amount
     * of time left in the month.
     * Multiply the time left with the monthlyPayment.
     * Return overpayment.
     *
     * @param principal Amount of money owed
     * @param apr Annual interest rate
     * @param monthlyPayment Amount of money paid each month
     * @return overpayment
     */
  public double calculateOverpayment(double principal, double apr, double monthlyPayment) {
    double leftOver = Math.ceil(calculatePayoffPeriod(principal, apr, monthlyPayment)) - calculatePayoffPeriod(principal, apr, monthlyPayment);
    return leftOver * monthlyPayment;
  }

  public double roundToHundredth(double value) {
    return Math.round(value * 100.0) / 100.0;
  }
}
