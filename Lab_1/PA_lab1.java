/*

  author Dancă Gabriel

 */


public class PA_lab1 {
    public static void main(String[] args) {

        // step 1

        System.out.println("Hello World!");

        // step 2

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        for (String language : languages) {
            System.out.println(language);
        }

        // step 3

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n = n * 3;
        n += 0b10101 + 0xFF;
        n *= 6;
        int result = 0;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }
        int newResult = 0;
        while (result > 9) {
            while (result > 0) {
                newResult += result % 10;
                result /= 10;
            }
            result = newResult;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

        // Bonus problem

        //int number = Integer.parseInt(args[0]);
//        Graph graf = new Graph(6);
//
//        graf.print_matrice();

        // Homework

        StringBuilder array = new StringBuilder();

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int k = Integer.parseInt(args[2]);
        int ok = 0;
        for(int i=a;i<=b;i++) {
            int sum =0;
            int numar_comparator = i;
            int result1 = 0;
            int new_num = 0;
            System.out.println("Numarul pe care il comparam este:" + numar_comparator);
            while (ok == 0) {
                while (numar_comparator > 0) {
                    int digit = numar_comparator % 10;
                    sum = sum + (digit * digit);
                    numar_comparator /= 10;
                }
                if (sum < 10) {
                    result1 = sum;
                    System.out.println("Rezultatul este " + result1);
                    break;
                }
                while (sum > 0) {
                    int digit = sum % 10;
                    new_num = new_num + (digit * digit);
                    sum /= 10;
                }
                if (new_num > 10) {
                    numar_comparator = new_num;
                } else {
                    result1 = new_num;
                    System.out.println("Rezultatul este " + result1);
                    break;
                }
            }
            if (result1 == k) {
                System.out.println("este ok");
                array.append(i + " ");

            } else {
                System.out.println("nu este ok");
            }
        }
        System.out.println(array.toString());
        System.out.println("Running time of the application in nanoseconds is: " + System.nanoTime());

    }
}