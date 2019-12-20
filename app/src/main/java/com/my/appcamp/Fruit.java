package com.my.appcamp;

public class Fruit {
    private int imageid;
    private String name;
    private String desc;

    public Fruit(){}
    public Fruit(int imageid, String name, String desc){
        this.imageid=imageid;
        this.name=name;
        this.desc=desc;
    }
    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
