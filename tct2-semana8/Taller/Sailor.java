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
