package hwr.oop.exercises.tictactoe;

class TicTacToe {
    private int[][] coordinates;

    TicTacToe() {
        coordinates = new int[3][3];
    }

    int getValueAt(int x, int y) {
        return coordinates[x][y];
    }

    void setCross(int x, int y) {
        if (coordinates[x][y]!=2){
        coordinates[x][y] = 1;
        }
    }

    void setCircle(int x, int y) {
        if (coordinates[x][y]!=1){
            coordinates[x][y] = 2;
        }
    }

    boolean isGameOver() {
        return playerOWon() || playerXWon();
    }

    public boolean playerXWon(){
        for (int i = 0; i < 3; i++) {
            if (coordinates[i][0] == 1 && coordinates[i][1] == 1 && coordinates[i][2] == 1
            || coordinates[0][i] == 1 && coordinates[1][i] == 1 && coordinates[2][i] == 1
            || coordinates[0][0] == 1 && coordinates[1][1] == 1 && coordinates[2][2] == 1
            || coordinates[0][2] == 1 && coordinates[1][1] == 1 && coordinates[2][1] ==1 ){
                return true;
            }
        }
        return false;
    }

    public boolean playerOWon(){
        for (int i = 0; i < 3; i++) {
            if (coordinates[i][0] == 2 && coordinates[i][1] == 2 && coordinates[i][2] == 2
                    || coordinates[0][i] == 2 && coordinates[1][i] == 2 && coordinates[2][i] == 2
                    || coordinates[0][0] == 2 && coordinates[1][1] == 2 && coordinates[2][2] == 2
                    || coordinates[0][2] == 2 && coordinates[1][1] == 2 && coordinates[2][1] ==2 ){
                return true;
            }
        }
        return false;

    }

    private boolean tieSituation(){
        return true;
    }
}
