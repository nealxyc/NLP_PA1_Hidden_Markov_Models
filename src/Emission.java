import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import utils.LinesIterator;


public class Emission {
	
	public static void main(String args[]){
		
	}
	
	private Map<String, Map<String, Integer>> tagCount = new HashMap<>();
	/**
	 * Reads input as count and outputs emission 
	 * @param count
	 * @param emisson
	 * @throws IOException 
	 */
	public void readTagCount(InputStream countInput) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(countInput));
		LinesIterator lines = new LinesIterator(countInput);
		while(lines.hasNext()){
			String line = lines.next();
			Iterator<String> words = wordIterator(line);
			if(words.hasNext()){
				int count = Integer.parseInt(words.next());
				String type = words.next() ;
				if("WORDTAG".equals(type)){
					String tag = words.next() ;
					String word = words.next();
					if(!tagCount.containsKey(tag)){
						tagCount.put(tag, new HashMap<String, Integer>());
					}
					Map<String, Integer> wordMap = tagCount.get(tag);
					if(wordMap.containsKey(word)){
						//Should not happen
						wordMap.put(word, wordMap.get(word) + count);
					}else{
						wordMap.put(word, count);
					}
				}else if("1-GRAM".equals(type)){
					
				}else if("2-GRAM".equals(type)){
					
				}else if("3-GRAM".equals(type)){
					
				}else{
					// not recognizing this type
				}
			}
		}
	}
	
	static Iterator<String> NULL_ITR = new Iterator<String>(){

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public String next() {
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}};
		
	Iterator<String> wordIterator(final String line){
		if(line == null || line.equals("")){
			return NULL_ITR ;
		}
		
		return new Iterator<String>(){
			String[] words = line.trim().split(" ");
			int i = 0 ;
			@Override
			public boolean hasNext() {
				return i < words.length;
			}

			@Override
			public String next() {
				if(i < words.length){
					return words[i++];
				}else{
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}};
	}
}
