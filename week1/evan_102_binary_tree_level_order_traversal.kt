/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode?>()
        var result = mutableListOf<List<Int>>()
        var left = mutableListOf<Int>()
        var right = mutableListOf<Int>()
        
        if(root != null){
            queue.add(root)
        }
        
        while(!queue.isEmpty()){
            val node = queue.pop()
            
            val level = getLevel(root, node, 0)
            if(result.size <= level){
                result.add(mutableListOf<Int>())
            }
            result[level]+=mutableListOf<Int>(node!!.`val`)
            if(node!!.left != null){
                queue.add(node!!.left)
            }
            if(node!!.right != null){
                queue.add(node!!.right)
            }
        }
        return result
    }
    
    fun getLevel(node: TreeNode?, target: TreeNode?, depth: Int): Int{
        if(node == null) return -1
        if(target == node) return depth
        return Math.max(getLevel(node!!.right, target, depth+1), getLevel(node!!.left, target, depth+1))
    }
}
/**
[1]
[3,9,20,null,null,15,7]
[1,2,3,4,null,null,5]
[1,2,3,4,5,6,7,null,null,null,null,8,9,null,null]
**/

