package algorithms.mazeGenerators;

public abstract class AMazaGenerator implements IMazeGenerator{
    @Override
    public long measureAlgorithmTimeMillis(int row, int col) {
        long before=System.currentTimeMillis();
        generate(row,col);
        long after=System.currentTimeMillis();
        return (after-before);
    }

}
