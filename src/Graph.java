import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Graph {

    public static void main(String[] args) {
        int ve = Integer.parseInt(JOptionPane.showInputDialog("Enter no. of vertices"));
        int e = Integer.parseInt(JOptionPane.showInputDialog("Enter no. of edges"));
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[][] matrix = new int[ve][ve];
        for (int i = 0; i < ve; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < e; i++) {
            int u = Integer.parseInt(JOptionPane.showInputDialog("Enter starting node"));
            int v = Integer.parseInt(JOptionPane.showInputDialog("Enter terminating node"));
            if(matrix[u][v] == 1){
                System.out.println("Edge already added");
                continue;
            }
            else {
                matrix[u][v] = 1;
                matrix[v][u] = 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            System.out.println("Edge added");
        }
        System.out.println("Printing Adjacency Matrix");
        for (int i = 0; i < ve; i++) {
            for (int j = 0; j < ve; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Printing Adjacency List");
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + "->");
            for (Integer nodes : graph.get(i)) {
                System.out.print(nodes + "->");
            }
            System.out.println("");
        }
    }
}
