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

