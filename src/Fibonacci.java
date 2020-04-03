import java.util.ArrayList;

class Fibonacci {

    private static ArrayList<Integer> cache = new ArrayList<>();

    public Fibonacci() {

    }

    public static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0 | n == 1) return n;


        if (cache.size() > n - 2) return Fibonacci.cache.get(n - 2);

        int nthFib = fibonacci(n - 1) + fibonacci(n - 2);
        cache.add(n - 2, nthFib);

        return nthFib;
    }
}