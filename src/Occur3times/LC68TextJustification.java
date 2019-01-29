package Occur3times;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 */
public class LC68TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;

            // 这步就是算出一行一共能塞多少个单词
            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth) {  // 这里的+1是两个word中间的空格的宽度
                    break;
                }
                count += words[last].length() + 1;  // 依然要加上1个空格
                last++;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last - 1 - index;

            // 处理最后一行，尽力向左缩进
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < words.length; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                // 处理除最后一行以外的其他行
                int spaces = (maxWidth - count) / diff;  // spaces存放的是平均每两个单词间要放的空格数
                int r = (maxWidth - count) % diff;   // r存放的是需要多给左边的空格数
                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k >= 0; k--) {
                        sb.append(" ");
                    }
                    if (r > 0) {
                        sb.append(" ");
                        r--;
                    }
                    // 此时要append下两个单词间本来就应该有的一个空格
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }

    public static void main(String[] args) {
        int maxWidth = 20;
        String[] words = new String[] {
                "Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"
        };
        List<String> res = fullJustify(words, maxWidth);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}
