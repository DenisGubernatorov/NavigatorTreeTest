package actions;

import processing.ConstructTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Actions {

	private String text;
	DefaultMutableTreeNode model;
	public DefaultMutableTreeNode buttonAction(String text) {

		Path path = Paths.get(text);
		System.out.println(Files.isDirectory(path));
		if (Files.isDirectory(path)){
			model = new ConstructTree().tree(path);
		} else
			model = null;
		return model;

	}
}
