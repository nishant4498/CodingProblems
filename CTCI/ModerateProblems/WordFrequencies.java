package ModerateProblems;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencies {
	Map<String, Integer> wordCountMap = new HashMap<>();

	public Map<String, Integer> generateDictionary(String[] book) {
		for (String word : book) {
			if (!wordCountMap.containsKey(word)) {
				wordCountMap.put(word, 1);
			} else {
				wordCountMap.put(word, wordCountMap.get(word) + 1);
			}
		}

		return wordCountMap;
	}

	public int getWordFrequency(String word) {
		if (wordCountMap == null || word == null)
			return -1;
		word = word.toLowerCase();
		if (wordCountMap.containsKey(word)) {
			return wordCountMap.get(word);
		}
		return -1;
	}
}
