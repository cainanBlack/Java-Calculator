package lightRoastCalculator;

//imports for swing GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class LightRoastCalculator implements ActionListener{
	
	// Creation of JFrame, TextField, Buttons and Button holders, and JPanel

	JFrame frame;
	JTextField textfield;
	JTextField mainTextfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[20];
	JButton addButton, subButton, mulButton, divButton, numberButton;
	JButton decButton, equButton, delButton, clrButton, negButton, piButton;
	JButton sinButton, cosButton, tanButton, LperButton, RperButton, expButton;
	JButton modButton, sqrtButton, saveValButton, pasteValButton;
	JPanel panel;
	JPanel functionPanel;
	JPanel parenPanel;
	JPanel sqrPanel;
	
	// Two fonts that are implemented in the Buttons and TextField
	Font myFont = new Font("Calbri", Font.BOLD,30);
	Font specialFont = new Font("Calbri", Font.BOLD,15);
	Font textFont = new Font("Calbri", Font.PLAIN, 25);
	
	// New Colors 
	Color LightBlue = new Color(0, 220, 255);

	// Global variables to hold temporary values for calculation
	double num1 = 0, num2 = 0, result = 0;
	String tempNum = "", tempRes = "";
	char operator = ' ';
	static String savedVal = "";

	
	// Creation of the Calculator instance
	LightRoastCalculator(){
		
		// Configuration for JFrame
		frame = new JFrame("LightRoast Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 680);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.ORANGE);
		
		// Configuration for back end TextField 
		textfield = new JTextField();
		textfield.setBounds(33, 25, 383, 65);
		textfield.setFont(textFont);
		
		// Special Button declaration for operations
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("neg");
		sinButton = new JButton("sin");
		cosButton = new JButton("cos");
		tanButton = new JButton("tan");
		LperButton = new JButton("(");
		RperButton = new JButton(")");
		expButton = new JButton("^");
		piButton = new JButton("π");
		modButton = new JButton("Mod %");
		sqrtButton = new JButton("√");
		saveValButton = new JButton("Save");
		pasteValButton = new JButton("Paste");
		
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
		functionButtons[12] = LperButton;
		functionButtons[13] = RperButton;
		functionButtons[14] = expButton;
		functionButtons[15] = piButton;
		functionButtons[16] = modButton;
		functionButtons[17] = sqrtButton;
		functionButtons[18] = saveValButton;
		functionButtons[19] = pasteValButton;
		
		

		// Loop that formats the function buttons
		for(int i = 0; i < 20; i++) {
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
		panel.setBounds(35,315,380,300);
		panel.setLayout(new GridLayout(4,100,8,8));
		panel.setBackground(Color.DARK_GRAY);
		
		// JPanel for functions and special operations
		functionPanel = new JPanel();
		functionPanel.setBounds(35, 100, 380, 200);
		functionPanel.setLayout(new GridLayout(4,100,8,8));
		functionPanel.setBackground(Color.DARK_GRAY);	
		
		// JPanel for Parentheses
		parenPanel = new JPanel();
		parenPanel.setLayout(new GridLayout(1, 100, 8, 8));
		parenPanel.setBackground(Color.DARK_GRAY);
		
		// JPanel for save and paste value
		sqrPanel = new JPanel();
		sqrPanel.setLayout(new GridLayout(1, 100, 8, 8));
		sqrPanel.setBackground(Color.DARK_GRAY);
		
		
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
		functionPanel.add(delButton);
		functionPanel.add(negButton);
		functionPanel.add(clrButton);
		functionPanel.add(sinButton);
		functionPanel.add(cosButton);
		functionPanel.add(tanButton);
		functionPanel.add(modButton);
		functionPanel.add(piButton);
		functionPanel.add(sqrPanel);
		functionPanel.add(parenPanel);
		functionPanel.add(saveValButton);
		functionPanel.add(pasteValButton);
		
		// Adding Parenthesis to the parenPanel
		parenPanel.add(LperButton);
		parenPanel.add(RperButton);
		
		// Adding exponent and square root to the sqrPanel
		sqrPanel.add(expButton);
		sqrPanel.add(sqrtButton);
		
		// Color formatting for buttons to make them stand out
		clrButton.setBackground(LightBlue);
		equButton.setBackground(LightBlue);
		saveValButton.setBackground(LightBlue);
		pasteValButton.setBackground(LightBlue);
		
		// Adding panels to frame and setting frame to Visible
		frame.add(panel);
		frame.add(functionPanel);
		frame.add(textfield);
		frame.setVisible(true);		
	}
	
	// Main function
	public static void main(String[] args) {
			// Creating Calculator Instance 
			new LightRoastCalculator();
	}
		
	
	// Adds number to textfield
	public void actionPerformed(ActionEvent e) {
		String mainString = textfield.getText();
		
		// dynamic spacing for digits
		if (mainString.length() < 2) {
			for(int i = 0; i < 10; i++) {
				if(e.getSource() == numberButtons[i]) {
					textfield.setText(textfield.getText().concat(String.valueOf(i)));
				}
			}
		}else if (Character.isDigit(mainString.charAt(mainString.length() - 2)) | Character.isDigit(mainString.charAt(mainString.length()-1)) | mainString.charAt(mainString.length()-2) != ' ') {
			for(int i = 0; i < 10; i++) {
				if(e.getSource() == numberButtons[i]) {
					textfield.setText(textfield.getText().concat(String.valueOf(i)));
				}
			}
		} else {
			for(int i = 0; i < 10; i++) {
				if(e.getSource() == numberButtons[i]) {
					textfield.setText(textfield.getText().concat(" " + String.valueOf(i)));
				}
			}
		}
		
		// Adds a decimal to the text field
		if(e.getSource() == decButton) {			
			textfield.setText(textfield.getText().concat("."));
		}
		
		// Adds an addition operator to the expression
		if(e.getSource() == addButton) {
			textfield.setText(textfield.getText().concat(" + "));
		}
		
		// Adds an subtraction operator to the expression
		if(e.getSource() == subButton) {
			textfield.setText(textfield.getText().concat(" - "));
		}
		
		// Adds an multiplication operator to the expression
		if(e.getSource() == mulButton) {
			textfield.setText(textfield.getText().concat(" * "));
		}
		
		// Adds an division operator to the expression
		if(e.getSource() == divButton) {
			textfield.setText(textfield.getText().concat(" / "));
		}
		
		// Adds an sin operator to the expression
		if(e.getSource() == sinButton) {
			textfield.setText(textfield.getText().concat(" sin ( "));
		}
		
		// Adds an cos operator to the expression
		if(e.getSource() == cosButton) {
			textfield.setText(textfield.getText().concat(" cos ( "));
		}
		
		// Adds an tan operator to the expression
		if(e.getSource() == tanButton) {
			textfield.setText(textfield.getText().concat(" tan ( "));
		}
		
		// Adds an opening (left parentheses) to the expression
		if(e.getSource() == LperButton) {
			textfield.setText(textfield.getText().concat("( "));
		}
		
		// Adds an closing (right parentheses) to the expression
		if(e.getSource() == RperButton) {
			textfield.setText(textfield.getText().concat(" ) "));
		}
		
		// Adds an exponent symbol to the expression
		if(e.getSource() == expButton) {
			textfield.setText(textfield.getText().concat(" ^ "));
		}
		
		// Adds an π (pi) symbol to the expression
		if(e.getSource() == piButton) {
			textfield.setText(textfield.getText().concat(" π "));
		}
		
		// Adds an % (modulus) symbol to the expression
		if(e.getSource() == modButton) {
			textfield.setText(textfield.getText().concat(" % "));
		}
		
		// Adds a √ symbol to the expression
		if(e.getSource() == sqrtButton) {
			textfield.setText(textfield.getText().concat(" √ ( "));
		}
		
		// Clears text field if clear button is pressed
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		// Deletes one number by saving a string and outputting that string -1 char
		if(e.getSource() == delButton) {
			mainString = textfield.getText();
			textfield.setText("");
			
			// dynamic spacing for removed digit or space
			if (Character.isDigit(mainString.charAt(mainString.length() - 2)) | Character.isDigit(mainString.charAt(mainString.length()-1))) {
				for(int i = 0; i < mainString.length() - 1; i ++) {
					textfield.setText(textfield.getText() + mainString.charAt(i));
				}
			} else {
				for(int i = 0; i < mainString.length() - 2; i ++) {
					textfield.setText(textfield.getText() + mainString.charAt(i));
				}
			}
		}
		
		// Changes the value of the sign by multiplying the text field by -1
		if(e.getSource() == negButton) {
			mainString = textfield.getText();
			String[] temp = mainString.split(" ");
			textfield.setText("");
			for(int i = 0; i < temp.length - 1; i ++) {
				if(i == 0) {
					textfield.setText(textfield.getText()+temp[i]);
				} else {
				textfield.setText(textfield.getText() +" "+temp[i]);
				}
			}
			
			
			try {
				try {
					int tempInt = Integer.parseInt(temp[temp.length - 1]);
					if(temp.length == 1) {
						textfield.setText(textfield.getText().concat(Integer.toString(tempInt * -1)));
					} else {
						textfield.setText(textfield.getText().concat(" "+Integer.toString(tempInt * -1)));
					}
				} catch(NumberFormatException ex) {
					double tempDouble = Double.parseDouble(temp[temp.length - 1]);
					if(temp.length == 1) {
						textfield.setText(textfield.getText().concat(" "+Double.toString(tempDouble * -1)));
					} else {
						textfield.setText(textfield.getText().concat(" "+Double.toString(tempDouble * -1)));
					}
				} }catch(Exception k) {
				System.out.println("Invalid operator.");
				}	
	
		}
		
		// Save Value Button saves the result of the equation as a double
		if(e.getSource() == saveValButton) { 
			mainString = textfield.getText();
			String[] temp = mainString.split("=");
			savedVal = temp[temp.length - 1];
		}
		
		// Paste Value Button pastes in the saved value
		if(e.getSource() == pasteValButton) {
			for(int i = 1; i < savedVal.length(); i ++) {
				textfield.setText(textfield.getText() + savedVal.charAt(i));
			}
		}
		
		// If equal button is pressed, goes through cases to determine operation
		if(e.getSource() == equButton) {	

		// Outputs the calculation by setting the text field to 'result'	
		String equation = textfield.getText();
		try {
			Double res = shunting_algo(equation);
			textfield.setText(textfield.getText().concat(" = "+String.valueOf(res)));
		} catch (Exception k) {
			textfield.setText("Syntax Error");
		}
		}
	}
	
    public static double shunting_algo(String expression) {
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("%", 2);
        precedence.put("^", 3);
        precedence.put("√", 3);
        precedence.put("sin", 4);
        precedence.put("cos", 4);
        precedence.put("tan", 4);

        Deque<Double> operands = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();

        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {    	
            if (isNumber(token)) {
                operands.push(Double.parseDouble(token));
            } else if (token.equals("π")) {
                operands.push(Math.PI);
            } else if (precedence.containsKey(token)) {
                while (!operators.isEmpty() && !operators.peek().equals("(") && precedence.get(token) <= precedence.get(operators.peek())) {
                    evaluateTop(operands, operators);
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    evaluateTop(operands, operators);
                }
                operators.pop();

                if (!operators.isEmpty() && (operators.peek().equals("sin") || operators.peek().equals("cos") || operators.peek().equals("tan"))) {
                    evaluateTop(operands, operators);
                }
            } else if (token.equals("sin") || token.equals("cos") || token.equals("tan")) {
                operators.push(token);
            } else if (token.equals("^")) {
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            evaluateTop(operands, operators);
        }

        return operands.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void evaluateTop(Deque<Double> operands, Deque<String> operators) {
        String operator = operators.pop();
        if (operator.equals("sin")) {
            operands.push(Math.sin(operands.pop()));
        } else if (operator.equals("cos")) {
            operands.push(Math.cos(operands.pop()));
        } else if (operator.equals("tan")) {
            operands.push(Math.tan(operands.pop()));
        } else if (operator.equals("^")) {
            double exponent = operands.pop();
            double base = operands.pop();
            operands.push(Math.pow(base, exponent));
        } else if (operator.equals("√")) {
        	operands.push(Math.sqrt(operands.pop()));
    	}else {
            double rightOperand = operands.pop();
            double leftOperand = operands.pop();
            switch (operator) {
                case "+":
                    operands.push(leftOperand + rightOperand);
                    break;
                case "-":
                    operands.push(leftOperand - rightOperand);
                    break;
                case "*":
                    operands.push(leftOperand * rightOperand);
                    break;
                case "/":
                    operands.push(leftOperand / rightOperand);
                    break;
                case "%":
                	operands.push(leftOperand % rightOperand);
                	break;
            }
        }
    }

}
