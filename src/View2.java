import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class View2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View2 window = new View2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton button_0 = new JButton("综合");
		button_0.setEnabled(false);
		toolBar.add(button_0);
		
		JButton button_1 = new JButton("物品");
		button_1.setEnabled(false);
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("武器");
		button_2.setEnabled(false);
		toolBar.add(button_2);
		
		JButton button_3 = new JButton("防具");
		button_3.setEnabled(false);
		toolBar.add(button_3);
		
		JButton button_4 = new JButton("护石");
		toolBar.add(button_4);
		
		JPanel otherPanel = new JPanel();
		otherPanel.setVisible(false);
		JPanel itemPanel = new JPanel();
		JPanel weaponPanel = new JPanel();
		JPanel equipmentPanel = new JPanel();
		JPanel talismanPanel = new JPanel();
		frame.getContentPane().add(otherPanel, BorderLayout.CENTER);
		frame.getContentPane().add(itemPanel, BorderLayout.CENTER);
		frame.getContentPane().add(weaponPanel, BorderLayout.CENTER);
		frame.getContentPane().add(equipmentPanel, BorderLayout.CENTER);
		frame.getContentPane().add(talismanPanel, BorderLayout.CENTER);
	}

}
