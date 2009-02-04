package agent;

import frsf.cidisi.faia.state.EnvironmentState;
import java.util.Vector;

public class WumpusWorldState extends EnvironmentState {

    public static final int WORLD_LENGTH = 4;

    public enum CellState {
        STENCH,
        BREEZE,
        GLITTER,
        BUMP,
        WUMPUS_SCREAM,

        GOLD,
        WUMPUS,
        PIT
    }

	private Vector<CellState>[][] world;
	
	public WumpusWorldState() {
		this.world = (Vector<CellState>[][]) new Vector[WORLD_LENGTH][WORLD_LENGTH];
		this.initState();
	}
	
	@Override
	public void initState() {
		this.addCellState(0, 3, CellState.WUMPUS);
        this.addCellState(2, 2, CellState.PIT);
        this.addCellState(0, 3, CellState.PIT);
	}

    private void addCellState(int row, int col, CellState cellState) {

        CellState stenchOrBreeze = null;

        if (cellState == CellState.WUMPUS)
            stenchOrBreeze = CellState.STENCH;
        else if (cellState == CellState.PIT)
            stenchOrBreeze = CellState.BREEZE;

        this.world[row][col].add(cellState);
        
        if (row-1 >= 0)
            this.world[row-1][col].add(stenchOrBreeze);

        if (row+1 < WORLD_LENGTH)
            this.world[row+1][col].add(stenchOrBreeze);

        if (col-1 >= 0)
            this.world[row][col-1].add(stenchOrBreeze);

        if (col+1 < WORLD_LENGTH)
            this.world[row][col+1].add(stenchOrBreeze);
    }

    private void removeCellState(int row, int col, CellState cellState) {

        CellState stenchOrBreeze = null;

        if (cellState == CellState.WUMPUS)
            stenchOrBreeze = CellState.STENCH;
        else if (cellState == CellState.PIT)
            stenchOrBreeze = CellState.BREEZE;

        this.world[row][col].remove(cellState);

        if (row-1 >= 0)
            this.world[row-1][col].remove(stenchOrBreeze);

        if (row+1 < WORLD_LENGTH)
            this.world[row+1][col].remove(stenchOrBreeze);

        if (col-1 >= 0)
            this.world[row][col-1].remove(stenchOrBreeze);

        if (col+1 < WORLD_LENGTH)
            this.world[row][col+1].remove(stenchOrBreeze);
    }

	@Override
	public String toString() {
		String str = "";
        String temp;

        str = str + "[ \n";
        for (int row = 0; row < WORLD_LENGTH; row++) {
            str = str + "[ ";
            for (int col = 0; col < WORLD_LENGTH; col++) {
                temp = " ";

                if (this.world[row][col].contains(CellState.WUMPUS) ||
                        this.world[row][col].contains(CellState.PIT))
                    temp = "O";
                else if (this.world[row][col].contains(CellState.STENCH) ||
                        this.world[row][col].contains(CellState.BREEZE))
                    temp = "~";
                else if (this.world[row][col].contains(CellState.GLITTER) ||
                        this.world[row][col].contains(CellState.GOLD))
                    temp = "G";

                str = str + temp + "1";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
	}

}
