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
import java.nio.charset.StandardCharsets;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class View2 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tf_hunterName;
	private JTextField tf_money;
	private JTextField tf_HR;
	private JTextField tf_AP;
	private JComboBox cb_voice;
	private JComboBox cb_gender;

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
	
	public void reload() {
		Main.emptySpaceInEquipBoxOffset = 0;
		item.getItemBox();
		tf_hunterName.setText(getHunterName());
		tf_money.setText(""+getMoney());
		tf_HR.setText(""+getHR());
		tf_AP.setText(""+getAP());
		cb_voice.setSelectedIndex(getVoice());
		cb_gender.setSelectedIndex(getGender());
	}
	
	public String getHunterName(){
		String name = "";
		byte[] byteArray = new byte[32];
		for (int i=0; i<32; i++){
			byteArray[i] = Main.buffer[Main.useroffset + 146301 + i];
		}
		name = new String(byteArray, StandardCharsets.UTF_8);
		return name;
	}
	
	public void setHunterName(String name){
		if (name.length()>10){
			name = name.substring(0, 10);
		}
		byte[] b = name.getBytes(StandardCharsets.UTF_8);
		for (int i=0; i<32; i++){
			if (i < b.length){
				Main.buffer[Main.useroffset + i] = b[i];
				Main.buffer[Main.useroffset + i + 146301] = b[i];
			} else {
				Main.buffer[Main.useroffset + i] = (byte)0;
				Main.buffer[Main.useroffset + i + 146301] = (byte)0;
			}
		}
	}
	
	public int getHR(){
		int a = Main.buffer[Main.useroffset + 10254] & 0xff;
		int b =	Main.buffer[Main.useroffset + 10253] & 0xff;
		int c = Main.buffer[Main.useroffset + 10252] & 0xff;
		int d = Main.buffer[Main.useroffset + 10251] & 0xff;
		return (a*16*16*16*16*16*16 + b*16*16*16*16 + c*16*16 + d)/3000 + 9;
		//return (Main.buffer[Main.useroffset + 40] & 0xff)  + (Main.buffer[Main.useroffset + 41] & 0xff) * 16 * 16;
	}
	
	public void setHR(int hr){
		Main.buffer[Main.useroffset + 40] = (byte)(hr%(16*16));
		Main.buffer[Main.useroffset + 41] = (byte)(hr/(16*16));
		int hrpts = (hr-9)*3000;
		Main.buffer[Main.useroffset + 10251] = (byte)(hrpts%(16*16));
		Main.buffer[Main.useroffset + 10252] = (byte)((hrpts/(16*16)) % (16*16));
		Main.buffer[Main.useroffset + 10253] = (byte)((hrpts/(16*16*16*16)) % (16*16));
		Main.buffer[Main.useroffset + 10254] = (byte)(hrpts/(16*16*16*16*16*16));
	}
	
	public int getMoney(){
		int a = Main.buffer[Main.useroffset + 10258] & 0xff;
		int b =	Main.buffer[Main.useroffset + 10257] & 0xff;
		int c = Main.buffer[Main.useroffset + 10256] & 0xff;
		int d = Main.buffer[Main.useroffset + 10255] & 0xff;
		return a*16*16*16*16*16*16 + b*16*16*16*16 + c*16*16 + d;
	}
	
	public void setMoney(int money){
		int a = money/(16*16*16*16*16*16);
		int b = (money/(16*16*16*16)) % (16*16);
		int c = (money/(16*16)) % (16*16);
		int d = money % (16*16);
		Main.buffer[Main.useroffset + 39] = (byte)a;
		Main.buffer[Main.useroffset + 38] = (byte)b;
		Main.buffer[Main.useroffset + 37] = (byte)c;
		Main.buffer[Main.useroffset + 36] = (byte)d;
		Main.buffer[Main.useroffset + 10258] = (byte)a;
		Main.buffer[Main.useroffset + 10257] = (byte)b;
		Main.buffer[Main.useroffset + 10256] = (byte)c;
		Main.buffer[Main.useroffset + 10255] = (byte)d;
	}

	public int getAP(){
		int a = Main.buffer[Main.useroffset + 10266] & 0xff;
		int b =	Main.buffer[Main.useroffset + 10265] & 0xff;
		int c = Main.buffer[Main.useroffset + 10264] & 0xff;
		int d = Main.buffer[Main.useroffset + 10263] & 0xff;
		return a*16*16*16*16*16*16 + b*16*16*16*16 + c*16*16 + d;
	}
	
	public void setAP(int ap){
		int a = ap/(16*16*16*16*16*16);
		int b = (ap/(16*16*16*16)) % (16*16);
		int c = (ap/(16*16)) % (16*16);
		int d = ap % (16*16);
		Main.buffer[Main.useroffset + 10266] = (byte)a;
		Main.buffer[Main.useroffset + 10265] = (byte)b;
		Main.buffer[Main.useroffset + 10264] = (byte)c;
		Main.buffer[Main.useroffset + 10263] = (byte)d;
	}
	
	public int getGender(){
		return Main.buffer[Main.useroffset + 146251] & 0xff; //580
	}
	
	public void setGender(int i){
		Main.buffer[Main.useroffset + 580] = (byte)i;
		Main.buffer[Main.useroffset + 146251] = (byte)i;
	}
	
	public int getVoice(){
		return Main.buffer[Main.useroffset + 146248] & 0xff - 1; //580
	}
	
	public void setVoice(int i){
		Main.buffer[Main.useroffset + 577] = (byte)(i+1);
		Main.buffer[Main.useroffset + 146248] = (byte)(i+1);
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
		otherPanel.setLayout(null);
		
		container.add(itemPanel, "item");
		itemPanel.setLayout(null);
		container.add(weaponPanel, "weapon");
		container.add(equipmentPanel, "equipment");
		container.add(visionPanel, "vision");
		container.add(talismanPanel, "talisman");
		cards.show(container, "other");
		frame.getContentPane().add(container, BorderLayout.CENTER);
		visionPanel.setLayout(null);
		talismanPanel.setLayout(null);
		
		
		talisman tsm = new talisman();
		JButton button_0 = new JButton("综合");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(container, "other");
			}
		});
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
		button_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
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
		if ((int)Main.buffer[4] == 0){
			rdbtnUser_1.setEnabled(false);
		}
		rdbtnUser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.useroffset = Main.user1offset;
				reload();
			}
		});
		buttonGroup.add(rdbtnUser_1);
		rdbtnUser_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		toolBar.add(rdbtnUser_1);
		
		JRadioButton rdbtnUser_2 = new JRadioButton("User2");
		if ((int)Main.buffer[5] == 0){
			rdbtnUser_2.setEnabled(false);
		}
		rdbtnUser_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.useroffset = Main.user2offset;
				reload();
			}
		});
		buttonGroup.add(rdbtnUser_2);
		rdbtnUser_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		toolBar.add(rdbtnUser_2);
		
		JRadioButton rdbtnUser_3 = new JRadioButton("User3");
		if ((int)Main.buffer[6] == 0){
			rdbtnUser_3.setEnabled(false);
		}
		rdbtnUser_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.useroffset = Main.user3offset;
				reload();
			}
		});
		buttonGroup.add(rdbtnUser_3);
		rdbtnUser_3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		toolBar.add(rdbtnUser_3);
		
		rdbtnUser_1.setSelected(true);
		
		//<-----------------------------------------------------otherPanel--------------------------------------------------------------------->//
		
		JLabel lbl_hn = new JLabel("猎人名：");
		lbl_hn.setBounds(119, 23, 52, 16);
		otherPanel.add(lbl_hn);
		
		JLabel lbl_time = new JLabel("游戏时间：");
		lbl_time.setBounds(224, 163, 71, 16);
		otherPanel.add(lbl_time);
		
		JLabel lbl_money = new JLabel("金钱：");
		lbl_money.setBounds(46, 117, 61, 16);
		otherPanel.add(lbl_money);
		
		JLabel lbl_HR = new JLabel("HR:");
		lbl_HR.setBounds(46, 163, 61, 16);
		otherPanel.add(lbl_HR);
		
		JLabel lbl_AP = new JLabel("农场点：");
		lbl_AP.setBounds(224, 117, 61, 16);
		otherPanel.add(lbl_AP);
		
		JLabel lbl_sound = new JLabel("声音：");
		lbl_sound.setBounds(224, 72, 61, 16);
		otherPanel.add(lbl_sound);
		
		JLabel lbl_gender = new JLabel("性别：");
		lbl_gender.setBounds(46, 72, 61, 16);
		otherPanel.add(lbl_gender);
		
		tf_hunterName = new JTextField();
		tf_hunterName.setText(getHunterName());
//		tf_hunterName.addKeyListener(new KeyAdapter() {
//		    public void keyTyped(KeyEvent e) {
//		        char c = e.getKeyChar();
//		        if (!(tf_hunterName.getText().length() <= 10 || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
//		          //getToolkit().beep();
//		          e.consume();
//		        }
//		      }
//		    });
		tf_hunterName.setBounds(171, 18, 130, 26);
		otherPanel.add(tf_hunterName);
		tf_hunterName.setColumns(10);
		
		tf_money = new JTextField();
		tf_money.setBounds(82, 112, 109, 26);
		tf_money.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		          //getToolkit().beep();
		          e.consume();
		        }
		      }
		    });
		tf_money.setText(""+getMoney());
		otherPanel.add(tf_money);
		tf_money.setColumns(10);
		
		tf_HR = new JTextField();
		tf_HR.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		          //getToolkit().beep();
		          e.consume();
		        }
		      }
		    });
		tf_HR.setText(""+getHR());
		tf_HR.setBounds(82, 158, 109, 26);
		
		otherPanel.add(tf_HR);
		tf_HR.setColumns(10);
		
		tf_AP = new JTextField();
		tf_AP.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
		          //getToolkit().beep();
		          e.consume();
		        }
		      }
		    });
		tf_AP.setBounds(286, 112, 109, 26);
		tf_AP.setText(""+getAP());
		otherPanel.add(tf_AP);
		tf_AP.setColumns(10);
		
		cb_gender = new JComboBox();
		cb_gender.setBounds(82, 68, 71, 27);
		cb_gender.addItem("男");
		cb_gender.addItem("女");
		cb_gender.setSelectedIndex(getGender());
		otherPanel.add(cb_gender);
		
		cb_voice = new JComboBox();
		for (int i=1; i<=20; i++){
			cb_voice.addItem(""+i);
		}
		cb_voice.setSelectedIndex(getVoice());
		cb_voice.setBounds(284, 68, 71, 27);
		otherPanel.add(cb_voice);
		
		JButton btn_apply = new JButton("应用");
		btn_apply.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btn_apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setHunterName(tf_hunterName.getText());
				setMoney(Integer.parseInt(tf_money.getText())%10000000);
				setAP(Integer.parseInt(tf_AP.getText())%10000000);
				setHR(Integer.parseInt(tf_HR.getText())%1000);
				setGender(cb_gender.getSelectedIndex());
				setVoice(cb_voice.getSelectedIndex());
				JOptionPane.showMessageDialog(null, "不要忘记按右上角保存哦");
			}
		});
		btn_apply.setBounds(166, 199, 117, 29);
		otherPanel.add(btn_apply);
		
		//<--------------------------------------------------item Panel--------------------------------------------------->//
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

		
		
				
		//<-------------------------------------------------Talisman Panel-------------------------------------------------->//
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
		for (int i=-10; i<15; i++){
			txtSkill1Num.addItem(i);
		}
		txtSkill1Num.setSelectedIndex(11);
		
				
		JComboBox txtSkill2Num = new JComboBox();
		txtSkill2Num.setBounds(295, 115, 78, 26);
		talismanPanel.add(txtSkill2Num);
		for (int i=-10; i<15; i++){
			txtSkill2Num.addItem(i);
		}
		txtSkill2Num.setSelectedIndex(10);
		
		
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
				
				int sk1Num = txtSkill1Num.getSelectedIndex() - 10;
				if (sk1Num == 0){	
					JOptionPane.showMessageDialog(null, "请填写技能1点数");
					return;
				}
				int sk2Num = txtSkill2Num.getSelectedIndex() - 10;
				
				int slot = cbSlot.getSelectedIndex();
				
				talisman.addtalisman(typeCode, sk1Code, sk2Code, sk1Num, sk2Num, slot);		
				
			}
		});
		btnAddtalisman.setBounds(256, 193, 117, 29);
		talismanPanel.add(btnAddtalisman);
		
		
		//<-------------------------------------------------vision Panel--------------------------------------------------->//
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Panel.background"));
		textPane.setText("使用说明\n1. 请将防具按照(本体,幻化外形)为一组放在第一个箱子的第一行；\n2. 可以幻化二名DLC等防具，射手剑士装可以互相幻化；\n3. 此幻化后，偶数位的防具还在。");
		textPane.setBounds(19, 163, 397, 87);
		visionPanel.add(textPane);
		
		JButton vision1 = new JButton("将第1格防具幻化为第2格防具的外形");
		vision1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int equipment1Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset] & 0xff) % 32;
				int equipment2Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 36] & 0xff) % 32;
				equipment1Type = (equipment1Type<0)?equipment1Type+32:equipment1Type;
				equipment2Type = (equipment2Type<0)?equipment2Type+32:equipment2Type;
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
				int equipment1Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 72] & 0xff) % 32;
				int equipment2Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 108] & 0xff) % 32;
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
				int equipment1Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 144] & 0xff) % 32;
				int equipment2Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 180] & 0xff) % 32;
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
				int equipment1Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 216] & 0xff) % 32;
				int equipment2Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 252] & 0xff) % 32;
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
				int equipment1Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 288] & 0xff) % 32;
				int equipment2Type = (Main.buffer[Main.useroffset + Main.equipmentBoxOffset + 324] & 0xff) % 32;
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
