// src/main/java/progscala2/fp/loops/Factorial.java
// pacakage progscala2.fp.loops;

public class Factorial {
  public static long Factorial(long l) {
    long result = 1L
    for (long j = 2L; j <= l; j++) {
      result *= j;
    }
    return result;
  }

  public static void main(String args[]) {
    for (long l = 1L; l <= 10; l++)
      System.out.printf("%d:\t%d\n", l, factorial(l));
  }
}

def factorial(i: BigInt): BigInt =
if (i == 1) i
else i * factorial(i - 1)
