package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.ModelCard3;
public class DaoCard3 {
	public void themdulieuNV(ModelCard3 model) {
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO quanlinhanvien (MaNhanVien, HoTen,GioiTinh,NgaySinh, QuocTich, DiaChi, ChucVu) "
			        + "VALUES (" + model.getMaNhanVien() + ", '" + model.getHoTen()+ "', '" + model.getGioiTinh() + "', " + model.getNgaySinh()
			        + ", '" + model.getQuocTich() + "', '" + model.getDiaChi() + "', '"
			        + model.getChucVu() + "')";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public boolean suadulieuNV(ModelCard3 model) {
		String query = "UPDATE quanlinhanvien SET HoTen = ?,GioiTinh = ? , NgaySinh = ?, QuocTich = ?, DiaChi = ?, ChucVu = ? WHERE MaNhanVien = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, model.getHoTen());
			st.setString(2, model.getGioiTinh());
			st.setString(3, model.getNgaySinh());
			st.setString(4, model.getQuocTich());
			st.setString(5, model.getDiaChi());
			st.setString(6, model.getChucVu());
			st.setInt(7, model.getMaNhanVien());
			int rowUpdate = st.executeUpdate();
			return rowUpdate > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void xoadulieuNV(ModelCard3 model) {
		String sql = "DELETE FROM quanlinhanvien WHERE MaNhanVien = ? ";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, model.getMaNhanVien());
			st.executeUpdate();
			st.close();
			System.out.println("Dữ liệu đã được xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ModelCard3> timkiemnhanvien(int ma) {
		ArrayList<ModelCard3> ketQua = new ArrayList<ModelCard3>();

		try {
			Connection connection = JDBC.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM quanlinhanvien WHERE MaNhanVien = "+ma;

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int MaNhanVien = rs.getInt("MaNhanVien");
				String HoTen = rs.getString("HoTen");
				String GioiTinh = rs.getString("GioiTinh");
				String NgaySinh = rs.getString("NgaySinh");
				String QuocTich = rs.getString("QuocTich");
				String DiaChi = rs.getString("DiaChi");
				String ChucVu = rs.getString("ChucVu");			
				ModelCard3 model3 = new ModelCard3(MaNhanVien, HoTen, GioiTinh, NgaySinh, QuocTich, DiaChi, ChucVu);
				ketQua.add(model3);
			}

			st.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}
}
	
