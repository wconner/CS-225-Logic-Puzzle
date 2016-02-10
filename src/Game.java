import java.util.ArrayList;

/**
 * Created by Bill on 2/10/16.
 * Main logic controlling class of the game.
 */
public class Game {
    private ArrayList<Cell[][]> matrices;
    private Cell[][] matrixA = new Cell[4][4], matrixB = new Cell[4][4], matrixC = new Cell[4][4];

    public Game(){
        matrices = new ArrayList<Cell[][]>();
        initMatrices();
    }

    private void initMatrices(){
        for (int i = 0; i < 4; i++)             /** Initializing all positions in matrix to false cells */
            for (int j = 0; j < 4; j++){
                matrixA[i][j] = new Cell(Cell.FALSE); matrixB[i][j] = new Cell(Cell.FALSE); matrixC[i][j] = new Cell(Cell.FALSE);
            }
        for (int i = 0; i < 4; i++) {           /** Setting the correct cells to true cells */
            matrixB[i][i] = new Cell(Cell.TRUE);
            for (int j = 3; j >= 0; j--){
                matrixA[j][i] = new Cell(Cell.TRUE); matrixC[j][i] = new Cell(Cell.TRUE);
            }
        }
        matrices.add(matrixA); matrices.add(matrixB); matrices.add(matrixC);
    }

    /**
     * This method should be called when the user clicks on a position in the graph,
     * will update the states of the cells.
     * @param matrixNum Which matrix was clicked on (A = 1, B = 2, C = 3)
     * @param row The position of the row clicked
     * @param column The position of the column clicked
     */
    public void buttonClicked(int matrixNum, int row, int column){
        parseButtonReturn(matrices.get(matrixNum)[row][column].buttonClicked(), matrixNum, row, column);
    }

    /**
     * Determines if any other actions need to be taken based on one cell changing state,
     * for example if the cell at [0][0] was set to true all other columns in the [0] row
     * need to be set to a hard false.
     * @param command What action should be taken, this value is returned from the cell
     * @param matrixNum Which matrix was clicked on (A = 1, B = 2, C = 3)
     * @param row The position of the row clicked
     * @param column The position of the column clicked
     */
    private void parseButtonReturn(String command, int matrixNum, int row, int column){
        switch (command){
            case "ChangeToHard":
                for (int i = 0; i < 4; i++) {
                    if (i != row)
                        matrices.get(matrixNum)[i][column].setCurrentState(Cell.HARD_FALSE);
                    if (i != column)
                        matrices.get(matrixNum)[row][i].setCurrentState(Cell.HARD_FALSE);
                }
                break;
            case "ChangeToSoft":
                for (int i = 0; i < 4; i++){
                    if (i != row)
                        matrices.get(matrixNum)[i][column].setCurrentState(Cell.FALSE);
                    if (i != column)
                        matrices.get(matrixNum)[row][i].setCurrentState(Cell.FALSE);
                }
                break;
            default: System.out.println("Nothing to do here, Game -> parseButtonReturn");
        }
    }

    /**
     * Resets all cells to clear.
     */
    public void reset(){
        for (Cell[][] m : matrices)
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    m[i][j].setCurrentState(Cell.CLEAR);
    }

    /**
     * Checks the status of all the cells and compares them to their correct state,
     * if there is an error, it will set that cell to clear and tell the user
     * how many errors were found.  This method also checks to see if the user has
     * correctly solved the puzzle.
     */
    public void checkState(){
        int c = 0;
        int truesFound = 0;

        for (Cell[][] m : matrices)
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++) {
                    if (!m[i][j].isStateCorrect()) {
                        c++;
                        m[i][j].setCurrentState(Cell.CLEAR);
                    }
                    else if (m[i][j].getCurrentState() == Cell.TRUE)
                        truesFound++;
                }
        if (truesFound == 12)
            System.out.println("Congratulations, you won the game!.");
        else if (c > 0)
            System.out.println("There were " + c + " errors which have been cleared");
        else
            System.out.println("There were no errors.");
    }

    public static void main(String[] args){ new Game();}
}
