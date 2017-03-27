import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class View2 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		frame.setBounds(100, 100, Main.windowWidth, Main.windowHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MHXX存档修改器 by Mononoke");
		frame.setVisible(true);
		
		JToolBar toolBar = new JToolBar();
		CardLayout cards = new CardLayout();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel container = new JPanel(cards);
		JPanel otherPanel = new JPanel();
		JPanel itemPanel = new JPanel();
		JPanel weaponPanel = new JPanel();
		JPanel equipmentPanel = new JPanel();
		JPanel visionPanel = new JPanel();		
		JPanel talismanPanel = new JPanel();
		container.add(otherPanel, "other");
		container.add(itemPanel, "item");
		itemPanel.setLayout(null);
		container.add(weaponPanel, "weapon");
		container.add(equipmentPanel, "equipment");
		container.add(visionPanel, "vision");
		container.add(talismanPanel, "talisman");
		cards.show(container, "vision");
		frame.getContentPane().add(container, BorderLayout.CENTER);
		visionPanel.setLayout(null);
		talismanPanel.setLayout(null);
		
		
		talisman tsm = new talisman();
		JButton button_0 = new JButton("综合");
		button_0.setEnabled(false);
		toolBar.add(button_0);
		
		JButton button_1 = new JButton("物品");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(container, "item");
				item.getItemBox();
			}
		});
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
				cards.show(container, "vision");
			}
		});
		toolBar.add(button_6);
		
		JButton button_4 = new JButton("护石");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(container, "talisman");
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
		
		
		//UserX Radio Buttons
		JRadioButton rdbtnUser_1 = new JRadioButton("User1");
		rdbtnUser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.useroffset = Main.user1offset;
				Main.emptySpaceInEquipBoxOffset = 0;
				item.getItemBox();
			}
		});
		buttonGroup.add(rdbtnUser_1);
		rdbtnUser_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		toolBar.add(rdbtnUser_1);
		
		JRadioButton rdbtnUser_2 = new JRadioButton("User2");
		rdbtnUser_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.useroffset = Main.user2offset;
				Main.emptySpaceInEquipBoxOffset = 0;
				item.getItemBox();
			}
		});
		buttonGroup.add(rdbtnUser_2);
		rdbtnUser_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		toolBar.add(rdbtnUser_2);
		
		JRadioButton rdbtnUser_3 = new JRadioButton("User3");
		rdbtnUser_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.useroffset = Main.user3offset;
				Main.emptySpaceInEquipBoxOffset = 0;
				item.getItemBox();
			}
		});
		buttonGroup.add(rdbtnUser_3);
		rdbtnUser_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		toolBar.add(rdbtnUser_3);
		
		rdbtnUser_1.setSelected(true);
		
		//<--------item Panel--------->//
		JAutoCompleteComboBox cbItems = new JAutoCompleteComboBox();
		cbItems.setBounds(48, 31, 225, 26);
		itemPanel.add(cbItems);
		item.parseItemList();
		cbItems.addItem("(选择物品)");
		for (int i=0; i<item.itemList.length; i++)
			cbItems.addItem(item.itemList[i]);
		
		JTextField tf_itemNum = new JTextField();
		tf_itemNum.setBounds(295, 31, 85, 26);
		tf_itemNum.setText("0");
		tf_itemNum.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		          //getToolkit().beep();
		          e.consume();
		        }
		      }
		    });
		itemPanel.add(tf_itemNum);
		
		JButton btn_add_item = new JButton("添加物品");
		btn_add_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemStr = cbItems.getSelectedItem().toString();
				int itemId = 0;
				for (int i = 0; i < item.itemList.length; i++){
					if (itemStr == item.itemList[i]){
						itemId = i;
					}
				}
				System.out.print(itemId);
				int itemNum = Integer.parseInt(tf_itemNum.getText());
				if (itemId!=0 && itemNum!=0){
					if (item.addItemToBox(itemId, itemNum)) {
						JOptionPane.showMessageDialog(null, "添加成功！");
					}
//					item.itemBox = new item.itemSpace[2300];
//					item.emptySpaceInItemBox = 0;
//					for (int i=0; i<2300; i++){
//						item.itemBox[i] = new item.itemSpace(i, 1);
//					}
					item.rewriteItemBox();
				}
			}
		});
		btn_add_item.setBounds(166, 77, 117, 29);
		itemPanel.add(btn_add_item);
		
		JButton btn_DashG = new JButton("强走药Gx99");
		btn_DashG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (item.addItemToBox(16, 99)) {
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
				item.rewriteItemBox();
			}
		});
		btn_DashG.setBounds(48, 154, 117, 29);
		itemPanel.add(btn_DashG);
		
		JButton btn_MaxPotion = new JButton("秘药x99");
		btn_MaxPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (item.addItemToBox(28, 99)) {
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
				item.rewriteItemBox();
			}
		});
		btn_MaxPotion.setBounds(166, 154, 117, 29);
		itemPanel.add(btn_MaxPotion);
		
		JButton btn_AnciPotion = new JButton("古代秘药x99");
		btn_AnciPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (item.addItemToBox(29, 99)) {
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
				item.rewriteItemBox();
			}
		});
		btn_AnciPotion.setBounds(284, 154, 117, 29);
		itemPanel.add(btn_AnciPotion);
		
		JButton btn_DemonG = new JButton("鬼人药Gx99");
		btn_DemonG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (item.addItemToBox(18, 99)) {
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
				item.rewriteItemBox();
			}
		});
		btn_DemonG.setBounds(48, 184, 117, 29);
		itemPanel.add(btn_DemonG);
		
		JButton btn_LifeDustG = new JButton("生命大粉尘x99");
		btn_LifeDustG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (item.addItemToBox(32, 99)) {
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
				item.rewriteItemBox();
			}
		});
		btn_LifeDustG.setBounds(166, 184, 117, 29);
		itemPanel.add(btn_LifeDustG);
		
		JButton btnx = new JButton("素材玉x99");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (item.addItemToBox(69, 99)) {
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
				item.rewriteItemBox();
			}
		});
		btnx.setBounds(284, 184, 117, 29);
		itemPanel.add(btnx);
		
		JLabel label = new JLabel("快速添加物品：");
		label.setBounds(56, 133, 117, 16);
		itemPanel.add(label);

		
		
				
		//<--------Talisman Panel-------->//
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
		
		JComboBox txtSkill1Num = new JComboBox();
		txtSkill1Num.setBounds(295, 76, 78, 26);
		talismanPanel.add(txtSkill1Num);
		for (int i=14; i>=-10; i--){
			txtSkill1Num.addItem(i);
		}
		txtSkill1Num.setSelectedIndex(14);
		
				
		JComboBox txtSkill2Num = new JComboBox();
		txtSkill2Num.setBounds(295, 115, 78, 26);
		talismanPanel.add(txtSkill2Num);
		for (int i=14; i>=-10; i--){
			txtSkill2Num.addItem(i);
		}
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
		
		
		//<--------------vision Panel---------------->//
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Panel.background"));
		textPane.setText("使用说明\n1. 请将防具按照(本体,幻化外形)为一组放在第一个箱子的第一行；\n2. 可以幻化二名DLC等防具，射手剑士装可以互相幻化；\n3. 此幻化后，偶数位的防具还在。");
		textPane.setBounds(19, 163, 397, 87);
		visionPanel.add(textPane);
		
		JButton vision1 = new JButton("将第1格防具幻化为第2格防具的外形");
		vision1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipment1Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset] % 32;
				int equipment2Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 36] % 32;
				equipment1Type = (equipment1Type<0)?equipment1Type+32:equipment1Type;
				equipment2Type = (equipment2Type<0)?equipment2Type+32:equipment2Type;
//				System.out.println(equipment1Type);
//				System.out.println(equipment2Type);
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
				} else {
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 4] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 36 + 2];
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 5] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 36 + 3];
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
				int equipment1Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 72] % 32;
				int equipment2Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 108] % 32;
				equipment1Type = (equipment1Type<0)?equipment1Type+32:equipment1Type;
				equipment2Type = (equipment2Type<0)?equipment2Type+32:equipment2Type;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
				} else {
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 72 + 4] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 108 + 2];
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 72 + 5] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 108 + 3];
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
				int equipment1Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 144] % 32;
				int equipment2Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 160] % 32;
				equipment1Type = (equipment1Type<0)?equipment1Type+32:equipment1Type;
				equipment2Type = (equipment2Type<0)?equipment2Type+32:equipment2Type;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
				} else {
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 144 + 4] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 180 + 2];
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 144 + 5] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 180 + 3];
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
				int equipment1Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 216] % 32;
				int equipment2Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 252] % 32;
				equipment1Type = (equipment1Type<0)?equipment1Type+32:equipment1Type;
				equipment2Type = (equipment2Type<0)?equipment2Type+32:equipment2Type;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
				} else {
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 216 + 4] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 252 + 2];
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 216 + 5] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 252 + 3];
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
				int equipment1Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 288] % 32;
				int equipment2Type = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 324] % 32;
				equipment1Type = (equipment1Type<0)?equipment1Type+32:equipment1Type;
				equipment2Type = (equipment2Type<0)?equipment2Type+32:equipment2Type;
				if (equipment1Type < 1 || equipment1Type > 5 || equipment2Type < 1 || equipment2Type > 5) {
					JOptionPane.showMessageDialog(null, "失败！请按照说明放好防具");
					return;
				} else {
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 288 + 4] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 324 + 2];
					Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 288 + 5] = Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 324 + 3];
					JOptionPane.showMessageDialog(null, "幻化成功");
					return;
				}
			}
		});
		vision5.setBounds(92, 136, 266, 29);
		visionPanel.add(vision5);

	}
}
