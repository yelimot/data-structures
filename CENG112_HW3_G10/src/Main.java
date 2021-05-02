import java.util.Random;

public class Main {
	public static void main(String[] args){
		
		IProcess P1 = new Process("High", 1);
		IProcess P2 = new Process("Normal", 2);
		IProcess P3 = new Process("Low", 3);
		
		IProcess[] processList = {P1, P2, P3};
		
		Random rand = new Random();

		// creating the first queue
		ComputationQueue queue1 = new ComputationQueue("queue1", 1);
        
		int highNo1 = 0;
		int highWait1 = 0;
		int normalNo1 = 0;
		int normalWait1 = 0;
		int lowNo1 = 0;
		int lowWait1 = 0;
	
		// creating and adding the computations to the queue
    	for(int i = 0 ; i<3 ; i++){
			int randProcess1 = rand.nextInt(3);
			int occupation1 = (int)Math.floor((Math.random()*10)+1);
			var comp1 = new Computation(i, processList[randProcess1], occupation1, 0);
			if (i == 0)
				queue1.enqueue(comp1);
			else
				queue1.insert(comp1);

			if (randProcess1 == 0) {
				highNo1++;
				highWait1 += occupation1;						
			} else if (randProcess1 == 1) {
				normalNo1++;
				normalWait1 += occupation1;						
			} else {
				lowNo1++;
				lowWait1 += occupation1;
			}
		}
    	
		int highNo2 = 0;
		int highWait2 = 0;
		int normalNo2 = 0;
		int normalWait2 = 0;
		int lowNo2 = 0;
		int lowWait2 = 0;
		
		// creating second queue with similar fashion
		ComputationQueue queue2 = new ComputationQueue("queue2", 2);

		for(int i = 5 ; i< 10 ; i++){
			int randProcess2 = rand.nextInt(3);
			int occupation2 = (int)Math.floor((Math.random()*10)+1);
			var comp2 = new Computation(i, processList[randProcess2], occupation2, 0);
			queue2.insert(comp2);

			
			if (randProcess2 == 0) {
				highNo2++;
				highWait2 += occupation2;						
			} else if (randProcess2 ==1 ) {
				normalNo2++;
				normalWait2 += occupation2;						
			} else {
				lowNo2++;
				lowWait2 += occupation2;
			}
		}
		
		int highNo3 = 0;
		int highWait3 = 0;
		int normalNo3 = 0;
		int normalWait3 = 0;
		int lowNo3 = 0;
		int lowWait3 = 0;
		
		// creating third queue with similar fashion
		ComputationQueue queue3 = new ComputationQueue("queue3", 3);

		for(int i = 10 ; i< 20 ; i++){
			int randProcess3 = rand.nextInt(3);
			int occupation3 = (int)Math.floor((Math.random()*10)+1);
			var comp3 = new Computation(i, processList[randProcess3], occupation3, 0);
			queue3.insert(comp3);

			if (randProcess3 == 0) {
				highNo3++;
				highWait3 += occupation3;						
			} else if (randProcess3 == 1) {
				normalNo3++;
				normalWait3 += occupation3;						
			} else {
				lowNo3++;
				lowWait3 += occupation3;
			}
		}

		// creating simulation and adding queues into the simulation with linked them together
    	Simulation simulate = new Simulation();
    	
    	simulate.insert(queue1);
    	simulate.insert(queue2);
		simulate.insert(queue3);
		
		
		ComputationQueue[] queueList = {queue1, queue2, queue3};
		String nameList[] = {"queue1", "queue2", "queue3"}; 
		int highNoList[] = {highNo1, highNo1, highNo1};
		int normalNoList[] = {normalNo1, normalNo2, normalNo3};
		int lowNoList[] = {lowNo1, lowNo2, lowNo3};
		int highWaitList[] = {highWait1, highWait2, highWait3};
		int normalWaitList[] = {normalWait1, normalWait2, normalWait3};
		int lowWaitList[] = {lowWait1, lowWait2, lowWait3};
		
		
		// We printing only the first queue since there is an error exist but we could not find what happening. Please execute several times if you encounter that 
		// nullPointerException in the first trial. It works sometime correctly.
		for (int j = 0 ; j < 1 ; j ++) { 
			System.out.println("Simulation Number: " + queueList[j].getQueueNo());
			System.out.println("Length: " + queueList[j].getQueueLength());
			System.out.println("Computation Queue: " +  queueList[j].getFirstNode().getProcess().getType() + "," +  queueList[j].getFirstNode().getOccupation() + 
					"<-" +  queueList[j].getFirstNode().getNext().getProcess().getType() + "," +  queueList[j].getFirstNode().getNext().getOccupation() +
					"<-" +  queueList[j].getFirstNode().getNext().getNext().getProcess().getType() + "," +  queueList[j].getFirstNode().getNext().getNext().getOccupation());
		}
		
		System.out.println("\n");
		
		// Printing other outputs for every simulation as requested.
		for (int k = 0 ; k < 3 ; k ++) { 
		System.out.println("Total Number of Computation: " + simulate.getCQ(nameList[k]).getQueueLength());
		
		System.out.println("Total waiting time: " +  queueList[k].getTotalWaitingTime());
		System.out.println("Average waiting time: " + (double)(queueList[k].getTotalWaitingTime())/(queueList[k].getQueueLength())+ "\n");
		
		System.out.println("Total number of computations for High: " + highNoList[k]);
		System.out.println("Total number of computations for Normal: " + normalNoList[k]);
		System.out.println("Total number of computations for Low: " + lowNoList[k] + "\n");
		
		System.out.println("Total waiting time for High: " + highWaitList[k] );
		System.out.println("Average waiting time for High: " + ((highWaitList[k] == 0) || (highNoList[k]== 0) ? 0 : (highWaitList[k] / highNoList[k])) + "\n" );
		
		System.out.println("Total waiting time for Normal: "+ normalWaitList[k] );
		System.out.println("Average waiting time for Normal: "+ (normalWaitList[k] == 0 || (normalNoList[k]== 0) ? 0 : (normalWaitList[k] / normalNoList[k])) + "\n");
		
		System.out.println("Total waiting time for Low: "+ lowWaitList[k] );
		System.out.println("Average waiting time for Low: "+ ( lowWaitList[k]  == 0 || (lowNoList[k]== 0) ? 0 : (lowWaitList[k]  / lowNoList[k])) + "\n\n" );
		
		}
	}
}
