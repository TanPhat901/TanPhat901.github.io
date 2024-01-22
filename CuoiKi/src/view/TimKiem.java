package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControCard4;
import controller.ControTimKiem;
import dao.DaoCard3;
import dao.DaoCard4;
import model.ModelCard3;
import model.ModelCard4;

public class TimKiem extends JPanel {
	private JTextField tf_tim_mact;
	private DefaultTableModel dm_tkct;
	private JTable tbl_tkct;
	private JTextField tf_tim_manv;
	
	private JTable tbl_tknv;
	private DefaultTableModel dm_tknv;
	
	public TimKiem() {
		setLayout(new BorderLayout());
		ControTimKiem cctk = new ControTimKiem(this);
		// nút đổi
		JButton bt_timkiemnv = new JButton("Tìm Kiếm Nhân Viên");
		JButton bt_timkiemnct = new JButton("Tìm Kiếm Cầu Thủ");

		JPanel pn_chuyen = new JPanel();
		pn_chuyen.setBackground(Color.decode("#87CEFA"));
		pn_chuyen.add(bt_timkiemnv);
		pn_chuyen.add(bt_timkiemnct);

		add(pn_chuyen, BorderLayout.NORTH);
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new CardLayout());
		// tìm kiếm nhân viên

		// bên trái
		Border bor = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor = new TitledBorder(bor, "Tìm Kiếm");
		JPanel pnCard1 = new JPanel();
		pnCard1.setLayout(new BorderLayout());
		JLabel lb_tim_manv = new JLabel("Mã Nhân Viên");
		tf_tim_manv = new JTextField(30);
		JButton bt_tknhanvien = new JButton("Tìm Kiếm Nhân Viên");
		bt_tknhanvien.addActionListener(cctk);

		JPanel pn_timkiem = new JPanel();
		pn_timkiem.setLayout(new GridLayout(15, 0, 10, 10));
		pn_timkiem.setBackground(Color.decode("#F5FFFA"));
		pn_timkiem.add(lb_tim_manv);
		pn_timkiem.add(tf_tim_manv);
		pn_timkiem.add(bt_tknhanvien);
		pn_timkiem.setBorder(titlebor);

		// ben phai
		Border bor1 = BorderFactory.createEtchedBorder(Color.blue, Color.black);
		dm_tknv = new DefaultTableModel();
		dm_tknv.addColumn("Mã Nhân Viên");
		dm_tknv.addColumn("Họ Tên");
		dm_tknv.addColumn("Giới Tính");
		dm_tknv.addColumn("Năm Sinh");
		dm_tknv.addColumn("Quốc Tịch");
		dm_tknv.addColumn("Địa Chỉ");
		dm_tknv.addColumn("Chức Vụ");
		tbl_tknv = new JTable(dm_tknv);
		tbl_tknv.setBackground(Color.decode("#F5FFFA"));
		tbl_tknv.setFillsViewportHeight(true);
		JScrollPane scrollPanenv = new JScrollPane(tbl_tknv);
		scrollPanenv.setBorder(bor1);
		pnCard1.add(scrollPanenv, BorderLayout.CENTER);
		pnCard1.add(pn_timkiem, BorderLayout.WEST);
		// tìm kiếm cầu thủ
		JPanel pnCard2 = new JPanel();
		Border bor3 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor3 = new TitledBorder(bor, "Tìm Kiếm");

		pnCard2.setLayout(new BorderLayout());
		JLabel lb_tim_mact = new JLabel("Mã Cầu Thủ");
		tf_tim_mact = new JTextField(30);
		JButton bt_tkcauthu = new JButton("Tìm Kiếm Cầu Thủ");
		bt_tkcauthu.addActionListener(cctk);
		JPanel pn_timkiemct = new JPanel();
		pn_timkiemct.setLayout(new GridLayout(15, 0, 10, 10));

		pn_timkiemct.add(lb_tim_mact);
		pn_timkiemct.add(tf_tim_mact);
		pn_timkiemct.add(bt_tkcauthu);
		pn_timkiemct.setBorder(titlebor);
		pn_timkiemct.setBackground(Color.decode("#F5FFFA"));
		// ben phai
		Border bor4 = BorderFactory.createEtchedBorder(Color.blue, Color.black);
		dm_tkct = new DefaultTableModel();
		dm_tkct.addColumn("Mã Cầu Thủ");
		dm_tkct.addColumn("Họ Tên");
		dm_tkct.addColumn("Ngày Sinh");
		dm_tkct.addColumn("Quốc Tịch");
		dm_tkct.addColumn("Địa Chỉ");
		dm_tkct.addColumn("Tình Trạng");
		dm_tkct.addColumn("Vị Trí");
		dm_tkct.addColumn("Số Áo ");
		tbl_tkct = new JTable(dm_tkct);
		tbl_tkct.setBackground(Color.decode("#F5FFFA"));
		tbl_tkct.setFillsViewportHeight(true);

		JScrollPane scrollPanect = new JScrollPane(tbl_tkct);
		scrollPanect.setBorder(bor4);
		pnCard2.add(scrollPanect, BorderLayout.CENTER);
		pnCard2.add(pn_timkiemct, BorderLayout.WEST);

		pnCenter.add(pnCard1, "mycard1");
		pnCenter.add(pnCard2, "mycard2");
		add(pnCenter, BorderLayout.CENTER);
		bt_timkiemnv.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent arg0) {

				CardLayout cl = (CardLayout) pnCenter.getLayout();

				cl.show(pnCenter, "mycard1");

			}

		});

		bt_timkiemnct.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent arg0) {

				CardLayout cl = (CardLayout) pnCenter.getLayout();

				cl.show(pnCenter, "mycard2");

			}

		});
		
	}
	public void timkiemmaNV() {
		   int MaNhanVien = Integer.parseInt(tf_tim_manv.getText());
		   DaoCard3 Dao3 = new DaoCard3();
		   ArrayList<ModelCard3> list = Dao3.timkiemnhanvien(MaNhanVien);
		   dm_tknv.setRowCount(0);
		for (ModelCard3 modelcard3 : list) {
		   dm_tknv.addRow(new Object[] {modelcard3.getMaNhanVien(),modelcard3.getHoTen(),modelcard3.getGioiTinh(),modelcard3.getNgaySinh(),modelcard3.getQuocTich(),modelcard3.getDiaChi(),modelcard3.getChucVu()});
		}
	}
	public void timkiemmaCT() {
		   int MaCauThu = Integer.parseInt(tf_tim_mact.getText());
		   DaoCard4 Dao4 = new DaoCard4();
		   ArrayList<ModelCard4> list = Dao4.timKiemDuLieu(MaCauThu);
		   dm_tkct.setRowCount(0);
		for (ModelCard4 modelcard4 : list) {
		   dm_tkct.addRow(new Object[] {modelcard4.getMaCauThu(),modelcard4.getHoTenCT(),modelcard4.getNgaySinhCT(),modelcard4.getQuocTichCT(),modelcard4.getDiaChiCT(),modelcard4.getTinhTrang(),modelcard4.getViTri(),modelcard4.getSoAo()});
		}
	}
	
}
