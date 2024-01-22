package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TimKiem;

public class ControTimKiem implements ActionListener {
	private TimKiem timkiem;
	
	public ControTimKiem(TimKiem timkiem) {
		this.timkiem = timkiem;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button =e.getActionCommand();
		if(button.equals("Tìm Kiếm Cầu Thủ")) {
			this.timkiem.timkiemmaCT();
		}
		if(button.equals("Tìm Kiếm Nhân Viên")) {
			this.timkiem.timkiemmaNV();
		}

	}

}
