package com.newer.caculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;




public class ButListener implements ActionListener {
	
	JButton[] buttons = new JButton[20];
	JLabel label = new JLabel();
	Service service=new Service();
	
	char fuhao;
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	int t = 1;

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		String result=null;
//		char c = command.charAt(0);
//		if (c >= '0' && c <= '9') {
//			t = 0;
//			label.setText(label.getText() + command);
//
//		}
//
//		else if (t == 0 && command == "+") {
//			t = 1;
//	label.setText(label.getText() + command);
//			result=service.callMethod(command,label.getText());
//
//		
//
//		} else if (t == 0 && command == "-") {
//			t = 1;
//
//			label.setText(label.getText() + command);
//
//		} else if (t == 0 && command == "*") {
//			t = 1;
//
//			label.setText(label.getText() + command);
//
//		} else if (t == 0 && command == "/") {
//			t = 1;
//
//			label.setText(label.getText() + command);
//
//		} else if (t == 0 && c == '=') {
//
//			label.setText(label.getText() + command);
//
//			t = 2;
//		}
//
//		else if (c == '清') { // 清除功能
//			label.setText("");
//			t = 1;
//		}
		
		try {
			
			result=service.callMethod(command,label.getText());
		}
		catch(Exception e2) {
			System.out.println(e2.getMessage());
		}
		
		//显示计算结果
		if(result!=null) {
			label.setText(result);

	}

	
		
	}
	
	
}

//怎么在字符串中分别提取2组数字？
