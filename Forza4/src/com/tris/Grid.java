package com.tris;

public class Grid {
    private int [][] board= new int [6][7];
    private int counterTurn;
    private int lastSign=0;

    public Grid(){
        for(int i=0;i<6;i++){
            for (int j=0; j<7;j++) board[i][j]=0;
        }
    }

    public String setSign(int position, int sign){
        if(sign!=1 && sign!=5) return "WRONG PAWN";
        if(position<0 || position>7)return "WRONG POSITION";
        if(counterTurn==0) {
            lastSign = sign;
            return "TURN "+counterTurn++ + ": YOU INSERTED " + lastSign + " PAWN AT COLUMN " + position;
        }
        if(lastSign==sign) return "IT'S NOT YOUR TURN";
        for(int i=5;i>0;i--) {
            if (board[i][position] == 0) {
                board[i][position] = sign;
                System.out.println(board[i][position]);
                lastSign = sign;
                counterTurn++;
                if(youWin()) return "PLAYER " + lastSign + " WIN.\n GAME OVER.";
                return "TURN " + counterTurn + ": YOU INSERTED "+ lastSign + " PAWN AT COLUMN " + position;
            }
        }
                if (counterTurn == 21) return "PAIR. GAMEOVER";
                return "";
    }

    public boolean youWin(){
        int sumRow=0;
        int sumColumn=0;
        int sumDiagFirstLeft=0;
        int sumDiagFirstRight=0;
        int sumDiagSecondLeft=0;
        int sumDiagSecondRight=0;
        for(int i=0;i<6;i++) {
            for(int j=0;j<4;j++) {
                sumRow = board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i][j + 3];
            }
            if (sumRow == 4 || sumRow == 20) return true;
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++) {
                sumColumn = board[j][i] + board[j + 1][i] + board[j + 2][i] + board[j + 3][i];
            }
            if (sumColumn == 4 || sumColumn == 20) return true;
        }
        //un for per la diagonale principale e quella secondaria e dentro ognuna un'altro for per lo shift
        for(int i=2;i>=0;i--){
            int maxShift =2-i;
            for(int j=0;j<maxShift;j++) {
                sumDiagFirstLeft = board[i+j][j] + board[i+1+j][1+j] + board[i+2+j][j + 2] + board[i+3+j][j+ 3];
                sumDiagSecondLeft = board[j][i+j] + board[j+1][i+1+j] + board [j+2][i+2+j] + board[j+3][i+3+j];
            }
            if(sumDiagFirstLeft==4|| sumDiagFirstLeft==20 || sumDiagSecondLeft==4 || sumDiagSecondLeft==20)return true;
        }
        for(int i=0;i<3;i++){
            int maxShift=3+i;
            int shift=0;
            for(int j=6;j>maxShift;j--) {
                sumDiagSecondRight = board[i+shift][j] + board[i+1+shift][j-1] + board[i+2+shift][j-1] + board[i+3+shift][j-3];
                System.out.println(sumDiagSecondRight);
                ++shift;
            }
            if(sumDiagSecondRight == 4 || sumDiagSecondRight == 20)return true;
        }
        /*for(int i=3;i<6;i++){
            int maxShift=i-3;
            for(int j=0;j<=maxShift;j++){
                sumDiagSecondLeft = board[i][j]+board[i-1][j+1] +board[i-2][j+2] +board[i-3][j+3];
            }
            if(sumDiagSecondLeft == 4 || sumDiagSecondLeft == 20) return true;
        }*/
        for(int j=1;j<4;j++){
            int maxShift=4-j;
            for(int i=0;i<maxShift;i++) {
                int shift=0;
                sumDiagFirstRight = board[i][j+shift] + board[i+1][j+1+shift] + board[i+2][j+2+shift] + board[i+3][j+3+shift];;
                System.out.println(sumDiagSecondRight);
                ++shift;
            }
            if(sumDiagFirstRight == 4 || sumDiagFirstRight == 20) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder printBoard= new StringBuilder();
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                printBoard.append("| ").append(board[i][j]).append(" |");
            }
            printBoard.append("\n");
        }
        return printBoard.toString();
    }


}
