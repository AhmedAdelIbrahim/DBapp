import java.io.Serializable;
import java.util.ArrayList;


public class Page implements Serializable {
	int tuples;
	ArrayList<ArrayList<Comparable>> records;
	ArrayList<Boolean> tombStone; 
	public Page() {
		tuples = 0;
		tombStone = new ArrayList<Boolean>();
		records = new ArrayList<ArrayList<Comparable>>();
	}
	public boolean insert(ArrayList<Comparable> myTuple){
		if(tuples < 20) {
			records.add(myTuple);
			tuples++;
			return true;
		}
		else{
			return false;
		}
	}
	public boolean delete(Object Key) {
		Tuple myTuple = this.search(Key);
		int index = records.indexOf(myTuple);
		
		if(index != -1 && (!tombStone.get(index))) {
			tombStone.add(index, true);
			tuples--;
			return true;
		}
		else {
			System.out.println("Record not found");
			return false;
		}
	}
	// check 2alabtaha
	public ArrayList<ArrayList<Comparable>> search (Object Key) {
		 ArrayList<ArrayList<Comparable>> wanted = null;
		 for(int i = 0; i<tuples; i++) {
			 for(int j = 0; j<records.get(i).size() ; j++){
				 if(Key.equals(records.get(i).get(j))) {
					 wanted.add(records.get(i));
				 }
			 }
		 }
		 return wanted;
	}
	

	
	
}
