package com.example.myapplication.Presentation.Cart.Repository;

import com.example.myapplication.Presentation.Cart.Model.Cart;
import com.example.myapplication.Presentation.Cart.Model.DiaChi;
import com.example.myapplication.Presentation.Cart.Model.KhuyenMai;
import com.example.myapplication.Presentation.Cart.Model.PTThanhToan;
import com.example.myapplication.Presentation.Cart.Model.VanCHuyen;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public  List<Cart> getAll(){
        Cart cart1 = new Cart();
        cart1.setImage(R.drawable.logo);
        cart1.setTenSanPham("AIRism Cotton Áo Thun Không Tay");
        cart1.setSize("L");
        cart1.setMau("Đen");
        cart1.setSoLuong("2");
        cart1.setThanhTien(2);
        cart1.setChecked(true);

        Cart cart2 = new Cart();
        cart2.setImage(R.drawable.logo);
        cart2.setTenSanPham("AIRism Cotton Áo Thun Không Tay");
        cart2.setSize("L");
        cart2.setMau("Đen");
        cart2.setSoLuong("2");
        cart2.setThanhTien(2);
        cart2.setChecked(true);

        Cart cart3 = new Cart();
        cart3.setImage(R.drawable.logo);
        cart3.setTenSanPham("AIRism Cotton Áo Thun Không Tay");
        cart3.setSize("L");
        cart3.setMau("Đen");
        cart3.setSoLuong("2");
        cart3.setThanhTien(2);
        cart3.setChecked(true);

        Cart cart4 = new Cart();
        cart4.setImage(R.drawable.logo);
        cart4.setTenSanPham("AIRism Cotton Áo Thun Không Tay");
        cart4.setSize("L");
        cart4.setMau("Đen");
        cart4.setSoLuong("2");
        cart4.setThanhTien(2);
        cart4.setChecked(true);

        Cart cart5 = new Cart();
        cart5.setImage(R.drawable.logo);
        cart5.setTenSanPham("AIRism Cotton Áo Thun Không Tay");
        cart5.setSize("L");
        cart5.setMau("Đen");
        cart5.setSoLuong("2");
        cart5.setThanhTien(2);
        cart5.setChecked(true);

        List<Cart> list = new ArrayList<>();
        list.add(cart1);
        list.add(cart2);
        list.add(cart3);
        list.add(cart4);
        list.add(cart5);

        return  list;
    }
     public List<String> getListSize(){
        List<String> list = new ArrayList<>();
        list.add("XS");
        list.add("S");
        list.add("M");
        list.add("L");
        list.add("XL");
        return list;
     }

     public List<DiaChi> getListAddress(){
        List<DiaChi> list = new ArrayList<>();

        DiaChi dc1 = new DiaChi();
        dc1.setId("1");
        dc1.setDiaChiChinh(true);
        dc1.setNguoiNhan("Trung Hậu");
        dc1.setSDT("0765328458");
        dc1.setDiaChi("155/33 Nguyễn Trãi");
        dc1.setXacDinh(true);
        dc1.setChecked(false);

         DiaChi dc2 = new DiaChi();
         dc2.setId("1");
         dc2.setDiaChiChinh(true);
         dc2.setNguoiNhan("Trung Hậu");
         dc2.setSDT("0765328458");
         dc2.setDiaChi("155/33 Nguyễn Trãi");
         dc2.setXacDinh(true);
         dc2.setChecked(false);

         DiaChi dc3 = new DiaChi();
         dc3.setId("1");
         dc3.setDiaChiChinh(true);
         dc3.setNguoiNhan("Trung Hậu");
         dc3.setSDT("0765328458");
         dc3.setDiaChi("155/33 Nguyễn Trãi");
         dc3.setXacDinh(true);
         dc3.setChecked(false);

         list.add(dc1);
         list.add(dc2);
         list.add(dc3);
         return list;
     }

     public List<VanCHuyen> getListDelivery(){
        List<VanCHuyen> list = new ArrayList<>();

        VanCHuyen vc1 = new VanCHuyen();
        vc1.setLogo(R.drawable.baseline_check_box_outline_blank_24);
        vc1.setTenDonVI("J&T Express");
        vc1.setThoiGian("23 - 25 tháng 10 2024");
        vc1.setGiaTien(10);
        vc1.setChecked(false);

        VanCHuyen vc2 = new VanCHuyen();
        vc2.setLogo(R.drawable.baseline_check_box_outline_blank_24);
        vc2.setTenDonVI("J&T Express");
        vc2.setThoiGian("23 - 25 tháng 10 2024");
        vc2.setGiaTien(10);
        vc2.setChecked(false);

        VanCHuyen vc3 = new VanCHuyen();
        vc3.setLogo(R.drawable.baseline_check_box_outline_blank_24);
        vc3.setTenDonVI("J&T Express");
        vc3.setThoiGian("23 - 25 tháng 10 2024");
        vc3.setGiaTien(10);
        vc3.setChecked(false);

        list.add(vc1);
        list.add(vc2);
        list.add(vc3);

        return list;
     }

     public List<PTThanhToan> getListMP(){
        List<PTThanhToan> list = new ArrayList<>();

        PTThanhToan tt1 = new PTThanhToan();
        tt1.setLogo(R.drawable.baseline_check_box_outline_blank_24);
        tt1.setTenPhuongThuc("Paypal");
        tt1.setChecked(false);

        PTThanhToan tt2 = new PTThanhToan();
        tt2.setLogo(R.drawable.baseline_check_box_outline_blank_24);
        tt2.setTenPhuongThuc("Paypal");
        tt2.setChecked(false);

        PTThanhToan tt3 = new PTThanhToan();
        tt3.setLogo(R.drawable.baseline_check_box_outline_blank_24);
        tt3.setTenPhuongThuc("Paypal");
        tt3.setChecked(false);

        list.add(tt1);
        list.add(tt2);
        list.add(tt3);
        return list;
     }

     public List<KhuyenMai> getListKhuyenMai(){
        List<KhuyenMai> list = new ArrayList<>();

        KhuyenMai km1 = new KhuyenMai();
        km1.setTenKhuyenMai("Test giảm giá");
        km1.setChiTietKhuyenMai("Mua 1 tặng 10");
        km1.setChecked(false);
        KhuyenMai km2 = new KhuyenMai();
        km2.setTenKhuyenMai("Test giảm giá");
        km2.setChiTietKhuyenMai("Mua 1 tặng 10");
        km2.setChecked(false);
        KhuyenMai km3 = new KhuyenMai();
        km3.setTenKhuyenMai("Test giảm giá");
        km3.setChiTietKhuyenMai("Mua 1 tặng 10");
        km3.setChecked(false);

        list.add(km1);
        list.add(km2);
        list.add(km3);

        return list;
     }
}
