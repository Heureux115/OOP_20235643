import java.util.Scanner;
public class vehinh{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= (2* i - 1); k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}

