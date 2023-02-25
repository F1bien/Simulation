import java.util.*;

public class World {
	
	private static ArrayList<Particella> particleList = new ArrayList<Particella>();
	private static ArrayList<Particella> deadParticleList = new ArrayList<Particella>();
	
	private int length;
	private int width;
	
	public World ( int x, int y,
				   int particle_n ) {
		
		this.length = x;
		this.width = y;
		
		
		// -------- SET-UP --------
		generateParticle(particle_n);
		
		
		
		// -------- EVOLUTION --------
		while ( true ) {
			for (int i = 0 ; i < particleList.size() ; i += 1) {
				
				if (particleList.get(i).dieCheck() == true ) {
					//particleList.get(i).interrupt();
					deadParticleList.add(particleList.get(i));
					particleList.remove(i);
				}
			}
			
			if ( particleList.size() == 0 ) {
				break;
			}
		}
		
		for (int i = 0 ; i < 10 ; i += 1) {
			try {
				deadParticleList.get(i).join();
			}
			catch (InterruptedException e) {
				System.out.println("\nTread non joinato");
			}
		}
		
		System.out.println("\n"+"------------------------------"+
								"\nTutte le particelle sono morte");
		

	}
	
	private void generateParticle ( int n ) {
		for (int i = 0 ; i < n ; i += 1) {
			particleList.add(new Particella(length, width));
			//particleList.get(i).start();
		}
		
		
	}
	
	
}

