import java.util.ArrayList;
import java.util.List;

// Clase que representa una flota
public class Fleet {
    private String name;
    private ArrayList<Machine> machines = new ArrayList<>();
    private ArrayList<Sailor> sailors;
    private ArrayList<Ship> ships = new ArrayList<>();
    private ArrayList<Plane> planes = new ArrayList<>();
    private ArrayList<AircraftCarrier> aircraftCarriers = new ArrayList<>();
    private Board board;


    public Fleet(String name, Board board) {
        this.name = name;
        this.machines = new ArrayList<>();
        this.sailors = new ArrayList<>();
        this.board = board;
    }
    
    public void addMachine(Machine machine) {
        machines.add(machine);
    }

    // Retorna una lista de las máquinas débiles en la flota
    public ArrayList<Machine> weakMachines() {
        ArrayList<Machine> weak = new ArrayList<>();
        for (Machine machine : machines) {
            if (machine instanceof Ship) {
                Ship ship = new ArrayList<>;
                if (ship.getSailorCount() < 5) {
                    weak.add(ship);
                }
            } else if (machine instanceof Plane) {
                Plane plane = new ArrayList<>;
                if (!plane.hasPilot()) {
                    weak.add(plane);
                }
            } else if (machine instanceof AircraftCarrier) {
                AircraftCarrier carrier = new ArrayList<>;
                if (carrier.getSailorCount() < 5 || carrier.hasWeakAirplanes()) {
                    weak.add(carrier);
                }
            }
        }
        return weak;
    }

    // Método para realizar un ataque a una posición específica
    public void attack(int targetLongitude, int targetLatitude) {
        for (Machine machine : machines) {
            if (!machine.isWeak()) {
                int deltaLongitude = targetLongitude - machine.getLocation().getLongitude();
                int deltaLatitude = targetLatitude - machine.getLocation().getLatitude();
                
                if (machine.canMove(deltaLongitude, deltaLatitude)) {
                    machine.move(deltaLongitude, deltaLatitude);
                } else {
                    System.out.println("Attack failed: Invalid movement");
                }
            }
        }
    }
}