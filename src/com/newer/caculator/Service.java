package com.newer.caculator;



public class Service {
	private boolean isSecondNum = false;
	private String lastOp;
	private String firstNum = "0";
	private String secondNum = null;

	private String numString = "0123456789";
	private String opString = "+-*/";

	/**
	 * 获取数字
	 * @param cmd
	 * @param label
	 * @return
	 */
	public String catNum(String cmd, String label) {
		String result = cmd;
		// 如果label不等于0
		if (!"0".equals(label)) {
			if (isSecondNum) {
				isSecondNum = false;
			} else {
				result = label + result;
			}

		}
		return result;

	}

	public String setOp(String cmd, String label) {
		this.lastOp = cmd;
		this.firstNum = label;
		this.secondNum = null;
		this.isSecondNum = true;
		return cmd;

	}

	// 除数为0
	public String cal(String label, boolean isPercent) {
		double secondResult = secondNum == null ? Double.valueOf(label).doubleValue()
				: Double.valueOf(secondNum).doubleValue();

		if (secondResult == 0 && this.lastOp.equals("/")) {
			return "0";
		}


		if (this.lastOp.equals("+")) {
			firstNum = String.valueOf(Maths.add(Double.valueOf(firstNum), secondResult));
		} else if (this.lastOp.equals("-")) {
			firstNum = String.valueOf(Maths.subtract(Double.valueOf(firstNum), secondResult));

		} else if (this.lastOp.equals("*")) {
			firstNum = String.valueOf(Maths.multiply(Double.valueOf(firstNum), secondResult));

		} else if (this.lastOp.equals("/")) {
			firstNum = String.valueOf(Maths.divide(Double.valueOf(firstNum), secondResult));
		}
		secondNum = secondNum == null ? label : secondNum;
		this.isSecondNum = true;
		return firstNum;
	}

	// 正负
	public String setNegative(String text) {
		if (text.indexOf("-") == 0) {
			return text.substring(1, text.length());
		} else {
			return "-" + text;
		}
	}

	private String back() {
		// TODO Auto-generated method stub
		
		return "0";
	}
//	Service service=new Service();

	public String callMethod(String cmd, String text) {

		if (numString.indexOf(cmd) != -1) {
			return catNum(cmd, text);//获得数字
		} else if (opString.indexOf(cmd) != -1) {
			return setOp(cmd, text);//获得符号
		} else if (cmd.equals("+/-")) {
			return setNegative(text); // 设置正负号
		} else if (cmd.equals("=")) {
			return cal(text, false);
		}else if(cmd.equals("清除")) {
			return back();
			
		}
		return null;

	}


}
