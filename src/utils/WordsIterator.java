package utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class WordsIterator implements Iterator<String>{

	private String[] words ;
	private int i ;
	
	private static String[] EMPTY = new String[0];
	
	public WordsIterator(String line){
		if(line == null || line.equals("")){
			words = EMPTY;
		}else{
			words = line.trim().split(" ");
		}
		i = 0 ;
	}
	
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
	};

}
