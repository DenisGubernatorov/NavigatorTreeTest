package window;


import actions.Actions;
import javafx.scene.shape.Path;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NavigatorGUI {
	private JButton buttonOK;
	private JPanel centralPanel;
	private JTextField inputField;
	 public JLabel bottomPanelLabel;

	public void init() {
		JFrame frame = new JFrame();
		frame.setSize(780, 550);
		JFrame.setDefaultLookAndFeelDecorated(true);

		//  выводим по центру
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dimension.width / 2 - 390, dimension.height / 2 - 275);
		frame.setLayout(new BorderLayout());

		//  добавляем панели

		JPanel inputPanel = createTopPanel();
		centralPanel = creteCentralPanel();

		frame.add(inputPanel, BorderLayout.NORTH);
		frame.add(centralPanel, BorderLayout.CENTER);

		// выводим
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//  обработка событий
		//TODO нет обработки при нажатии Enter в текстовом поле
		buttonOK.addActionListener(e -> {

			JTree tree = null;
			bottomPanelLabel.setText("processing");
			if (Files.isDirectory(Paths.get(inputField.getText()))){

				tree = new JTree(new Actions().buttonAction(inputField.getText()));
				centralPanel.remove(bottomPanelLabel);
				centralPanel.add(new JScrollPane(tree));
			}
			else
				bottomPanelLabel.setText("not valid directory");


			frame.repaint();
			frame.pack();
		});


	}


	private JPanel createTopPanel() {
		JPanel topPanel = new JPanel();
		//topPanel.setLayout(new BoxLayout(topPanel,3));
		JLabel label = new JLabel("Введите путь");


		buttonOK = new JButton("ОК");

		 inputField = new JTextField(50);
		//inputField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));


		topPanel.add(label, BorderLayout.WEST);
		topPanel.add(inputField, BorderLayout.CENTER);
		topPanel.add(buttonOK, BorderLayout.EAST);

		return topPanel;
	}

	private JPanel creteCentralPanel() {

		JPanel panel = new JPanel();
		//panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		bottomPanelLabel = new JLabel("catalog tree");
		panel.add(bottomPanelLabel);

		return panel;


	}
}

