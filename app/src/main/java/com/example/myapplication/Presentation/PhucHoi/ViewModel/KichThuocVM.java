package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.Domain.Model.KichThuoc;
import com.example.myapplication.Data.Data_Source.CartRepository;

import java.util.List;

public class KichThuocVM extends ViewModel {
    private MutableLiveData<List<KichThuoc>> kichThuocListLiveData;

    public KichThuocVM() {
        kichThuocListLiveData = new MutableLiveData<>();
        loadKichThuoc(); // Load data here from your repository or source
    }

    public LiveData<List<KichThuoc>> getKichThuocListLiveData() {
        return kichThuocListLiveData;
    }

    private void loadKichThuoc() {
        // Assuming you have a repository that provides the data
        CartRepository repository = new CartRepository();
        List<KichThuoc> kichThuocList = repository.getListSize();
        kichThuocListLiveData.setValue(kichThuocList);
    }
}
