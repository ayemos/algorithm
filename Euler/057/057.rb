=begin
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

√ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
=end

def count_digits(n)
  Math.log10(n.abs).to_i + 1
end

def solve
  a = 3
  b = 2
  c = 0

  1000.times do
    c += 1 if count_digits(a) > count_digits(b)


    tmp = b
    b = a + b
    a = a + tmp + tmp
  end

  c
end

if __FILE__ == $0
  puts solve
end

=begin
3/2
7/5
17/12
41/29
99/70
239/169
...

a/b
a+b+b/a+b
=end
