package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import database.JDBC;
import model.ModelCard2;


public class DaoCard2 {
	public void themdulieuTD(ModelCard2 model2t) {
		try {
			Connection connection = JDBC.getConnection();
			Statement st = connection.createStatement();
			String sql = "INSERT INTO quanlitrandau (MaTranDau,Doi1,TiSo,Doi2,SanVanDong,ThoiGian) "
					+ "VALUES (" + model2t.getMaTranDau() + ", '" + model2t.getDoi1() +  "', '"
					+ model2t.getTiSo() + "', '" + model2t.getDoi2() + "', '" + model2t.getSanVanDong()
					+ "', '" + model2t.getThoiGian() + "')";
			st.executeUpdate(sql);
			st.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	public void xoadulieuTD(ModelCard2 model) {
		String sql = "DELETE FROM quanlitrandau WHERE MaTranDau = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1,model.getMaTranDau());
			st.executeUpdate();
			st.close();
			System.out.println("Dữ liệu đã được xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean suadulieuTD(ModelCard2 model) {
		String query = "UPDATE quanlitrandau SET Doi1 = ?, TiSo = ?, Doi2 = ?, SanVanDong = ? WHERE MaTranDau = ?";
		try {
			Connection connection = JDBC.getConnection();
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, model.getDoi1());
			st.setString(2, model.getTiSo());
			st.setString(3, model.getDoi2());
			st.setString(4, model.getSanVanDong());
			st.setString(5, model.getThoiGian());
			st.setInt(6, model.getMaTranDau());
			int rowUpdate = st.executeUpdate();
			return rowUpdate > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}