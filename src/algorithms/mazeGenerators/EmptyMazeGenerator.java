package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazaGenerator {
    @Override
    public Maze generate(int row, int col) {
        Maze grid=new Maze(row,col);
        //update start and goal
        return grid;
    }
}
