package MostFrequentlyQuestions;

import java.util.*;

/**
 * void birth(String parent, String name) 父亲名字和孩子名字，生个娃
 * void death(String name) 此人要死
 * List<String> getOrder() 返回当前的继承顺序，string array/list
 *
 * 讨论得知，每个人的名字是唯一的，继承顺序符合如下规律:
 * 假设王有大皇子二皇子三皇子，大皇子有长子次子三子，
 * 那么继承顺序是王->大皇子->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 * 死掉的人不能出现在继承顺序里，但是如果上面例子中大皇子死了，
 *     只需把大皇子移除，原始继承顺序保持不变：王->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 *
 * 三个function会被反复调用，实现function细节。
 */
public class KingInherition {
    static Map<String, List<String>> tree = new HashMap<>();
    static Set<String> dead = new HashSet<>();
    String root = "king";
    public KingInherition() {
        tree.put("king", new ArrayList<>());
    }


    public static void main(String[] args) {

    }

    public void birth(String parent, String name) {
        if (!tree.containsKey(parent)) {
            // throw exception
        } else {
            tree.get(parent).add(name);
            tree.put(name, new ArrayList<>());
        }
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getOrder() {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private static void dfs(String curr, List<String> res) {
        if (!dead.contains(curr)) {
            res.add(curr);
        }
        for (String child : tree.get(curr)) {
            dfs(child, res);
        }
    }

}
