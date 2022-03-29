class Solution {
    public boolean isNumber(String s) {
        /*
        number struct
        1 : + or - (optional)
        2 : number, followed by a dot
            number, followed by a dot, followed by number
            a dot, followed by number
        */
        if (s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == 'E')
            return false;
        String[] numbers = s.split("e|E");
        if (numbers.length == 2) {
            return (isDecimal(numbers[0]) || isInteger(numbers[0]))  && isInteger(numbers[1]);
        } else if (numbers.length == 1) {
            return isDecimal(numbers[0]) || isInteger(numbers[0]);
        } else return false;
    }
    
    boolean isInteger(String s) {
        int i = 0;
        if (s.length() < 1)
            return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            i = 1;
        boolean hadDigit = false;
        for (; i < s.length(); i++) {
            if (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9) {
                return false;
            } else {
                hadDigit = true;
            }
        }
        return hadDigit;
    }
    
    boolean isDecimal(String s) {
        int i = 0;
        if (s.length() < 1)
            return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            i = 1;
        boolean hadDot = false;
        boolean hadDigit = false;
        for (; i < s.length(); i++) {
            if (hadDot) {
                if (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9) {
                    return false;
                } else {
                    hadDigit = true;
                }
            } else {
                if (s.charAt(i) != '.' && (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9)) {
                    return false;
                } else if (s.charAt(i) == '.') {
                    hadDot = true;
                } else {
                    hadDigit = true;
                }
            }
        }
        return hadDigit;
    }
}