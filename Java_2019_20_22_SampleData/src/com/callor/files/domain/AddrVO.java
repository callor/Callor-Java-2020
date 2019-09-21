package com.callor.files.domain;

/*
대한민국 지방자치단체 주소록 파일
구분:자치구:소 재 지:우편번호:지역번호:대표전화:홈페이지

 */
public class AddrVO {

    private String name;
    private String city;
    private String addr;
    private String zipcode;
    private String tel;
    private String homepage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "AddrVO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", addr='" + addr + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", tel='" + tel + '\'' +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}
