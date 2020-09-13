package parseinfo;

import java.util.List;

public class Record {
	//Variables declared which later get initialized in the constructor.
	String timestamp;
	String name1;
	String name2;
	String email1;
	String email2;
	String workP;
	//Constructor that initializes variables with values from sample.csv.
	public Record(List<String> record) {

		timestamp = record.get(0);
		name1 = record.get(1);
		name2 = record.get(2);
		email1 = record.get(3);
		email2 = record.get(4);
		workP = record.get(6);
	}
	
	//Methods that combines two different indexes.
	public String emailM1() {
		
		return name1 + " " + email1;
	}
	public String emailM2() {
		
		return name2 + " " + email2;
	}
}
