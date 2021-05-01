import java.util.Random;

public class Main {
	public static void main(String[] args){
		IProcess P1 = new Process("High", 1);
		IProcess P2 = new Process("Normal", 2);
		IProcess P3 = new Process("Low", 3);
		
		IProcess[] processList = {P1, P2, P3};
		
		Random rand = new Random();
	   
    
        
        // Creating computation queue of length 3
        ComputationQueue queue1 = new ComputationQueue();
        // for(int i = 0; i<3; i++) {
    	int randProcess1 = rand.nextInt(3);
    	int occupation1 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp1 = new Computation(1, processList[randProcess1], occupation1, 0, null);
    	queue1.insert(comp1);
        
    	int randProcess2 = rand.nextInt(3);
    	int occupation2 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp2 = new Computation(2, processList[randProcess2], occupation2, 0, null);
    	queue1.insert(comp2);   	
    	
    	int randProcess3 = rand.nextInt(3);
    	int occupation3 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp3 = new Computation(3, processList[randProcess3], occupation3, 0, null);
    	queue1.insert(comp3);

		System.out.println(queue1);

		System.out.println(queue1.getfirstNode().getProcess().getType());
		System.out.println(queue1.getfirstNode().getNext().getProcess().getType());
		System.out.println(queue1.getfirstNode().getNext().getNext().getProcess().getType());
    	
}
	
}
