import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class View1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View1 window = new View1();
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
	public View1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("欢迎使用MHXX存档修改器");
		lblWelcome.setBounds(148, 73, 154, 27);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblStatement = new JLabel("请适当使用，合理修改");
		lblStatement.setBounds(160, 100, 130, 16);
		frame.getContentPane().add(lblStatement);
		
		JButton btnLoad = new JButton("加载存档");
		btnLoad.setBounds(166, 128, 117, 29);
		frame.getContentPane().add(btnLoad);
	}
}
