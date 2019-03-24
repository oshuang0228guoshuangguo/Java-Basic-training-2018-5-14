package com.shop.JFrame;
/***����Ա�޸���Ʒ��Ϣ����***/

import com.shop.user.*;
import com.shop.admin.*;
import com.shop.index.*;
import com.shop.mysql.*;
import com.shop.other.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import static java.lang.System.out;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.concurrent.TimeUnit;
import com.shop.JFrame.*;
import com.shop.JFrame.AdminSelect;
import com.shop.JFrame.UserLogin;
import com.shop.JFrame.UserSelect;
import com.shop.JFrame.UserRegion.Myaction;

public class AdminGoodsUpdate extends JFrame {
	static Connection conn;	//����Connection����
	static PreparedStatement pres;	//�����ݿⷢ��SQL���
	static ResultSet res;	//ִ�����ݿ��ѯ
	private String adminname;
	private final JPanel contenctPanel = new JPanel();
	
	private final JTextField field = new JTextField(10);
	private final JTextField field1 = new JTextField(10);
	private final JTextField field2 = new JTextField(10);
	private final JTextField field3 = new JTextField(10);
	private final JTextField field4 = new JTextField(10);
	private final JTextField field5 = new JTextField(10);

	//private final JPasswordField password = new JPasswordField();//�����ı���
	
	private final JLabel label = new JLabel();
	private final JLabel label0 = new JLabel();
	private final JLabel label1 = new JLabel();
	private final JLabel label2 = new JLabel();
	private final JLabel label3 = new JLabel();
	private final JLabel label4 = new JLabel();
	private final JLabel label5 = new JLabel();
	private final JLabel label6 = new JLabel();
	private final JLabel label7 = new JLabel();
	private final JLabel label8 = new JLabel();

	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box0 = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	private final Box box5 = Box.createHorizontalBox();
	private final Box box6 = Box.createHorizontalBox();
	private final Box box7 = Box.createHorizontalBox();
	private final Box box8 = Box.createHorizontalBox();
	private final Box box9 = Box.createHorizontalBox();
	private final Box box10 = Box.createHorizontalBox();
	private final Box box11 = Box.createHorizontalBox();
	
	private JTextArea text= new JTextArea();
	
	public void getName(String name) {
		this.adminname = name;
	}
	
	public AdminGoodsUpdate(String adminname) {
		setTitle("��ӭʹ��  Hern  �����̳�");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    ��   ��   ��   ��");
		label.setFont(new Font("΢���ź�",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("��  ��  ��  Ʒ  ��  Ϣ  ��  ��\n");
		label0.setFont(new Font("΢���ź�",1,25));
		
		label1.setText("��ӭ  " + adminname + "  ����Ա");
		label1.setFont(new Font("΢���ź�",0,20));
		
		text.setSize(800, 800);
		DBconnection db = new DBconnection();
		conn = db.getConn();
		try{
			pres = conn.prepareStatement("select * from goods ");
			res = pres.executeQuery();
			text.append("---- �� Ʒ �� �� ----"+" ��  Ʒ  ��  �� ----" + " �� Ʒ �� �� �� �� ----"+" �� Ա �� �� ----" + " �� �� Ա �� �� ----" + " �� Ʒ �� �� ----"+"\n");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				String date = res.getString("goodsDate");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				BigDecimal money = res.getBigDecimal("goodsMoney");
				int num = res.getInt("goodsNum");
				text.append("\n          "+id+"\t "+name+"\t     "+date+"\t           "+vipmoney+"\t        "+money+"  \t        "+num+"\n");
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(800, 800);
		
		label2.setText("�������е���Ʒ��Ϣ��");
		label2.setFont(new Font("΢���ź�",0,18));
		
		label3.setText("���� �� Ҫ �� �� �� �� Ʒ �� �ţ�");
		label3.setFont(new Font("΢���ź�",0,18));
		label4.setText("�� �� �� Ҫ  ��  ��  �� Ʒ �� �ƣ�");
		label4.setFont(new Font("΢���ź�",0,18));
		label5.setText("�� �� �� Ҫ  ��  ��  �� �� �� �ڣ�");
		label5.setFont(new Font("΢���ź�",0,18));
		label6.setText("�� �� �� Ҫ  ��  ��  �� Ա �� ��");
		label6.setFont(new Font("΢���ź�",0,18));
		label7.setText("�� �� �� Ҫ  ��  �� �� ��Ա�۸�");
		label7.setFont(new Font("΢���ź�",0,18));
		label8.setText("�� �� �� Ҫ  ��  ��  �� Ʒ �� ����");
		label8.setFont(new Font("΢���ź�",0,18));
		
		button.setText("��  ��  ��  ��");
		button.setFont(new Font("΢���ź�",1,18));
		button.addActionListener(new Myaction());
		
		button1.setText("���ع���Ա����������");
		button1.setFont(new Font("΢���ź�",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					AdminSelect select = new AdminSelect(adminname);
					select.getName(adminname);
					
				}
			}			
		});
		
		box.add(label);
		box1.add(label0);
		box2.add(label1);
		box3.add(scroll);
		box4.add(label2);
		box5.add(label3);
		box5.add(field);
		box6.add(label4);
		box6.add(field1);
		box7.add(label5);
		box7.add(field2);
		box8.add(label6);
		box8.add(field3);
		box9.add(label7);
		box9.add(field4);
		box10.add(label8);
		box10.add(field5);
		box11.add(button);
		box11.add(button1);
		
		base.add(box);
		base.add(Box.createVerticalStrut(10));
		base.add(box0);
		base.add(Box.createVerticalStrut(10));
		base.add(box1);
		base.add(Box.createVerticalStrut(10));
		base.add(box2);
		base.add(Box.createVerticalStrut(10));
		base.add(box3);
		base.add(Box.createVerticalStrut(30));
		base.add(box4);
		base.add(Box.createVerticalStrut(30));
		base.add(box5);
		base.add(Box.createVerticalStrut(30));
		base.add(box6);
		base.add(Box.createVerticalStrut(30));
		base.add(box7);
		base.add(Box.createVerticalStrut(30));
		base.add(box8);
		base.add(Box.createVerticalStrut(30));
		base.add(box9);
		base.add(Box.createVerticalStrut(30));
		base.add(box10);
		base.add(Box.createVerticalStrut(40));
		base.add(box11);
		base.add(Box.createVerticalStrut(40));
		
		contenctPanel.add(base);
		add(contenctPanel);
		setVisible(true);
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBgoodsUP up = new DBgoodsUP();
			DBgoodsId id = new DBgoodsId();
			int goodsid = Integer.parseInt(field.getText());
			String name = field1.getText();
			String date = field2.getText();
			BigDecimal vip = new BigDecimal(field3.getText());
			BigDecimal money = new BigDecimal(field4.getText());
			int num = Integer.parseInt(field5.getText());
			if(goodsid < 1 || id.getgoodsID(goodsid) != goodsid || id.getgoodsID(goodsid) == 0) {
				JOptionPane.showMessageDialog(null,"�������Ʒ��Ų����ڣ�", "����",JOptionPane.ERROR_MESSAGE); 
				field.setText("");
				field1.setText("");
				field2.setText("");
				field3.setText("");
				field4.setText("");
				field5.setText("");
			}else {
				up.setupgoodsName(goodsid, name);
				up.setupgoodsDate(goodsid, date);
				up.setupgoodsVIPmoney(goodsid, vip);
				up.setupgoodsMoney(goodsid, money);
				up.setupgoodsNum(goodsid, num);
				JOptionPane.showMessageDialog(null, goodsid + "  ����Ʒ�޸ĳɹ�", "�޸ĳɹ�",JOptionPane.DEFAULT_OPTION);
				dispose();
				AdminGoodsUpdate Up = new AdminGoodsUpdate(adminname);
			}
		}
		
	}
}