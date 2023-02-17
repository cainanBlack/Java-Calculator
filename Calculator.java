package calculator;

// imports for swing GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator  implements ActionListener{
	
	// Creation of JFrame, TextField, Buttons and Button holders, and JPanel
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton, numberButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	// Two fonts that are implemented in the Buttons and TextField
	Font myFont = new Font("Calbri", Font.BOLD,30);
	Font specialFont = new Font("Calbri", Font.BOLD,15);
	
	// Global variables to hold temporary values for calculation
	double num1 = 0, num2 = 0, result = 0;
	String tempNum = "", tempRes = "";
	char operator;
	
	// Creation of the Calculator instance
	Calculator(){
		
		// Configuration for JFrame
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 550);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.ORANGE);
		
		// Configuration for TextField
		textfield = new JTextField();
		textfield.setBounds(43, 25, 367, 65);
		textfield.setFont(myFont);
		
		// Special Button declaration for operations
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("+/-");
		
		// Adding the function buttons to the array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		// Loop that formats the function buttons
		for(int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(specialFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(Color.ORANGE);
			functionButtons[i].setOpaque(true);
			functionButtons[i].setBorderPainted(false);
		}
		
		// Loop that formats the numerical buttons
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));  //Sets Value of button to loop iteration
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		// Sets position for the special buttons (This will probably change to a JPanel)
		negButton.setBounds(45,100,110,50);
		delButton.setBounds(160,100,120,50);
		clrButton.setBounds(285,100,120,50);
		
		// Creation of JPanel for the number buttons and operations
		panel = new JPanel();
		panel.setBounds(50,265,350,300);
		panel.setLayout(new GridLayout(5,100,8,8));
		panel.setBackground(Color.DARK_GRAY);
		
		// Placing all of the buttons on the JPanel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		// Adding the special buttons to the frame
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(panel);
		frame.add(textfield);
		frame.setVisible(true);
	}
	

	public static void main(String[] args) {
			// Creating Calculator Instance 
			new Calculator();

	}
	

	public void actionPerformed(ActionEvent e) {
		
		// Adds value of button pressed to the text field
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		// Adds a decimal to the text field
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
		}
		
		// If equal button is pressed, goes through cases to determine operation
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());	// Saves the value of the text field to num2
	
			// Looks at the operator used to determine which calculation to do.
			// Sets calculation result to 'result'
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 - num2;
				break;
			case'*':
				result = num1 * num2;
				break;
			case'/':
				result = num1 / num2;
				break;
				
			}

		// Outputs the calculation by setting the text field to 'result'	
		textfield.setText(String.valueOf(result));
		num1 = result; // Sets the value of num1 to result to do additional calculations
		}
		
		// Clears text field if clear button is pressed
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		// Deletes one number by saving a string and outputting that string -1 char
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length() - 1; i ++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		
		// Changes the value of the sign by multiplying the text field by -1
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		
	}

}
