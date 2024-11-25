package ebal2;

class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int current = 0;
            char c = s.charAt(i);
            
            if (c == 'I') current = 1;
            else if (c == 'V') current = 5;
            else if (c == 'X') current = 10;
            else if (c == 'L') current = 50;
            else if (c == 'C') current = 100;
            else if (c == 'D') current = 500;
            else if (c == 'M') current = 1000;
            
            if (i < s.length() - 1 && current < getValue(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }
        
        return result;
    }
    private int getValue(char c) {
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else if (c == 'M') return 1000;
        return 0; 
    }
}
