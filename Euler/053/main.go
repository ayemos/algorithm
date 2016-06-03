package main

import (
	"fmt"
)

func findR(n int, limit int) (r int) {
	tmp := n
	r = 1

	for r < n {
		tmp *= n - r
		r++
		tmp /= r

		if tmp >= limit {
			return r
		}
	}

	return -1
}

func main() {
	var c, r int
	c = 0

	for n := 1; n <= 100; n++ {
		r = findR(n, 1000000)
		fmt.Println(n, r)
		fmt.Println(n - r - r)

		if r >= 1 {
			c += n - r - r + 1
		}
	}

	fmt.Println(c)
}
