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

    public void move(int dLon, int dLat) {
        location.setLongitude((location.getLongitude() + dLon) % 180);
        location.setLatitude((location.getLatitude() + dLat) % 90);
    }

    public abstract boolean isWeak();
    public abstract void selfDestruct(String reason);
}