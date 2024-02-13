class Node{

    Node [] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag = true;
    }

    boolean isFlagSet(){
        return flag == true;
    }

}

class Trie {
    Node root;

    public Trie() {
       root = new Node(); 
    }  
    
    public void insert(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char ch: word.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            }
            else
                return false;
        }
        return node.isFlagSet();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch: prefix.toCharArray()){
            if(node.containsKey(ch)){
                node = node.get(ch);
            }
            else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */