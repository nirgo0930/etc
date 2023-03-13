package recursive_directory_listing;

public class File extends Node {
    public File(java.io.File file) {
        this.file = file;
    }

    @Override
    public boolean isDir() {
        return false;
    }

    @Override
    public long getSize() {
        return file.length();
    }

    @Override
    public void printList() {
        System.out.println("\t" + getPath());
    }
}