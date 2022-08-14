package calculator;

import java.sql.Date;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;

public class CalculatorMain implements ActionListener {

	JTextArea textfield = new JTextArea("");

	public void startingGui() {
		// Method to build the frame and buttons for the calculator
		JFrame frame = new JFrame("Simple Calculator");
		JOptionPane.showMessageDialog(frame,
				"Please understand that this calculator is a simple one \n do not expect it to be a scientific calculator. \n long divisons are not available yet");

		textfield.setBounds(200, 30, 150, 50);
		frame.add(textfield);
		JLabel LabelDate;

		LabelDate = new JLabel(String.format("%s", java.time.LocalDateTime.now()));

		// Adding the sizes for labels
		LabelDate.setBounds(10, 600, 20, 30);
		JButton zero = new JButton(new AbstractAction("0") {

			@Override
			public void actionPerformed(ActionEvent e) {
				textfield.append("0");
				// TODO Auto-generated method stub

			}

		});
		JButton one = new JButton(new AbstractAction("1") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("1");

			}

		});
		JButton two = new JButton(new AbstractAction("2") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("2");

			}

		});
		JButton three = new JButton(new AbstractAction("3") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("3");

			}

		});
		JButton four = new JButton(new AbstractAction("4") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("4");
			}

		});
		JButton five = new JButton(new AbstractAction("5") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("5");
			}
		});
		JButton six = new JButton(new AbstractAction("6") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("6");

			}
		});
		JButton seven = new JButton(new AbstractAction("7") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("7");

			}
		});
		JButton eight = new JButton(new AbstractAction("8") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("8");

			}
		});
		JButton nine = new JButton(new AbstractAction("9") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("9");

			}
		});

		// Adding the size of the digits buttons
		zero.setBounds(300, 400, 100, 50);
		one.setBounds(150, 100, 100, 50);
		two.setBounds(300, 100, 100, 50);
		three.setBounds(450, 100, 100, 50);
		four.setBounds(150, 200, 100, 50);
		five.setBounds(300, 200, 100, 50);
		six.setBounds(450, 200, 100, 50);
		seven.setBounds(150, 300, 100, 50);
		eight.setBounds(300, 300, 100, 50);
		nine.setBounds(450, 300, 100, 50);
		// Adding the action listener for the numbers buttons

		frame.add(zero);
		frame.add(one);
		frame.add(two);
		frame.add(three);
		frame.add(four);
		frame.add(five);
		frame.add(six);
		frame.add(seven);
		frame.add(eight);
		frame.add(nine);

		JButton plus = new JButton(new AbstractAction("+") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("+");
			}
		});
		plus.setBounds(40, 100, 100, 50);

		JButton minus = new JButton(new AbstractAction("-") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("-");

			}
		});
		minus.setBounds(40, 200, 100, 50);

		JButton times = new JButton(new AbstractAction("X") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("X");

			}
		});
		times.setBounds(40, 20, 100, 50);

		JButton division = new JButton(new AbstractAction("/") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.append("/");

			}
		});
		division.setBounds(40, 300, 100, 50);

		JButton deletes = new JButton(new AbstractAction("Del") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textfield.setText("");

			}
		});
		deletes.setBounds(40, 390, 100, 50);

		// Adding the buttons the frames
		frame.add(plus);
		frame.add(minus);
		frame.add(deletes);
		frame.add(times);
		frame.add(division);

		// The enter button to submit our math equation to the computer
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(380, 20, 100, 50);

		enterButton.addActionListener(this);
		frame.add(enterButton);

		frame.add(LabelDate);
		// Label that will change over the display depending on the screen
		frame.setSize(600, 600);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String mathOperator = textfield.getText();
		String value = "";
		try {
			if (mathOperator.contains("+")) {
				String[] numbers = mathOperator.replaceAll("\\+", ",").split(",");
				int[] numbersToAdd = { Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1]) };
				value = String.valueOf(Integer.sum(numbersToAdd[0], numbersToAdd[1]));

			}
			if (mathOperator.contains("-")) {
				String[] numbers = mathOperator.replaceAll("\\-", ",").split(",");
				int[] numbersToAdd = { Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1]) };
				value = String.valueOf(Math.subtractExact(numbersToAdd[0], numbersToAdd[1]));
			}
			if (mathOperator.contains("/")) {
				String[] numbers = mathOperator.replaceAll("/", ",").split(",");
				int[] numbersToAdd = { Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1]) };
				value = String.valueOf(Integer.divideUnsigned(numbersToAdd[0], numbersToAdd[1]));
			}
			if (mathOperator.contains("X")) {
				String[] numbers = mathOperator.replaceAll("X", ",").split(",");
				int[] numbersToAdd = { Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1]) };
				value = String.valueOf(Math.multiplyExact(numbersToAdd[0], numbersToAdd[1]));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		textfield.setText(value);

	}

	public static void main(String[] args) {
		CalculatorMain calc = new CalculatorMain();
		calc.startingGui();

	}

}