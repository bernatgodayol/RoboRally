
public class Reboot extends Element {
	
	public void punishPlayer(Robot robot) {
		robot.getPlayer().getProgrammingDeck().getDeck().add(Card.Damage);
	}
}