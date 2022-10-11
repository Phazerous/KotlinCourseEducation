data class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Tree {
    var height: Int = 0
    var root: TreeNode? = null

    fun insert(n: Int) {
        height = 1
        root = insert(root, n, 1)
    }

    fun insert(node: TreeNode?, n: Int, level: Int): TreeNode {
        height = if (level > height) level else height

        if (node == null) return TreeNode(n)

        if (node.value == n) return node

        if (node.value > n) {
            node.right = insert(node.right, n, level + 1)
        } else {
            node.left = insert(node.left, n, level + 1)
        }

        return node
    }
}

fun main() {
    val tree = Tree()
    var n: Int

    while (true) {
        n = readln().toInt()

        if (n == 0) break

        tree.insert(n)
    }

    println("Height of the tree: " + tree.height)
}