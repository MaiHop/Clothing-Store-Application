package com.example.myapplication.Presentation.PhucHoi.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.myapplication.Domain.Model.Mau;
import com.example.myapplication.Data.Data_Source.CartRepository;

import java.util.List;

public class MauVM extends ViewModel {
    private MutableLiveData<List<Mau>> mauListLiveData;

    public MauVM() {
        mauListLiveData = new MutableLiveData<>();
        loadMau(); // Load data here from your repository or source
    }

    public LiveData<List<Mau>> getMauListLiveData() {
        return mauListLiveData;
    }

    private void loadMau() {
        // Assuming you have a repository that provides the data
        CartRepository repository = new CartRepository();
        List<Mau> mauList = repository.getListMau();
        mauListLiveData.setValue(mauList);
    }
}

