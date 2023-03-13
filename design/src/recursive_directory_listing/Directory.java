package recursive_directory_listing;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Node {
    private List nodeList = new ArrayList();

    public Directory(File file) {
        this.file = file;
        iterate();
    }

    @Override
    protected Node add(Node node) {
        nodeList.add(node);
        return this;
    }

    @Override
    protected Node remove(Node node) {
        nodeList.remove(node);
        return this;
    }

    @Override
    protected Node getChild(int num) {
        nodeList.get(num);
        return this;
    }

    @Override
    public boolean isDir() {
        return true;
    }

    @Override
    public long getSize() {
        long size = 0;
        Iterator it = nodeList.iterator();

        while (it.hasNext()) {
            Node node = (Node) it.next();
            size += node.getSize();
        }
        return size;
    }

    @Override
    public void printList() {
        System.out.println(getPath() + "(size: " + getSize() + " byte)"); // 디렉터리

        Iterator it = nodeList.iterator(); // 하위 파일들

        while (it.hasNext()) {
            Node node = (Node) it.next();
            node.printList(); // 재귀호출
        }
    }

    public List getNodeList() {
        return nodeList;
    }

    private void iterate() {
        File[] children = file.listFiles();

        if (children == null) {
            return;
        }

        for (File child : children) {
            if (child.isHidden()) {
                continue;
            }
            // 디렉토리와 파일을 구분하여 List에 추가
            if (child.isDirectory()) {
                nodeList.add(new Directory(child));
            } else {
                nodeList.add(new recursive_directory_listing.File(child));
            }
        }
    }
}