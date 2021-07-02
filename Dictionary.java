package dictionary.dictionary;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
	static Set<String> hash_Set = new HashSet<String>(); 
	List <String> dictniary=new ArrayList<String>();
	
	public Dictionary() { 
		try  
		{   
		String currentDir = System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(currentDir+"/Resources/EnglishWords.txt");       
		Scanner sc=new Scanner(fis);
		while(sc.hasNextLine())  
		{  
			dictniary.add((sc.nextLine()).toLowerCase());
		}  
		sc.close();
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		} 
    	
    }
    public boolean isEnglishWord(String word) {
    	if (dictniary.contains(word.toLowerCase())){
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    public void possibleComb(String strng,String val) {
    	    if (strng.length() == 0)
    	    {
    	    	hash_Set.add(val);
    	        return;
    	    }
    	    for(int i = 0 ;i < strng.length(); i++)
    	    {
    	        char ch = strng.charAt(i);
    	        String left_substr = strng.substring(0, i);
    	        String right_substr = strng.substring(i + 1);
    	        String rest = left_substr + right_substr;
    	        possibleComb(rest, val + ch);
    	    }
    	}
    
    public Set<String> possibleSwitches(String strng) {
    	String val="";
	    for(int i = 0 ;i < strng.length(); i++)
	    {
	        char ch = strng.charAt(i);
	        val=val+ch;
	        if(hash_Set.contains(val)) {
	        	break;
	        }
	        String left_substr = strng.substring(0, i);
	        String right_substr = strng.substring(i + 1);
	        String rest = left_substr + right_substr;
	        possibleSwitches(rest);
	        possibleComb(val,"");
	    }
		return hash_Set;
	    
	}
	
}
