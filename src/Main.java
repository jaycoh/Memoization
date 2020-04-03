class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(Fibonacci.fibonacciNoMO(45)); //without memoization
        System.out.println("Time taken without memoization: " + (System.currentTimeMillis() - startTime) + " ms");

        Fibonacci.fibonacci(45); // Run first time to store values in cache
        startTime = System.currentTimeMillis();
        Fibonacci.fibonacci(45); //Time with memoization
        System.out.println("Time taken with memoization: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}