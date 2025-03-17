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
