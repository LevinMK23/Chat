package stepik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello from cmd!");
        System.out.println("Command line args:");
        int cnt = 0;
        for (String str : args)
            System.out.println(cnt++ + ") " + str);
    }
}
