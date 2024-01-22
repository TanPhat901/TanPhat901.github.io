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
import javax.swing.BoxLayout;
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

import dao.DaoCard4;
import controller.ControCard4;
import model.ModelCard4;

public class Card4 extends JPanel {
	public JTextField tf_soao;
	public JComboBox cbo_vitri;
	public JComboBox cbo_tinhtrang;
	public JTextField tf_ma;
	public JTextField tf_ten;
	public JTextField tf_ngay;
	public JTextField tf_quoctich;
	public JTextField tf_diachi;
	public JTable tbl4;
	public DefaultTableModel dm4;
	private JTextField tf_timkiem;

	public Card4() {
		setLayout(new BorderLayout());
		Border bor4 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor4 = new TitledBorder(bor4, "Cầu thủ:");
		// nhap du lieu
		JPanel pn_dien = new JPanel();
		JLabel lb_ma = new JLabel("Mã Cầu Thủ");
		tf_ma = new JTextField(20);
		JLabel lb_ten = new JLabel("Họ Tên ");
		tf_ten = new JTextField(20);
		JLabel lb_ngay = new JLabel("Năm Sinh");
		tf_ngay = new JTextField(20);
		JLabel lb_quoctich = new JLabel("Quốc Tịch");
		tf_quoctich = new JTextField(20);
		JLabel lb_diachi = new JLabel("Địa Chỉ ");
		tf_diachi = new JTextField(20);
		String arr1[] = { "Chấn Thương", "Khoẻ Mạnh" };
		JLabel lb_tinhtrang = new JLabel("Tình Trạng");
		cbo_tinhtrang = new JComboBox(arr1);
		cbo_tinhtrang.setBackground(Color.white);
		JLabel lb_soao = new JLabel("Số áo");
		tf_soao = new JTextField(20);
		JLabel lb_vitri = new JLabel("Vị trí");
		String arr2[] = { "Trung Phong", "Tiền Đạo Cánh Trái", "Tiền Đạo Cánh Phải", "Tiền Vệ Phòng Ngự",
				"Tiền Vệ Trung Tâm", "Tiền Vệ Tấn Công", "Trung Vệ", " Hậu Về Cánh Phải", "Hậu Vệ Cánh Trái",
				"Thủ Môn" };
		cbo_vitri = new JComboBox(arr2);
		cbo_vitri.setBackground(Color.white);

		// nút chức năng
		ControCard4 cc4 = new ControCard4(this);

		JButton bt_themct = new JButton("Thêm");
		bt_themct.addActionListener(cc4);
		bt_themct.setIcon(new ImageIcon(Card3.class.getResource("icons8-add-18.png")));
		JButton bt_suact = new JButton("Sửa");
		bt_suact.addActionListener(cc4);

		bt_suact.setIcon(new ImageIcon(Card3.class.getResource("icons8-update-18.png")));
		JButton bt_xoact = new JButton("Xoá");
		bt_xoact.addActionListener(cc4);
		bt_xoact.setIcon(new ImageIcon(Card3.class.getResource("icons8-remove-18.png")));
		JButton bt_luuct = new JButton("Lưu");
		bt_luuct.addActionListener(cc4);
		bt_luuct.setIcon(new ImageIcon(Card3.class.getResource("icons8-save-18.png")));
		// tạo bảng
		dm4 = new DefaultTableModel();
		dm4.addColumn("Mã Cầu Thủ");
		dm4.addColumn("Họ Tên");
		dm4.addColumn("Năm Sinh");
		dm4.addColumn("Quốc Tịch");
		dm4.addColumn("Địa Chỉ");
		dm4.addColumn("Tình Trạng");
		dm4.addColumn("Vị Trí");
		dm4.addColumn("Số Áo ");
		tbl4 = new JTable(dm4);
		tbl4.setBackground(Color.decode("#F5FFFA"));
		tbl4.setFillsViewportHeight(true);

		// them cac nut
		pn_dien.setLayout(new GridLayout(9, 2, 5, 5));
		pn_dien.add(lb_ma);
		pn_dien.add(tf_ma);
		pn_dien.add(lb_ten);
		pn_dien.add(tf_ten);
		pn_dien.add(lb_ngay);
		pn_dien.add(tf_ngay);
		pn_dien.add(lb_quoctich);
		pn_dien.add(tf_quoctich);
		pn_dien.add(lb_diachi);
		pn_dien.add(tf_diachi);
		pn_dien.add(lb_soao);
		pn_dien.add(tf_soao);
		pn_dien.add(lb_tinhtrang);
		pn_dien.add(cbo_tinhtrang);
		pn_dien.add(lb_vitri);
		pn_dien.add(cbo_vitri);
		pn_dien.setBackground(Color.decode("#F5FFFA"));

		JPanel pn_1 = new JPanel();
		pn_1.setLayout(new FlowLayout());
		pn_1.setBackground(Color.decode("#F5FFFA"));
		JPanel pn_2 = new JPanel();
		pn_2.setLayout(new FlowLayout());
		pn_2.setBackground(Color.decode("#F5FFFA"));

		pn_1.add(bt_suact);
		pn_1.add(bt_luuct);
		pn_2.add(bt_themct);
		pn_2.add(bt_xoact);

		JPanel panel_chua2 = new JPanel();
		panel_chua2.setLayout(new GridLayout(0, 2));
		panel_chua2.add(pn_2);
		panel_chua2.add(pn_1);

		JPanel pn_trai = new JPanel();
		pn_trai.setLayout(new GridLayout(2, 0));
		pn_trai.add(pn_dien);
		pn_trai.add(panel_chua2);
		pn_trai.setBorder(titlebor4);
		pn_trai.setBackground(Color.decode("#F0F8FF"));
		add(pn_trai, BorderLayout.WEST);

		// thanh page

		JPanel pn_phai = new JPanel();
		pn_phai.setLayout(new BoxLayout(pn_phai, BoxLayout.Y_AXIS));
		tf_timkiem = new JTextField(70);
		JButton bt_timkiem = new JButton("Dữ Liệu Cầu Thủ");
		JPanel pn_timkiem = new JPanel();
		pn_timkiem.setBackground(Color.decode("#F0FFFF"));
		pn_timkiem.setLayout(new FlowLayout());
		pn_timkiem.add(tf_timkiem);
		pn_timkiem.add(bt_timkiem);

		JScrollPane sc4 = new JScrollPane(tbl4);
		JPanel pn_bang = new JPanel();

		pn_bang.setLayout(new BorderLayout());
		pn_bang.add(sc4, BorderLayout.CENTER);
		
		pn_phai.add(pn_timkiem);
		pn_phai.add(pn_bang);
		Border bor41 = BorderFactory.createEtchedBorder(Color.blue, Color.black);
		pn_phai.setBorder(bor41);
		add(pn_phai);
	}

	public void themct() {
		int Ma = Integer.parseInt(tf_ma.getText());
		String Ten = tf_ten.getText();
		String Ngaysinh = tf_ngay.getText();
		String Quoctich = tf_quoctich.getText();
		String Diachi = tf_diachi.getText();
		String Tinhtrang = (String) cbo_tinhtrang.getSelectedItem();
		String Vitri = (String) cbo_vitri.getSelectedItem();
		String Soao = tf_soao.getText();
		ModelCard4 model4t = new ModelCard4(Ma, Ten, Ngaysinh, Quoctich, Diachi, Tinhtrang, Vitri, Soao);
		DaoCard4 Dao4 = new DaoCard4();
		Dao4.themdulieucauthu(model4t);
		DefaultTableModel tablemodel4t = (DefaultTableModel) tbl4.getModel();
		tablemodel4t.addRow(new Object[] { Ma, Ten, Ngaysinh, Quoctich, Diachi, Tinhtrang, Vitri, Soao });
		tbl4.setModel(tablemodel4t);
		// làm mới lại phần nhập
		tf_ma.setText("");
		tf_ten.setText("");
		tf_ngay.setText("");
		tf_quoctich.setText("");
		tf_diachi.setText("");
		cbo_tinhtrang.setSelectedItem(null);
		cbo_vitri.setSelectedItem(null);
		tf_soao.setText("");
	}

	public void suact() {
		int selectRow = tbl4.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
		if (selectRow != -1) {
			int MaCauThu = Integer.valueOf(tbl4.getValueAt(selectRow, 0) + "");
			String HoTenCT = tbl4.getValueAt(selectRow, 1) + "";
			String NgaySinhCT = tbl4.getValueAt(selectRow, 2) + "";
			String QuocTichCT = tbl4.getValueAt(selectRow, 3) + "";
			String DiaChiCT = tbl4.getValueAt(selectRow, 4) + "";
			String TinhTrang = tbl4.getValueAt(selectRow, 5) + "";
			String ViTri = tbl4.getValueAt(selectRow, 6) + "";
			String SoAo = tbl4.getValueAt(selectRow, 7) + "";

			this.tf_ma.setText(MaCauThu + "");
			this.tf_ten.setText(HoTenCT);
			this.tf_ngay.setText(NgaySinhCT + "");
			this.tf_quoctich.setText(QuocTichCT);
			this.tf_diachi.setText(DiaChiCT + "");
			this.cbo_tinhtrang.setSelectedItem(TinhTrang + "");
			this.cbo_vitri.setSelectedItem(ViTri + "");
			this.tf_soao.setText(SoAo + "");
		}
	}

	public void luuct() {
		int selectRow = tbl4.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để lưu");
		}
		int MaCauThu = Integer.valueOf(this.tf_ma.getText());
		String HoTenCT = this.tf_ten.getText();
		String NgaySinhCT = this.tf_ngay.getText();
		String QuocTichCT = this.tf_quoctich.getText();
		String DiaChiCT = this.tf_diachi.getText();
		String TinhTrang = (String) cbo_tinhtrang.getSelectedItem();
		String ViTri = (String) cbo_vitri.getSelectedItem();
		String SoAo = this.tf_soao.getText();

		ModelCard4 model = new ModelCard4(MaCauThu, HoTenCT, NgaySinhCT, QuocTichCT, DiaChiCT, TinhTrang, ViTri, SoAo);
		int selectedRow = tbl4.getSelectedRow();
		if (selectedRow != -1) {

			dm4.setValueAt(MaCauThu, selectedRow, 0);
			dm4.setValueAt(HoTenCT, selectedRow, 1);
			dm4.setValueAt(NgaySinhCT, selectedRow, 2);
			dm4.setValueAt(QuocTichCT, selectedRow, 3);
			dm4.setValueAt(DiaChiCT, selectedRow, 4);
			dm4.setValueAt(TinhTrang, selectedRow, 5);
			dm4.setValueAt(ViTri, selectedRow, 6);
			dm4.setValueAt(SoAo, selectedRow, 7);

			DaoCard4 Dao4 = new DaoCard4();

			if (Dao4.suaDuLieu(model)) {
				JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
		tf_ma.setText("");
		tf_ten.setText("");
		tf_ngay.setText("");
		tf_quoctich.setText("");
		tf_diachi.setText("");
		cbo_tinhtrang.setSelectedItem(null);
		cbo_vitri.setSelectedItem(null);
		tf_soao.setText("");
	}

	public void xoact() {
		int selectRow = tbl4.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xoá");
		}
		int[] selectedRows = tbl4.getSelectedRows();
		DaoCard4 dao4 = new DaoCard4();

		List<Integer> rowDeXoa = new ArrayList<Integer>();
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			int selectedRow = tbl4.convertRowIndexToModel(selectedRows[i]);
			rowDeXoa.add(selectedRow);
		}
		for (int row : rowDeXoa) {
			int MaCauThu = Integer.parseInt(tbl4.getValueAt(row, 0).toString());
			String HoTenCT = tbl4.getValueAt(row, 1).toString();
			String NgaySinhCT = tbl4.getValueAt(row, 2).toString();
			String QuocTichCT = tbl4.getValueAt(row, 3).toString();
			String DiaChiCT = tbl4.getValueAt(row, 4).toString();
			String TinhTrang = tbl4.getValueAt(row, 5).toString();
			String ViTri = tbl4.getValueAt(row, 6).toString();
			String SoAo = tbl4.getValueAt(row, 7).toString();

			ModelCard4 model = new ModelCard4(MaCauThu, HoTenCT, NgaySinhCT, QuocTichCT, DiaChiCT, TinhTrang, ViTri,
					SoAo);
			dao4.xoadulieucauthu(model);
			dm4.removeRow(row);
		}
	}
	

}
