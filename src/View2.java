import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class View2 {

	private JFrame frame;
	private JPanel currentPanel;
	private JComboBox txtSkill1Num;
	private JComboBox txtSkill2Num;

	/**
	 * Launch the application.
	 */
	public static void main() {
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
		frame.setTitle("MHXX Save Editor by Mononoke");
		frame.setVisible(true);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel otherPanel = new JPanel();
		JPanel itemPanel = new JPanel();
		JPanel weaponPanel = new JPanel();
		JPanel equipmentPanel = new JPanel();
		JPanel visionPanel = new JPanel();		
		JPanel talismanPanel = new JPanel();
		frame.getContentPane().add(talismanPanel, BorderLayout.CENTER);
		frame.getContentPane().add(visionPanel, BorderLayout.CENTER);
		visionPanel.setLayout(null);
		frame.getContentPane().add(otherPanel, BorderLayout.CENTER);
		frame.getContentPane().add(itemPanel, BorderLayout.CENTER);
		frame.getContentPane().add(weaponPanel, BorderLayout.CENTER);
		frame.getContentPane().add(equipmentPanel, BorderLayout.CENTER);
		talismanPanel.setLayout(null);
		
		talismanPanel.setVisible(false);
		otherPanel.setVisible(false);
		itemPanel.setVisible(false);
		weaponPanel.setVisible(false);
		equipmentPanel.setVisible(false);
		visionPanel.setVisible(false);
		currentPanel = visionPanel;
		currentPanel.setVisible(true);
		
		talisman tsm = new talisman();
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
		
		JButton button_6 = new JButton("幻化");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPanel.setVisible(false);
				currentPanel = visionPanel;
				currentPanel.setVisible(true);
			}
		});
		toolBar.add(button_6);
		
		JButton button_4 = new JButton("护石");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPanel.setVisible(false);
				currentPanel = talismanPanel;
				currentPanel.setVisible(true);
			}
		});
		toolBar.add(button_4);
		
		JButton button_5 = new JButton("保存");
		JFileChooser f = new JFileChooser();
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//f.setDialogTitle("保存存档文件");
					f.setDialogType(JFileChooser.SAVE_DIALOG);
					int openResult = f.showDialog(null, "保存存档文件");
					if (openResult == JFileChooser.APPROVE_OPTION) {
						File file = f.getSelectedFile();
						FileOutputStream out = new FileOutputStream(file.getPath());
						out.write(Main.buffer);
					    out.close();
					    JOptionPane.showConfirmDialog(null, "已保存");
					}
					
					
				}catch(Exception exc){
					JOptionPane.showMessageDialog(null, "保存失败");
				}
			}
		});
		toolBar.add(button_5);
		
		
		//Talisman
		//JAutoCompleteComboBox cbType = new JAutoCompleteComboBox();
		JComboBox cbType = new JComboBox();
		cbType.setBounds(199, 38, 123, 27);
		talismanPanel.add(cbType);
		cbType.setModel(new DefaultComboBoxModel(talisman.tType.values()));
		
		JAutoCompleteComboBox cbSkill1 = new JAutoCompleteComboBox();
		//JComboBox cbSkill1 = new JComboBox();
		cbSkill1.setBounds(148, 77, 123, 27);
		talismanPanel.add(cbSkill1);
		
		JAutoCompleteComboBox cbSkill2 = new JAutoCompleteComboBox();
		//JComboBox cbSkill2 = new JComboBox();
		cbSkill2.setBounds(148, 116, 123, 27);
		talismanPanel.add(cbSkill2);
		
		txtSkill1Num = new JComboBox();
		txtSkill1Num.setBounds(295, 76, 78, 26);
		talismanPanel.add(txtSkill1Num);
		txtSkill1Num.setSelectedIndex(14);
		
				
		txtSkill2Num = new JComboBox();
		txtSkill2Num.setBounds(295, 115, 78, 26);
		talismanPanel.add(txtSkill2Num);
		txtSkill2Num.setSelectedIndex(14);
		
		
		JComboBox cbSlot = new JComboBox();
		cbSlot.setBounds(148, 154, 61, 27);
		talismanPanel.add(cbSlot);
		
		for (int i=0; i<204; i++){
			cbSkill1.addItem(tsm.ts[i]);
		}
		for (int i=0; i<204; i++){
			cbSkill2.addItem(tsm.ts[i]);
		}
		for (int i=14; i>=-10; i--){
			txtSkill1Num.addItem(i);
		}
		for (int i=14; i>=-10; i--){
			txtSkill2Num.addItem(i);
		}
		for (int i=0; i<4; i++){
			cbSlot.addItem(i);
		}
						
		JLabel lblSkill1 = new JLabel("技能1");
		lblSkill1.setBounds(75, 81, 61, 16);
		talismanPanel.add(lblSkill1);
		
		JLabel lblSkill2 = new JLabel("技能2");
		lblSkill2.setBounds(75, 120, 61, 16);
		talismanPanel.add(lblSkill2);
		
		JLabel lblSlot = new JLabel("孔数");
		lblSlot.setBounds(75, 158, 61, 16);
		talismanPanel.add(lblSlot);
		
		JLabel lblType = new JLabel("护石类型：");
		lblType.setBounds(75, 42, 71, 16);
		talismanPanel.add(lblType);
		
		JButton btnAddtalisman = new JButton("快速添加护石");
		btnAddtalisman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int typeCode = cbType.getSelectedIndex();
				if (typeCode == 0){	
					JOptionPane.showMessageDialog(null, "请选择护石类型");
					return;
				}
				
				String skill1 = cbSkill1.getSelectedItem().toString();
				String skill2 = cbSkill2.getSelectedItem().toString();
				int sk1Code = 0, sk2Code = 0;
				
				for (int i=0; i<204; i++){
					if (skill1 == tsm.ts[i].toString()) sk1Code = i;
					if (skill2 == tsm.ts[i].toString()) sk2Code = i;
				}
				
				if (sk1Code == 0){	
					JOptionPane.showMessageDialog(null, "请选择护石技能");
					return;
				}
				
				int sk1Num = 14 - txtSkill1Num.getSelectedIndex();
				if (sk1Num == 0){	
					JOptionPane.showMessageDialog(null, "请填写技能1点数");
					return;
				}
				int sk2Num = 14 - txtSkill2Num.getSelectedIndex();
				
				int slot = cbSlot.getSelectedIndex();
				
				talisman.addtalisman(typeCode, sk1Code, sk2Code, sk1Num, sk2Num, slot);		
				
			}
		});
		btnAddtalisman.setBounds(256, 193, 117, 29);
		talismanPanel.add(btnAddtalisman);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Panel.background"));
		textPane.setText("使用说明：\n1. 请将防具按照(本体,幻化外形)为一组放在第一个箱子的第一行； \n2. 可以幻化二名DLC等防具，射手剑士互通；\n3. 此幻化后偶数位的防具还在；");
		textPane.setBounds(19, 163, 397, 87);
		visionPanel.add(textPane);
		
		JButton vision1 = new JButton("将第1格防具幻化为第2格防具的外形");
		vision1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipment1Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset] % 32;
				int equipment2Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 36] % 32;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
//				} else if (equipment1Type != equipment2Type) {
//					JOptionPane.showMessageDialog(null, "失败！防具部位不同");
//					return;
				} else {
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 4] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 36 + 2];
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 5] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 36 + 3];
					JOptionPane.showMessageDialog(null, "幻化成功");
					return;
				}
			}
		});
		vision1.setBounds(92, 16, 266, 29);
		visionPanel.add(vision1);
		
		JButton vision2 = new JButton("将第3格防具幻化为第4格防具的外形");
		vision2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipment1Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 72] % 32;
				int equipment2Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 108] % 32;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
//				} else if (equipment1Type != equipment2Type) {
//					JOptionPane.showMessageDialog(null, "失败！防具部位不同");
//					return;
				} else {
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 72 + 4] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 108 + 2];
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 72 + 5] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 108 + 3];
					JOptionPane.showMessageDialog(null, "幻化成功");
					return;
				}
			}
		});
		vision2.setBounds(92, 46, 266, 29);
		visionPanel.add(vision2);
		
		JButton vision3 = new JButton("将第5格防具幻化为第6格防具的外形");
		vision3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipment1Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 144] % 32;
				int equipment2Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 160] % 32;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
//				} else if (equipment1Type != equipment2Type) {
//					JOptionPane.showMessageDialog(null, "失败！防具部位不同");
//					return;
				} else {
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 144 + 4] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 180 + 2];
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 144 + 5] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 180 + 3];
					JOptionPane.showMessageDialog(null, "幻化成功");
					return;
				}
			}
		});
		vision3.setBounds(92, 76, 266, 29);
		visionPanel.add(vision3);
		
		JButton vision4 = new JButton("将第7格防具幻化为第8格防具的外形");
		vision4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipment1Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 216] % 32;
				int equipment2Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 252] % 32;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
//				} else if (equipment1Type != equipment2Type) {
//					JOptionPane.showMessageDialog(null, "失败！防具部位不同");
//					return;
				} else {
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 216 + 4] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 252 + 2];
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 216 + 5] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 252 + 3];
					JOptionPane.showMessageDialog(null, "幻化成功");
					return;
				}
			}
		});
		vision4.setBounds(92, 106, 266, 29);
		visionPanel.add(vision4);
		
		JButton vision5 = new JButton("将第9格防具幻化为第10格防具的外形");
		vision5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipment1Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 288] % 32;
				int equipment2Type = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 324] % 32;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
//				} else if (equipment1Type != equipment2Type) {
//					JOptionPane.showMessageDialog(null, "失败！防具部位不同");
//					return;
				} else {
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 288 + 4] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 324 + 2];
					Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 288 + 5] = Main.buffer[Main.user1offset + Main.equipmentBoxOffset + 324 + 3];
					JOptionPane.showMessageDialog(null, "幻化成功");
					return;
				}
			}
		});
		vision5.setBounds(92, 136, 266, 29);
		visionPanel.add(vision5);

	}
}
