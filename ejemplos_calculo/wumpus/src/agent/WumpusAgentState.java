package agent;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.solver.ActionFactory;
import frsf.cidisi.faia.solver.situationcalculus.KnowledgeBase;
import java.util.Hashtable;

public class WumpusAgentState extends KnowledgeBase {

	public WumpusAgentState() throws PrologConnectorException {
		super("wumpus_world.pl");
		
		this.initState();
	}
	
	@Override
	public ActionFactory getActionFactory() {
		return WumpusActionFactory.getInstance();
	}

	@Override
	public String getBestActionPredicate() {
		return "bestAction";
	}

	@Override
	public String getExecutedActionPredicate() {
		return "action";
	}

	@Override
	public void updateState(Perception p) {
		this.tell(p);
	}

	@Override
	public void initState() {
		this.addKnowledge("position([1,1],1)");
        this.addKnowledge("orientation(right,1)");
        this.addKnowledge("holding(arrow,1)");
	}

    public int[] getPosition() {
        String positionQuery = "position([X,Y]," + this.getSituation() + ")";

        Hashtable[] pos = this.query(positionQuery);

        int x = Integer.parseInt(pos[0].get("X").toString());
        int y = Integer.parseInt(pos[0].get("Y").toString());

        return new int[]{x, y};
    }

    public int getRow() {
        return this.getPosition()[0];
    }

    public int getColumn() {
        return this.getPosition()[1];
    }

    private String getCellString(int row, int col) {

        String cellStateQuery = "unknown([" + row + "," +
                col + "]," + this.getSituation() + ")";
        if (!this.queryHasSolution(cellStateQuery))
            return "X";

        cellStateQuery = "glitter([" + row + "," +
                col + "]," + this.getSituation() + ")";
        if (this.queryHasSolution(cellStateQuery))
            return "G";

        cellStateQuery = "belief(wumpus,[" + row + "," +
                col + "])";
        if (this.queryHasSolution(cellStateQuery))
            return "W";

        cellStateQuery = "belief(pit,[" + row + "," +
                col + "])";
        if (this.queryHasSolution(cellStateQuery))
            return "P";
        
        cellStateQuery = "stench([" + row + "," +
                col + "]," + this.getSituation() + ")";
        if (this.queryHasSolution(cellStateQuery))
            return "~";
        
        cellStateQuery = "breeze([" + row + "," +
                col + "]," + this.getSituation() + ")";
        if (this.queryHasSolution(cellStateQuery))
            return "~";

//        cellStateQuery = "safe([" + row + "," +
//                col + "]," + this.getSituation() + ")";
//        if (this.queryHasSolution(cellStateQuery))
//            return "S";

        cellStateQuery = "at(nothing,[" + row + "," +
                col + "])";
        if (this.queryHasSolution(cellStateQuery))
            return " ";

        return null;
    }

	@Override
	public String toString() {
		String str = "";
        String temp;

        str = str + "[ \n";
        for (int row = 0; row < WumpusWorldState.WORLD_LENGTH; row++) {
            str = str + "[ ";
            for (int col = 0; col < WumpusWorldState.WORLD_LENGTH; col++) {
                temp = " ";

                str = str + this.getCellString(row, col) + "1";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
	}

}
