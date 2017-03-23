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
		
		JLabel lblStatement = new JLabel("请适当使用，合理修改");
		lblStatement.setBounds(160, 100, 130, 16);
		lblStatement.setVisible(false);
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
						//System.out.print(String.format("%02X", buffer[16 * 231831]));
					    in.close();
					    //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					    Main.user1offset = Main.buffer[18]*16*16*16*16 + Main.buffer[17]*16*16 + Main.buffer[16];
					    //System.out.println(Main.user1offset);
					    Main.equipmentBoxOffset = 1230690 - Main.user1offset;
					    //System.out.println(Main.equipmentBoxOffset);
//					    for (int i=0; i<72; i++){
//					    	if (i%16==0) System.out.println("");
//					    	System.out.print(Main.buffer[Main.user1offset + Main.equipmentBoxOffset + i - 36]);
//					    	System.out.print(" ");
//					    }
					    frame.setVisible(false);
					    View2 v = new View2();
					    v.setVisible(true);
					    //System.exit(0);
						
					}
					
				}catch(Exception exc){
					JOptionPane.showMessageDialog(null, "请加载正确的存档文件System");
				}
			}
		});
		btnLoad.setBounds(166, 128, 117, 29);
		frame.getContentPane().add(btnLoad);
	
	}


}
