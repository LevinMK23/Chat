package base_OOP;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Main implements Comparable<Main>, Serializable, Runnable {

    int v;

    @Override
    public int compareTo(Main o) {
        return this.v - o.v;
    }

    @Override
    public void run() {

    }
}
