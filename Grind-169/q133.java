import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

// BFS
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> copies = new HashMap<>();
        Node copyGraph = new Node(node.val);
        copies.put(node, copyGraph);
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(node);
        while(!nodes.isEmpty()){
            Node currentNode = nodes.poll();
            List<Node> neigh = copies.get(currentNode).neighbors;
            for(Node neighbor: currentNode.neighbors){
                if(!copies.containsKey(neighbor)){
                    copies.put(neighbor, new Node(neighbor.val));
                    nodes.offer(neighbor);
                }
                neigh.add(copies.get(neighbor));
            }
        }
        return copyGraph;
    }
}