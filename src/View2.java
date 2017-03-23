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

public class View2 {

	private JFrame frame;
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
						
					}
					JOptionPane.showMessageDialog(null, "已保存");
					
				}catch(Exception exc){
					JOptionPane.showMessageDialog(null, "保存失败");
				}
			}
		});
		toolBar.add(button_5);
		
		JPanel otherPanel = new JPanel();
		JPanel itemPanel = new JPanel();
		JPanel weaponPanel = new JPanel();
		JPanel equipmentPanel = new JPanel();
		JPanel talismanPanel = new JPanel();
		frame.getContentPane().add(otherPanel, BorderLayout.CENTER);
		frame.getContentPane().add(itemPanel, BorderLayout.CENTER);
		frame.getContentPane().add(weaponPanel, BorderLayout.CENTER);
		frame.getContentPane().add(equipmentPanel, BorderLayout.CENTER);
		frame.getContentPane().add(talismanPanel, BorderLayout.CENTER);
		talismanPanel.setLayout(null);
		
		//JAutoCompleteComboBox cbType = new JAutoCompleteComboBox();
		JComboBox cbType = new JComboBox();
		cbType.setBounds(199, 38, 123, 27);
		talismanPanel.add(cbType);
		cbType.setModel(new DefaultComboBoxModel(talisman.tType.values()));
		
		talisman tsm = new talisman();
		
		JAutoCompleteComboBox cbSkill1 = new JAutoCompleteComboBox();
		//JComboBox cbSkill1 = new JComboBox();
		cbSkill1.setBounds(148, 77, 123, 27);
		talismanPanel.add(cbSkill1);
		for (int i=0; i<204; i++){
			cbSkill1.addItem(tsm.ts[i]);
		}
		
		JAutoCompleteComboBox cbSkill2 = new JAutoCompleteComboBox();
		//JComboBox cbSkill2 = new JComboBox();
		cbSkill2.setBounds(148, 116, 123, 27);
		talismanPanel.add(cbSkill2);
		for (int i=0; i<204; i++){
			cbSkill2.addItem(tsm.ts[i]);
		}
		
		txtSkill1Num = new JComboBox();
		txtSkill1Num.setBounds(295, 76, 78, 26);
		talismanPanel.add(txtSkill1Num);
		for (int i=14; i>=-10; i--){
			txtSkill1Num.addItem(i);
		}
		txtSkill1Num.setSelectedIndex(14);

		
		txtSkill2Num = new JComboBox();
		txtSkill2Num.setBounds(295, 115, 78, 26);
		talismanPanel.add(txtSkill2Num);
		for (int i=14; i>=-10; i--){
			txtSkill2Num.addItem(i);
		}
		txtSkill2Num.setSelectedIndex(14);

		
		JLabel lblSkill1 = new JLabel("技能1");
		lblSkill1.setBounds(75, 81, 61, 16);
		talismanPanel.add(lblSkill1);
		
		JLabel lblSkill2 = new JLabel("技能2");
		lblSkill2.setBounds(75, 120, 61, 16);
		talismanPanel.add(lblSkill2);
		
		JLabel lblSlot = new JLabel("孔数");
		lblSlot.setBounds(75, 158, 61, 16);
		talismanPanel.add(lblSlot);
		
		JComboBox cbSlot = new JComboBox();
		cbSlot.setBounds(148, 154, 61, 27);
		talismanPanel.add(cbSlot);
		for (int i=0; i<4; i++){
			cbSlot.addItem(i);
		}
		
		
		JLabel lblType = new JLabel("护石类型：");
		lblType.setBounds(75, 42, 71, 16);
		talismanPanel.add(lblType);
		
		JButton btnAddTailsman = new JButton("快速添加护石");
		btnAddTailsman.addActionListener(new ActionListener() {
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
				
				talisman.addTailsman(typeCode, sk1Code, sk2Code, sk1Num, sk2Num, slot);		
				
			}
		});
		btnAddTailsman.setBounds(256, 193, 117, 29);
		talismanPanel.add(btnAddTailsman);
		otherPanel.setVisible(false);
		itemPanel.setVisible(false);
		weaponPanel.setVisible(false);
		equipmentPanel.setVisible(false);

	}
	
	public void setVisible(boolean visible){
		this.frame.setVisible(visible);
	}
}
