package com.example.cau1thoitiet;

public class ThoiTiet {

    private String NgayThang;
    private int Hinh;
    private String NhietDo;

    public ThoiTiet( String ngayThang, int hinh,String nhietDo) {

        NgayThang = ngayThang;
        Hinh = hinh;
        NhietDo = nhietDo;
    }

    public String getNhietDo() {
        return NhietDo;
    }

    public void setNhietDo(String nhietDo) {
        NhietDo = nhietDo;
    }

    public String getNgayThang() {
        return NgayThang;
    }

    public void setNgayThang(String ngayThang) {
        NgayThang = ngayThang;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
