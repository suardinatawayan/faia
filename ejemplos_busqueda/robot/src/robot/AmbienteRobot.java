package robot;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmbienteRobot extends Environment {

    public AmbienteRobot() {
        // Se instancia el estado del ambiente.-
        this.environmentState = new EstadoAmbiente();
    }

    public Perception getPercept(Agent agent) {
        // Retorna la nueva percepción creada.-
        return null;
    }

    public String toString() {

//		return environmentState.toString();
        return "";
    }
}
