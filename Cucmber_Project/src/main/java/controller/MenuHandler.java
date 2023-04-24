package controller;


import java.util.HashSet;
import java.util.Set;

import View.View;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MenuHandler implements EventHandler<MouseEvent> {

	private View view;
	private Set<MenuHandlerObserver> registeredMenuHandlerObservers = new HashSet<MenuHandlerObserver>();
	
	public MenuHandler(View view) {
		this.view = view;
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() instanceof Button) {
			Button button = (Button) event.getSource();
			String buttonText = button.getText();
			
			if ("1".equals(buttonText)) {
				view.typePlayerNames(1);
			}
			else if ("2".equals(buttonText)) {
				view.typePlayerNames(2);
			}
			else if ("3".equals(buttonText)) {
				view.typePlayerNames(3);
			}
			else if ("4".equals(buttonText)) {
				view.typePlayerNames(4);
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
	
	public void setRegisteredObservers(MenuHandlerObserver observer) {
		this.registeredMenuHandlerObservers.add(observer);	
	}
	
	public void notifyMenuHandlerUpdated(int i) {
		for(MenuHandlerObserver o : registeredMenuHandlerObservers) {
			o.menuHandlerUpdated(i);
		}
	}
	
	
	
	
}
