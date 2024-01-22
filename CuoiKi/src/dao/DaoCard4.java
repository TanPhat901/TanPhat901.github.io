package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.ModelCard4;

public class DaoCard4 {

	public void themdulieucauthu(ModelCard4 model4t) {
		try {
			Connection connection = JDBC.getConnection();
			Statement st = connection.createStatement();
			String sql = "INSERT INTO quanlicauthu (MaCauThu,HoTenCT,NgaySinhCT,QuocTichCT,DiaChiCT,TinhTrang,ViTri,SoAo) "
					+ "VALUES (" + model4t.getMaCauThu() + ", '" + model4t.getHoTenCT() + "', "
					+ model4t.getNgaySinhCT() + ", '" + model4t.getQuocTichCT() + "', '" + model4t.getDiaChiCT()
					+ "', '" + model4t.getTinhTrang() + "', '" + model4t.getViTri() + "', '" + model4t.getSoAo() + "')";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

	public boolean suaDuLieu(ModelCard4 model) {
		String query = "UPDATE quanlicauthu SET HoTenCT = ?, NgaySinhCT = ?, QuocTichCT = ?, DiaChiCT = ?, TinhTrang = ?, ViTri = ?, SoAo = ? WHERE MaCauThu = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, model.getHoTenCT());
			st.setString(2, model.getNgaySinhCT());
			st.setString(3, model.getQuocTichCT());
			st.setString(4, model.getDiaChiCT());
			st.setString(5, model.getTinhTrang());
			st.setString(6, model.getViTri());
			st.setString(7, model.getSoAo());
			st.setInt(8, model.getMaCauThu());
			int rowUpdate = st.executeUpdate();
			return rowUpdate > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void xoadulieucauthu(ModelCard4 model) {
		String sql = "DELETE FROM quanlicauthu WHERE MaCauThu = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, model.getMaCauThu());
			st.executeUpdate();
			st.close();
			System.out.println("Dữ liệu đã được xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<ModelCard4> timKiemDuLieu(int ma) {
		ArrayList<ModelCard4> ketQua = new ArrayList<ModelCard4>();

		try {
			Connection connection = JDBC.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM quanlicauthu WHERE MaCauThu = "+ma;

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int MaCauThu = rs.getInt("MaCauThu");
				String HoTenCT = rs.getString("HoTenCT");
				String NgaySinhCT = rs.getString("NgaySinhCT");
				String QuocTichCT = rs.getString("QuocTichCT");
				String DiaChiCT = rs.getString("DiaChiCT");
				String TinhTrang = rs.getString("TinhTrang");
				String ViTri = rs.getString("ViTri");
				String SoAo = rs.getString("SoAo");

				ModelCard4 model4 = new ModelCard4(MaCauThu, HoTenCT, NgaySinhCT, QuocTichCT, DiaChiCT, TinhTrang,
						ViTri, SoAo);
				ketQua.add(model4);
			}

			st.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ketQua;
	}

}