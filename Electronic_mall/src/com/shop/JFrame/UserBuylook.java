package com.shop.JFrame;
/***�û��鿴������Ʒ����***/

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
import com.shop.JFrame.UserSelect;
import com.shop.JFrame.UserRegion.Myaction;

public class UserBuylook extends JFrame {
	static Connection conn;	//����Connection����
	static PreparedStatement pres;	//�����ݿⷢ��SQL���
	static ResultSet res;	//ִ�����ݿ��ѯ
	
	private final JPanel contenctPanel = new JPanel();
	
	private final JTextField field = new JTextField(10);
	private final JTextField field1 = new JTextField(10);
	
	private final JLabel label = new JLabel();
	private final JLabel label0 = new JLabel();
	private final JLabel label1 = new JLabel();
	private final JLabel label2 = new JLabel();
	private final JLabel label3 = new JLabel();
	private final JLabel label4 = new JLabel();

	private final JButton button = new JButton();
	private final JButton button1 = new JButton();
	
	private final Box base = Box.createVerticalBox();
	private final Box box = Box.createHorizontalBox();
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createHorizontalBox();
	private final Box box3 = Box.createHorizontalBox();
	private final Box box4 = Box.createHorizontalBox();
	private final Box box5 = Box.createHorizontalBox();
	private final Box box6 = Box.createHorizontalBox();
	private final Box box7 = Box.createHorizontalBox();
	private JTextArea text= new JTextArea();
	
	private String username;
	
	public void getName(String name) {
		this.username = name;
	}
	
	public UserBuylook(String username) {
		setTitle("��ӭʹ��  Hern  �����̳�");
		setBounds(300,100,900,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contenctPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		contenctPanel.setBackground(Color.WHITE);
		label.setText("H e r n    ��   ��   ��   ��");
		label.setFont(new Font("΢���ź�",1,32));
		label.setForeground(Color.BLUE);
		
		label0.setText("��  ��  ��  ��  ��  ��  ��\n");
		label0.setFont(new Font("΢���ź�",1,25));
		
		
		label1.setText("��ӭ  " + username + "  VIP�û�");
		label1.setFont(new Font("΢���ź�",0,20));
		
		DBconnection db = new DBconnection();
		conn = db.getConn();
		
		try{
			pres = conn.prepareStatement("select * from cost where userName = ?");
			pres.setString(1, username);
			res = pres.executeQuery();
			text.append("\t\t---- �� Ʒ �� �� ----"+" ��  Ʒ  ��  �� ----" + " �� Ʒ �� �� ----"+" �� �� �� �� ----" + " �� Ʒ �� �� �� �� ----");
			while(res.next()){
				int id = res.getInt("goodsID");
				String name = res.getString("goodsName");
				BigDecimal vipmoney = res.getBigDecimal("goodsVIPmoney");
				int num = res.getInt("goodsNum");
				BigDecimal usercost = res.getBigDecimal("userCost");
				text.append("\n\t\t\t"+id+"\t        "+name+"\t      "+vipmoney+"\t\t"+num+"\t\t"+usercost+"\t");
			}
			res.close();
			pres.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JScrollPane scroll = new JScrollPane(text);
		scroll.setSize(800, 800);
		
		label2.setText("�𾴵� "+username+"  VIP�û������������еĹ����¼��");
		label2.setFont(new Font("΢���ź�",0,18));
		button.setText("�� �� �� �� ��");
		button.setFont(new Font("΢���ź�",0,18));
		button.addActionListener(new Myaction());
		
		button1.setText("�����û�����ѡ�����");
		button1.setFont(new Font("΢���ź�",1,18));
		button1.setBorderPainted(false);
		button1.setBackground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == button1) {
					dispose();
					UserSelect select = new UserSelect(username);
					select.getName(username);
					
				}
			}			
		});
		
		box.add(label);
		box1.add(label0);
		box2.add(label1);
		box3.add(scroll);
		box4.add(label2);
		box5.add(button);
		box5.add(button1);
		
		base.add(box);
		base.add(Box.createVerticalStrut(20));
		base.add(box1);
		base.add(Box.createVerticalStrut(20));
		base.add(box2);
		base.add(Box.createVerticalStrut(20));
		base.add(box3);
		base.add(Box.createVerticalStrut(20));
		base.add(box4);
		base.add(Box.createVerticalStrut(30));
		base.add(box5);
		base.add(Box.createVerticalStrut(40));
		
		contenctPanel.add(base);
		add(contenctPanel);
		setVisible(true);
	}
	
	class Myaction extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			DBcostDel costdel = new DBcostDel();
			costdel.Costdel(username);
			JOptionPane.showMessageDialog(null, "�� �� �� �� �� ��", "�ɹ�",JOptionPane.DEFAULT_OPTION); 
		}
		
	}
}