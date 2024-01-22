package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.JDBC;

public class DangNhap extends JFrame {
	private JTextField tf_tendangnhap;
	private JPasswordField tf_matkhau;

	public DangNhap() {
		JLabel lb_tendangnhap = new JLabel("Tên đăng nhập");
		JLabel lb_matkhau = new JLabel("Mật khẩu");
		tf_tendangnhap = new JTextField(20);
		tf_matkhau = new JPasswordField(20);
		JButton bt_dangnhap = new JButton("Đăng Nhập");

		JLabel lb_img = new JLabel();
		lb_img.setIcon(new ImageIcon(DangNhap.class.getResource("icons8-manchester-united-240.png")));
		add(lb_img);

		JPanel pn_dangnhap = new JPanel();
		pn_dangnhap.setLayout(new GridLayout(1, 2));
		JPanel pn_dn1 = new JPanel();
		JPanel pn_dn2 = new JPanel();
		pn_dn2.setLayout(new GridLayout(7, 1, 10, 10));
		pn_dn2.add(lb_tendangnhap);
		pn_dn2.add(tf_tendangnhap);
		pn_dn2.add(lb_matkhau);
		pn_dn2.add(tf_matkhau);
		pn_dn2.add(bt_dangnhap);
		pn_dn1.add(lb_img);
		pn_dangnhap.add(pn_dn2);
		pn_dangnhap.add(pn_dn1);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(pn_dangnhap, BorderLayout.CENTER);
		pack();
		bt_dangnhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dangNhapHeThong();
			}
		});
	}

	public void dangNhapHeThong() {

		String TenDangNhap = tf_tendangnhap.getText();
		String MatKhau = new String(tf_matkhau.getPassword());

		if (TenDangNhap.equals("")) {
			JOptionPane.showMessageDialog(this, "Tên tài khoản không được để trống");
			return;
		}
		if (MatKhau.equals("")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
			return;
		}
		if (kiemTraTaiKhoan(TenDangNhap, MatKhau)) {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
			this.setVisible(false);
			GiaoDien view = new GiaoDien();
			view.setLocationRelativeTo(null);
			view.setExtendedState(view.MAXIMIZED_BOTH);
			view.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu");
		}
	}

	public boolean kiemTraTaiKhoan(String ten, String matKhau) {
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM taikhoan WHERE TenDangNhap='" + ten + "' AND MatKhau='" + matKhau + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				con.close();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DangNhap view = new DangNhap();
		view.setLocationRelativeTo(null);
		view.setSize(550, 300);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
}
