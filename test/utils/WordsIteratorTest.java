package utils;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import utils.WordsIterator;


public class WordsIteratorTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testWordIterator(){
		Iterator<String> itr = new WordsIterator("A B C");
		assertTrue(itr.hasNext());
		assertEquals("A", itr.next());
		assertTrue(itr.hasNext());
		assertEquals("B", itr.next());
		assertTrue(itr.hasNext());
		assertEquals("C", itr.next());
		assertFalse(itr.hasNext());
		
		exception.expect(NoSuchElementException.class);
		itr.next();
	}
	
	@Test
	public void testWordIteratorNull(){
		Iterator<String> itr =new WordsIterator(null);
		
		assertFalse(itr.hasNext());
		exception.expect(NoSuchElementException.class);
		itr.next();
	}
	
	@Test
	public void testWordIteratorEmptyString(){
		Iterator<String> itr = new WordsIterator("");
		
		assertFalse(itr.hasNext());
		exception.expect(NoSuchElementException.class);
		itr.next();
	}
}
