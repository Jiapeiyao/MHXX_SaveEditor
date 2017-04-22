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
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class View1 {
	

	private JFrame frame;
	private JTextField txt_website;
	private JLabel txtupdate;

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
		frame.setBounds(100, 100, Main.windowWidth, Main.windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MHXX存档修改器v0.5a by Mononoke");
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("欢迎使用MHXX存档修改器");
		lblWelcome.setEnabled(false);
		lblWelcome.setBounds(163, 39, 154, 27);
		lblWelcome.setVisible(false);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblStatement = new JLabel("请备份存档，妥善保存");
		lblStatement.setBounds(175, 78, 130, 16);
		lblStatement.setVisible(true);
		frame.getContentPane().add(lblStatement);
		
		JButton btnLoad = new JButton("开始修改");
		btnLoad.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		//JFileChooser f = new JFileChooser();
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				View2.main();
			}
		});
		btnLoad.setBounds(123, 126, 234, 56);
		frame.getContentPane().add(btnLoad);
		
		txt_website = new JTextField();
		txt_website.setEditable(false);
		txt_website.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txt_website.setText("https://github.com/Jiapeiyao/MHXX_SaveEditor/releases");
		txt_website.setBounds(79, 223, 322, 27);
		txt_website.requestFocus();//获得焦点
		txt_website.selectAll();//选中
		frame.getContentPane().add(txt_website);
		txt_website.setColumns(10);
		
		txtupdate = new JLabel();
		txtupdate.setText("更新地址：");
		txtupdate.setBounds(41, 193, 130, 26);

		frame.getContentPane().add(txtupdate);
		
		JButton btnCopyButton = new JButton("复制到剪贴板");
		btnCopyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringSelection contents=new StringSelection("https://github.com/Jiapeiyao/MHXX_SaveEditor/releases");  //用拷贝文本框文本实例化StringSelection对象
				Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
	            clipboard.setContents(contents, null);    //设置系统剪贴板内容
			}
		});
		btnCopyButton.setBounds(331, 262, 117, 29);
		frame.getContentPane().add(btnCopyButton);
		
	}
}
