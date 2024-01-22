package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.DaoCard2;
import controller.ControCard2;
import model.ModelCard2;
public class Card2 extends JPanel {
	public JTextField tf_MaTran;
	public JComboBox cbo_Doi1;
	public JComboBox cbo_Doi2;
	public JTextField tf_TiSo;
	public JTextField tf_tg;
	public JComboBox cbo_san;
	public DefaultTableModel dm;
	public JTable tbl;
	
	public Card2() {
		setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Trận đấu");

		// các nút nhập dữ liệu
		JLabel lb_MaTran = new JLabel("Mã Trận Đấu");
		tf_MaTran = new JTextField(20);
		JLabel lb_Doi1 = new JLabel("Đội Chủ Nhà:");
		String arrdoi1[] = { "Arsenal", "Aston Villa", "Bournemouth", "Brentford", "Brighton & Hove Albion", "Burnley",
				"Chelsea", "Crystal Palace", "Everton", "Fulham", "Liverpool", "Luton Town", "Manchester City",
				"Manchester United", "Newcastle United", "Nottingham Forest", "Sheffield United", "Tottenham Hotspur",
				"West Ham United", "Wolverhampton Wanderers" };
		cbo_Doi1 = new JComboBox(arrdoi1);
		cbo_Doi1.setBackground(Color.white);

		JLabel lb_TiSo = new JLabel("Tỉ Số:");
		tf_TiSo = new JTextField(20);

		JLabel lb_Doi2 = new JLabel("Đội Khách:");
		String arrdoi2[] = { "Arsenal", "Aston Villa", "Bournemouth", "Brentford", "Brighton & Hove Albion", "Burnley",
				"Chelsea", "Crystal Palace", "Everton", "Fulham", "Liverpool", "Luton Town", "Manchester City",
				"Manchester United", "Newcastle United", "Nottingham Forest", "Sheffield United", "Tottenham Hotspur",
				"West Ham United", "Wolverhampton Wanderers" };
		cbo_Doi2 = new JComboBox(arrdoi2);
		cbo_Doi2.setBackground(Color.white);

		JLabel lb_tg = new JLabel("Thời gian:");
		tf_tg = new JTextField(20);

		JLabel lb_san = new JLabel("Sân vận động:");
		String arrsan[] = { "Anfield", "Boleyn Ground", "Bramall Lane", "Brentford Community", "City Ground",
				"Craven Cottage", "Dean Court", "Emirates", "Etihad", "Falmer Stadium", "Goodison Park",
				"Kenilworth Road	", "Molineux", "Old Trafford", "St James' Park", "Selhurst Park", "Stamford Bridge",
				"Tottenham Hotspur", "Turf Moor", "Villa Park" };
		cbo_san = new JComboBox(arrsan);
		cbo_san.setBackground(Color.white);
		// các nút chức năng
		ControCard2 cc2 = new ControCard2(this);
		JButton bt_themtd = new JButton("Thêm");
		bt_themtd.addActionListener(cc2);
		bt_themtd.setIcon(new ImageIcon(Card2.class.getResource("icons8-add-18.png")));
		JButton bt_suatd = new JButton("Sửa");
		bt_suatd.addActionListener(cc2);
		bt_suatd.setIcon(new ImageIcon(Card2.class.getResource("icons8-update-18.png")));
		JButton bt_xoatd = new JButton("Xóa");
		bt_xoatd.addActionListener(cc2);
		bt_xoatd.setIcon(new ImageIcon(Card2.class.getResource("icons8-remove-18.png")));
		JButton bt_luutd = new JButton("Lưu");
		bt_luutd.addActionListener(cc2);
		bt_luutd.setIcon(new ImageIcon(Card2.class.getResource("icons8-save-18.png")));

		// tạo bảng
		dm = new DefaultTableModel();
		dm.addColumn("Mã Trận Đấu");
		dm.addColumn("Đội Chủ Nhà");
		dm.addColumn("Tỉ Số");
		dm.addColumn("Đội Khách");
		dm.addColumn("Sân Vận Động");
		dm.addColumn("Thời Gian");
		tbl = new JTable(dm);
		tbl.setBackground(Color.decode("#F5FFFA"));
		tbl.setFillsViewportHeight(true);

		
		// add nhập dữ liệu
		JPanel pn_trandau = new JPanel();
		pn_trandau.setBackground(Color.decode("#F5FFFA"));
		pn_trandau.setLayout(new GridLayout(7, 2, 10, 10));
		pn_trandau.add(lb_MaTran);
		pn_trandau.add(tf_MaTran);
		pn_trandau.add(lb_Doi1);
		pn_trandau.add(cbo_Doi1);
		pn_trandau.add(lb_TiSo);
		pn_trandau.add(tf_TiSo);
		pn_trandau.add(lb_Doi2);
		pn_trandau.add(cbo_Doi2);
		pn_trandau.add(lb_san);
		pn_trandau.add(cbo_san);
		pn_trandau.add(lb_tg);
		pn_trandau.add(tf_tg);
		
		// add các chức năng
		JPanel panel_chua2td = new JPanel();
		panel_chua2td.setBackground(Color.decode("#F5FFFA"));
		panel_chua2td.setLayout(new FlowLayout());
		panel_chua2td.add(bt_themtd);
		panel_chua2td.add(bt_xoatd);
		panel_chua2td.add(bt_suatd);	
		panel_chua2td.add(bt_luutd);
		// phần nhập và chức năng
		JPanel pn_traitd = new JPanel();
		pn_traitd.setLayout(new GridLayout(2, 0));
		pn_traitd.add(pn_trandau);
		pn_traitd.add(panel_chua2td);
		pn_traitd.setBorder(titlebor2);
		pn_traitd.setBackground(Color.cyan);
		add(pn_traitd, BorderLayout.WEST);
		JScrollPane scrollPane = new JScrollPane(tbl);
		add(scrollPane, BorderLayout.CENTER);
	}
	public void themtd() {
		int MaTranDau = Integer.parseInt(tf_MaTran.getText());
		String Doi1 = (String) cbo_Doi1.getSelectedItem();
		String TiSo = tf_TiSo.getText();
		String Doi2 = (String) cbo_Doi2.getSelectedItem();
		String SanVanDong = (String) cbo_san.getSelectedItem();
		String ThoiGian = tf_tg.getText();

		ModelCard2 model2t = new ModelCard2(MaTranDau, Doi1, TiSo, Doi2, SanVanDong, ThoiGian);
		DaoCard2 Dao2 = new DaoCard2();
		Dao2.themdulieuTD(model2t);
		DefaultTableModel tablemodel2t =(DefaultTableModel) tbl.getModel();
		tablemodel2t.addRow(new Object[] { MaTranDau, Doi1, TiSo, Doi2, SanVanDong, ThoiGian});
		tbl.setModel(tablemodel2t);
		// làm mới lại phần nhập
		tf_MaTran.setText("");
		cbo_Doi1.setSelectedItem(null);
		tf_TiSo.setText("");
		cbo_Doi2.setSelectedItem(null);
		tf_tg.setText("");
		cbo_san.setSelectedItem(null);

	}
	

	public void xoatd() {
		int selectRow = tbl.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa");
		}
		int[] selectedRows = tbl.getSelectedRows();
		DaoCard2 Dao2 = new DaoCard2();

		List<Integer> rowDeXoa = new ArrayList<Integer>();
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			int selectedRow = tbl.convertRowIndexToModel(selectedRows[i]);
			rowDeXoa.add(selectedRow);
		}
		for (int row : rowDeXoa) {
			int MaTranDau = Integer.parseInt(tbl.getValueAt(row, 0).toString());
			String Doi1 = tbl.getValueAt(row, 1).toString();
			String TiSo = tbl.getValueAt(row, 2).toString();
			String Doi2 = tbl.getValueAt(row, 3).toString();
			String SanVanDong = tbl.getValueAt(row, 4).toString();
			String ThoiGian = tbl.getValueAt(row, 5).toString();

			ModelCard2 model = new ModelCard2(MaTranDau, Doi1, TiSo, Doi2, SanVanDong, ThoiGian);
			Dao2.xoadulieuTD(model);
			dm.removeRow(row);
		}
	}
	
	
	public void suatd() {
		int selectRow = tbl.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
		if (selectRow != -1) {
			int MaTranDau = Integer.valueOf(tbl.getValueAt(selectRow, 0) + "");
			String Doi1 = tbl.getValueAt(selectRow, 1) + "";
			String TiSo = tbl.getValueAt(selectRow, 2) + "";
			String Doi2 = tbl.getValueAt(selectRow, 3) + "";
			String SanVanDong = tbl.getValueAt(selectRow, 4) + "";
			String ThoiGian = tbl.getValueAt(selectRow, 5) + "";

			this.tf_MaTran.setText(MaTranDau + "");
			this.cbo_Doi1.setSelectedItem(Doi1);
			this.tf_TiSo.setText(TiSo + "");
			this.cbo_Doi2.setSelectedItem(Doi2);
			this.cbo_san.setSelectedItem(SanVanDong + "");
			this.tf_tg.setText(ThoiGian + "");
		}
	}

	public void luutd() {
		int selectRow = tbl.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để lưu");
		}
		int MaTranDau = Integer.valueOf(this.tf_MaTran.getText());
		String Doi1 = (String) cbo_Doi1.getSelectedItem();
		String TiSo = this.tf_TiSo.getText();
		String Doi2 =(String) cbo_Doi2.getSelectedItem();
		String SanVanDong = (String) cbo_san.getSelectedItem();;
		String ThoiGian =  this.tf_tg.getText();
	

		ModelCard2 model = new ModelCard2(MaTranDau, Doi1, TiSo, Doi2, SanVanDong, ThoiGian);
		int selectedRow = tbl.getSelectedRow();
		if (selectedRow != -1) {

			dm.setValueAt(MaTranDau, selectedRow, 0);
			dm.setValueAt(Doi1, selectedRow, 1);
			dm.setValueAt(TiSo, selectedRow, 2);
			dm.setValueAt(Doi2, selectedRow, 3);
			dm.setValueAt(SanVanDong, selectedRow, 4);
			dm.setValueAt(ThoiGian, selectedRow, 5);
			DaoCard2 Dao2 = new DaoCard2();

			if (Dao2.suadulieuTD(model)) {
				JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
	}

	
}