package management;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

/**
 *
 * @author ACER
 */
public class Invoices {
    private String maHD;
    private String khachHang;
    private Date ngayLap;
    private String trangThai;
    private double tongTien;

    public Invoices(String maHD, String khachHang, Date ngayLap,
                   String trangThai, double tongTien) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.ngayLap = ngayLap;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public String getMaHD() { return maHD; }
    public String getKhachHang() { return khachHang; }
    public Date getNgayLap() { return ngayLap; }
    public String getTrangThai() { return trangThai; }
    public double getTongTien() { return tongTien; }
}
