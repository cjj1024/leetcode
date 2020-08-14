import java.util.*;

/**
 * @author cuijunjie
 * @create 2020--14-9:42
 */
public class Solution {
    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        if (path == null || path.length() < 1) {
            return null;
        }
        String[] fileNames = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (int i = 1; i < fileNames.length; i++) {
            if ("..".equals(fileNames[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(fileNames[i])) {
                stack.push(fileNames[i]);
            }
        }

        StringBuilder sb = new StringBuilder(path.length());
        for (String str : stack) {
            sb.append("/").append(str);
        }

        if (stack.isEmpty()) {
            sb.append("/");
        }

        return sb.toString();
    }

//    public static String simplifyPath(String path) {
//        if (path == null || path.length() < 1) {
//            return null;
//        }
//
//        StringBuilder sb = new StringBuilder(path.length());
//        List<String> fileNames = new ArrayList<>();
//        char now = path.charAt(0);
//        char pre = now;
//        for (int i = 0; i < path.length(); i++) {
//            pre = now;
//            now = path.charAt(i);
//
//            if (now == '/') {
//                String name = sb.toString();
//                if (pre != '/' && !".".equals(name) && !"..".equals(name)) {
//                    fileNames.add(sb.toString());
//                } else if ("..".equals(name)) {
//                    if (fileNames.size() > 0) {
//                        fileNames.remove(fileNames.size() - 1);
//                    }
//                }
//                sb.setLength(0);
//            } else {
//                sb.append(path.charAt(i));
//            }
//        }
//        if (sb.length() > 0) {
//            String name = sb.toString();
//            if (!(now == '/' && pre == '/') && !".".equals(name) && !"..".equals(name)) {
//                fileNames.add(sb.toString());
//            } else if ("..".equals(name)) {
//                if (fileNames.size() > 0) {
//                    fileNames.remove(fileNames.size() - 1);
//                }
//            }
//            sb.setLength(0);
//        }
//        sb.append('/');
//        for (String fileName : fileNames) {
//            sb.append(fileName);
//            sb.append('/');
//        }
//        if (sb.length() > 1) {
//            sb.deleteCharAt(sb.length() - 1);
//        }
//
//        return sb.toString();
//    }
}
