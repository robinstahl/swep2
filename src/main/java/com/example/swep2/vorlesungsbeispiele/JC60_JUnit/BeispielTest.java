package com.example.swep2.vorlesungsbeispiele.JC60_JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
public class BeispielTest {
	private final Beispiel obj = new Beispiel();

	public BeispielTest() {
		System.out.println(super.toString());
	}

	@Test
	public void addition() {
		assertEquals(10, obj.add(2, 8));
		assertEquals(0, obj.add(-1, 1));
	}

	@Test
//	@Disabled("disabled until error #41 is solved!")
	public void division() {
		assertThrows(ArithmeticException.class, () -> obj.divide(5, 0));
		boolean irgendwas = true;
		assumingThat(irgendwas, ()-> {System.out.println("aha, irgendwas==true");});
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,3,4,5})
	public void test(int x) {
		System.out.println("Parameter: " + x);
	}

	@Test
	public void settergetter() {
		obj.setValue(8);
		assertEquals(8, obj.getValue());
	}

	@Test
	@BeforeAll
	public static void startTests() {
		System.out.println("Starting Test");
	}

	@Test
	@AfterAll
	public static void stopTests() {
		System.out.println("... done");
	}

	@Test
	@BeforeEach
	public void nextTest() {
		System.out.println("next test...");
	}

	@Test
	@AfterEach
	public void afterTest() {
		System.out.println("method ended");
	}
}
