import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab6 {

    public static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        String a,b;
        reader = new BufferedReader(new InputStreamReader(System.in));
        a = reader.readLine();
        b = reader.readLine();
        int p[][] = new int[a.length()+1][b.length()+1];
        for(int i=0;i<=a.length();i++){
            for(int j=0;j<=b.length();j++){
                if(i == 0 || j == 0){
                    p[i][j] = 0;
                } else{
                    if(a.charAt(i-1) == b.charAt(j-1)){
                        p[i][j] = 1 + p[i-1][j-1];
                    } else{
                        p[i][j] = Math.max(p[i-1][j],p[i][j-1]);
                    }
                }
            }
        }
        System.out.println("LCS length:- ");
        System.out.println(p[a.length()][b.length()]);
        int i = a.length(),j = b.length();
        String commonSubse = "";
        while(i >= 1 && j >= 1){
            if(p[i][j] == 1 + p[i-1][j-1]){
                commonSubse = a.charAt(i-1) + " " + commonSubse;
                i--;
                j--;
            } else{
                if(p[i][j] == p[i-1][j]){
                    i--;
                } else if(p[i][j] == p[i][j-1]){
                    j--;
                }
            }
        }
        System.out.println("LCS:- ");
        System.out.println(commonSubse);
        System.out.println("LCS matrix:- ");
        for(i=0;i<a.length();i++){
            for(j=0;j<b.length();j++){
                System.out.print(p[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
