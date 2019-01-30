import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Graph {

    public static void main(String[] args) {
        String vertices = JOptionPane.showInputDialog("Enter no. of vertices");
        String edges = JOptionPane.showInputDialog("Enter no. of edges");
        StringTokenizer verticeTokenizer = new StringTokenizer(vertices,",");
        int ve = verticeTokenizer.countTokens();
        StringTokenizer edgeTokenizer = new StringTokenizer(edges,",");
        int e = edgeTokenizer.countTokens();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[][] matrix = new int[ve][ve];
        for (int i = 0; i < ve; i++) {
            graph.add(new ArrayList<Integer>());
        }
        while(edgeTokenizer.hasMoreTokens()){
            String token = edgeTokenizer.nextToken();
            String[] node = token.split("-");
            int u = Integer.parseInt(node[0]) - 1;
            int v = Integer.parseInt(node[1]) - 1;
            if(matrix[u][v] == 1){
                System.out.println("Edge already added");
                continue;
            }
            else {
                matrix[u][v] = 1;
                matrix[v][u] = 1;
                graph.get(u).add(v+1);
                graph.get(v).add(u+1);
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
            System.out.print((i+1) + "->");
            for (Integer nodes : graph.get(i)) {
                System.out.print(nodes + "->");
            }
            System.out.println("");
        }
    }
}
