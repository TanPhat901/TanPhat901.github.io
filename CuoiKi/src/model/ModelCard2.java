package model;

public class ModelCard2 {
	private int MaTranDau;
	private String Doi1;
	private String TiSo;
	private String Doi2;
	private String SanVanDong;
	private String ThoiGian;
	public ModelCard2(int maTranDau, String doi1, String tiSo, String doi2, String sanVanDong, String thoiGian) {
		super();
		MaTranDau = maTranDau;
		Doi1 = doi1;
		TiSo = tiSo;
		Doi2 = doi2;
		SanVanDong = sanVanDong;
		ThoiGian = thoiGian;
	}
	public int getMaTranDau() {
		return MaTranDau;
	}
	public void setMaTranDau(int maTranDau) {
		MaTranDau = maTranDau;
	}
	public String getDoi1() {
		return Doi1;
	}
	public void setDoi1(String doi1) {
		Doi1 = doi1;
	}
	public String getTiSo() {
		return TiSo;
	}
	public void setTiSo(String tiSo) {
		TiSo = tiSo;
	}
	public String getDoi2() {
		return Doi2;
	}
	public void setDoi2(String doi2) {
		Doi2 = doi2;
	}
	public String getSanVanDong() {
		return SanVanDong;
	}
	public void setSanVanDong(String sanVanDong) {
		SanVanDong = sanVanDong;
	}
	public String getThoiGian() {
		return ThoiGian;
	}
	public void setThoiGian(String thoiGian) {
		ThoiGian = thoiGian;
	}
	
}