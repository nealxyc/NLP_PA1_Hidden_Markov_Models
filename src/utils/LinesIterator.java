package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinesIterator implements Iterator<String>, Iterable<String>{

	private BufferedReader br ;
	private String line ;
	
	public LinesIterator(InputStream is){
		 br = new BufferedReader(new InputStreamReader(is));
		 readNextLine();
	}
	
	@Override
	public boolean hasNext() {
		return line != null ;
	}

	@Override
	public String next() {
		if(line == null){
			throw new NoSuchElementException();
		}
		String ret = line ;
		readNextLine();
		return ret;
	}
	
	boolean readNextLine(){
		try {
			line = br.readLine() ;
		} catch (IOException e) {
			return false;
		}
		return true ;
	}
	
	public WordsIterator iteratorOfNextLine(){
		return new WordsIterator(next());
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<String> iterator() {
		return this;
	}

}
