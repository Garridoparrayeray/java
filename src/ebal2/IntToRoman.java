package ebal2;

class IntToRoman {
    public String intToRoman(int num) {
		String zenbaki_hamartar = "";
		int [] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String unitatea[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		for(int i = 0; i < n.length; i++) {
			while(num >= n[i]) {
				zenbaki_hamartar += unitatea[i];
				num -= n[i];	
			}
		}
        /*
          while (num >= 1000) {
            zenbaki_hamartar += "M";
            num -= 1000;
        }

        // Handle 900s
        while (num >= 900) {
            zenbaki_hamartar += "CM";
            num -= 900;
        }

        // Handle 500s
        while (num >= 500) {
            zenbaki_hamartar += "D";
            num -= 500;
        }

        // Handle 400s
        while (num >= 400) {
            zenbaki_hamartar += "CD";
            num -= 400;
        }

        // Handle 100s
        while (num >= 100) {
            zenbaki_hamartar += "C";
            num -= 100;
        }

        // Handle 90s
        while (num >= 90) {
            zenbaki_hamartar += "XC";
            num -= 90;
        }

        // Handle 50s
        while (num >= 50) {
            zenbaki_hamartar += "L";
            num -= 50;
        }

        // Handle 40s
        while (num >= 40) {
            zenbaki_hamartar += "XL";
            num -= 40;
        }

        // Handle 10s
        while (num >= 10) {
            zenbaki_hamartar += "X";
            num -= 10;
        }

        // Handle 9s
        while (num >= 9) {
            zenbaki_hamartar += "IX";
            num -= 9;
        }

        // Handle 5s
        while (num >= 5) {
            zenbaki_hamartar += "V";
            num -= 5;
        }

        // Handle 4s
        while (num >= 4) {
            zenbaki_hamartar += "IV";
            num -= 4;
        }

        // Handle 1s
        while (num >= 1) {
            zenbaki_hamartar += "I";
            num -= 1;
        }*/
		return zenbaki_hamartar;
    }
}
