package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class HackThePlanetGUI extends JDialog {
	private JPanel contentPane;
	private JButton calculateButton;
	private JTextField a112TextField;
	private ImageButton öppnaButton;

	private Main ourMagnificentCalculatorYo = new Main();

	public HackThePlanetGUI() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(calculateButton);

// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});

// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = a112TextField.getText();
				double result = Double.NaN;

				if (input.equals("")) {
					return;
				}

				try {
					result = ourMagnificentCalculatorYo.parse(input);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				a112TextField.setText(String.valueOf(result));
			}
		});
		öppnaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void onCancel() {
// add your code here if necessary
		dispose();
	}

	public static void main(String[] args) throws Exception {
		HackThePlanetGUI dialog = new HackThePlanetGUI();
		dialog.setUndecorated(true);
		dialog.pack();

		dialog.setLocationRelativeTo(null);

		System.out.println(new File("").getAbsolutePath());

		dialog.setVisible(true);
		System.exit(0);
	}
}
