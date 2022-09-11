class Solution {
    class Pair(val i: Int, val j: Int)
    
    fun numIslands(grid: Array<CharArray>): Int {
        val visit = Array(grid.size) { BooleanArray(grid[0].size) }
        val stack = Stack<Pair>()
        var count = 0
        for(i in 0 until grid.size){
            for(j in 0 until grid[0].size){
                if(grid[i][j] == '1' && !visit[i][j]){
                    stack.add(Pair(i, j))
                    while(!stack.isEmpty()){
                        val pair = stack.pop()
                        visit[pair.i][pair.j] = true
                        if(pair.i > 0 && !visit[pair.i-1][pair.j] && grid[pair.i-1][pair.j] == '1'){
                            stack.add(Pair(pair.i-1, pair.j))
                        }
                        if(pair.i+1 < grid.size && !visit[pair.i+1][pair.j] && grid[pair.i+1][pair.j] == '1'){
                            stack.add(Pair(pair.i+1,pair.j))
                        }
                        if(pair.j > 0 && !visit[pair.i][pair.j-1] && grid[pair.i][pair.j-1] == '1'){
                            stack.add(Pair(pair.i, pair.j-1))
                        }
                        if(pair.j+1 < grid[0].size && !visit[pair.i][pair.j+1] && grid[pair.i][pair.j+1] == '1'){
                            stack.add(Pair(pair.i, pair.j+1))
                        }
                    }
                    count++
                }
            }
        }
        return count
    }
}

/**
[["1"]]
[["0"]]
[["1", "1"]]
[["1", "0"]]
[["1"], ["1"]]
[["1"], ["0"]]
[["1", "1"], ["1", "1"]]
[["1", "1"], ["1", "0"]]
[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
[["1","0","1","1","1"],["1","0","1","0","1"],["1","1","1","0","1"]]
**/
