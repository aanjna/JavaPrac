

public class FizzBuzz {
    public static void main(String[] args) {
        for(int i=1;i<100;i++){
            if( i%3==0 && i%5 ==0){
                System.out.print("FIZZBuZZ" + " ");
            } else if(i%3==0){
                System.out.print("FIZZ" + " ");
            }else if(i%5==0){
                System.out.print("BUZZ" + " ");
            }else{
                System.out.print(i + " ");
            }
        }
    }
}
