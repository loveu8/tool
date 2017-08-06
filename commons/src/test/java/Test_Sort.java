

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import commons.Utils_Sort_Manger;

public class Test_Sort {

	Utils_Sort_Manger sort;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sort = Utils_Sort_Manger.singleton;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntArrayBubbleSort() {
		sort.bubbleSort(sort.genRandomIntList(100,10));
	}
	
	@Test
	public void testIntListBubbleSort() {
		sort.bubbleSort(sort.genRandomIntList(100,10));
	}

}
