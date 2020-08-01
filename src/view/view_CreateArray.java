package view;

public class view_CreateArray {
    public static void main(String[] args) {     

        int[] A = { 1, 2, 3, 4, 5};
        int[] B = { 2, 3, 1, 0, 5};
        int[] icount = {1,1,1,1,1};
        int i;
        int j;
        
        	for(i=0; i<A.length; i++){
        		for(j=0; j<B.length; j++){
        			if(A[i] < 100){
        				if(B[j] < 100){
        					if(A[i] == B[j]){
	        					icount[i] = icount[i]+1;
	        					icount[j] = icount[j]+1;
	        					System.out.println(A[i]);
        					}
        				}
        			}
        			
        		}
        	}
    }
}





