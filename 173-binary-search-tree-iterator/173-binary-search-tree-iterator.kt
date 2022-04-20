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
class BSTIterator(root: TreeNode?) {

    var stack: ArrayDeque<TreeNode>
    init {
        stack = ArrayDeque()
        var cur = root;
        while (cur != null) {
            stack.addLast(cur)
            cur = cur.left
        }
    }
    
    fun next(): Int {
        val cur = stack.removeLast()
        var right = cur.right
        while (right != null) {
            stack.addLast(right)
            right = right.left
        }
        return cur.`val`
    }

    fun hasNext(): Boolean {
        return !stack.isEmpty()
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */