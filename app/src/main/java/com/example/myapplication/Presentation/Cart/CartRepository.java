package com.example.myapplication.Presentation.Cart;

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
}
