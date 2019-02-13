package stepik.tree;

import java.util.Random;

/**
 * Декартово дерево поиска (Tree + Heap = Treap)
 * Дерамида = дерево + пирамида
 * Декартово дерево - структура данных, объединяющая в себе бинарное дерево поиска и бинарную кучу
 * (отсюда и второе её название: treap (tree+heap) и дерамида (дерево+пирамида).
 * <p>
 * <T extends Comparable<T>> implements SearchTree<T>
 */

public class Treap {

    static private Random rand = new Random();
    public long x, sum;
    public long y;
    public Treap Left, root;
    public Treap Right;

    public Treap(long x) {
        this(x, rand.nextInt());
        if (root == null){
            root = this;
            sum = 0;
        }
        sum += x;
    }

    private Treap(long x, long y) {
        this.x = x;
        this.y = y;
        this.Left = null;
        this.Right = null;
        sum += x;
    }

    long getSum(Treap node){
        return node == null ? 0 : node.sum;
    }

    void update(Treap node){
        if(node == null){
            return;
        }
        node.sum = getSum(node.Left) + getSum(node.Right);
    }

    private Treap(long x, long y, Treap left, Treap right) {
        this.x = x;
        this.y = y;
        this.Left = left;
        this.Right = right;
        sum += x;
    }

    /**
     * Слияние
     *
     * @param L левое поддерево
     * @param R правое поддерево
     * @return Объединённое дерево
     */
    public Treap Merge(Treap L, Treap R) {
        if (L == null) return R;
        if (R == null) return L;
        if (L.y > R.y) {
            Treap node = new Treap(L.x, L.y, L.Left, Merge(L.Right, R));
            update(node);
            return node;
        } else {
            Treap node = new Treap(R.x, R.y, Merge(L, R.Left), R.Right);
            update(node);
            return node;
        }
    }

    public Treap[] Split(long x) {
        Treap newTree = null;
        Treap L, R;
        if (this.x < x) {
            if (Right == null)
                R = null;
            else {
                Treap[] gg = Right.Split(x);
                newTree = gg[0];
                R = gg[1];
            }
            L = new Treap(this.x, y, Left, newTree);
            update(L);
        } else {
            if (Left == null)
                L = null;
            else {
                Treap[] gg = Left.Split(x);
                L = gg[0];
                newTree = gg[1];

            }
            R = new Treap(this.x, y, newTree, Right);
            update(R);
        }
        return new Treap[]{L, R};
    }

    /**
     * Поиск значения в дереве поиска
     *
     * @param value Значение
     * @return найдено ли значение?
     */
    public boolean find(long value) {
        if (x == value)
            return true;
        if (x > value)
            if (Left != null)
                return Left.find(value);
        if (x < value)
            if (Right != null)
                return Right.find(value);
        return false;
    }

    // здесь будут операции...

    public int deep() {
        return 0;
    }

    public void Add(long x) {
        Treap[] t = Split(x);
        Treap l = t[0];
        Treap r = t[1];
        Treap m = new Treap(x, rand.nextInt());
        //update(node);
        root = Merge(Merge(l, m), r);
    }

    public void show(Treap root){
        if (root == null) return;
        show(root.Left);
        System.out.print(root.x + " ");
        show(root.Right);
    }

    public void showTree(){
        show(root);
    }

    public Treap Remove(long x) {
        if (this.x == x)
            return Merge(Left, Right);
        if (this.x > x)
            if (Left != null)
                Left = Left.Remove(x);
        if (this.x < x)
            if (Right != null)
                Right = Right.Remove(x);
        update(this);
        return this;
    }

    public static void main(String[] args) {
        Treap treap = new Treap(5);
        for (int i = 0; i < 10; i++) {
            treap.Add(rand.nextInt(100));
        }
        treap.showTree();
        System.out.println(treap.getSum(treap));
    }

}