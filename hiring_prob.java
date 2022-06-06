import java.util.Random;
public class hiring_prob{
    public static void main(String arg[]){
        int candrank[] = new int[]{1,2,3,4,5,6,7,8};
        int n = 8;

        int normalhires = normal(candrank, n);
        int randomhires = randomized(candrank, n);
        System.out.println("The number of hires by normal method = "+normalhires);
        System.out.println("The number of hires by random method = "+randomhires);
    }

    public static int randomized(int[] candrank, int n){
        int randomcand[] = new int[n];
        for(int i=0; i<n; i++){
            randomcand[i] = candrank[i];
        }
        swaparr(randomcand, n);
        return normal(randomcand, n);
    }

    public static void swaparr(int[] randomcand, int n){
        Random random = new Random();
        for(int i=0; i<n; i++){
            performswap(randomcand, i, random.nextInt((n-i)+i));
        }
    }

    public static void performswap(int[] randomcand, int i, int nextInt){
        int temp = 0;
        temp = randomcand[i];
        randomcand[i] = randomcand[nextInt];
        randomcand[nextInt] = temp;
    }

    public static int normal(int[] candrank, int n){
        int best = 0;
        int counthires = 0;
        for(int i=0; i<n; i++){
            if(candrank[i]>best){
                best = candrank[i];
                counthires += 1;
            }
        }
        return counthires;
    }
}