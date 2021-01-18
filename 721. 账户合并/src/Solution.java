import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @create CuiJunJie
 * @date 2021/1/18-20:25
 */
public class Solution {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
//        accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
//        ["John", "johnnybravo@mail.com"],
//        ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
//        ["Mary", "mary@mail.com"]]
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));

        accountsMerge(accounts).forEach(System.out::print);
    }

    public static  List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailId = new HashMap<>();
        Map<Integer, String> idEmail = new HashMap<>();
        Map<String, String> emailName = new HashMap<>();
        Integer id = 0;
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!emailId.containsKey(account.get(i))) {
                    idEmail.put(id, account.get(i));
                    emailId.put(account.get(i), id++);
                    emailName.put(account.get(i), account.get(0));
                }
            }
        }

        int[] parents = new int[emailId.size()];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (List<String> account : accounts) {
            if (account.size() > 1) {
                int a = emailId.get(account.get(1));
                for (int i = 2; i < account.size(); i++) {
                    int b = emailId.get(account.get(i));
                    union(parents, a, b);
                }
            }
        }

        List<List<String>> ret = new ArrayList<>();
        boolean[] visited = new boolean[parents.length];
        for (int i = 0; i < parents.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;

            int iRoot = find(parents, i);
            List<String> list = new ArrayList<>();
            list.add(emailName.get(idEmail.get(iRoot)));
            List<String> emails = new ArrayList<>();
            emails.add(idEmail.get(i));
            for (int j = i + 1; j < parents.length; j++) {
                int jRoot = find(parents, j);
                if (iRoot == jRoot) {
                    visited[j] = true;
                    emails.add(idEmail.get(j));
                }
            }

            Collections.sort(emails);
            list.addAll(emails);

            ret.add(list);
        }

        return ret;
    }

    private static void union(int[] parents, int a, int b) {
        int aRoot = find(parents, a);
        int bRoot = find(parents, b);

        if (aRoot != bRoot) {
            parents[bRoot] = aRoot;
        }
    }

    private static int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }

        return parents[x];
    }
}
