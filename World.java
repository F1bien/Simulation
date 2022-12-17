import java.util.ArrayList;

public class World {
	
	public int length;
	public int width;
	public int num_particle;
	public ArrayList<Particle> list_particle;
	

	//-------Costructor-------//
		
	public World(int length, int width, int num_particle){
		this.length = length; 
		this.width = width;
		this.num_particle = num_particle;

		// TO-DO generate particle

	}
	

	//--------get&set-------//
	
	public int get_length() {
		return length;
	}
	public int get_width() {
		return width;
	}
	public int get_num_particle() {
		return num_particle;
	}
	
	

	//--------method-------//
		
	public void populate(int num) {
		int i;
		double random = Math.random()*50;
		double random2 = Math.random() * 2;

		for( i = 0  ; i < random ; i++ ) {		
			if ( random2 == 1 )
				this.list_particle.add(new Particle(true));
			if ( random2 == 2 )
				this.list_particle.add(new Particle(false));
		}
	}
	
	

}
