import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class View1 {
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
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
		frame.setTitle("MHXX Save Editor by Mononoke");
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("欢迎使用MHXX存档修改器");
		lblWelcome.setBounds(148, 73, 154, 27);
		lblWelcome.setVisible(false);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblStatement = new JLabel("请备份存档，妥善保存");
		lblStatement.setBounds(160, 100, 130, 16);
		lblStatement.setVisible(true);
		frame.getContentPane().add(lblStatement);
		
		JButton btnLoad = new JButton("加载存档");
		JFileChooser f = new JFileChooser();
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					f.setDialogTitle("打开存档文件");
					int openResult = f.showOpenDialog(null);
					if (openResult == JFileChooser.APPROVE_OPTION) {
						File file = f.getSelectedFile();
						FileInputStream in = new FileInputStream(file.getPath());
						in.read(Main.buffer);
					    in.close();
					}
				}catch(Exception exc){
					JOptionPane.showMessageDialog(null, "请加载正确的存档文件System");
				}
			    Main.user1offset = Main.buffer[18]*16*16*16*16 + Main.buffer[17]*16*16 + Main.buffer[16];
			    Main.equipmentBoxOffset = 1230690 - Main.user1offset;
			    frame.setVisible(false);
			    View2 v = new View2();
			    //System.exit(0);
			}
		});
		btnLoad.setBounds(166, 128, 117, 29);
		frame.getContentPane().add(btnLoad);
//		JTextPane textPane = new JTextPane();
//		textPane.setBackground(UIManager.getColor("Panel.background"));
//		textPane.setText("幻化功能使用说明：\n1. 请将防具按照(本体,幻化外形)为一组放在第一个箱子的第一行； \n2. 可以幻化二名DLC等防具，射手剑士互通；\n3. 此幻化后偶数位的防具还在；\n4. 同一系列的防具幻化效果相同（例：麒麟S射手胴可以将所有部位防具幻化成麒麟S射手");
//		textPane.setBounds(19, 163, 397, 87);
//		frame.getContentPane().add(textPane);
	}


}
