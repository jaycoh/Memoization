# Memoization
### Description

Memoization is a method used to optimize the runtime of functions (functions that are optimized in this way can be referred to as *memoized 
functions*). In particular, memoization is able to be used on functions that are *referentially transparent*, 
meaning that:

- The function will always have the same output when given a certain input, ie it cannot be non-deterministic nor can it require some data 
  (such as an object) that may hold different values
  
- The function has no side effects, ie it does not affect another part of the program 

This makes memoization particularly useful in functional programming, where functions do not utilize mutable data.

Essentially, in a memoized function, whenever the function is called with some input for the first time, the return value is stored in a 
cache, and whenever the function is called again with that same input, rather than recompute the function we use the stored return 
value. By doing this, we assume a space-time tradeoff: as we add input-output pairs into our cache, we save time on all future function calls
of that particular input, but we also need space to store these values.

Therefore, it is not necessarily always beneficial to use meomization. Functions that are best suited to be memoized are those with high computational cost, especially when their outputs take up relatively little space. Memoization is especially useful for many recursive 
problems, where many function calls can be reduced to 𝗢(𝟭) time, and the total time saved is greatly increased.
### My example

I chose to illustrate the memoization technique on a function that computes the n-th value of the fibonacci sequence (more information can
be found [here](https://en.wikipedia.org/wiki/Fibonacci_number)). I chose this, as it is a problem that most people are familiar with and the 
recursive nature of the problem leads to high computational costs when given a large valued input, making it a great candidate to highlight memoization. This function is Fibonacci.fibonacci.

In my function, I chose to cache the values in a static array. I chose to store my values this way, as the inputs given are all continuous. 
For example, if I call the function with n = 8, then the function will also be called on n = 7, n = 6, n = 5, ..., n = 0. Thus the inputs stored are all the integers from 0 until
the maximum input given. In this case, any future calls to fibonacci(n) will be able to access our returned value.

The first thing my function does is check for base cases (n = 0 or n = 1) and return appropriate values if needed. If n > 1, then we check to see if fibonacci(n) is stored in the cache.
If so, we return the stored value, and thus our work is done. Otherwise, we recursively call the function on the n - 1 and n - 2 case, sum them up, add the sum to our cache for the n-th case, and return the sum.

### The Results

Running the code in Main.java gives us a true comparison of the fibonacci sequence with memoization. The first time printed to the screen is the time a recursive fibonacci function takes to return the 45th value of the sequence. This function runs in **O(n^2)** time
I then run the fibonacci sequence with memoization twice: once to put our n = 45 value into the cache, and once to check the runtime when we are reusing an input in a memoized function. The runtimes of both are printed to the screen.

I found that a fibonacci sequence with no memoization takes 11413 milliseconds, and both calls to fibonacci with memoization run in 0ms.

It is easy to see why the second call to fibonacci(45) is so fast (since the n = 45 case is stored, we can access this value in **O(1)** time, but even the first call with memoization runs very quickly. This is because the values are stored in our recursive calls as we go. Remember that Fibonacci(45) = fibonnaci(44) + fibonacci(43). Fibonacci(44) is executed first, so when we finish that call and go to fibonacci(43), we find that the value is already stored and thus is returned in **O(1)** time. Within the fibonacci(44) call, this happens at every level. Thus, with our implementation for Fibonacci.fibonacci, we have achieved **O(n)** time, as the value of fibonacci(n) is calculated exactly once for each n from 0 until our initial input. 


