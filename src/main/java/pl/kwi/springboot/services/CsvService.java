package pl.kwi.springboot.services;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;

@Service
public class CsvService {
	
	
	public List<String[]> readLinesFromFile(InputStream is) {
		
		List<String[]> result = new ArrayList<String[]>();
		
		try {
			
			CSVReader csvReader = new CSVReader(new InputStreamReader(is));
			result = csvReader.readAll();
			csvReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
}
