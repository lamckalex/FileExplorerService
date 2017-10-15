package com.github.tobycapapps.fileexplorerservice;

import fileExplorerService.Main;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyTest {
	@Test
	public void two_plus_two_equals_four() {
		assertEquals(4, 2 + 2);
	}

	@Test
	public void main_test() {
		Main.main(new String[] {"C:\\"});
	}
}
