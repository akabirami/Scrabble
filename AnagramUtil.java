import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramUtil {

	public static void main(String[] args) {
		
		Map<String,String> anagram=getMapOfWords();
		System.out.println(printAnargam(anagram));
	}
		
		
	private static String printAnargam(Map<String, String> anagram) {
		// TODO Auto-generated method stub
		String clusters="";
		for(String s: anagram.keySet()){
			if(anagram.get(s).contains(" ")){
				clusters+=anagram.get(s)+"\n";
			}
		}
		return clusters;
		
	}

	public static Map<String,String> getMapOfWords(){
		 Map<String,String> words_count = new HashMap<String,String>();
			
			try {
				FileInputStream fstream = new FileInputStream("sowpods.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

				String strLine;
				while ((strLine = br.readLine()) != null)   {
				  
					String sorted=sortLetters(strLine);
				     
					     if(words_count.keySet().contains(sorted))
					     {
					    	 
					         words_count.put(sorted, words_count.get(sorted)+"  "+strLine);
					     }
					     else
					         words_count.put(sorted,strLine);

					}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return words_count;
		
	}

	private static String sortLetters(String strLine) {
		// TODO Auto-generated method stub
		char[] chars = strLine.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars).toLowerCase();
		return sorted;
	}
}
