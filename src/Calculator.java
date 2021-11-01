import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

//	Author
//	Elia El Khoury
//	201910274

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[13];
	JButton addButton, subButton, mulButton, divButton, modButton, sqrButton, facButton;
	JButton decButton, equButton, delButton, clrButton, negButton, powButton;
	JPanel panel;

	Font text = new Font("Arial", Font.BOLD, 30);
	Font myFont = new Font("Ink Free", Font.BOLD, 30);

	double num1 = 0, num2 = 0, result = 0;
	char operator;

	Calculator() {

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520, 550);
		frame.setLayout(null);

		textfield = new JTextField();
		textfield.setBounds(50, 25, 400, 50);
		textfield.setFont(myFont);
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		textfield.setEditable(false);

		ImageIcon icon = new ImageIcon("calculator.png");

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		sqrButton = new JButton("√");
		modButton = new JButton("%");
		powButton = new JButton("^");
		facButton = new JButton("!");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = sqrButton;
		functionButtons[10] = modButton;
		functionButtons[11] = powButton;
		functionButtons[12] = facButton;

		for (int i = 0; i < 13; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(text);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(new Color(100, 100, 100));
			functionButtons[i].setForeground(new Color(255, 255, 255));
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(text);
			numberButtons[i].setFocusable(false);

			numberButtons[i].setBackground(new Color(100, 100, 100));
			numberButtons[i].setForeground(new Color(255, 255, 255));
		}

		negButton.setBounds(50, 430, 120, 50);
		delButton.setBounds(190, 430, 120, 50);
		clrButton.setBounds(330, 430, 120, 50);

		panel = new JPanel();
		panel.setBounds(40, 100, 420, 300);
		panel.setLayout(new GridLayout(4, 5, 10, 10));

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(addButton);
		panel.add(sqrButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(modButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(mulButton);
		panel.add(powButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(divButton);
		panel.add(facButton);
		panel.add(equButton);

		panel.setBackground(new Color(50, 50, 50));
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		textfield.setBackground(new Color(150, 150, 150));

		frame.setIconImage(icon.getImage());
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new Calculator();
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}

		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}

		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}

		if (e.getSource() == facButton) {
			double num1 = Double.parseDouble(textfield.getText());
			operator = '!';
			textfield.setText("");
			result = 1;
			for (int i = 1; i <= num1; i++) {
				result = result * i;
			}

			textfield.setText(String.valueOf(result));
		}

		if (e.getSource() == modButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '%';
			textfield.setText("");
		}

		if (e.getSource() == sqrButton) {
			operator = '&';
		}

		if (e.getSource() == powButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '^';
			textfield.setText("");
		}

		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			String resultS = "";
			try {

				switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				case '^':
					result = Math.pow(num1, num2);
					break;
				case '%':
					result = num1 % num2;
					break;
				case '&':
					result = Math.sqrt(num2);
					break;
				}
				resultS = String.valueOf(result);
			} catch (ArithmeticException A) {
				// error
				resultS = "You Created A Paradox!";
			}

			textfield.setText(resultS);
			num1 = result;
		}

	}
}