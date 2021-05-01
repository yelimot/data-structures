import java.util.Random;

public class Main {
	public static void main(String[] args){
		
		IProcess P1 = new Process("High", 1);
		IProcess P2 = new Process("Normal", 2);
		IProcess P3 = new Process("Low", 3);
		
		IProcess[] processList = {P1, P2, P3};
		
		Random rand = new Random();
	   
		// ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****
    
        // Creating computation queue of length 3
        ComputationQueue queue1 = new ComputationQueue("queue1", 1);
               
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

		/* System.out.println(queue1);

		System.out.println(queue1.getFirstNode().getProcess().getType());
		System.out.println(queue1.getFirstNode().getNext().getProcess().getType());
		System.out.println(queue1.getFirstNode().getNext().getNext().getProcess().getType()); */
    	
    	// ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** ***** *****
        
        // Creating computation queue of length 3
        ComputationQueue queue2 = new ComputationQueue("queue2", 2);
               
        int randProcess4 = rand.nextInt(3);
    	int occupation4 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp4 = new Computation(4, processList[randProcess4], occupation4, 0, null);
    	queue1.insert(comp4); 
    	
    	int randProcess5 = rand.nextInt(3);
    	int occupation5 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp5 = new Computation(5, processList[randProcess5], occupation5, 0, null);
    	queue1.insert(comp5); 
    	
    	int randProcess6 = rand.nextInt(3);
    	int occupation6 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp6 = new Computation(6, processList[randProcess6], occupation6, 0, null);
    	queue1.insert(comp6); 
    	
    	int randProcess7 = rand.nextInt(3);
    	int occupation7 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp7 = new Computation(7, processList[randProcess7], occupation7, 0, null);
    	queue1.insert(comp7); 
    	
    	int randProcess8 = rand.nextInt(3);
    	int occupation8 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp8 = new Computation(8, processList[randProcess8], occupation8, 0, null);
    	queue1.insert(comp8); 
    	
    	int randProcess9 = rand.nextInt(3);
    	int occupation9 = (int)Math.floor((Math.random()*10)+1);
    	Computation comp9 = new Computation(9, processList[randProcess9], occupation9, 0, null);
    	queue1.insert(comp9); 
    	
    	Simulation simulate = new Simulation();
    	
    	simulate.insert(queue1);
    	simulate.insert(queue2);
    	
    	
		System.out.println(simulate.getCQ("queue2"));

		System.out.println(simulate.getCQ("queue2").getFirstNode().getProcess().getType());
		System.out.println(simulate.getCQ("queue2").getFirstNode().getNext().getProcess().getType());
		System.out.println(simulate.getCQ("queue2").getFirstNode().getNext().getNext().getProcess().getType()); 
    	
    	
  
    	
}
	
}
