import java.lang.reflect.Array;

public class PrifixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // end of word
        int freq = 1;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }else {
                curr.children[idx].freq += 1;
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static String search(String word) {
        Node curr = root;
        String res = "";
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return "-1";
            }
            res += word.charAt(level);
            if(curr.children[idx].freq == 1){
                break;
            }
            curr = curr.children[idx];
        }

        return res;
    }

    public static void prefixProb(String[] words){
        String prefix[] = new String[words.length];

        for (int i=0; i<words.length ;i++){
            prefix[i] = search(words[i]);
        }

        for(String x: prefix){
            System.out.print(x + ", ");
        }
        // return prefix;
    }

    public static void main(String[] args) {
        String words[] = { "zebra", "dog", "duck", "dove"};

        root.freq = -1;
        
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        prefixProb(words);
    }
}
