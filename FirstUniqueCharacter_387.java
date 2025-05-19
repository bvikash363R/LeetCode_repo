import java.util.HashMap;

public class FirstUniqueCharacter_387 {

    // Using freequncy array
    public static int uniqueCharacter(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    // Using hashmap
    public static int uniqueCharacter_hashmap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(uniqueCharacter(str));

        System.out.println(uniqueCharacter_hashmap(str));
    }
}
