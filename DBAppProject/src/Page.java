import java.io.Serializable;
import java.util.ArrayList;


public class Page implements Serializable {
	int tuples;
	ArrayList<Tuple> records;
	
	public Page() {
		tuples = 0;
		records = new ArrayList();
	}
	public boolean insert(Tuple myTuple){
		if(tuples < 20) {
			records.add(myTuple);
			return true;
		}
		else{
			return false;
		}
	}
	public boolean delete(Tuple myTuple) {
		int index = records.indexOf(myTuple);
		if(index != -1 && records.get(index).tombStone == false) {
			Tuple record = records.get(index) ;
			record.tombStone = true;
			return true;
		}
		else {
			System.out.println("Record not found");
			return false;
		}
	}
	public Tuple search (Object Key) {
		 Tuple wanted = new Tuple();
		 for(int i = 0; i<tuples; i++) {
			 for(int j = 0; j<records.get(i).record.size() ; j++){
				 if(Key.equals(records.get(i).record.get(j))) {
					 wanted =  records.get(i);
					 break;
				 }
			 }
		 }
		 return wanted;
	}
	

	
	
}
