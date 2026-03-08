/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // maps original node -> its clone
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }

        // if we've already cloned this node, return the existing clone
        // (prevents infinite loop on cycles)
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // create the clone and register it BEFORE visiting neighbors
        // (so cycles point to this clone instead of triggering infinite recursion)
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // recursively clone each neighbor and add it to the clone's neighbor list
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }
}