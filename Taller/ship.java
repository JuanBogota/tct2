import java.util.Collection;

public class Ship extends Machine {

    private Collection<Sailor> sailors;

public Ship(Position location, Collection<Sailor> sailors, int longitude, int latitude) {
        super(location);
        this.sailors = sailors;
    }

public Ship(int longitude, int latitude){
    this.location = new Position(longitude, latitude);
}



}

