import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class EmissionTest {

	Emission e = new Emission();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testWordIterator(){
		Iterator<String> itr = e.wordIterator("A B C");
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
		Iterator<String> itr = e.wordIterator(null);
		
		assertFalse(itr.hasNext());
		exception.expect(NoSuchElementException.class);
		itr.next();
	}
	
	@Test
	public void testWordIteratorEmptyString(){
		Iterator<String> itr = e.wordIterator("");
		
		assertFalse(itr.hasNext());
		exception.expect(NoSuchElementException.class);
		itr.next();
	}
}
