package recursive_directory_listing;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=======================================");
        FileSystemManager manager = new FileSystemManager();
        manager.setNodeTree(2);

        manager.printTotalList(null); // 전체리스트 출력
        System.out.println("=======================================");
    }
}