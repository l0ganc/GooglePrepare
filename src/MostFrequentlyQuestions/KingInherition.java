package MostFrequentlyQuestions;

/**
 * void birth(String parent, String name) 父亲名字和孩子名字，生个娃
 * void death(String name) 此人要死
 * List<String> getOrder() 返回当前的继承顺序，string array/list
 *
 * 讨论得知，每个人的名字是唯一的，继承顺序符合如下规律:
 * 假设王有大皇子二皇子三皇子，大皇子有长子次子三子，那么继承顺序是王->大皇子->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 * 死掉的人不能出现在继承顺序里，但是如果上面例子中大皇子死了，只需把大皇子移除，原始继承顺序保持不变：王->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 *
 * 三个function会被反复调用，实现function细节。
 */
public class KingInherition {
    public static void main(String[] args) {

    }
}
