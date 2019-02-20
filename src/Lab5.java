import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab5 {

    public static BufferedReader reader;

    static int num, i, j;
    static int magicSquare[][];

    static void generateSquare(int n, int num) {
        if (num == 0) {
            return;
        }
        System.out.println(i + " " + j);
        if (i == -1 && j == n) {
            j = n - 2;
            i = 0;
        }
        else {
            if (j == n)
                j = 0;
            if (i < 0)
                i = n - 1;
        }
        if (magicSquare[i][j] != 0) {
            j -= 2;
            i++;
            generateSquare(n, num - 1);
        } else
            magicSquare[i][j] = num++;
        j++;
        i--;
        generateSquare(n, num - 1);
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        i = n / 2;
        j = n - 1;
        magicSquare = new int[n][n];
        generateSquare(n, n * n);
    }
}
