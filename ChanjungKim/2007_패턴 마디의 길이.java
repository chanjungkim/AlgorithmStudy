import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution{
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                List<Integer> list = new ArrayList<>();
                
                int n = sc.nextInt();
                int max = 0;
                int bestMax = 0;
                int bestNum = 0;
                for(int i = 0 ; i < n ; i++){
                        list.clear();
                        for(int j = 0 ; j < 1000 ; j++){
                                list.add(sc.nextInt());
                        }
                        Collections.sort(list);

                        for(int j = 0 ; j < 1000; j++){
                                max = 0;
                                while(j+1 < 999 && list.get(j) == list.get(j+1)){
                                        max++;
                                        j++;
                                }
                                if(max > bestMax){
                                        bestMax = max;
                                        bestNum = list.get(j);
                                }
                        }
                        System.out.println("#"+(i+1)+" "+bestNum);
                }
                sc.close();
        }
}