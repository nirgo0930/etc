package recursive_directory_listing;

public abstract class Node {
    // 노드가 실제로 나타내는 파일 객체
    protected java.io.File file;

    public abstract long getSize(); // 사이즈 반환

    public abstract boolean isDir(); // 디렉토리 여부 반환

    public abstract void printList(); // 노드 리스트 출력

    public java.io.File getFile() {
        return file;
    }

    public String getPath() {
        return file.getPath();
    }

    public String toString() {
        return getPath() + "(" + getSize() + ")";
    }

    protected Node add(Node node) throws Exception {
        throw new Exception();
    }

    protected Node remove(Node node) throws Exception {
        throw new Exception();
    }

    protected Node getChild(int num) throws Exception {
        throw new Exception();
    }
}