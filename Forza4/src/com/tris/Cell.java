package com.tris;

public class Cell {
    private int owner=0;
    private boolean state=false;

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        if(owner==1 || owner==5) this.owner=owner;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if(this.owner==1) return "red";
        else return "yellow";
    }
}
