package parseinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Samplepars {
	// variable initialized with a comma mark, used later to separate fields in the
	// csv file.
	public static String COMMA_DELIMITER = ",";

	public static void main(String[] args) {
		// List of the type Record, that gets initialized with the content of the object
		// record.
		// the List called line get initialized by scanning the file and using the
		// getRecordFromLine method to separate the fields at the comma mark.
		// the object called record get initialized by the List line & then the type
		// Record List gets initialized with it's value.
		List<Record> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				List<String> line = getRecordFromLine(scanner.nextLine());
				Record record = new Record(line);
				records.add(record);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Variables that get initialized by using a for loop with if statements,
		// checking if indexes contains the requested characters.
		// If a condition is true the variables value increases.
		int nameA1 = 0;
		int nameA2 = 0;
		int workplans = 0;
		// Using the Record object to store the List records indexes & uses it's values
		// in if statement conditions.
		for (int i = 1; i < records.size(); i++) {
			Record record = records.get(i);
			if (!record.emailM1().isBlank()) {
				System.out.println(record.emailM1());
			}
			if (!record.emailM2().isBlank()) {
				System.out.println(record.emailM2());
			}
			if (record.name1.contains("a")) {
				nameA1++;
			}
			if (record.name2.contains("a")) {
				nameA2++;
			}
			if (record.workP.contains("android app")) {
				workplans++;
			}

		}
		// For loops that runs through List Record indexes & stores it's values in two
		// different Record objects in order to compare the list against itself.
		// Also compares elements of the index positions against each other so they
		// won't get equal if they end up comparing the same element.
		// Also checks if there's an empty slot & use that as a condition for the if
		// statement.
		for (int i = 1; i < records.size(); i++) {

			Record record = records.get(i);

			for (int z = 1; z < records.size(); z++) {
				Record recordT = records.get(z);
				if (record.email1.equals(recordT.email2) && z != i && !record.email1.isBlank()) {
					System.out.println("Varning dessa personerna har samma email: " + record.email1 + " " + record.name1
							+ " och " + record.name2 + "!\n");
				}

			}

		}
		
		// For loop used to compare timestamps with each other to see if any are the
		// same & to see if there's an empty element in the index.

		for (int i = 1; i < records.size(); i++) {
			Record record = records.get(i);

			for (int z = 1; z < records.size(); z++) {

				Record recordT = records.get(z);

				if (record.timestamp.equals(recordT.timestamp) && z != i && !record.timestamp.isBlank()) {

					System.out.println("Dessa personerna har samma tidstample " + record.timestamp + " " + record.name1
							+ " och " + record.name2);
				}

			}

		}
		System.out.println("\nAntal personer i grupp 1 med bokstaven a i sitt namn " + nameA1 + ".\n");
		System.out.println("Antal personer i grupp 2 med bokstaven a i sitt namn " + nameA2 + ".\n");
		System.out.println("Antal personer totalt med bokstaven a i sitt namn " + (nameA1 + nameA2) + ".\n");
		System.out.println(workplans + " personer har valt att arbeta med en Andriod app.");
	}

	// creates a list that get separated indexes by using the comma marks in the csv
	// file
	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next().toLowerCase());

			}

		}
		return values;

	}

}
