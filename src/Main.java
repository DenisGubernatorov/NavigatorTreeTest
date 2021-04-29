import window.NavigatorGUI;
import actions.*;
import processing.*;


import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
	public static void main(String[] args) throws InterruptedException, InvocationTargetException {
		NavigatorGUI gui = new NavigatorGUI();
		//Actions action = new Actions();
		//ConstructTree ctree = new ConstructTree();

		EventQueue.invokeAndWait(() -> {

			gui.init();

		});


	}
}
