package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("x:Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}
	@Test
	void plus() {
		String actual = queryProcessor.process("nutten:what is 20 plus 15");
		System.out.println(actual);
		if (!actual.equals("35")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}
	@Test
	void largest() {
		String actual = queryProcessor.process("abc:%20which%20of%20the%20following%20numbers%20is%20the%20largest:%20601,%2025");
		if (!actual.equals("601")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("x:shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

}
