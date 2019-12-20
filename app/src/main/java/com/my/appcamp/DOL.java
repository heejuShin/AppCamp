package com.my.appcamp;

public class DOL {
    private int ImageId;
    private String name;
    private String ex;
    //private boolean[] check = new boolean[3];

    DOL(){

    }
    DOL(int id, String name, String ex){
        this.ImageId=id;
        this.name=name;
        this.ex=ex;
    }
    DOL(int id, String name, String ex, boolean check1, boolean check2, boolean check3){
        this.ImageId=id;
        this.name=name;
        this.ex=ex;
        //this.check[0]=check1;
        //this.check[1]=check2;
        //this.check[2]=check3;
    }
    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    /*
    public boolean getCheck(int i) {
        return check[i];
    }

    public void setCheck(boolean[] check) {
        this.check = check;
    }*/
}
