package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Card4;

public class ControCard4 implements ActionListener{
	private Card4 card4;
	
	public ControCard4(Card4 card4) {
		this.card4 = card4;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button4t =e.getActionCommand();
		if(button4t.equals("Thêm")) {
			this.card4.themct();
		}
		if(button4t.equals("Sửa")) {
			this.card4.suact();
		}
		if(button4t.equals("Xoá")) {
			this.card4.xoact();
		}
		if(button4t.equals("Lưu")) {
			this.card4.luuct();
		}
		
	}

}