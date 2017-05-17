
public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    	
    	int[] r = new BowlingGame().getString(bowlingCode);
    	
    	int sum = 0;
    	int length = r.length/2;
    	int i = 0;
    	
    	for(; i < length - 3; i++){
    		
    		if(r[2*i + 1] == -1){
    			sum = sum + 10;
    			if(r[2*(i+1) + 1] == -1){
    				sum = sum + 10;
    				sum = sum + r[2*(i+2)];
    			}else{
    				sum = sum + r[2*(i+1)] + r[2*(i+1) + 1];
    			}
    			
    		}else{
    			
    			if((r[2*i] + r[2*i + 1]) == 10){
    				sum = sum + 10 + r[2*(i + 1)];
    			}else{
    				sum = sum + r[2*i] + r[2*i + 1];
    			}
    		}
	
    	}
    	

    	int j = i + 1;
    	if(r[2*j + 1] == -1){
    			sum = sum + 10 + r[2*(j + 1)] + r[2*(j + 1) + 1];
    			if(r[2*i + 1] == -1){
        			sum = sum + 20 + r[2*(j + 1)];
        		}else{
        			if((r[2*i] + r[2*i + 1]) == 10){
        				sum = sum + 10 + r[2*(i + 1)];
        			}else{
        				sum = sum + r[2*i] + r[2*i + 1];
        			}
        		}
    		
    	}else{
    		
    		if((r[2*j] + r[2*j + 1]) == 10){
    			sum = sum + 10 + r[2*(j + 1)];
    			if(r[2*i + 1] == -1){
        			sum = sum + 20;
        		}else{
        			if((r[2*i] + r[2*i + 1]) == 10){
        				sum = sum + 10 + r[2*(i + 1)];
        			}else{
        				sum = sum + r[2*i] + r[2*i + 1];
        			}
        		}
    		}else{
    			
    			sum = sum + r[2*j] + r[2*j + 1];
    			if(r[2*i + 1] == -1){
        			sum = sum + 10 + r[2*j] + r[2*j + 1];
        		}else{
        			if((r[2*i] + r[2*i + 1]) == 10){
        				sum = sum + 10 + r[2*(i + 1)];
        			}else{
        				sum = sum + r[2*i] + r[2*i + 1];
        			}
        		}
    			
    			
    		}
	
    	}    		
        return sum;
    }
    
    /**
     * Convert a string into numbers
     * @param bowlingCode
     * @return
     */
    public int[] getString(String bowlingCode){

    	String[] temp = bowlingCode.split("\\|\\|");    	
    	String left = temp[0];    	
    	String[] tempL = left.split("\\|");
    	int[] r = new int[tempL.length*2 + 2];
    	
    	for(int i = 0; i < tempL.length; i++){
    		
    		if(tempL[i].equals("X") ){
    			r[i*2] = 10;
    			r[i*2 + 1] = -1;
    		}else {
    			
    			String[] str1 = tempL[i].split("");
    			if(!str1[0].equals("-") ){
    				r[i*2] = Integer.parseInt(str1[0]);
    			}else{
    				r[i*2] = 0;
    			}
    			
    			if(!str1[1].equals("-") && !str1[1].equals("/") ){
    				r[i*2 + 1] = Integer.parseInt(str1[1]);
    			}else{
    				if(str1[1].equals("-")){
    					r[i*2 + 1] = 0;
    				}else{
    					r[i*2 + 1] = 10 - r[i*2];
    					
    				}	
    			}
    			
    		}	
    	}
    	if(temp.length > 1){
    		
    		String right = temp[1];
        	String[] tempR = right.split("");
        	for(int i = 0; i < tempR.length; i++){
        		
        		if(tempR[i].equals("X")){
        			r[i + 20] = 10;
        		}else{
        			if(tempR[i].equals("-")){
        				r[i + 20] = 0;
        			}else{
        				r[i + 20] = Integer.parseInt(tempR[i]);
        			}
        			
        		}
        	}
    	}   	    	    	
    	return r;
    }
    
   
    
}
