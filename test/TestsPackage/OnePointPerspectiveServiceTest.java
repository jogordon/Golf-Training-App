package TestsPackage;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import service.OnePointPerspectiveService;

public class OnePointPerspectiveServiceTest {

	@Test
	public void test() {
		OnePointPerspectiveService.initialize();
		OnePointPerspectiveService.setScreenSize(1024, 768);
		Point xy = OnePointPerspectiveService.Transform(0,0);
		assertEquals(1024/2, xy.x);
		assertEquals(768, xy.y);
		
		xy = OnePointPerspectiveService.Transform(100,100);
		
		assertEquals(1024/2+100, xy.x);
		assertEquals(668, xy.y);
	}

}
