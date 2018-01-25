
public class Node {
	
     public Node NRight;
     public Node NLeft;
     
     Node(){
         
    	 NLeft = null;
    	        
    	 NRight = null;
    	         
    	 Value = new String();
    	     }
     
     String Value;
        public Node (String input) {
        	
        	Value = input;
        }
}
