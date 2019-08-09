package com.newer.caculator;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

import java.awt.SystemColor;

public class ViewUi extends JFrame {

	private JLabel label=new JLabel("0");
//	private JLabel downLabel=new JLabel("");
	private JPanel contentPane;
	private JPanel northPanel;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					ViewUi frame = new ViewUi();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("null")
	public ViewUi() {
		setTitle("\u8BA1\u7B97\u5668");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,400, 550);
		
		Init();
		
		}
		
	/**
	 *  初始化面板和按钮
	 *  
	 */
	public void Init() {
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		setContentPane(contentPane);

		setResizable(false);//大小不能改变

		JPanel northPanel=new JPanel();
		
		northPanel.setBackground(Color.WHITE);
		northPanel.setPreferredSize(new Dimension(400, 100));
		contentPane.add(northPanel,BorderLayout.NORTH);
		
		//设置标签
		label.setFont(new Font("仿宋", Font.PLAIN, 30));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setPreferredSize(new Dimension(300,30));
		northPanel.add(label,BorderLayout.NORTH);
		
//		downLabel.setFont(new Font("仿宋", Font.PLAIN, 31));
//		downLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		downLabel.setPreferredSize(new Dimension(300,30));
//		northPanel.add(downLabel,BorderLayout.SOUTH);
		
		
		
		
		
		panel=new JPanel();
		
		contentPane.add(panel,BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(5, 4));
		
		
		String[] number= {"*","/","0","清除",
						  "1","2","3","+",
						  "4","5","6","-",
						  "7","8","9","=",};
	
		String[] redButton= {"*","/","-","+","="};
		JButton[] nButton=new JButton[number.length];
		ButListener listener=new ButListener();
		for(int i=0;i<number.length;i++) {
			JButton b=new JButton(number[i]);
			b.setPreferredSize(new Dimension(100, 100));
			b.setBackground(Color.black);
			listener.setLabel(label);
			b.addActionListener(listener);
			
			Arrays.sort(redButton);
			if(Arrays.binarySearch(redButton, number[i])>=0) {
				b.setForeground(Color.red);	
			}else {
				b.setForeground(Color.BLUE);
			}
			nButton[i]=b;
			panel.add(b);
		
		}
		
//		JButton[] buttons = new JButton[20];//定义按钮数组
//		
//		ButListener listener=new ButListener();
//		
//			
//		for(int i=0;i<number.length;i++) {
//			buttons[i]=new JButton(number[i]);
//			
//			buttons[i].setBackground(Color.black);
//			buttons[i].setFont(new Font("宋体", Font.PLAIN, 20));
//			buttons[i].setForeground(Color.WHITE);
//			
//			//设置按钮大小
//			buttons[i].setPreferredSize(new Dimension(100, 100));
//			
//			listener.setLabel(label);
////			listener.setDownLabel(downLabel);
//			buttons[i].addActionListener(listener);//按钮添加监听器
//			
//			panel.add(buttons[i]);//把按钮添加到面板上
//		
//		}
		
	}
}

