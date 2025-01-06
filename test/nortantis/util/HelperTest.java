package nortantis.util;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelperTest
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Test
	public void testNullInput()
	{
		assertNull(Helper.array2DTo1D(null));
	}

	@Test
	public void testEmptyArray()
	{
		float[][] input = new float[0][0];
		float[] expected = new float[0];
		assertArrayEquals(expected, Helper.array2DTo1D(input), 0f);
	}

	@Test
	public void testSingleElementArray()
	{
		float[][] input = { { 1.0f } };
		float[] expected = { 1.0f };
		assertArrayEquals(expected, Helper.array2DTo1D(input), 0f);
	}

	@Test
	public void testRegularArray()
	{
		float[][] input = { { 1.0f, 2.0f }, { 3.0f, 4.0f } };
		float[] expected = { 1.0f, 2.0f, 3.0f, 4.0f };
		assertArrayEquals(expected, Helper.array2DTo1D(input), 0f);
	}

	@Test
	public void testRegularArrayLarger()
	{
		float[][] input = { { 1.0f, 2.0f, 3.0f }, { 4.0f, 5.0f, 6f }, {7f, 8f, 9f}};
		float[] expected = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6f, 7f, 8f, 9f };
		assertArrayEquals(expected, Helper.array2DTo1D(input), 0f);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testArrayConversion()
	{
		float[][] expected = { { 1.0f, 2.0f, 3.0f }, { 4.0f, 5.0f, 6f }, {7f, 8f, 9f}};
		float[][] actual = Helper.array1DTo2D(Helper.array2DTo1D(expected), expected.length, expected[0].length);
		assertEquals(expected, actual);
	}
}
