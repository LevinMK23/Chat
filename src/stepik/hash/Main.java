package stepik.hash;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static long [] pow;

    static class Node{

        LinkedList<String> list;

        public Node() {
            list = new LinkedList<>();
        }
    }

    static Node [] table;

    static int h(String word, int mod){
        long code = 0, x = 263, mul = 1, max = Long.MAX_VALUE / 255;
        for (int i = 0; i < word.length(); i++) {
            //System.out.print(word.charAt(i) * mul + " ");
            code += word.charAt(i) * pow[i];
        }
        return (int) ((code % 1000000007) % mod);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mod = in.nextInt();
        int n = in.nextInt();
        table = new Node[mod];
        pow = new long[20];
        pow[0] = 1;
        long p = 1000000007L;
        for (int i = 1; i < 20; i++) {
            pow[i] = ((pow[i-1] % p) * (263 % p)) % p;
        }
        String query, word;
        int hash;
        while (n-- > 0){
            query = in.next();
            switch (query){
                case "add":
                    word = in.next();
                    int code = h(word, mod);
                    if(table[code] == null){
                        table[code] = new Node();
                        table[code].list.add(word);
                    }
                    else {
                        if(!table[code].list.contains(word)) {
                            table[code].list.addFirst(word);
                        }
                    }
                    break;
                case "find":
                    word = in.next();
                    hash = h(word, mod);
                    int flag = 0;
                    if(table[hash] == null){
                        System.out.println("no");
                        break;
                    }
                    if(table[hash].list.contains(word)){
                        System.out.println("yes");
                    }
                    else{
                        System.out.println("no");
                    }
                    break;
                case "check":
                    hash = in.nextInt();
                    int cnt = 0;
                    if(table[hash] != null) {
                        for (String str : table[hash].list) {
                            System.out.print(str + " ");
                            cnt++;
                        }
                    }
                    System.out.println();
                    break;
                case "del":
                    word = in.next();
                    hash = h(word, mod);
                    if(table[hash] != null){
                        table[hash].list.remove(word);
                    }
                    break;
            }
        }
    }
}
