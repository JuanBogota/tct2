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