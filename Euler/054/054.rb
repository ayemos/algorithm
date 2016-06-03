=begin
High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
=end

SCORE_MAP = {
  royal: 14 ** 10
  straight_flush: 14 ** 9
  four: 14 ** 8
  full_house: 14 ** 7
  flush: 14 ** 6
  straight: 14 ** 5
  three: 14 ** 4,
  two: 14 ** 3,
  one: 14 ** 2,
  none: 14 ** 1
}

NUM_MAP = {
  A: 14,
  T: 10,
  J: 11,
  Q: 12,
  K: 13
}

def flush?(hand)
  c = hand.first[1]
  if hand.all?{|h| h[1] == c}
    hand_to_digits(hand).sort[0]
  else
    nil
  end
end

def hand_to_digits(hand)
  digits = hand.map{|h| NUM_MAP[h[0].to_sym] || h[0].to_i }.sort
end

def straight?(hand)
  digits = hand_to_digits(hand)

  last = nil
  digits.each do |d|
    if last
      return nil if d - last != 1
    end

    last = d
  end

  digits[0]
end

def count_digits(hand)
  group = Array.new(13, 0)

  hand.each do |h|
    d = NUM_MAP[h[0].to_sym] || h[0].to_i
    group[d - 2] += 1
  end

  group
end

def max_pair(hand)
  group = count_digits(hand)

  max = 0
  argmax = -1
  13.times do |n|
    if group[n] >= max
      max = group[n]
      argmax = n
    end
  end

  [max, argmax]
end

def calc_partial(hand, pair_argmax)
  res = []
  hand_to_digits(hand).each do |d|
    if d != pair_argmax
      res << d
    end
  end

  p = 1
  score = 0
  res.sort.each do |d|
    score += d * p
    p *= 10
  end

  score.to_f / 10000000
end

def calc(hand)
  score = 0
  pair_max, pair_argmax = max_pair(hand)

  if sd = straight?(hand)
    if fd = flush?(hand)
      if sd == 10
        # royal
        score += SCORE_MAP[:royal]
      else
        # straight flush
        score += SCORE_MAP[:straight_flush] * sd
      end
    else
      # straight only
      score += SCORE_MAP[:straight] * sd
    end
  else
    if d = flush?(hand)
      # flush only
      score += SCORE_MAP[:flush] * d
    end
  end

  # four
  if pair_max == 4
    score += SCORE_MAP[:four] * pair_argmax
    score += calc_partial(hand, pair_argmax)
  end

  # full house
  if pair_max == 3 && count_digits(hand).sort[-2] == 2
    score += SCORE_MAP[:full_house] * pair_argmax
    score += calc_partial(hand, pair_argmax)
  end


  # three
  if pair_max == 3
    score += SCORE_MAP[:three] * pair_argmax
    score += calc_partial(hand, pair_argmax)
  end

  # two
  if pair_max == 2
    puts "TWO"
    puts hand.to_s
    score += SCORE_MAP[:two] * pair_argmax
    score += calc_partial(hand, pair_argmax)
  end

  # one
  if pair_max == 1
    score += SCORE_MAP[:one] * pair_argmax
    score += calc_partial(hand, pair_argmax)
  end

  # none
  if pair_max == 0
    score += calc_partial(hand, -1)
  end

  score
end

def judge(hand1, hand2)
#  puts hand1.to_s
#  puts calc(hand1)
  calc(hand1) > calc(hand2)
end

def solve(file)
  c = 0

  File.open(file).each do |line|
    hand1 = line[0..13].split(' ')
    hand2 = line[15..line.size].split(' ')

    if judge(hand1, hand2)
      c += 1
    end
  end

  puts c
end

if __FILE__ == $0
  solve('./p054_poker.txt')
end
