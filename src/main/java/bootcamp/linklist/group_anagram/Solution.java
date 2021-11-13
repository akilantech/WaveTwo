package bootcamp.linklist.group_anagram;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        List<List<String>> lists = new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>  groupAnagram = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] v = strs[i].toCharArray();
            Arrays.sort(v);
            String sortedString = new String(v);
            if(groupAnagram.containsKey(sortedString)){
                List<String> strings = groupAnagram.get(sortedString);
                strings.add(strs[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                groupAnagram.put(sortedString, list);
            }

        }
        return new ArrayList<>(groupAnagram.values());
    }
}
