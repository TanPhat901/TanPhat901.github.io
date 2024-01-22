package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Card2;

public class ControCard2 implements ActionListener {
	private Card2 card2;

	public ControCard2(Card2 card2) {
		this.card2 = card2;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button2 =e.getActionCommand();
		if(button2.equals("Thêm")) {
			this.card2.themtd();
		}
		if(button2.equals("Xóa")) {
			this.card2.xoatd();
		}
		if(button2.equals("Sửa")) {
			this.card2.suatd();
		}
		if(button2.equals("Lưu")) {
			this.card2.luutd();
		}
	}
}