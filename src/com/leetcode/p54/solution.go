package p54

func spiralOrder(matrix [][]int) []int {
	rowSize := len(matrix)
	colSize := len(matrix[0])
	size := rowSize * colSize

	direction := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	currentDirection := 0
	row, col := 0, 0

	var result []int
	for len(result) < size {
		result = append(result, matrix[row][col])
		matrix[row][col] = 1000

		nextRow := row + direction[currentDirection][0]
		nextCol := col + direction[currentDirection][1]
		if nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize || matrix[nextRow][nextCol] == 1000 {
			currentDirection = (currentDirection + 1) % 4
		}

		row += direction[currentDirection][0]
		col += direction[currentDirection][1]
	}
	return result
}
