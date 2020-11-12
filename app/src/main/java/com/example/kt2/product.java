package com.example.kt2;
import java.io.Serializable;

public class product implements Serializable {
    private String ten;
    private int hinh;

    public product(String ten, int hinh) {
        this.ten = ten;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setPhoto(int photo) {
        this.hinh = photo;
    }

    public product() {
    }
}
