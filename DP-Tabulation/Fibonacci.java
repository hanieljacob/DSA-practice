class Fibonacci{

    private static long getFib(int num){
        long [] table = new long[num+1];
        table[1] = 1;
        for(int i=0; i<num; i++){
            table[i+1] += table[i];
            if(i+2 > num){
                break;
            }
            table[i+2] += table[i];
        }
        return table[num];
    }


    public static void main(String [] args){
        System.out.println(getFib(50));
    }
}