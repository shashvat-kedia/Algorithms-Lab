import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab4 {
    /**
     * @param args the command line arguments
     */
    static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int MIN = Integer.MIN_VALUE,gre;
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i=0;i<n;i++){
            int p = Integer.parseInt(reader.readLine());
            integers.add(p);
            if(p > MIN){
                MIN = p;
            }
        }
        int Y[] = new int[MIN+1];
        for(int i = 0;i<n;i++){
            Y[integers.get(i)]++;
        }
        for(int i=0;i<=MIN;i++){
            if(Y[i] != 0){
                for(int j=0;j<Y[i];j++) {
                    System.out.print(i + " ");
                }
            }
        }
        selection_sort(integers,integers.size());
    }

    public static void selection_sort(ArrayList<Integer> list,int n){
        Lab4 r = new Lab4();
        int[] list1 = Arrays.asList(list);
        r.selection_sort_r(list1,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(list1[i] > list1[j]){
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    public int[] selection_sort_r(int[] list,int index,int n){
        for(int i=0;i<n;i++){
            int min = selection_sort_p(list,index,i,n);
                int temp = list[min];
                list[min] = list[index];
                list[index] = temp;
        }
        return selection_sort_r(list,index+1,n);
    }

    public int selection_sort_p(int[] list,int index,int index1,int n){
            if(list[index1] > list[index]) {
                return index1;
            }
            return selection_sort_p(list,index,index1+1,n);
    }
}