import javax.swing.JOptionPane;

public class Equations{
	public static void main(String[] args){
		String Type = JOptionPane.showInputDialog(null, "Choose type of equations:(1 for Linear, 2 for System of Linear, 3 for Quadratic)", "Type", JOptionPane.INFORMATION_MESSAGE);
		int type = Integer.parseInt(Type);
		switch(type){
			case 1:
				LinearEquation();
				break;
			case 2:
				SystemLinearEquation();
				break;
			case 3:
				Quadratic();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Bro choose again !", "Invalid choice", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void LinearEquation(){
		String strNum1 = JOptionPane.showInputDialog(null, "Please input a:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum2 = JOptionPane.showInputDialog(null, "Please input b:", "Input", JOptionPane.INFORMATION_MESSAGE);
		double a = Double.parseDouble(strNum1);
		double b = Double.parseDouble(strNum2);
		if(a == 0){
			if(b == 0){
				JOptionPane.showMessageDialog(null, "Infinite Solutions", "Result", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "No Solutions", "Result", JOptionPane.INFORMATION_MESSAGE);
			}
		}else{
			double x = -b / a;
			JOptionPane.showMessageDialog(null, "Solution is x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void SystemLinearEquation(){
		String strNum1 = JOptionPane.showInputDialog(null, "Please input a11:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum2 = JOptionPane.showInputDialog(null, "Please input a12:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum3 = JOptionPane.showInputDialog(null, "Please input b1:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum4 = JOptionPane.showInputDialog(null, "Please input a21:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum5 = JOptionPane.showInputDialog(null, "Please input a22:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum6 = JOptionPane.showInputDialog(null, "Please input b2:", "Input", JOptionPane.INFORMATION_MESSAGE);
		double a11 = Double.parseDouble(strNum1);
		double a12 = Double.parseDouble(strNum2);
		double b1 = Double.parseDouble(strNum3);
		double a21 = Double.parseDouble(strNum4);
		double a22 = Double.parseDouble(strNum5);
		double b2 = Double.parseDouble(strNum6);
		double D = a11 * a22 - a21 * a12;
		double D1 = b1 * a22 - b2 * a12;
		double D2 = a11 * b2 - a21 * b1;
		if(D != 0){
			double x1 = D1 / D;
			double x2 = D2 / D;
			JOptionPane.showMessageDialog(null, "Solutions are :"  + "\nx1 = " + x1 + "\nx2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
		}else{
			if(D1 == 0 && D2 == 0){
				JOptionPane.showMessageDialog(null, "Infinite Solutions", "Result", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "No Solutions", "Result", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	public static void Quadratic(){
		String strNum1 = JOptionPane.showInputDialog(null, "Please input a:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum2 = JOptionPane.showInputDialog(null, "Please input b:", "Input", JOptionPane.INFORMATION_MESSAGE);
		String strNum3 = JOptionPane.showInputDialog(null, "Please input c:", "Input", JOptionPane.INFORMATION_MESSAGE);
		double a = Double.parseDouble(strNum1);
		double b = Double.parseDouble(strNum2);
		double c = Double.parseDouble(strNum3);
		if(a == 0){
			JOptionPane.showMessageDialog(null, "This is Linear Equation! Please choose wisely!", "Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		double delta = b * b - 4 * a * c;
		if(delta > 0){
			double x1 = (-b + Math.sqrt(delta)) / (2 * a);
			double x2 = (-b - Math.sqrt(delta)) / (2 * a);
			JOptionPane.showMessageDialog(null, "The solutions are :" + "\nx1 = " + x1 + "\nx2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
		}else if(delta == 0){
			double x = -b / (2 * a);
			JOptionPane.showMessageDialog(null, "The solution is x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "No real roots !", "Result", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}