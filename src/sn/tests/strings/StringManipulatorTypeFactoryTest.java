package sn.tests.strings;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sn.java.strings.SimpleStringManipulator;
import sn.java.strings.StringManipulatorTypeFactory;
import sn.java.strings.iface.IStringManipulator;

public class StringManipulatorTypeFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStringManipulatorWithValidType() {
		List<String> testInputStringList = new ArrayList<>();
		IStringManipulator stringManipulator = StringManipulatorTypeFactory.INSTANCE.getStringManipulator("SIMPLE", testInputStringList);
		assertTrue(stringManipulator instanceof SimpleStringManipulator);
	}
	
	@Test
	public void testGetStringManipulatorWithInValidType() {
		List<String> testInputStringList = new ArrayList<>();
		assertNull(StringManipulatorTypeFactory.INSTANCE.getStringManipulator("INVALID", testInputStringList));
	}
	
	@Test
	public void testStringManipulatorFactoryForNull(){
		assertNotNull(StringManipulatorTypeFactory.INSTANCE);
	}

}
