package com.example.myapplication.Presentation.Homepage.DTO;

public class Size {
    private String size;
    private boolean isSelected;

    public Size(String size) {
        this.size = size;
        this.isSelected = false;
    }

    public String getSize() {
        return size;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}