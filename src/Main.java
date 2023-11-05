public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int a) {
        int length = (a+"").length();
        String result = "";
        for (int i = length-1; i>=0; i--) {
            result = result + (a+"").charAt(i);
        }
        return result;
    }

    // 3. encryptThis
    /*
    You are given a message you need to encrypt. Here are the things you need to know to
    encrypt it:
    For each word:
    the second and the last letter is switched (e.g. Hello becomes Holle) the first letter is
    replaced by its character code (e.g. H becomes 72) Note: there are no special characters
    used, only letters and spaces
    Examples
    encryptThis('Hello good day'); // '72olle 103doo 100ya'
    encryptThis('Ready set go'); // '82yade 115te 103o'
    */
    public static String encryptThis(String str) {
        String[] words = str.split(" ");
        String result = "";
        for (String word : words) {
            if (word.length() == 3) {
                int code = (char) word.charAt(0);
                result = result + code + word.charAt(2) + word.charAt(1) + " ";
            }
            else if (word.length() == 2) {
                int code = (char) word.charAt(0);
                result = result + code + word.charAt(1) + " ";
            }
            else {
                int code = (char) word.charAt(0);
                result = result + code + word.charAt(word.length() - 1) + word.substring(2, word.length() - 1) + word.charAt(1) + " ";
            }
        }
        return result.substring(0,result.length()-1);
    }

    // 4. decipherThis (reverse of encrypt)
    public static String decipherThis(String str) {
        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {
            if ((Character.isDigit(word.charAt(2))) && word.length() == 4) {
                int code = Integer.parseInt(word.substring(0,3));
                char firstChar = (char) code;
                result = result +  firstChar + word.charAt(3) + " ";
            }
            else if ((Character.isDigit(word.charAt(2))) && word.length() == 5) {
                int code = Integer.parseInt(word.substring(0,3));
                char firstChar = (char) code;
                result = result +  firstChar + word.charAt(word.length() - 1) + word.charAt(3) + " ";
            } else if (((Character.isDigit(word.charAt(2)) && word.length() == 6))) {
                int code = Integer.parseInt(word.substring(0,3));
                char firstChar = (char) code;
                result = result +  firstChar + word.charAt(word.length() - 1) + word.charAt(4) + word.charAt(3) + " ";
            } else if (((!Character.isDigit(word.charAt(2)) && word.length() == 6))) {
                int code = Integer.parseInt(word.substring(0,2));
                char firstChar = (char) code;
                result = result +  firstChar + word.charAt(word.length() - 1) + word.substring(3,5) + word.charAt(2) + " ";
            } else if (Character.isDigit(word.charAt(2))){
                int code = Integer.parseInt(word.substring(0,3));
                char firstChar = (char) code;
                result = result +  firstChar + word.charAt(word.length() - 1) + word.substring(3, word.length() - 1) + word.charAt(3) + " ";
            }
            else {
                int code = Integer.parseInt(word.substring(0,2));
                char firstChar = (char) code;
                result = result +  firstChar + word.charAt(word.length() - 1) + word.substring(3, word.length() - 1) + word.charAt(2) + " ";
            }
        }

        return result.substring(0,result.length()-1);
    }

}