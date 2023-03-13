package recursive_directory_listing;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileSystemManager {

    private List rootDirList = new ArrayList();
    private File[] roots;

    public FileSystemManager() {
        this.roots = File.listRoots();
    }

    public int rootSize() {
        return roots.length;
    }

    public List getRootDirList() {
        return rootDirList;
    }

    public void setNodeTree() {
        setNodeTree(0, roots.length);
    }

    public void setNodeTree(int index) throws Exception {
        if (index > roots.length - 1) {
            throw new Exception("인덱스가 너무 큽니다.");
        }
        setNodeTree(index, index + 1);
    }

    public void setNodeTree(int startIndex, int lastIndex) {
        for (int i = startIndex; i < lastIndex; i++) {
            Node dirNode = new Directory(roots[i]);
            rootDirList.add(dirNode);
        }
    }

    public void printTotalList(List list) {
        if (list == null) {
            list = rootDirList;
        }
        Iterator it = list.iterator();

        while (it.hasNext()) {
            Node node = (Node) it.next();
            node.printList();
        }
    }
}