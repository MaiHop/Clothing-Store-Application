package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Data.Data_Source.CartRepository;
import com.example.myapplication.Model.KieuSP;


import java.util.List;

public class KieuSPVM extends ViewModel {
    private MutableLiveData<List<KieuSP>> kieuspListLiveData;
    public KieuSPVM() {
        kieuspListLiveData = new MutableLiveData<>();

        loadData(); // Load data here from your repository or source
    }
    public LiveData<List<KieuSP>> getNhomSPListLiveData() {
        return kieuspListLiveData;

    }
    private void loadData() {
        CartRepository repository = new CartRepository();
        List<KieuSP> kieuSP = repository.getListKieuSP();
        kieuspListLiveData.setValue(kieuSP);
    }
}
