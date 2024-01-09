import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int i=0;
        int j=1;
        HashMap<Character, Integer> conversions = new HashMap<>();
        conversions.put('I',1);
        conversions.put('V',5);
        conversions.put('X',10);
        conversions.put('L',50);
        conversions.put('C',100);
        conversions.put('D',500);
        conversions.put('M',1000);
        for(; j<s.length(); i++, j++){
            if(s.charAt(i) == 'I' && s.charAt(j) == 'V'){
                sum += 4;
            }
            else if(s.charAt(i) == 'I' && s.charAt(j) == 'X'){
                sum += 9;
            }
            else if(s.charAt(i) == 'X' && s.charAt(j) == 'L'){
                sum += 40;
            }
            else if(s.charAt(i) == 'X' && s.charAt(j) == 'C'){
                sum += 90;
            }
            else if(s.charAt(i) == 'C' && s.charAt(j) == 'D'){
                sum += 400;
            }
            else if(s.charAt(i) == 'C' && s.charAt(j) == 'M'){
                sum += 900;
            }
            else{
                sum += conversions.get(s.charAt(i));
                i--;
                j--;
            }
            i++;
            j++;
        }
        if(i != s.length())
            sum += conversions.get(s.charAt(i));
        return sum;
    }
}