package base_level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class QuickSort {

    private Scanner in;

    public QuickSort() {
        in = new Scanner(System.in);
    }

    private void run(){
        int n = in.nextInt(), m = in.nextInt();
        TreeMap<Node, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(in.nextInt(), in.nextInt(), i);
            map.put(node, map.getOrDefault(node, 1) + 1);
        }
        int tmp;
        for (int i = 0; i < m; i++) {
            tmp = in.nextInt();
            int le = map.floorEntry(new Node(tmp, tmp, 0)).getKey().i;
            int ra = map.ceilingEntry(new Node(tmp, tmp, 0)).getKey().i;
            System.out.println(le + " " + ra);
//            if(left != -1 && right != -1)
//                System.out.print(right - left + " ");
//            else System.out.print(0 + " ");
        }
    }

    static class Node implements Comparable<Node>{
        int l, r, i;

        public Node(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }

        @Override
        public String toString() {
            return String.format("[l = %d, r = %d]", l, r);
        }

        @Override
        public int compareTo(Node o) {
            return this.l - o.l;
        }
    }


    public static void main(String[] args) {
        new QuickSort().run();
    }
}
