class Solution {
    String[] one = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] two = new String[] {"","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] three = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
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
        if (num > 99) {
            return threeDigit(num/100) + "Hundred " + threeDigit(num%100);
        } else if (num > 19){
            return two[num/10 - 1] +" "+ threeDigit(num%10);
        } else if (num > 9) {
            return three[num-10] + " ";
        } else if (num > 0){
            return one[num]+ " ";
        } return "";
    }
}