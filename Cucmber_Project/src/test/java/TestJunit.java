import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import model.Damage;
import model.Laser;
import model.LeftTurn;
import model.MoveForward;
import model.Pit;
import model.RightTurn;
import model.Robot;
import model.UTurn;
import model.Wall;
import model.Color;

public class TestJunit {
	
	Wall wall1 = new Wall();
	Wall wall2 = new Wall();
	Pit pit1 = new Pit();
	Pit pit2 = new Pit();
	Laser laser1 = new Laser();
	Laser laser2 = new Laser();
	MoveForward moveForward1 = new MoveForward();
	MoveForward moveForward2 = new MoveForward();
	UTurn uTurn1 = new UTurn();
	UTurn uTurn2 = new UTurn();
	LeftTurn leftTurn1 = new LeftTurn();
	LeftTurn leftTurn2 = new LeftTurn();
	RightTurn rightTurn1 = new RightTurn();
	RightTurn rightTurn2 = new RightTurn();
	Damage damage1 = new Damage();
	Damage damage2 = new Damage();
	Robot robot1 = new Robot(Color.BLUE);
	Robot robot11 = new Robot(Color.BLUE);
	Robot robot2 = new Robot(Color.RED);
	Robot robot21 = new Robot(Color.RED);
	Robot robot3 = new Robot(Color.GREEN);
	Robot robot31 = new Robot(Color.GREEN);
	Robot robot4 = new Robot(Color.YELLOW);
	Robot robot41 = new Robot(Color.YELLOW);
	
   @Test
   public void testLaserEquals() {
      assertEquals(laser1, laser2);
   }
   
   @Test
   public void testWallEquals() {
      assertEquals(wall1, wall2);
   }
   
   
   @Test
   public void testPitEquals() {
      assertEquals(pit1, pit2);
   }
   
   @Test
   public void testUTurnEquals() {
      assertEquals(uTurn1, uTurn2);
   }
   
   @Test
   public void testRightTurnEquals() {
      assertEquals(rightTurn1, rightTurn2);
   }
   
   @Test
   public void testLeftTurnEquals() {
      assertEquals(leftTurn1, leftTurn2);
   }
   
   @Test
   public void testDamageEquals() {
      assertEquals(damage1, damage2);
   }
   
   @Test
   public void testRobotEquals() {
      assertEquals(robot1, robot11);
      assertEquals(robot2, robot21);
      assertEquals(robot3, robot31);
      assertEquals(robot4, robot41);
      assertNotEquals(robot1, robot2);
      assertNotEquals(robot1, robot3);
      assertNotEquals(robot1, robot4);
      assertNotEquals(robot2, robot3);
      assertNotEquals(robot2, robot4);
      assertNotEquals(robot3, robot4);
   }
   
}