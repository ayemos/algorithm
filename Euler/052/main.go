package main

import (
	"fmt"
	"sort"
)

func count_digits(n int) (digits []int) {
	flags := make([]bool, 10)

	for ; n > 0; n /= 10 {
		flags[n%10] = true
	}

	for i, b := range flags {
		if b {
			digits = append(digits, i)
		}
	}

	return digits
}

func compare_digits(digitsA []int, digitsB []int) bool {
	if len(digitsA) != len(digitsB) {
		return false
	} else {
		sort.Ints(digitsA)
		sort.Ints(digitsB)

		for i := 0; i < len(digitsA); i++ {
			if digitsA[i] != digitsB[i] {
				return false
			}
		}
	}

	return true
}

func examine(n int) bool {
	var digits []int

	digits = count_digits(n)

	for j := 2; j <= 6; j++ {
		if !compare_digits(digits, count_digits(n*j)) {
			return false
		}
	}

	return true
}

func main() {
	for n := 1; ; n++ {
		if examine(n) {
			fmt.Println(n)
		}
	}
}
