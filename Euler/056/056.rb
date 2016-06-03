=begin
A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
=end

def sum_digit(n)
  s = 0

  while n > 0
    s += n % 10
    n /= 10
  end

  s
end

def solve
  max = 0
  argmax = 0
  1.step(99) do |a|
    1.step(99) do |b|
      num = a ** b
      sum = sum_digit(num)
      if sum > max
        max = sum
        argmax = num
      end
    end
  end

  puts max, argmax
end

if __FILE__ == $0
  solve
end
