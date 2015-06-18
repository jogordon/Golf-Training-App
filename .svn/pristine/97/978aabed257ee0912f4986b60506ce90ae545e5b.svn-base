package TestsPackage;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.PlotInfo;
import models.PlotMessenger;

import org.junit.Test;

public class PlotMessengerTest {

	@Test
	public void test() {
		final String IMAGE_ROOT = "src/resources/";
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(IMAGE_ROOT + "orc_forward_east.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		PlotInfo plotElementInfo = new PlotInfo(image, 1,2,3,4);
		PlotInfo shadow = null;
		PlotMessenger pm1 = new PlotMessenger(plotElementInfo, shadow);
		assertEquals(1, pm1.getPlotElementInfo(). getImageStartX());
		assertEquals(2, pm1.getPlotElementInfo().getImageStartY());
		assertEquals(3, pm1.getPlotElementInfo().getImageWidth());
		assertEquals(4, pm1.getPlotElementInfo().getImageHeight());
		
	}

}
