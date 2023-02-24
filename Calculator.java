package calculator;

// imports for swing GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Calculator  implements ActionListener{
	
	// Creation of JFrame, TextField, Buttons and Button holders, and JPanel
	JFrame frame;
	JTextField textfield;
	JTextField mainTextfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[12];
	JButton addButton, subButton, mulButton, divButton, numberButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JButton sinButton, cosButton, tanButton;
	JPanel panel;
	JPanel functionPanel;
	
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
		
		// Configuration for back end TextField 
		textfield = new JTextField();
		textfield.setBounds(43, 25, 367, 65);
		textfield.setFont(myFont);
		textfield.setVisible(false);
		
		// Configuration for mainTextField
		mainTextfield = new JTextField();
		mainTextfield.setBounds(43, 25, 367, 65);
		mainTextfield.setFont(myFont);
		
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
		sinButton = new JButton("sin(x)");
		cosButton = new JButton("cos(x)");
		tanButton = new JButton("tan(x)");
		
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
		functionButtons[9] = sinButton;
		functionButtons[10] = cosButton;
		functionButtons[11] = tanButton;
		
		

		// Loop that formats the function buttons
		for(int i = 0; i < 12; i++) {
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
		
		
		// Creation of JPanel for the number buttons and operations
		panel = new JPanel();
		panel.setBounds(50,265,350,300);
		panel.setLayout(new GridLayout(5,100,8,8));
		panel.setBackground(Color.DARK_GRAY);
		
		// JPanel for functions and special operations
		functionPanel = new JPanel();
		functionPanel.setBounds(50, 100, 350, 200);
		functionPanel.setLayout(new GridLayout(4,20,8,8));
		functionPanel.setBackground(Color.DARK_GRAY);	
		
		
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

		// Adding the special buttons to the functionPanel JPanel
		functionPanel.add(negButton);
		functionPanel.add(delButton);
		functionPanel.add(clrButton);
		functionPanel.add(sinButton);
		functionPanel.add(cosButton);
		functionPanel.add(tanButton);
		
		
		// Adding panels to frame and setting frame to Visible
		frame.add(panel);
		frame.add(functionPanel);
		//frame.add(textfield);
		frame.add(mainTextfield);
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
				mainTextfield.setText(mainTextfield.getText().concat(String.valueOf(i)));
			}
		}
		
		// Adds a decimal to the text field
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
			mainTextfield.setText(mainTextfield.getText().concat("."));
		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == addButton) {
			num1 += Double.parseDouble(textfield.getText());
			operator = '+'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
			mainTextfield.setText(mainTextfield.getText().concat("+"));

		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == subButton) {
			num1 -= Double.parseDouble(textfield.getText());
			operator = '-'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
			mainTextfield.setText(mainTextfield.getText().concat("-"));

		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == mulButton) {
			if (num1 == 0) {
				num1 = Double.parseDouble(textfield.getText());
			}
			else {
				num1 *= Double.parseDouble(textfield.getText());
			}
			operator = '*'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
			mainTextfield.setText(mainTextfield.getText().concat("*"));

		}
		
		// Saves the value of the text field to num1 and clears text field
		if(e.getSource() == divButton) {
			if (num1 == 0) {
				num1 = Double.parseDouble(textfield.getText());
			}
			else {
				num1 /= Double.parseDouble(textfield.getText());
			}			operator = '/'; // Sets the 'operator' holder to the correct operation
			textfield.setText("");
			mainTextfield.setText(mainTextfield.getText().concat("/"));

		}
		
		// Sin function that sets the value of num1 to sin of input
		if(e.getSource() == sinButton) {
			num1 = Math.sin(Double.parseDouble(textfield.getText()));			
			String string = mainTextfield.getText();
			mainTextfield.setText("");
			textfield.setText(String.valueOf(num1));
			
			for(int i = 0; i < string.length() - 1; i ++) {
				mainTextfield.setText(mainTextfield.getText() + string.charAt(i));
			}
			mainTextfield.setText(mainTextfield.getText().concat("sin("+string.charAt(string.length()-1)+")"));

		}
		
		// Cos function that sets the value of num1 to sin of input
		if(e.getSource() == cosButton) {
			num1 = Math.cos(Double.parseDouble(textfield.getText()));
			String string = mainTextfield.getText();
			mainTextfield.setText("");
			textfield.setText(String.valueOf(num1));
			
			for(int i = 0; i < string.length() - 1; i ++) {
				mainTextfield.setText(mainTextfield.getText() + string.charAt(i));
			}
			mainTextfield.setText(mainTextfield.getText().concat("cos("+string.charAt(string.length()-1)+")"));
		}
		
		// Tan function that sets the value of num1 to sin of input
		if(e.getSource() == tanButton) {
			num1 = Math.tan(Double.parseDouble(textfield.getText()));
			String string = mainTextfield.getText();
			mainTextfield.setText("");
			textfield.setText(String.valueOf(num1));
			
			for(int i = 0; i < string.length()-1; i ++) {
				mainTextfield.setText(mainTextfield.getText() + string.charAt(i));
			}
			
			mainTextfield.setText(mainTextfield.getText().concat("tan("+string.charAt(string.length()-1)+")"));
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
		mainTextfield.setText(mainTextfield.getText().concat(" = "+String.valueOf(result)));
		num1 = result; // Sets the value of num1 to result to do additional calculations
		}
		
		// Clears text field if clear button is pressed
		if(e.getSource() == clrButton) {
			textfield.setText("");
			mainTextfield.setText("");
			num1 = 0;
		}
		
		// Deletes one number by saving a string and outputting that string -1 char
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			String mainString = mainTextfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length() - 1; i ++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
			
			mainTextfield.setText("");
			for(int i = 0; i < mainString.length() - 1; i ++) {
				mainTextfield.setText(mainTextfield.getText() + mainString.charAt(i));
			}
		}
		
		// Changes the value of the sign by multiplying the text field by -1
		if(e.getSource() == negButton) {
			String mainString = mainTextfield.getText();
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
			
			mainTextfield.setText("");
			for(int i = 0; i < mainString.length() - 1; i ++) {
				mainTextfield.setText(mainTextfield.getText() + mainString.charAt(i));
			}
			mainTextfield.setText(mainTextfield.getText().concat("(-"+mainString.charAt(mainString.length()-1)+")"));
		}
	}

}
