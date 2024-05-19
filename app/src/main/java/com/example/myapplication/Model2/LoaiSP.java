package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoaiSP implements Serializable {

    private Integer idLoaiSP;

    private String ten;


    private String imageURL;



    private List<KieuSP> listKieuSP = new ArrayList<>();


    private List<NhomSP> listNhomSP = new ArrayList<>();
}
