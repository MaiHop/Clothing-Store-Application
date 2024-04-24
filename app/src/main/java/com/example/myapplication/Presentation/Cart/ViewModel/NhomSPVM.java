package com.example.myapplication.Presentation.Cart.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.Presentation.Cart.Model.NhomSP;

import com.example.myapplication.Presentation.Cart.Repository.CartRepository;

import java.util.List;

public class NhomSPVM extends ViewModel {
    private MutableLiveData<List<NhomSP>> nhomspListLiveData;
    public NhomSPVM() {
        nhomspListLiveData = new MutableLiveData<>();

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
}
