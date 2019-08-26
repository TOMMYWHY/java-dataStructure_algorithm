package dataStructures;

/**
 * Created by Tommy on 2019/8/24.
 */
public class TestMain {

    public static void main(String[] args){
        System.out.println("testing...");

//        StackArrayBox box =  new StackArrayBox();
        LinkedListBox box =  new LinkedListBox();




        for( int i =1; i<12;i++){
            box.add(5*i);
        }

        System.out.println();
//        System.out.println("StackArray");
        System.out.println("LinkedList");
        for (int i=0;i<box.size();i++) {
            System.out.print(box.get(i) + "; ");
        }
        System.out.println();
        System.out.println(box.pop(2));

        System.out.println("Array pop");
        for (int i=0;i<box.size();i++) {
            System.out.print(box.get(i) + "; ");
        }

    }
}
