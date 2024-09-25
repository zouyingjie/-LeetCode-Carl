package p27

func removeElement(nums []int, val int) int {
	length := len(nums)
	num := 0
	for i := 0; i < length; i++ {
		if nums[i] != val {
			nums[num] = nums[i]
			num++
		}
	}
	return num
}
