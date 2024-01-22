package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

import dao.DaoCard3;
import dao.DaoCard4;
import controller.ControCard3;
import model.ModelCard3;
import model.ModelCard4;
public class Card3 extends JPanel {
	public JTextField tf_manv;
	public JTextField tf_tennv;
	public JTextField tf_ngaynv;
	public JTextField tf_quoctichnv;
	public JTextField tf_diachinv;
	public JComboBox cbo_chucvu;
	public JLabel lb_gioitinh;
	public JComboBox cbo_gioitinh;
	private DefaultTableModel dm3;
	private JTable tbl3;

	public Card3() {
		setLayout(new BorderLayout());
		JPanel pnCard3 = new JPanel();
		pnCard3.setBackground(Color.WHITE);
		pnCard3.setLayout(new BorderLayout());
		Border bor3 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor3 = new TitledBorder(bor3, "Nhân viên");

		JLabel lb_manv = new JLabel("Mã nhân viên");
		tf_manv = new JTextField(20);
		JLabel lb_tennv = new JLabel("Họ Tên ");
		tf_tennv = new JTextField(20);
		lb_gioitinh = new JLabel("Giới Tính ");
		String arrgioitinh[] = { "Nam", "Nữ"};
		cbo_gioitinh = new JComboBox(arrgioitinh);
		cbo_gioitinh.setBackground(Color.white);
		JLabel lb_ngaynv = new JLabel("Năm sinh");
		tf_ngaynv = new JTextField(20);
		JLabel lb_quoctichnv = new JLabel("Quốc tịch");
		tf_quoctichnv = new JTextField(20);
		JLabel lb_diachinv = new JLabel("Địa chỉ ");
		tf_diachinv = new JTextField(20);
		JLabel lb_chucvu = new JLabel("Chức vụ");
		String arrchucvu[] = { "Chủ Tịch", "Giám Đốc ", "Huấn Luyện Viên", "Trợ Lí Huấn Luyện Viên","Quản Lí Đội","Bác Sĩ","Nhân Viên Truyền Thông" };
		cbo_chucvu = new JComboBox(arrchucvu);
		cbo_chucvu.setBackground(Color.white);

		JPanel pn_nhanvien = new JPanel();
		pn_nhanvien.setLayout(new GridLayout(8, 2, 5, 5));
		pn_nhanvien.setBackground(Color.decode("#F5FFFA"));
		pn_nhanvien.add(lb_manv);
		pn_nhanvien.add(tf_manv);
		pn_nhanvien.add(lb_tennv);
		pn_nhanvien.add(tf_tennv);
		pn_nhanvien.add(lb_gioitinh);
		pn_nhanvien.add(cbo_gioitinh);
		pn_nhanvien.add(lb_ngaynv);
		pn_nhanvien.add(tf_ngaynv);
		pn_nhanvien.add(lb_quoctichnv);
		pn_nhanvien.add(tf_quoctichnv);
		pn_nhanvien.add(lb_diachinv);
		pn_nhanvien.add(tf_diachinv);
		pn_nhanvien.add(lb_chucvu);
		pn_nhanvien.add(cbo_chucvu);

		ControCard3 cc3 = new ControCard3(this);

		JButton bt_themnv = new JButton("Thêm");
		bt_themnv.addActionListener(cc3);
		bt_themnv.setIcon(new ImageIcon(Card3.class.getResource("icons8-add-18.png")));
		JButton bt_suanv = new JButton("Sửa");
		bt_suanv.addActionListener(cc3);
		bt_suanv.setIcon(new ImageIcon(Card3.class.getResource("icons8-update-18.png")));
		JButton bt_xoanv = new JButton("Xoá");
		bt_xoanv.addActionListener(cc3);
		bt_xoanv.setIcon(new ImageIcon(Card3.class.getResource("icons8-remove-18.png")));
		JButton bt_luunv = new JButton("Lưu");
		bt_luunv.addActionListener(cc3);
		bt_luunv.setIcon(new ImageIcon(Card3.class.getResource("icons8-save-18.png")));

		JPanel pn_1nv = new JPanel();
		pn_1nv.setLayout(new FlowLayout());
		pn_1nv.setBackground(Color.decode("#F5FFFA"));
		JPanel pn_2nv = new JPanel();
		pn_2nv.setLayout(new FlowLayout());
		pn_2nv.setBackground(Color.decode("#F5FFFA"));
	
		pn_1nv.add(bt_suanv);
		pn_1nv.add(bt_luunv);
		pn_2nv.add(bt_themnv);
		pn_2nv.add(bt_xoanv);
		
		JPanel pn_chua2nv = new JPanel();
		pn_chua2nv.setBackground(Color.decode("#F5FFFA"));
		pn_chua2nv.setLayout(new FlowLayout());
		pn_chua2nv.add(pn_2nv);
		pn_chua2nv.add(pn_1nv);

		JPanel pn_trainv = new JPanel();
		pn_trainv.setLayout(new GridLayout(2, 0));
		pn_trainv.add(pn_nhanvien);
		pn_trainv.add(pn_chua2nv);
		pn_trainv.setBorder(titlebor3);
		add(pn_trainv, BorderLayout.WEST);

		// thanh page
		dm3 = new DefaultTableModel();
		dm3.addColumn("Mã Nhân Viên");
		dm3.addColumn("Họ Tên");
		dm3.addColumn("Giới Tính");
		dm3.addColumn("Năm Sinh");
		dm3.addColumn("Quốc Tịch");
		dm3.addColumn("Địa Chỉ");
		dm3.addColumn("Chức Vụ");

		JPanel pn_phainv = new JPanel();
		pn_phainv.setLayout(new BoxLayout(pn_phainv, BoxLayout.Y_AXIS));

		JTextField tf_timkiemnv = new JTextField(80);
		JButton bt_timkiemnv = new JButton("Dữ Liệu Nhân Viên");
		JPanel pn_timkiemnv = new JPanel();
		pn_timkiemnv.setLayout(new FlowLayout());
		pn_timkiemnv.setBackground(Color.decode("#F5FFFA"));
		pn_timkiemnv.add(tf_timkiemnv);
		pn_timkiemnv.add(bt_timkiemnv);

		tbl3 = new JTable(dm3);
		tbl3.setBackground(Color.decode("#F5FFFA"));
		tbl3.setFillsViewportHeight(true);

		JScrollPane sc3 = new JScrollPane(tbl3);
		JPanel pn_bangnv = new JPanel();
		pn_bangnv.setLayout(new BorderLayout());
		pn_bangnv.add(sc3, BorderLayout.CENTER);
		pn_phainv.add(pn_timkiemnv);
		pn_phainv.add(pn_bangnv);
		Border bor1 = BorderFactory.createEtchedBorder(Color.blue, Color.black);
		pn_phainv.setBorder(bor1);

		add(pn_phainv, BorderLayout.CENTER);
	}

	public void them() {
		int Manv = Integer.parseInt(tf_manv.getText());
		String Tennv = tf_tennv.getText();
		String GioiTinh = (String) cbo_gioitinh.getSelectedItem();
		String Ngaysinhnv = tf_ngaynv.getText();
		String Quoctichnv = tf_quoctichnv.getText();
		String Diachinv = tf_diachinv.getText();
		String Chucvu = (String) cbo_chucvu.getSelectedItem();

		ModelCard3 model = new ModelCard3(Manv, Tennv, GioiTinh, Ngaysinhnv, Quoctichnv, Diachinv, Chucvu);
		DaoCard3 Dao3 = new DaoCard3();
		Dao3.themdulieuNV(model);
		DefaultTableModel tablemodel = (DefaultTableModel) tbl3.getModel();
		tablemodel.addRow(new Object[] { Manv, Tennv, GioiTinh,Ngaysinhnv, Quoctichnv, Diachinv, Chucvu });
		tbl3.setModel(tablemodel);
		tf_manv.setText("");
		tf_tennv.setText("");
		cbo_gioitinh.setSelectedItem(null);
		tf_ngaynv.setText("");
		tf_quoctichnv.setText("");
		tf_diachinv.setText("");
		cbo_chucvu.setSelectedItem(null);
	}
	public void suanv() {
		int selectRow = tbl3.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
		if (selectRow != -1) {
			int MaNhanVien = Integer.valueOf(tbl3.getValueAt(selectRow, 0) + "");
			String HoTen = tbl3.getValueAt(selectRow, 1) + "";
			String GioiTinh = tbl3.getValueAt(selectRow, 2) + "";
			String NgaySinh = tbl3.getValueAt(selectRow, 3) + "";
			String QuocTich = tbl3.getValueAt(selectRow, 4) + "";
			String DiaChi = tbl3.getValueAt(selectRow, 5) + "";
			String ChucVu = tbl3.getValueAt(selectRow, 6) + "";
			
			this.tf_manv.setText(MaNhanVien + "");
			this.tf_tennv.setText(HoTen);
			this.cbo_gioitinh.setSelectedItem(GioiTinh + "");
			this.tf_ngaynv.setText(NgaySinh + "");
			this.tf_quoctichnv.setText(QuocTich);
			this.tf_diachinv.setText(DiaChi + "");
			this.cbo_chucvu.setSelectedItem(ChucVu + "");
			
		}
	}

	public void luunv() {
		int selectRow = tbl3.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để lưu");
		}
		int MaNhanVien = Integer.valueOf(this.tf_manv.getText());
		String HoTen = this.tf_tennv.getText();
		String GioiTinh = (String) cbo_gioitinh.getSelectedItem();
		String NgaySinh = this.tf_ngaynv.getText();
		String QuocTich = this.tf_quoctichnv.getText();
		String DiaChi = this.tf_diachinv.getText();
		String ChucVu = (String) cbo_chucvu.getSelectedItem();
		
		ModelCard3 model = new ModelCard3(MaNhanVien, HoTen, GioiTinh, NgaySinh, QuocTich, DiaChi, ChucVu);
		int selectedRow = tbl3.getSelectedRow();
		if (selectedRow != -1) {

			dm3.setValueAt(MaNhanVien, selectedRow, 0);
			dm3.setValueAt(HoTen, selectedRow, 1);
			dm3.setValueAt(GioiTinh, selectedRow, 2);
			dm3.setValueAt(NgaySinh, selectedRow, 3);
			dm3.setValueAt(QuocTich, selectedRow, 4);
			dm3.setValueAt(DiaChi, selectedRow, 5);
			dm3.setValueAt(ChucVu, selectedRow, 6);
			

			DaoCard3 Dao3 = new DaoCard3();

			if (Dao3.suadulieuNV(model)) {
				JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công");
			} else {
				JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
		}
		tf_manv.setText("");
		tf_tennv.setText("");
		cbo_gioitinh.setSelectedItem(null);
		tf_ngaynv.setText("");
		tf_quoctichnv.setText("");
		tf_diachinv.setText("");
		cbo_chucvu.setSelectedItem(null);
	}

	public void xoanv() {
		int selectRow = tbl3.getSelectedRow();
		if (selectRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa");
		}
		int[] selectedRows = tbl3.getSelectedRows();
		DaoCard3 dao3 = new DaoCard3();

		List<Integer> rowDeXoa = new ArrayList<Integer>();
		for (int i = selectedRows.length - 1; i >= 0; i--) {
			int selectedRow = tbl3.convertRowIndexToModel(selectedRows[i]);
			rowDeXoa.add(selectedRow);
		}
		for (int row : rowDeXoa) {
			int MaNhanVien = Integer.parseInt(tbl3.getValueAt(row, 0).toString());
			String HoTen = tbl3.getValueAt(row, 1).toString();
			String GioiTinh = tbl3.getValueAt(row, 2).toString();
			String NgaySinh = tbl3.getValueAt(row, 3).toString();
			String QuocTich = tbl3.getValueAt(row, 4).toString();
			String DiaChi = tbl3.getValueAt(row, 5).toString();
			String ChucVu = tbl3.getValueAt(row, 6).toString();
			

			ModelCard3 model = new ModelCard3(MaNhanVien, HoTen, GioiTinh, NgaySinh, QuocTich, DiaChi, ChucVu);
			dao3.xoadulieuNV(model);
			dm3.removeRow(row);
		}
	}
}