import java.util.*;

// Clase base para todas las máquinas de la flota
abstract class Machine {
    protected Position location;
    protected boolean isDestroyed = false;

    public Machine(int longitude, int latitude) {
        this.location = new Position(longitude, latitude);
    }

    public Position getLocation() {
        return location;
    }

    // Método para mover la máquina en el tablero
    public void move(int dLon, int dLat) {
        location.setLongitude((location.getLongitude() + dLon) % 180);
        location.setLatitude((location.getLatitude() + dLat) % 90);
    }

    public abstract boolean isWeak();
    public abstract void selfDestruct(String reason);
}

// Clase para representar la posición en el tablero
class Position {
    private int longitude;
    private int latitude;

    public Position(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}

// Clase que representa un barco
class Ship extends Machine {
    private int sailors;

    public Ship(int longitude, int latitude, int sailors) {
        super(longitude, latitude);
        this.sailors = sailors;
    }

    // Determina si el barco es débil (menos de 5 marineros)
    @Override
    public boolean isWeak() {
        return sailors < 5;
    }

    // Método para autodestruirse
    @Override
    public void selfDestruct(String reason) {
        System.out.println("Ship destroyed: " + reason);
        isDestroyed = true;
    }
}

// Clase para representar un portaaviones
class AircraftCarrier extends Ship {
    private List<Plane> airplanes;

    public AircraftCarrier(int longitude, int latitude, int sailors) {
        super(longitude, latitude, sailors);
        airplanes = new ArrayList<>();
    }

    public void addAirplane(Plane plane) {
        airplanes.add(plane);
    }

    // Verifica si hay aviones débiles en el portaaviones
    public boolean hasWeakAirplanes() {
        for (Plane plane : airplanes) {
            if (plane.isWeak()) return true;
        }
        return false;
    }
}

// Clase que representa un avión
class Plane extends Machine {
    private boolean hasPilot;

    public Plane(int longitude, int latitude, boolean hasPilot) {
        super(longitude, latitude);
        this.hasPilot = hasPilot;
    }

    // Determina si el avión es débil (si no tiene piloto)
    @Override
    public boolean isWeak() {
        return !hasPilot;
    }

    // Método para autodestruirse
    @Override
    public void selfDestruct(String reason) {
        System.out.println("Plane destroyed: " + reason);
        isDestroyed = true;
    }
}

// Clase que representa un marinero
class Sailor {
    private Plane assignedPlane;
    private Fleet assignedFleet;
    private String name;
    private int rank;

    public Sailor(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.assignedPlane = null;
        this.assignedFleet = null;
    }

    public void assignPlane(Plane plane) {
        this.assignedPlane = plane;
    }
}

// Clase que representa una flota
class Fleet {
    private String name;
    private ArrayList<Machine> machines;
    private Board board;

    public Fleet(String name, Board board) {
        this.name = name;
        this.machines = new ArrayList<>();
        this.board = board;
    }
    
    public void addMachine(Machine machine) {
        machines.add(machine);
    }

    // Retorna una lista de las máquinas débiles en la flota
    public ArrayList<Machine> weakMachines() {
        ArrayList<Machine> weak = new ArrayList<>();
        for (Machine machine : machines) {
            if (machine.isWeak()) {
                weak.add(machine);
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
                machine.move(deltaLongitude, deltaLatitude);
            }
        }
    }
}

// Clase que representa el tablero de juego
class Board {
    private List<Fleet> fleets;

    public Board() {
        this.fleets = new ArrayList<>();
    }

    public List<Fleet> getFleets() {
        return fleets;
    }

    public void addFleet(Fleet fleet) {
        fleets.add(fleet);
    }

    // Calcula la cantidad de máquinas débiles en todas las flotas
    public int power() {
        int totalPower = 0;
        for (Fleet f : fleets) {
            totalPower += f.weakMachines().size();
        }
        return totalPower;
    }
}