package model;

public class ModelTaiKhoan {
	private int MaTaiKhoan;
	private String TenDangNhap;
	private String MatKhau;
	public ModelTaiKhoan(int maTaiKhoan, String tenDangNhap, String matKhau) {
		MaTaiKhoan = maTaiKhoan;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	public int getMaTaiKhoan() {
		return MaTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
}
