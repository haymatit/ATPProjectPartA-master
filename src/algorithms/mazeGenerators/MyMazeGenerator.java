package algorithms.mazeGenerators;

import java.util.Random;

public class MyMazeGenerator extends AMazaGenerator{
    @Override
    public Maze generate(int row, int col) {
        int[][] grid=new int[row][col];
        Position start=new Position(0,0);
        Position end=new Position(row-1,col-1);
        genRecursiveDivision(grid,new Position(0,0),new Position(row-1,col-1),start,end);
        /*make a way*/
        int i=0,j=0,stepper=0;
        while(i<row && j<col){
            grid[i][j]=2;
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

        end=new Position(i,j);

        for(int k=0;k<grid.length;k++){
            for(int s=0;s<grid[0].length;s++){
                if(grid[k][s]==2)
                    grid[k][s]=0;
                else if(grid[k][s]==0) {
                    double wall=Math.random();
                    if(wall>0.8)
                        grid[k][s] =1;
                }
            }
        }
        Maze my=new Maze(grid,start,end);
        return my;
    }

    private void genRecursiveDivision(int[][] grid,Position lu, Position rd, Position start, Position end){
        if((rd.getColumnIndex()-lu.getColumnIndex())<2 || (rd.getRowIndex()-lu.getRowIndex())<2){
            return;
        }

        boolean isHorizontal=false;
        int ans= (int)(Math.random()*2);
        if(ans == 0){
            isHorizontal=true;
        }
        int wallInd=RandomFunc(lu,rd,isHorizontal);
        buildWall(wallInd,grid,isHorizontal,lu,rd);

        int pathInd= RandomFunc(lu,rd,!isHorizontal);
        CravePath(pathInd,grid,!isHorizontal,lu,rd);

        if(isHorizontal){
            genRecursiveDivision(grid,lu,new Position(wallInd-1,rd.getColumnIndex()),start,end);
            genRecursiveDivision(grid,new Position(wallInd+1,lu.getColumnIndex()),rd,start,end);
        }
        else{
            genRecursiveDivision(grid,lu,new Position(rd.getRowIndex(),wallInd-1),start,end);
            genRecursiveDivision(grid,new Position(lu.getRowIndex(),wallInd+1),rd,start,end);
        }


    }
    public int RandomFunc(Position start,Position end,boolean isHorizontal){
        int ind;
        if(isHorizontal == true)
            ind=(int)(Math.random()*(end.getRowIndex()-start.getRowIndex()))+start.getRowIndex();
        else
            ind=(int)(Math.random()*(end.getColumnIndex()-start.getColumnIndex()))+start.getColumnIndex();
        return ind;
    }

    public void buildWall(int wallInd,int[][]grid,boolean isHorizontal,Position lu, Position rd){
        if(isHorizontal==true){
            for(int i=lu.getColumnIndex();i<rd.getColumnIndex()+1;i++){
                grid[wallInd][i]=1;
            }
        }
        else{
            for(int i=lu.getRowIndex();i<rd.getRowIndex()+1;i++){
                grid[wallInd][i]=1;
            }
        }
    }

    public void CravePath(int pathInd,int[][]grid,boolean isHorizontal,Position lu, Position rd){
        int ans= (int)(Math.random()*2);
        if(ans == 0) {
            if (isHorizontal == true) {
                for (int i = lu.getColumnIndex(); i < rd.getColumnIndex() + 1; i++) {
                    grid[pathInd][i] = 0;
                }
            } else {
                for (int i = lu.getRowIndex(); i < rd.getRowIndex() + 1; i++) {
                    grid[i][pathInd] = 0;
                }
            }
        }
    }
}
