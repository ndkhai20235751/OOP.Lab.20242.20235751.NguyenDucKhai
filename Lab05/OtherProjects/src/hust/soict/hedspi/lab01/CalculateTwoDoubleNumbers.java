import javax.swing.JOptionPane;

public class CalculateTwoDoubleNumbers {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String quotientResult;
        if (num2 == 0) {
            quotientResult = "Nah! Oh hell no u put the \'0\' in the number tooo!";
        } else {
            double quotient = num1 / num2;
            quotientResult = String.format("%.2f", quotient);
        }
        String message = String.format("Entered numbers: %s and %s\n" + "Sum: %.2f\n" + "Difference: %.2f\n" + "Product: %.2f\n" + "Quotient: %s", strNum1, strNum2, sum, difference, product, quotientResult);
        JOptionPane.showMessageDialog(null, message, "Results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}