package com.example.myapplication.Domain.Repository;

import com.example.myapplication.Domain.Model.DonHang;

import java.util.List;

public interface DonHangRepository {
    public List<DonHang> getListDonHang();
    public DonHang getDonHang(String IdDonHang);
    public boolean AddDonHang(DonHang dh);
    public boolean UpdateDonHang(DonHang dh);
    public boolean DeleteDonHang(String IdDonHang);

}
