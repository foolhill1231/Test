package shuwa;

public class prog6_1 {
    static final int N=8;
    static final int SIZE=10;
    
    public static void main(final String[] args) {
        final int[] array = { 7, 4, 3, 7, 4, 7, 4, 9, 1 };
        final int[] bucket = new int[SIZE];
        final int[] sorted = new int[N];
        int i, j, m, c, p;

        Display(array);

        for (i = 0; i < SIZE; i++)
            bucket[i] = 0;

        for (i = 0; i < N; i++) {
            m = array[i];
            bucket[m]++;
        }

        p = 0;
        for (i = 0; i < SIZE; i++) {
            c = bucket[i];
            for (j = 0; j < c; j++) {
                sorted[p] = i;
                p++;
            }
        }

        Display(sorted);
    }

    private static void Display(final int[] data) {
        int i;
        for (i=0;i<N;i++)
        System.out.printf("%d ", data[i]);
        System.out.printf("%n");
        }
        
    }

