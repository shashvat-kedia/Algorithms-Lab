import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Btree {

 private Node root;

 private static class Node {
  public Node left;
  public Node right;
  public int data;

  Node(int newData) {
   left = null;
   right = null;
   data = newData;
  }
 }

 /**
  * Creates an empty binary tree -- a null root pointer.
  */
 public void Btree() {
  root = null;
 }
 // Methods to be created

 /**
  * Inserts the given data into the binary search tree.
  * Uses recursion.
  */
 public Node insert_Recursive(Node node,int data) {
  if(node == null) {
   System.out.println("Data inserted");
   return new Node(data);
  }
  else{
   if(node.data > data){
    node.left = insert_Recursive(node.left,data);
   }
   else{
    node.right = insert_Recursive(node.right,data);
   }
  }
  return node;
 }

 public Node insertIterative(int data) {
  Node node = root;
  Node node1 = new Node(data);
  Node node2 = null;
  while(node != null){
   node2 = node;
   if(node.data > data){
    node = node.left;
   }
   else{
    node = node.right;
   }
  }
  if(node2 == null){
   node2 = node1;
   return node2;
  }
  else if(node2.data > data){
   node2.left = node1;
  }
  else{
   node2.right = node1;
  }
  return null;
 }

 public void printInorder(Node node) {
  if(node.left != null){
    printInorder(node.left);
  }
  System.out.println(node.data);
  if(node.right != null){
    printInorder(node.right);
  }
 }

 public void printPreorder(Node node) {
  if(node != null) {
   System.out.println(node.data);
  }
 if(node.left != null){
   printPreorder(node.left);
 }
 if(node.right != null){
   printPreorder(node.right);
 }
 }
// write recursive Postorder traversal for your binary search tree

 public void printPostorder(Node node) {
  if(node.left != null){
   printPostorder(node.left);
  }
  if(node.right != null){
   printPostorder(node.right);
  }
  System.out.println(node.data);
 }

 /*
* Returns true if the given target is in the binary tree.
* Uses recursion
*/
 public boolean searchRecursive(Node tree, int data) {
  if(tree != null) {
   if(tree.data  == data){
    return true;
   }
   else if(tree.data > data){
    return searchRecursive(tree.left,data);
   }
   else{
    return searchRecursive(tree.right,data);
   }
  }
  return false;
 }

 /**
  * Returns true if the given target is in the binary tree.
  * Non recursive
  */
 public boolean searchIterative(int data) {
  Node node = root;
  while(node != null){
   if(node.data == data){
    return true;
   }
   else if(node.data > data){
    node = node.left;
   }
   else{
    node = node.right;
   }
  }
  return false;
 }

 public static void main(String[] args) throws IOException{
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  Btree btree = new Btree();
  showOptions();
  int opt = Integer.parseInt(reader.readLine()),val;
  while(opt != 8){
   switch (opt){
    case 1:
     System.out.println("Data to insert:");
     val = Integer.parseInt(reader.readLine());
     btree.root = btree.insert_Recursive(btree.root,val);
     break;

    case 2:
     System.out.println("Data to insert:");
     val = Integer.parseInt(reader.readLine());
     Node node = btree.insertIterative(val);
     if(node != null){
      btree.root = node;
     }
     break;

    case 3:
     btree.printPreorder(btree.root);
     break;

    case 4:
     btree.printPostorder(btree.root);
     break;

    case 5:
     btree.printInorder(btree.root);
     break;

    case 6:
      System.out.println("Data to search:");
     val = Integer.parseInt(reader.readLine());
     if(btree.searchRecursive(btree.root,val)){
      System.out.println("Found");
     }
     else{
      System.out.println("Not Found");
     }
     break;

    case 7:
      System.out.println("Data to search:");
     val = Integer.parseInt(reader.readLine());
     if(btree.searchIterative(val)){
      System.out.println("Found");
     }
     else{
      System.out.println("Not Found");
     }
     break;
   }
   showOptions();
   opt = Integer.parseInt(reader.readLine());
  }
 }

 public static void showOptions(){
  System.out.println("1. Insert R");
  System.out.println("2. Insert I");
  System.out.println("3. Preorder");
  System.out.println("4. Postorder");
  System.out.println("5. Inorder");
  System.out.println("6. Search R");
  System.out.println("7. Search I");
  System.out.println("8. Exit");
 }
}