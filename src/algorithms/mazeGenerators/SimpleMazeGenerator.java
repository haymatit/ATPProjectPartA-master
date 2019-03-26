package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazaGenerator {

    @Override
    public Maze generate(int row, int col) {
        int [][]grid=new int[row][col];

        /*building walls*/
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]=(int) (Math.random()*2);
            }
        }
        /*make a way*/
        int i=0,j=0,stepper=0;
        while(i<row && j<col){
            grid[i][j]=0;
            stepper=(int) (Math.random()*2);
            if(stepper==0)
                i++;
            else
                j++;
        }
        if(i>=row)
            i--;
        else
            j--;
        Position startPosition=new Position(0,0);
        Position goalPosition=new Position(i,j);
        Maze simple=new Maze(grid,startPosition,goalPosition);
        return simple;
    }
}
