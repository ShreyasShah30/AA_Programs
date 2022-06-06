import java.util.*;

public class hiringAhmed {
    public static void main(String args[]){
        ArrayList<Integer> candidateList = new ArrayList<Integer>();
        candidateList.add(1);
        candidateList.add(2);
        candidateList.add(3);
        candidateList.add(4);
        candidateList.add(5);

        int currentCandidate = candidateList.get(0);
        int hiringCost = 1;

        for(int i=0; i<5; i++){
            if(candidateList.get(i)>currentCandidate){
                currentCandidate = candidateList.get(i);
                hiringCost += 1;
            }
        }

        System.out.println(candidateList);
        System.out.println(hiringCost);

        Collections.shuffle(candidateList);
        currentCandidate = candidateList.get(0);
        hiringCost = 1;

        for(int i=0; i<5; i++){
            if(candidateList.get(i)>currentCandidate){
                currentCandidate = candidateList.get(i);
                hiringCost += 1;
            }
        }
        System.out.println(candidateList);
        System.out.println(hiringCost);
    }
}
