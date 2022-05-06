package jh.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

//    解释：
//1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
//1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
//3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
//2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
//4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
//没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
//  1178

    public static void main(String[] args) {

        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(findNumOfValidWords(words,puzzles));
    }

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> rs = new ArrayList<>();
        String[] newWords = new String[words.length];
        for (int i =0 ; i < words.length ; i++){
            Map<Character,Integer> have = new HashMap<>();
            String newWord = "";
            for (Character c : words[i].toCharArray()) {
                if(!have.containsKey(c)){
                    newWord+=c;
                    have.put(c,null);
                }
            }
            newWords[i] = newWord;
        }
        for(String puzzle:puzzles){
            Integer i = 0;
            for(String word:newWords){
                if(word.indexOf(puzzle.charAt(0))>-1) {
                    Integer wordLen = word.length();
                    Integer haveLen = 0;
                    for (Character c : word.toCharArray()) {
                        if (puzzle.indexOf(c) > -1) {
                            haveLen++;
                        }
                    }
                    if (wordLen == haveLen) {
                        i++;
                    }
                }
            }
            rs.add(i);
        }
        return rs;
    }

}
