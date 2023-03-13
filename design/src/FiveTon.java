import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FiveTon {
    private static List<FiveTon> list = Collections.synchronizedList(new LinkedList<FiveTon>());
    private static int index = 0;

    private FiveTon() {
    }

    public static FiveTon getInstance() {
        if (list.size() < 5) {
            synchronized (list) {
                FiveTon newObj = new FiveTon();
                list.add(newObj);
                return newObj;
            }
        } else {
            synchronized (list) {
                FiveTon head = list.get(index);
                index = (index + 1) % list.size();
                return head;
            }
        }
    }

    public int getSize() {
        return list.size();
    }


    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            FiveTon ft = FiveTon.getInstance();
            System.out.println("Fiveton : " + ft + " Size is " + ft.getSize());
        }
    }
}