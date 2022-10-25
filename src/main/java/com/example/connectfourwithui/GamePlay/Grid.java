package com.example.connectfourwithui.GamePlay;

public class Grid {
    private String[][] grid;

    public Grid() {
        this.grid = new String[][]{
                {"_", "_", "_", "_", "_", "_", "_"},
                {"_", "_", "_", "_", "_", "_", "_"},
                {"_", "_", "_", "_", "_", "_", "_"},
                {"_", "_", "_", "_", "_", "_", "_"},
                {"_", "_", "_", "_", "_", "_", "_"},
                {"_", "_", "_", "_", "_", "_", "_"}
        };
    }

    public String getExactField(int column, int row){
        return this.grid[column][row];
    }

    public int getGridLength(){
        return this.grid.length;
    }

    public void setGrid(Spot.Symbol symbol, int column, int row) {
        this.grid[column][row] = symbol.toString();
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                temp += grid[i][j] + "    ";
            }
            temp += "\n";
        }
        return temp;
    }

    public boolean winGame(){
        int countSymbolsO = 0;
        int countSymbolsX = 0;
        if(checkHorizontalWin(countSymbolsX, countSymbolsO)){
            return true;
        }else if(checkVerticalWin(countSymbolsX, countSymbolsO)){
            return true;
        }else if(checkDiagonalWin(countSymbolsX, countSymbolsO)){
            return true;
        }
        return false;
    }

    private boolean checkHorizontalWin(int countSymbolsX, int countSymbolsO){
        for(int column = 0; column < grid.length; column++) {
            for (int row = 0; row < grid[column].length; row++) {
                if(grid[column][row].equals(Spot.Symbol.X.toString())){
                    countSymbolsX++;
                    countSymbolsO = 0;
                    if(countSymbolsX == 4) {
                        return true;
                    }
                }else if(grid[column][row].equals(Spot.Symbol.O.toString())){
                    countSymbolsO++;
                    countSymbolsX = 0;
                    if(countSymbolsO == 4) {
                        return true;
                    }
                }
                else{
                    countSymbolsX = 0;
                    countSymbolsO = 0;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin(int countSymbolsX, int countSymbolsO){
        for(int row = 0; row < grid[1].length; row++){
            for(int column = 0; column < grid.length; column++){
                if(grid[column][row].equals(Spot.Symbol.X.toString())){
                    countSymbolsX++;
                    countSymbolsO = 0;
                    if(countSymbolsX == 4){
                        return true;
                    }
                }else if(grid[column][row].equals(Spot.Symbol.O.toString())){
                    countSymbolsO++;
                    countSymbolsX = 0;
                    if (countSymbolsO == 4){
                        return true;
                    }
                }else{
                    countSymbolsX = 0;
                    countSymbolsO = 0;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(int countSymbolsX, int countSymbolsO){
        for(int column = 0; column < grid.length; column++) {
            for (int row = 0; row < grid[1].length; row++) {
                int column2 = column;
                int row2 = row;
                if (grid[column][row].equals(Spot.Symbol.X.toString())){
                    countSymbolsX++;
                    for(int checks = 0; checks <= 4; checks++) {
                        if (column2 - 1 >= 0 && row2 + 1 <= 6){
                            column2--;
                            row2++;
                            if (grid[column2][row2].equals(Spot.Symbol.X.toString())) {
                                countSymbolsX++;
                                if (countSymbolsX == 4) {
                                    return true;
                                }
                            }else{
                                countSymbolsX = 1;
                            }
                        }else{
                            break;
                        }
                    }
                    column2 = column;
                    row2 = row;
                    for(int checks = 0; checks <= 4; checks++) {
                        if (column2 - 1 >= 0 && row2 -1 >= 0) {
                            column2--;
                            row2--;
                            if (grid[column2][row2].equals(Spot.Symbol.X.toString())) {
                                countSymbolsX++;
                                if(countSymbolsX == 4){
                                    return true;
                                }
                            }else{
                                countSymbolsX = 1;
                            }
                        }else{
                            break;
                        }
                    }
                }
                column2 = column;
                row2 = row;
                if (grid[column][row].equals(Spot.Symbol.O.toString())){
                    countSymbolsO++;
                    for(int checks = 0; checks <= 4; checks++) {
                        if (column2 - 1 >= 0 && row2 + 1 <= 6){
                            column2--;
                            row2++;
                            if (grid[column2][row2].equals(Spot.Symbol.O.toString())) {
                                countSymbolsO++;
                                if (countSymbolsO == 4) {
                                    return true;
                                }
                            }else{
                                countSymbolsO = 1;
                            }
                        }else{
                            break;
                        }
                    }
                    column2 = column;
                    row2 = row;
                    for(int checks = 0; checks <= 4; checks++) {
                        if (column2 - 1 >= 0 && row2 -1 >= 0) {
                            column2--;
                            row2--;
                            if (grid[column2][row2].equals(Spot.Symbol.O.toString())) {
                                countSymbolsO++;
                                if(countSymbolsO == 4){
                                    return true;
                                }
                            }else{
                                countSymbolsO = 1;
                            }
                        }else{
                            break;
                        }
                    }
                }
                countSymbolsO = 0;
                countSymbolsX = 0;
            }
        }
        return false;
    }
}
