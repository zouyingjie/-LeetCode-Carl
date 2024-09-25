package p977

func sortedSquares(nums []int) []int {
	start, end := 0, len(nums)-1
	index := end
	result := make([]int, len(nums))

	for index >= 0 {
		startVal := nums[start] * nums[start]
		endVal := nums[end] * nums[end]

		if startVal > endVal {
			result[index] = startVal
			start++
		} else {
			result[index] = endVal
			end--
		}
		index--
	}
	return result
}
