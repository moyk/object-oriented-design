public class EvenBetterSimulation {
	private static final int SIMULATION_TIME = 50000;  // Simulate for 50,000 seconds.

	public static void main(String[] args) {
		DiningHall hall = new DiningHall();
		
		for (int t=0; t<SIMULATION_TIME; t++) 
			hall.elapseOneSecond(t);

		hall.printStatistics();
	}
}