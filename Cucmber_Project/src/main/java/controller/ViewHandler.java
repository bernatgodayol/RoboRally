package controller;


import java.util.HashSet;
import java.util.Set;

import View.MenuView;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ViewHandler implements EventHandler<MouseEvent> {
	
	private MenuView menuView;
	private Set<ViewHandlerObserver> registeredMenuHandlerObservers = new HashSet<ViewHandlerObserver>();
	
	public ViewHandler(MenuView menuView) {
		this.menuView = menuView;
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() instanceof Button) {
			Button button = (Button) event.getSource();
			String buttonText = button.getText();
			
			if ("1".equals(buttonText)) {
				menuView.typePlayerNames(1);
			}
			else if ("2".equals(buttonText)) {
				menuView.typePlayerNames(2);
			}
			else if ("3".equals(buttonText)) {
				menuView.typePlayerNames(3);
			}
			else if ("4".equals(buttonText)) {
				menuView.typePlayerNames(4);
			}
			else if ("Easy".equals(buttonText)) {
				notifyMenuHandlerUpdated(1);
			}
			else if ("Medium".equals(buttonText)) {
				notifyMenuHandlerUpdated(2);
			}
			else if ("Hard".equals(buttonText)) {
				notifyMenuHandlerUpdated(3);
			}
			
		}
	}

	public void setRegisteredObservers(ViewHandlerObserver observer) {
		this.registeredMenuHandlerObservers.add(observer);	
	}
	
	public void notifyMenuHandlerUpdated(int i) {
		for(ViewHandlerObserver o : registeredMenuHandlerObservers) {
			o.menuHandlerUpdated(i);
		}
	}
	
	
	
	
}
