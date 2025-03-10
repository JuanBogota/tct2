import java.util.ArrayList;

public class fleet{
    private int name;
    private ArrayList<Machine> machines;
    private ArrayList<Sailor> sailors;
    private Board board;

public fleet(int name, int board){
    this.name = name;
    this.machines = new ArrayList<>();
    this.sailors = new ArrayList<>();
    this.board = board;
}

public weakMachines(){
    for (int[] m : machines){
        if (sailors.size() < 5){
            return true;
            weakMachines.add(machine);
        } else {
            return false;
        } 
    }
}
}