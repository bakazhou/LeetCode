package ½£Ö¸Offer2;

public class Offer018 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            if (Character.isAlphabetic(chars[i]) || Character.isDigit(chars[i])){
                sb.append(chars[i]);
            }
        }
        char[] array = sb.toString().toLowerCase().toCharArray();
        int low =0,high=array.length-1;
        while (low<high){
            if (array[low]!=array[high]){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
