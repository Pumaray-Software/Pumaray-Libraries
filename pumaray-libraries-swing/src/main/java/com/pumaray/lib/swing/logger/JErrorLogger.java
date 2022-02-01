package com.pumaray.lib.swing.logger;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class JErrorLogger extends JFrame {

	private static final long serialVersionUID = 6806264612345575089L;

	public JErrorLogger(String errorContent) {
		setTitle("Error");
		setSize(500, 200);
		setLayout(new BorderLayout());
		doLayout(errorContent);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void doLayout(String errorContent) {
		JPanel main = new JPanel();
		JPanel content = new JPanel();
		JPanel buttons = new JPanel();
		JTextArea area = new JTextArea();
		JButton getJavaButton = new JButton("Get Java & Close");
		JButton closeButton = new JButton("Exit & Close");

		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

		area.setEditable(false);
		area.setText(errorContent);
		content.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		getJavaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (Desktop.isDesktopSupported()) {
						Desktop.getDesktop().browse(new URL("http://www.java.com").toURI());
						System.exit(0);
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(JErrorLogger.this,
							"We cannot open your browser please get Java at http://www.java.com",
							"Error opening browser", JOptionPane.ERROR_MESSAGE );
					System.exit(0);
				}
			}

		});

		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		content.add(new JLabel(getErrorIcon()));
		content.add(Box.createRigidArea(new Dimension(5, 0)));
		content.add(area);

		buttons.add(getJavaButton);
		buttons.add(Box.createRigidArea(new Dimension(5, 0)));
		buttons.add(closeButton);

		main.add(content);
		main.add(Box.createRigidArea(new Dimension(0, 5)));
		main.add(buttons);
		main.add(Box.createRigidArea(new Dimension(0, 5)));

		add(main);

	}

	public static void displayError(String errorContent) {
		new JErrorLogger(errorContent).setVisible(true);
		;
	}

	public static void displayErrorContentFromFile(URI location) throws IOException {
		Path filePath = Paths.get(location);
		StringBuilder builder = new StringBuilder();
		Files.readAllLines(filePath).stream().forEach(line -> builder.append(line));
		displayError(builder.toString());

	}

	public static void displayErrorContentFromStream(InputStream input) throws IOException {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
			displayError(buffer.lines().collect(Collectors.joining("\n")));
		}
	}

	public Icon getErrorIcon() {
		Icon icon = null;
		try {
			URL url = ClassLoader.getSystemClassLoader().getResource("media/images/error-icon.png");
			return new ImageIcon(url);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return icon;
	}

}
