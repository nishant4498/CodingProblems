package LevelFour;
/*
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * For search a word can contain 
 */
public class AddAndSearchWord {
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("nishant");
		System.out.println(wordDictionary.search("nishant"));
		System.out.println(wordDictionary.search("n.sh.n."));
	}
}

class WordDictionary {
    TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i =0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
       return dfsSearch(word, root , 0);
    }
    
    public boolean dfsSearch(String word, TrieNode node , int start){
        /*
         * Base cases are important.
         */
    	if(start == word.length() && node.isEnd()) return true;
        
        if(start >= word.length()) return false;
        
        char ch = word.charAt(start);
        boolean result = false;
        if(ch == '.'){
            for(int j = 0;j < 26 ; j++ ){
                if(node.get(j) != null){
                    result = dfsSearch(word, node.get(j), start +1);
                    if (result){
                        break;
                    }
                }
            }
            //return result;
        }else{
            if(node.containsKey(ch)){
                result =  dfsSearch(word, node.get(ch) , start + 1);
            }else{
                result = false;
            }
        }
        
        return result;
    }
}

class TrieNode {
    public TrieNode[] links;
    public int numLinks = 26;
    public boolean isEnd;
    public int size;
    
    public TrieNode() {
        links = new TrieNode[numLinks];    
    }
    
    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
        size++;
    }
    
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    
    /*
     * To accomodate the . feature in search, we need to iterate over all the keys in the
     * link. Thus we need a way to either get the links array directly or get node from
     * links by index.
     */
    public TrieNode get(int index){
        return links[index];
    }    
    
    public boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    
    public boolean isEnd(){
        return isEnd;
    }
    
    public void setEnd(){
        isEnd = true;
    }
}
