package com.tris;

public class Main {

    public static void main(String[] args) {
    Grid a = new Grid();
    String gameTurn;
    gameTurn=a.setSign(5,1);
        System.out.println(gameTurn);
        gameTurn=a.setSign(4,5);
        System.out.println(gameTurn);
        gameTurn=a.setSign(2,1);
        System.out.println(gameTurn);
    }
}
