import java.util.Scanner;

public class PayoffDebt {

    double principal;
    double apr;
    double monthlyPayment;

    public void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Principal:\t\t\t\t");
        principal = input.nextDouble();
        System.out.print("Annual Interest Rate (%):\t");
        apr = input.nextDouble();
        System.out.print("Monthly Payment:\t\t\t");
        monthlyPayment = input.nextDouble();
        input.close();
    }

    public int calculatePayoffPeriod(
            double principal,
            double apr,
            double monthlyPayment
    ) {
        double months = Math.ceil(
                Math.log(monthlyPayment) -
                        Math.log(
                                monthlyPayment -
                                        ((apr / 1200.0) * principal) / Math.log((apr / 1200.0) + 1.0)
                        )
        );
        return (int) months;
    }
}
