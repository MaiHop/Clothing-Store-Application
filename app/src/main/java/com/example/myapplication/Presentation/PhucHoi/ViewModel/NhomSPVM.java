package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.Model2.NhomSP;
import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Repository.DanhMucRepository;
import com.example.myapplication.Repository.GioHangRepository;

import java.util.List;

public class NhomSPVM extends ViewModel {
//    implements DanhMucRepository.DanhMucInterface
    private MutableLiveData<List<NhomSP>> nhomspListLiveData;
//    private DanhMucRepository res = new DanhMucRepository(this);
    public NhomSPVM() {
        nhomspListLiveData = new MutableLiveData<>();
//        res.readNhomSP();
        loadData(); // Load data here from your repository or source
    }


    public LiveData<List<NhomSP>> getNhomSPListLiveData() {
        return nhomspListLiveData;

    }

    private void loadData() {
        // Assuming you have a repository that provides the data
        CartRepository repository = new CartRepository();
        List<NhomSP> nhomSP = repository.getListNhomSP();
        nhomspListLiveData.setValue(nhomSP);


    }
//
//    @Override
//    public void getListNhomSP(List<NhomSP> list) {
//        nhomspListLiveData.setValue(list);
//    }
}
