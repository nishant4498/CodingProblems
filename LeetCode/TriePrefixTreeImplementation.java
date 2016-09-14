
public class TriePrefixTreeImplementation {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("nishant");
		System.out.println(trie.search("nishant"));
		System.out.println(trie.startsWith("nisu"));
	}

}

class TrieNode{
	private TrieNode[] links;
	private final int numLinks = 26;
	private boolean isEnd;
	
	
	public TrieNode(){
		links = new TrieNode[numLinks];
	}
	
	public boolean containsKey(char ch){
		return links[ch - 'a'] != null;
	}
	
	public TrieNode get(char ch){
		return links[ch - 'a'];
	}
	
	public void put(char ch , TrieNode node){
		links[ch - 'a'] = node;	
	}
	
	public void setEnd() {
		this.isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}

class Trie{
	/*
	 * A root for a trie just holds the links for the first level.It does not contain 
	 * any value.
	 */
	TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	 // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i =0; i < word.length(); i++){
        	char currChar = word.charAt(i);
        	if(!node.containsKey(currChar)){
        		node.put(currChar, new TrieNode());
        	}
        	node = node.get(currChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
    	TrieNode node = root;
        for(int i =0; i < word.length(); i++){
        	char currChar = word.charAt(i);
        	if(node.containsKey(currChar)){
        		node = node.get(currChar);
        	}else{
        		return null;
        	}        	
        }
        return node;    
   }

    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
