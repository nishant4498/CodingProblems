package Level8;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 * 
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * 
 * dir
 *   subdir1
 *   subdir2
 *       file.ext
 *       
 * If we represent this as a tree, we will have the below:
 * 
 * 			dir           		Level 0
 *          / \
 *   subdir1   subdir2    		Level 1
 *              \
 *               file.txt 		Level 2
 *               
 * The longest length of path will be 
 * 
 * dir/subdir2/file.txt with length = 20
 * 
 * Here we maintain a stack of length which is initiaized with zero.
 * We split the given string path on the basis of "\n"  - After that the number of tabs("\t") in each part
 * tells the level at which the dir/file is located.
 * 
 * e.g file.txt will be represented as "\t\tfile.txt" after we split with "\n"
 * 
 * Thus level = s.lastIndexOf("\t") + 1 ,here it will be  1 + 1 = 2
 * 
 * Here last index of \t = 1.
 *
 */
public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input){
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int maxLength = 0;
		
		for(String s : input.split("\n")){
			int level = s.lastIndexOf("\t") + 1;
			
			/**
			 * Here we are trying to to get the parent directory for the current file directory.
			 * Hence we keep removing all the other directories.
			 * If we look at level 0, we will start with one element in the stack,0.
			 * Thus for us to be at the correct level in the stack, level + 1 = stack.size()
			 * 
			 * It means that we are at level 2, there should be 3 elements in the stack, 
			 *       0, level 0- and level 1
			 */
			while(level + 1 < stack.size()) stack.pop();
			
			/**
			 * To compute the length, we take the length till parent directory.
			 * Add the length of string.
			 * Since the level number shows the number of "\t" in the string, we subtract that length
			 * Add 1 since we need to append "\"
			 */
			int len = stack.peek() + s.length() - level + 1;
			stack.push(len);
			
			/**
			 * Here we compare with len -1 , since in the ned we do not need the "\" which is counted above.
			 */
			if(s.contains(".")) maxLength = Math.max(maxLength, len -1);			
		}
		return maxLength;
	}
}
