class Solution {
    String[] one = new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] two = new String[] {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] four = new String[] {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        /*
        from end to start
        every 3 digit
        1 digit -> one - nine
        2 digit -> == 1 diff, > 1 diff
        3 digit -> divided by 100 -> one
        
        */
        if (num == 0)
            return "Zero";
        int cur = 0;
        StringBuilder words = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0)
                words.insert(0, " ").insert(0, four[cur]).insert(0, threeDigit(num % 1000));
            num /= 1000;
            cur++;
        }
        
        return words.toString().trim();
    }
    
    String threeDigit(int num) {
        StringBuilder s = new StringBuilder();
        if (num > 99) {
            return s.append(threeDigit(num/100)).append("Hundred ").append(threeDigit(num%100)).toString();
        } else if (num > 19){
            return s.append(two[num/10 - 2]).append(" ").append(threeDigit(num%10)).toString();
        } else if (num > 0){
            return s.append(one[num - 1]).append(" ").toString();
        } return "";
    }
}