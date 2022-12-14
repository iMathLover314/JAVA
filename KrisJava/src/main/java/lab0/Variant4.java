package lab0;

import static java.lang.Math.pow;

public class Variant4 {
    public static int intTask(int a, int b) {
        return a / b;
    }

    /*Boolean4. Даны два целых числа: A, B. Проверить истинность высказывания: «Справедливы неравенства A > 2 и B <= 3».*/
    public static boolean booleanTask(int a, int b) {
        return a > 2 && b <= 3;
    }

    /*If4*. Даны три целых числа. Найти количество положительных чисел в исходном наборе.*/
    public static int ifTask(int a, int b, int c) {
        int counter = 0;
        if (a > 0) counter++;
        if (b > 0) counter++;
        if (c > 0) counter++;
        return counter;
    }

    /*Case4*. Дан номер месяца — целое число в диапазоне 1–12 (1 — январь, 2 — февраль и т. д.).
    Определить количество дней в этом месяце для невисокосного года.*/
    public static int caseTask(int m) {
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                m = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                m = 30;
                break;
            case 2:
                m = 28;
                break;
            default:
                m = 0;
        }
        return m;
    }

    /*For4. Дано вещественное число — цена 1 кг конфет. Вывести стоимость 1, 2, … , 10 кг конфет.*/
    public static double[] forTask(double n) {
        double res[] = new double[10];
        int j = 0;
        for (int i = 1; i <= 10; ++i)
        {
            res[j] = n * i;
            System.out.print(res[j] + " ");
            j++;
        }
        return res;
    }

    /*While4*. Дано целое число N (> 0).
    Если оно является степенью числа 3, то вывести True, если не является — вывести False.*/
    public static boolean whileTask(int n) {
        double s = 1;
        double k = 0;
        while (n >= s) {
            s *= 3;
            if (s == n) {
                k++;
            }
        }
        if (k > 0) {
            return true;
        }
        return false;
    }

    /*Array4. Дано целое число N (> 1), а также первый член A и знаменатель D геометрической прогрессии.
    Сформировать и вывести массив размера N, содержащий N первых членов данной прогрессии*/
    public static int[] arrayTask(int n, int d, int a) {
        int arr[] = new int[n];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            arr[j] = (int) (a * Math.pow(d, i));
            j++;
        }
        return arr;
    }
    /*Matrix4. Даны целые положительные числа M, N и набор из N чисел.
    Сформировать матрицу размера M ґ N,
    у которой в каждой строке содержатся все числа из исходного набора (в том же порядке).*/
    public static int[][] matrixTask(int m, int arr[])
    {
        int res[][] = new int[m][arr.length];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < arr.length; j++)
            {
                res[i][j] = arr[j];
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }
}
