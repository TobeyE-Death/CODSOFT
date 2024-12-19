import java.util.Scanner;

public class GradeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int[] m = new int[n];
        int t = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            m[i] = sc.nextInt();
            t += m[i];
        }

        double avg = (double) t / n;
        String g;

        if (avg >= 90) g = "A";
        else if (avg >= 80) g = "B";
        else if (avg >= 70) g = "C";
        else if (avg >= 60) g = "D";
        else if (avg >= 50) g = "E";
        else g = "F";

        System.out.println("Total Marks: " + t);
        System.out.println("Average Percentage: " + avg);
        System.out.println("Grade: " + g);
    }
}