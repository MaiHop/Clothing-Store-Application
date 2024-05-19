package com.example.myapplication.Model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NhomSP implements Serializable {
    private Integer idNhomSP;

    private String ten;


    private String imageURL;


    private List<LoaiSP> listLoaiSP = new ArrayList<>();
}
