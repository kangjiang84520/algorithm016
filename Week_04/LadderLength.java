package No127;

import java.util.*;

public class LadderLength {
    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(ladderLength.ladderLength(beginWord, endWord, Arrays.asList(wordList)));

    }

    //https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>(); // 在图的BSF中，要通过记录已经访问过的节点来避免环
        visited.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String curWord = queue.poll();
                // 针对当前单词，逐个替换每一位上的字母后进行比较
                if (changeWordEveryOneLetter(curWord, endWord, set, queue, visited)) {
                //if (isNext(curWord, endWord, set, queue, visited)) {
                    return steps + 1;
                }
            }
            // 每处理完一层，步数++
            steps++;
        }
        return 0;
    }


    private boolean isNext(String curWord, String endWord, HashSet<String> set, Queue<String> queue, HashSet<String> visited) {
        if (curWord.equals(endWord)) {
            return true;
        }
        for (String tmpStr : set) {
            int count = 0;
            if (!visited.contains(tmpStr)){
                for (int i = 0; i < tmpStr.length(); i++) {
                    if (curWord.charAt(i) != tmpStr.charAt(i)) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                }
                if (count == 1) {
                    queue.offer(tmpStr);
                    visited.add(tmpStr);
                }
            }
        }
        return false;
    }

    private boolean changeWordEveryOneLetter(String curWord, String endWord, HashSet<String> set, Queue<String> queue, HashSet<String> visited) {
        for (int j = 0; j < curWord.length(); j++) {
            char originChar = curWord.charAt(j);
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                char[] tmpChars = curWord.toCharArray();
                tmpChars[j] = k;
                String nextWord = String.valueOf(tmpChars);
                if (set.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
        }
        return false;
    }
}
