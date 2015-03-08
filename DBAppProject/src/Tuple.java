import java.util.ArrayList;


public class Tuple  {
	ArrayList<Comparable> record;
	boolean tombStone;
	
	public Tuple() {
		tombStone = false;
	}
	
	public static void setNull(Tuple someTuple) {
		 someTuple = null;
	}

}
