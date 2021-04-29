package processing;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConstructTree {
	private String s;


		//DefaultTreeModel model;


		//Path path = Paths.get(s);

		 public DefaultMutableTreeNode tree(Path path){
			DefaultMutableTreeNode root = new DefaultMutableTreeNode(path.getFileName(), true);

			try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
				for (Path p: stream){
					if (Files.isDirectory(p)) {  //TODO  если в последнем каталоге нет файлов, то он отображается листом
						root.add(tree(p));

					}
					else
						root.add(new DefaultMutableTreeNode(p.getFileName(), true));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return root;
		}


}
