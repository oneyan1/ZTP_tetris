package logic;

public enum Tetrominos {
    NO_SHAPE(new int[][] {{0,0},{0,0},{0,0},{0,0}}),
    I_SHAPE(new int[][] {{0,-1},{0,0},{0,1},{0,2}}),
    O_SHAPE(new int[][] {{0,0},{1,0},{0,1},{1,1}}),
    T_SHAPE(new int[][] {{-1,0},{0,0},{1,0},{0,1}}),
    J_SHAPE(new int[][] {{1,-1},{0,-1},{0,0},{0,1}}),
    L_SHAPE(new int[][] {{-1,-1},{0,-1},{0,0},{0,1}}),
    S_SHAPE(new int[][] {{0,-1},{0,0},{1,0},{1,1}}),
    Z_SHAPE(new int[][] {{0,-1},{0,0},{-1,0},{-1,1}});


    public int[][] coords;

    private Tetrominos(int[][] coords){
        this.coords = coords;
    }
}
