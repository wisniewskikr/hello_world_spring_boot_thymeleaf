package pl.kwi.springboot.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;


@Service
public class CsvService {
	
	
	public List<String[]> readLinesFromFile(InputStream is) {
		
		List<String[]> result = new ArrayList<String[]>();
		
		CSVReader csvReader = null;
		try {
			
			csvReader = new CSVReader(new InputStreamReader(is));
			result = csvReader.readAll();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (csvReader != null) {
				try {
					csvReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return result;
		
	}
	
	
}
