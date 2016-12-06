package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Data;

public class ProcessFile {
	
	public static List<Data> openFile(String filePath) {
		List<Data> dataList = new ArrayList<Data>();
		
		try {
			/** Open file */
			File file = new File(filePath);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			Data data = null;
			/** Read file */
			while (br.ready()) {
				
				String str = br.readLine();
				if(str.indexOf(">")==0){
					data = new Data();
					/** Species */
					data.setMark(str);
					int endIndex = str.indexOf("/");
					String species = str.substring(1, endIndex);
					data.setSpecies(species);
				}else{
					/** Squence */
					String squence = str;
					if(!squence.equals("")) {
						char[] squenceArray = squence.toCharArray();
						data.setSquence(squenceArray);
						dataList.add(data);
					}
				}
			}
			/** Close file */
			br.close();
			fr.close();
		} catch (Exception e) {
			/** Exception error */
			e.printStackTrace();
		}
		/** Return Data List */
		return dataList;
	}
	
	public static void writeFile_allData(List<Data> dataList, double percent) {
		try {
			FileWriter fw = new FileWriter("Species-squence.txt", false);
			for(Data data:dataList) {
				if(data.getSimilarity() < percent) { continue; }
				fw.write(data.getMark() + "_" + data.getSimilarity() + "\n");
				char[] array = data.getSquence();
				for(char atom:array) {
					fw.write(atom);
				}
				fw.write("\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile_onlyMark(List<Data> dataList, double percent) {
		try {
			FileWriter fw = new FileWriter("Species-mark.txt", false);
			for(Data data:dataList) {
				if(data.getSimilarity() < percent) { continue; }
				fw.write(data.getMark() + "_" + data.getSimilarity() + "\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
