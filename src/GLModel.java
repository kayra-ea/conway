/*
GLModel

This is the Model for the Model-View-Controller Design Pattern. This will handle the data that we
are manipulating. In this, case, the cells that are alive and dead.
 */
public class GLModel {
    boolean[][] matrix;
    int length = 400;

    public GLModel() {
        matrix = new boolean[length + 2][length + 2];
    }

    public void setDimensions(int size) {
        length = size;
        matrix = new boolean[size + 2][size + 2];
    }

    public void setAlive(int x, int y) {
        matrix[x+1][y+1] = true;
    }

    public boolean isAlive(int x, int y) {
        return matrix[x+1][y+1];
    }

    /*
     * Looks at all cells surrounding each cell to determine if it is still alive, dead or should come to life
     */
    public void update() {
        boolean[][] nextMatrix = new boolean[length+2][length+2];
        for(int x = 1; x < length + 1; x++) {
            for(int y = 1; y < length + 1; y++) {
                nextMatrix[x][y] = cellIsAlive(x, y);
            }
        }

        for(int x = 1; x < length + 2; x++) {
            for(int y = 1; y < length + 2; y++) {
                matrix[x][y] = nextMatrix[x][y];
            }
        }
    }

    /*
     * Look at the surrounding cells, if two or three celss surroudnign it are alive, then that cell  is alive
     * Otherwise it's dead
     */
    private boolean cellIsAlive(int x, int y) {
        int counter = 0;
        if (matrix[x-1][y-1]) counter++;
        if (matrix[x][y-1]) counter++;
        if (matrix[x+1][y-1]) counter++;
        if (matrix[x-1][y]) counter++;
        if (matrix[x+1][y]) counter++;
        if (matrix[x-1][y+1]) counter++;
        if (matrix[x][y+1]) counter++;
        if (matrix[x+1][y+1]) counter++;

        return matrix[x][y] && counter == 2 || counter == 3;
    }
}
