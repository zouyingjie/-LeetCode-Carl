package p209

import "math"

func minSubArrayLen(target int, nums []int) int {
	minLen := math.MaxUint32

	left := 0
	sum := 0
	numsLen := len(nums)
	for right := 0; right < numsLen; right++ {
		sum += nums[right]
		for sum >= target {
			minLen = int(math.Min(float64(minLen), float64(right-left+1)))
			sum -= nums[left]
			left++
		}
	}

	if minLen == math.MaxUint32 {
		return 0
	} else {
		return minLen
	}
}
