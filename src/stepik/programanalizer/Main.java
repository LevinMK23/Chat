package stepik.programanalizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    private BufferedReader in;
    private long [] rank;
    private int [] parent;
    private long max;
    private int n, e, d;

    public Main() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String [] line = in.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        e = Integer.parseInt(line[1]);
        d = Integer.parseInt(line[2]);
        parent = new int[n+1];
        rank = new long[n+1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int from, to;
        for (int i = 1; i <= e; i++) {
            line = in.readLine().split(" ");
            to = Integer.parseInt(line[0]);
            from = Integer.parseInt(line[1]);
            parent[to] = parent[from];
        }
        for (int i = 1; i <= d; i++) {
            line = in.readLine().split(" ");
            to = Integer.parseInt(line[0]);
            from = Integer.parseInt(line[1]);
            if(find(to) == from || find(from) == to){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    private void union(int x, int y){
        x = find(x); y = find(y);
        if(x == y) return;
        if(x < y) {
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
    }

    private int find(int v){
        if(v != parent[v]) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}