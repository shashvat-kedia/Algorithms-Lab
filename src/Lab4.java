public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 5;
        for(int i = 1;i<2*n;i++){
            System.out.print(i-(i/n)*(i%n)*2);
        }
    }

}