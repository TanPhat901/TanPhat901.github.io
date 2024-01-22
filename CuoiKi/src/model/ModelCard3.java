package model;

public class ModelCard3 {
	private int MaNhanVien ;
	private String HoTen ;
	private String GioiTinh;
	
	private String NgaySinh ;
	private String QuocTich ;
	private String DiaChi ;
	private String ChucVu ;
	public ModelCard3(int maNhanVien, String hoTen, String gioiTinh, String ngaySinh, String quocTich, String diaChi,
			String chucVu) {
		super();
		MaNhanVien = maNhanVien;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgaySinh = ngaySinh;
		QuocTich = quocTich;
		DiaChi = diaChi;
		ChucVu = chucVu;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getQuocTich() {
		return QuocTich;
	}
	public void setQuocTich(String quocTich) {
		QuocTich = quocTich;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}
	
}