/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author PC
 */
public class Counter {

    private static final Scanner sc = new Scanner(System.in);
    private static Map<Character, Integer> countCharacter = new HashMap<Character, Integer>();
    private static Map<String, Integer> countWord = new HashMap<String, Integer>();

    private static String inputString() {
        System.out.println("Enter your content: ");
        String str = sc.nextLine();
        return str;
    }

    private static void analyse(String str) {
        for (char ch : str.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!countCharacter.containsKey(ch)) {
                countCharacter.put(ch, 1);
            } else {
                countCharacter.put(ch, ((int) countCharacter.get(ch)) + 1);
            }
        }

        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!countWord.containsKey(token)) {
                countWord.put(token, 1);
            } else {
                countWord.put(token, ((int) countWord.get(token)) + 1);
            }
        }
    }

    private static void display() {
        System.out.println(countWord);
        System.out.println(countCharacter);
    }

    public static void main(String[] args) {
        String str = inputString();
        analyse(str);
        display();
    }

}
