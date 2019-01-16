import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Lab1 {

    static LinkedList<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args){
        Random random = new Random();
        for(int i=0;i<10;i++){
            list.add(random.nextInt(1000) + 1);
        }
        String query = JOptionPane.showInputDialog("Enter query here");
        while(!(query.compareToIgnoreCase("quit") == 0)){
            if(query.compareToIgnoreCase("pop") == 0){
                pop();
            } else if(query.compareToIgnoreCase("push") == 0){
                push(random.nextInt(1000) + 1);
            } else if(query.compareToIgnoreCase("delete") == 0){
                delete();
            } else if(query.compareToIgnoreCase("add") == 0){
                add(random.nextInt(1000) + 1);
            } else{
                System.out.println("Command not found");
            }
            query = JOptionPane.showInputDialog("Enter query here");
        }
    }

    private static void pop(){
        if(list.size() > 0) {
            list.removeFirst();
        }
        printList();
    }

    private static void push(int val){
        list.addFirst(val);
        printList();
    }

    private static void delete(){
        if(list.size() > 0) {
            list.removeFirst();
        }
        printList();
    }

    private static void add(int val){
        list.addLast(val);
        printList();
    }

    private static void printList(){
        if(list.size() > 0) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        } else{
            System.out.println("Empty list");
        }
        System.out.println("");
    }


}