import org.junit.Test;
import static org.junit.Assert.assertEquals;

import model.Laser;
import model.Pit;
import model.Wall;
public class TestJunit {
	
	Wall wall1 = new Wall();
	Wall wall2 = new Wall();
	Pit pit1 = new Pit();
	Pit pit2 = new Pit();
	Laser laser1 = new Laser();
	Laser laser2 = new Laser();
	
   @Test
   public void testLaserEquals() {
      assertEquals(laser1, laser2);
   }
   
   @Test
   public void testPitEquals() {
      assertEquals(pit1, pit2);
   }
   
   @Test
   public void testWallEquals() {
      assertEquals(wall1, wall2);
   }
   
   
}