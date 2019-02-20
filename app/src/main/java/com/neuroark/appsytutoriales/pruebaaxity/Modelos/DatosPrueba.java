package com.neuroark.appsytutoriales.pruebaaxity.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosPrueba implements Parcelable {

    private String skuDisplayNameText;
    private String department;
    private String skuId;
    private String basePrice;

    public DatosPrueba(String skuDisplayNameText, String department,String skuId, String basePrice){
        this.skuDisplayNameText=skuDisplayNameText; this.department=department;
        this.skuId=skuId; this.basePrice=basePrice;
    }


    protected DatosPrueba(Parcel in) {
        skuDisplayNameText = in.readString();
        department = in.readString();
        skuId = in.readString();
        basePrice = in.readString();
    }

    public static final Creator<DatosPrueba> CREATOR = new Creator<DatosPrueba>() {
        @Override
        public DatosPrueba createFromParcel(Parcel in) {
            return new DatosPrueba(in);
        }

        @Override
        public DatosPrueba[] newArray(int size) {
            return new DatosPrueba[size];
        }
    };

    public String getSkuDisplayNameText() {
        return skuDisplayNameText;
    }

    public void setSkuDisplayNameText(String skuDisplayNameText) {
        this.skuDisplayNameText = skuDisplayNameText;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(skuDisplayNameText);
        dest.writeString(department);
        dest.writeString(skuId);
        dest.writeString(basePrice);
    }
}
