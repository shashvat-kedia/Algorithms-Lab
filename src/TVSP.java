import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import jdk.internal.util.xml.impl.Input;

public class TVSP {

    public static BufferedReader reader;

    public Node[] tree;
    int delta;

    Set<Integer> points;

    public class Node{
        int a;
        int w;

        public Node(int a,int w){
            this.a = a;
            this.w = w;
        }
    }

    public TVSP(int n,int delta){
        this.tree = new Node[n];
        this.delta = delta;
        this.points = new TreeSet<Integer>();
    }

    public void add(int i,int a,int w){
        this.tree[i] = new Node(a,w);
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public void inorder(int i,int val,int delta){
        if(val > delta){
            points.add(tree[parent(i)].a);
            delta = delta + tree[parent(i)].w;
        }
        if((2*i + 1) < tree.length && tree[2*i + 1] != null){
            inorder(2*i + 1,val + tree[2*i + 1].w,delta);
        }
        if((2*i + 2) < tree.length && tree[2*i + 2] != null){
            inorder(2*i + 2, val + tree[2*i + 2].w,delta);
        }
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        int a,w;
        int n = Integer.parseInt(reader.readLine());
        int delta = Integer.parseInt(reader.readLine());
        TVSP tvsp = new TVSP(n,delta);
        for(int i=0;i<n;i++){
            a = Integer.parseInt(reader.readLine());
            w = Integer.parseInt(reader.readLine());
            tvsp.add(i,a,w);
        }
        tvsp.inorder(0,0,delta);
        for(int point : tvsp.points){
            System.out.println(point);
        }
    }
}
