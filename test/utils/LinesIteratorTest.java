package utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;

import java.io.StringBufferInputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.hamcrest.core.AnyOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinesIteratorTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testIterator(){
		LinesIterator itr = new LinesIterator(new StringBufferInputStream("abc\ndef\n123"));
		assertTrue(itr.hasNext());
		assertEquals("abc", itr.next());
		assertTrue(itr.hasNext());
		assertEquals("def", itr.next());
		assertTrue(itr.hasNext());
		assertEquals("123", itr.next());
		assertFalse(itr.hasNext());
		
		exception.expect(NoSuchElementException.class);
		itr.next();
	}
	
	@Test
	public void testIterable(){
		LinesIterator itr = new LinesIterator(new StringBufferInputStream("abc\ndef\n123"));
		for(String s: itr){
			assertThat(s, AnyOf<T>());
			assertEquals("abc", itr.next());
			assertTrue(itr.hasNext());
			assertEquals("def", itr.next());
			assertTrue(itr.hasNext());
			assertEquals("123", itr.next());
		}
		
		assertFalse(itr.hasNext());
		
		exception.expect(NoSuchElementException.class);
		itr.next();
	}
}
