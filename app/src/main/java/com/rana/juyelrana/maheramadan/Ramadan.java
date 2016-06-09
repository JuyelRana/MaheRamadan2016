package com.rana.juyelrana.maheramadan;

/**
 * Created by JuyelRana on 6/2/2016.
 */
public class Ramadan {
    int image;
    String romjan_date,today_date,seheri_time,iftar_time;

    public Ramadan() {
    }

    public Ramadan(int image, String romjan_date, String today_date, String seheri_time, String iftar_time) {
        this.image = image;
        this.romjan_date = romjan_date;
        this.today_date = today_date;
        this.seheri_time = seheri_time;
        this.iftar_time = iftar_time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRomjan_date() {
        return romjan_date;
    }

    public void setRomjan_date(String romjan_date) {
        this.romjan_date = romjan_date;
    }

    public String getToday_date() {
        return today_date;
    }

    public void setToday_date(String today_date) {
        this.today_date = today_date;
    }

    public String getSeheri_time() {
        return seheri_time;
    }

    public void setSeheri_time(String seheri_time) {
        this.seheri_time = seheri_time;
    }

    public String getIftar_time() {
        return iftar_time;
    }

    public void setIftar_time(String iftar_time) {
        this.iftar_time = iftar_time;
    }
}
