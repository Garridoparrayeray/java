class Pow {
    public double myPow(double x, int n) {
        //si es negativo x, se divide 1/x y n se pasa a ser positivo asi conseguimos los casos negativos
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        double solution = 1;
        /*error in case x= 0.0001
        for(int i = 1; i <= n;i++){
            solution *= x;
        }*/

        while(n != 0){
            if((n & 1) != 0){
                solution *= x;
            }

            x *= x;
            n >>>= 1;
        }
        return solution;
    }
}
