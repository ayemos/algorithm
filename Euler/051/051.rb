=begin
By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
=end

require 'prime'

def solve(c)
  100000.step{|n|
    max, maxarg = examine(n)

    if max == c
      return maxarg
    end
  }
end

def count_digits(n)
  Math.log10(n.abs).to_i + 1
end

def examine(n)
  digits = count_digits(n)
  max = 0
  maxarg = nil

  (1..digits - 1).each do |i|
    (0..digits - 1).to_a.combination(i) do |arr|
      c, primes = count_prime(n, arr, digits)
      puts c
      puts primes.to_s

      if c >= max
        max = c
        maxarg = primes.min
      end
    end
  end

  [max, maxarg]
end

def count_prime(n, targets=[], digits)
  c = 0
  comb = 0

  targets.each do |t|
    pow = 10 ** t
    comb += pow
    n -= ((n / pow) % 10)* pow
  end

  primes = []

  10.times do |t|
    if n.prime? && count_digits(n) == digits
      c += 1

      primes << n
    end

    n += comb
  end

  [c, primes]
end

if __FILE__ == $0
  puts solve(8)
end
