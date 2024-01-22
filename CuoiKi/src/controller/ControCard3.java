package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Card3;

public class ControCard3 implements ActionListener {
	private Card3 card3;
	
	public ControCard3(Card3 card3) {
		this.card3 = card3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();
		if(button.equals("Thêm")) {
			this.card3.them();
		}
		if(button.equals("Sửa")) {
			this.card3.suanv();
		}
		if(button.equals("Xoá")) {
			this.card3.xoanv();
		}
		if(button.equals("Lưu")) {
			this.card3.luunv();
		}
	}

}