package com.wissen.soru;

public class Soru {

    private int soruNo;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String true1;

    public Soru () {
    }

    public Soru (int soruNo, String a, String b, String c, String d, String e, String true1) {
        this.soruNo = soruNo;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.true1 = true1;
    }

    public Integer getSoruNo () {
        return soruNo;
    }

    public void setSoruNo (Integer soruNo) {
        this.soruNo = soruNo;
    }

    public String getA () {
        return a;
    }

    public void setA (String a) {
        this.a = a;
    }

    public String getB () {
        return b;
    }

    public void setB (String b) {
        this.b = b;
    }

    public String getC () {
        return c;
    }

    public void setC (String c) {
        this.c = c;
    }

    public String getD () {
        return d;
    }

    public void setD (String d) {
        this.d = d;
    }

    public String getE () {
        return e;
    }

    public void setE (String e) {
        this.e = e;
    }

    public String getTrue1 () {
        return true1;
    }

    public void setTrue1 (String true1) {
        this.true1 = true1;
    }

    @Override
    public String toString () {
        return soruNo + "";
    }

}
