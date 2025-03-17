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
