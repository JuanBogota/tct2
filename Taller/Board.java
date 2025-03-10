public class Board {

    private ArrayList<Fleet> fleets;


public Board(){
    this.board = new ArrayList<Fleet>();
}


public ArrayList<Fleet> getFleets() {
    return fleets;
}


public void setFleets(ArrayList<Fleet> fleets) {
    this.fleets = fleets;
}
}