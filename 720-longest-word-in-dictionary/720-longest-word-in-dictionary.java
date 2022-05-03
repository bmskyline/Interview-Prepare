class Solution {
	private TreeNode root;
	private String result = "";

	public String longestWord(String[] words) {
		root = new TreeNode();

		for (String w : words)
			insert(w);

		dfs(root);

		return result;
	}

	private void dfs(TreeNode node) {
		if (node == null)
			return;

		if (node.word != null) {
			if (node.word.length() > result.length())
				result = node.word;
		}

		for (TreeNode child : node.children)
			if (child != null && child.word != null)
				dfs(child);
	}

	private void insert(String word) {
		TreeNode current = root;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new TreeNode();
			current = current.children[c - 'a'];
		}
		current.word = word;
	}

}

class TreeNode {
	TreeNode[] children = new TreeNode[26];
	String word;

	TreeNode () {}
}