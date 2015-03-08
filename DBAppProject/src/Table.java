import java.util.ArrayList;
import java.util.Hashtable;


public class Table {
	ArrayList<Page> pages;
	Hashtable<String,String> col;
	Hashtable<String,String> ref;
	Hashtable<String, Integer> index;
	ArrayList<String> primary;
	String name;
	public Table (String name, ArrayList<String> colName, ArrayList<String> types,Hashtable<String,String> ref,ArrayList<String> primary) {
		if (colName.size() != types.size())
			return; 
		for(int i = 0; i <colName.size(); i++) {
			col.put(colName.get(i), types.get(i));
			index.put(colName.get(i), i);
		}
		this.name = name; 
		pages = new ArrayList<Page>();
		this.ref = ref;
		this.primary = primary;
	}
	public boolean insertIntoTable(ArrayList<String> colName , ArrayList<Comparable> values) {
		ArrayList<Integer> ColNum = new ArrayList<Integer>();
		if(colName.size() != values.size())
			return false;
		// check primary key not null constraints
		// check if repeated namecol or command not valid 
		for(int i = 0; i <colName.size(); i++) {
			if(!index.containsKey(colName.get(i)))
				return false;
		}
		Page curr = pages.get(pages.size()-1);
		int rowIndex = curr.records.size()-1;
		ArrayList<Comparable> tuple = new ArrayList<Comparable>(); 
		for(int i = 0; i < colName.size(); i++) {
			int temp = index.get(colName.get(i));
			tuple.add(temp,values.get(i));
		}
	    boolean result = curr.insert(tuple);
	    if(!result) {
	    	Page page = new Page();
	    	page.insert(tuple);
	    	this.pages.add(page); 
	    }
	    return true; 
	}
	public boolean deleteFromTable(ArrayList<String> colName , ArrayList<Comparable> values){
		ArrayList<Integer> ColNum = new ArrayList<Integer>();
		if(colName.size() != values.size())
			return false;
		// check primary key not null constraints
		// check if repeated namecol or command not valid 
		for(int i = 0; i <colName.size(); i++) {
			if(!index.containsKey(colName.get(i)))
				return false;
		}
		// lesa msh 5elst 
		return false; 
	}
}
