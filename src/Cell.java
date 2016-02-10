/**
 * Created by Bill on 2/10/16.
 * Each position of the matrix will be a Cell object,
 * holds both the current state and the correct state.
 */
public class Cell {
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public static final int HARD_FALSE = 2;
    public static final int CLEAR = 3;

    private int currentState = HARD_FALSE;
    private int correctState;

    public Cell(int correctState){ this.correctState = correctState;}

    /**
     * Determines if this cell is in an incorrect state.
     * @return false if the cell's state is incorrect, otherwise true.
     */
    public boolean isStateCorrect(){
        if (correctState == TRUE)
            if (currentState == FALSE || currentState == HARD_FALSE)
                return false;
        if (correctState == FALSE)
            if (currentState == TRUE)
                return false;
        return true;
    }

    /**
     * Updates the current state.  Should be called from a button being pressed.
     * @return Command word that will give further instructions to game to update other Cells.
     */
    public String buttonClicked(){
        switch (currentState){
            case CLEAR: currentState = FALSE;
                return "clear";
            case FALSE: currentState = TRUE;
                return "ChangeToHard";
            case TRUE: currentState = CLEAR;
                return "ChangeToSoft";
            case HARD_FALSE:
                System.out.println("Hard false cannot change state.");
                return "ErrorChangingHard";
            default:
                System.out.println("Error in Cell -> buttonClicked");
                return "ErrorCellButtonClicked";
        }
    }

    public int getCurrentState(){ return currentState;}
    public void setCurrentState(int state){ currentState = state;}
}
