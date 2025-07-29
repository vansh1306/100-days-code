import java.util.Arrays;

class GfG {

    public static int findSubString(String str) {
        int n = str.length();

        int ans = n;

        // to store all distinct characters
        boolean[] visited = new boolean[26];
        for (int i = 0; i < n; i++) {
            visited[str.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < n; i++) {
            boolean[] cur = new boolean[26];

            for (int j = i; j < n; j++) {
                cur[str.charAt(j) - 'a'] = true;

                // if all characters are present
                if (Arrays.equals(cur, visited)) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.print(findSubString(str));
    }
}