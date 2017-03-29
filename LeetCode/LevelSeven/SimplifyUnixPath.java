package LevelSeven;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 * 
 * Here we need to simplify a uniq style path given to us.
 * We will use a stack to keep track of the valid paths, since in unix ".." means previous
 * directory. So if we get a ".." in the given path we need to remove the previous path as
 * its redundant.
 * 
 * Here are the cases that we need to consider:
 *   a) - ".." refers to the previous directory. So if we have something in stack , we pop the last directory.
 *   	  if stack is empty, we simply ignore it.
 *   b) - "//" an empty path such as this needs to be simply ignored. i.e since we will split paths
 *        using "/" if we get and empty dir we ignore.
 *   c) - we also need to ignore curr directory "."
 *      
 *
 */
public class SimplifyUnixPath {
	public String simplifyPath(String path) {
		Stack<String> s = new Stack<>();

		for (String dir : path.split("/")) {
			if (dir.equals("..")) {
				if (!s.isEmpty()) {
					s.pop();
				}
			} else if (!dir.equals("") && !dir.equals(".")) {
				s.push(dir);
			}
		}

		StringBuilder res = new StringBuilder();

		while (!s.isEmpty()) {
			res.insert(0, s.pop());
			res.insert(0, "/");
		}

		return (res.length() == 0) ? "/" : res.toString();
	}
}
