package agente.acciones;

import agente.EstadoRobot;
import java.util.ArrayList;

import frsf.cidisi.faia.agent.searchbased.SearchAction;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrH extends SearchAction {

    /**
     * 
     * @param s: Es el estado del agente en un determinado nodo del �rbol de b�squeda.-
     */
    public AgentState execute(AgentState s) {
        EstadoRobot estR = (EstadoRobot) s;

        if (estR.getPosicionesVisitadas().contains(EstadoRobot.H)) {
            return null;
        }
        ArrayList<String> sucesores = new ArrayList<String>(estR.getSucesores());
        if (sucesores != null) {
            int index = sucesores.indexOf(EstadoRobot.H);
            if (index >= 0) {
                estR.setPosicion(EstadoRobot.H);
                return estR;
            }

        }

        return null;
    }

    /**
     * Permite actualizar el estado real del agente y del ambiente.-
     * 
     * @param ast: Es el estado del agente a ser actualizado.-
     * @param est: Es el estado del ambiente a ser actualizado.-
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        this.execute(ast);

        return null;
    }

    @Override
    public Double getCost() {
        return new Double(0);
    }

    @Override
    public String toString() {
        return "IrH";
    }
}
