package process;

import java.util.List;

import entity.Data;
import file.ProcessFile;

public class Similarity {

	List<Data> dataList;
	Data human;
	
	public void similarityProcess(String filePath, double percent) {
		dataList = ProcessFile.openFile(filePath);
		human = getHumanData(dataList);
		
		/** human v.s others accuracy */
		getSimilarity(human, dataList);
		
		/** write file */
		ProcessFile.writeFile_allData(dataList, percent);
		ProcessFile.writeFile_onlyMark(dataList, percent);
	}
	
	private void getSimilarity(Data human, List<Data> dataList) {
		char[] humanSquence = human.getSquence();
		int[] accuracyRange = {0,0,0,0,0,0,0,0,0,0,0};
		
		for(Data data:dataList) {
			char[] dataSquence = data.getSquence();
			int humanCount = 0;
			int matchCount = 0;
			
			for(int i=0;i<humanSquence.length;i++){
				if(humanSquence[i] != '-') {
					humanCount++;
					//System.out.println("human:"+humanSquence[i]+";;other:"+dataSquence[i]);
					if(humanSquence[i] == dataSquence[i]){
						matchCount++;
					}
				}
			}
			double accuracy = (double)matchCount / (double)humanCount;
			data.setSimilarity(accuracy);
			
			System.out.println(accuracy+";;"+(int)(accuracy*10));
			switch((int)(accuracy*10)){
			case 0:
				accuracyRange[0]++;
				break;
			case 1:
				accuracyRange[1]++;
				break;
			case 2:
				accuracyRange[2]++;
				break;
			case 3:
				accuracyRange[3]++;
				break;
			case 4:
				accuracyRange[4]++;
				break;
			case 5:
				accuracyRange[5]++;
				break;
			case 6:
				accuracyRange[6]++;
				break;
			case 7:
				accuracyRange[7]++;
				break;
			case 8:
				accuracyRange[8]++;
				break;
			case 9:
				accuracyRange[9]++;
				break;
			case 10:
				accuracyRange[10]++;
				break;
			}
		}
		
		for(int i=0;i<11;i++) {
			System.out.println("about:"+i+"0%"+accuracyRange[i]);
		}
		
	}
	
	/**
	 * Get LYSC_HUMAN Data
	 * @param dataList
	 * @return
	 */
	private Data getHumanData(List<Data> dataList) {
		Data result = null;
		
		for(Data data:dataList) {
			if(data.getSpecies().equals("LYSC_HUMAN")) {
				result = data;
			}
		}
		return result;
	}
}
