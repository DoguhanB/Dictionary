package Dictionary.Distance;

public interface Distance {

    static int ldist(String str1, String str2) {

        int result;

        if (str1.length() == 0) {
            result = str2.length();
        } else if (str2.length() == 0) {
            result = str1.length();
        } else {
            int distSub = ldist(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
            if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
                result = distSub;
            } else {
                int distDel = ldist(str1.substring(0, str1.length() - 1), str2);
                int distIns = ldist(str1, str2.substring(0, str2.length() - 1));
                result = 1 + (Math.min(Math.min(distSub, distDel), distIns));
            }
        }

        return result;
    }

    //other
}
