import java.util.ArrayList;

class Fibonacci {

    private static ArrayList<Integer> cache = new ArrayList<>();

    public Fibonacci() {

    }

    public static int fibonacci(int n) {
        if (n < 1) return -1;

        if (n == 1) return 1;
        if (n == 2) return 1;


        if (cache.size() > n - 3) return Fibonacci.cache.get(n - 3);

        int nthFib = fibonacci(n - 1) + fibonacci(n - 2);
        cache.add(n - 3, nthFib);

        return nthFib;
    }
}