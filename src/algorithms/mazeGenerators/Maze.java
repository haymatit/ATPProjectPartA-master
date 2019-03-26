package algorithms.mazeGenerators;

public class Maze {

    private  int [][] grid;
    private Position startPosition;
    private Position goalPosition;
    public Maze(int row, int col) {
        grid=new int[row][col];
        this.goalPosition=new Position(0,0);
        this.startPosition=new Position(0,0);
    }

    public Maze(int[][] grid,Position startPosition,Position goalPosition){
        this.grid=grid;
        this.goalPosition=goalPosition;
        this.startPosition=startPosition;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getGoalPosition() {
        return goalPosition;
    }

    public void print(){
        for(int i=0;i<grid.length;i++){
            System.out.println();
            for(int j=0;j<grid[0].length;j++){
                if(startPosition.getRowIndex()==i && startPosition.getColumnIndex()==j)
                    System.out.print("S");
                else if(goalPosition.getRowIndex()==i && goalPosition.getColumnIndex()==j)
                    System.out.print("E");
                else
                    System.out.print(grid[i][j]);
            }
        }
    }

    public void setStartPosition(int row, int col) {
        this.startPosition=new Position(row,col);
    }

    public void setGoalPosition(int row, int col) {
        this.goalPosition=new Position(row,col);
    }

}
