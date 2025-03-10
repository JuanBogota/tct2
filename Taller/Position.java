public class Position {
    private int longitude;
    private int latitude;

    public Position(int longitude, int latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    abstract class Machine{
        Position location;
        
        public Machine(int longitude, int latitude){
            this.location = new Position(longitude, latitude);
        }
    }
    }