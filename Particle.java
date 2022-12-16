
public class Particle {

	private int x;
	private int y;
	private int age;
	private boolean diet;
	
	
	//-------Costructor-------//
	
	public Particle( boolean input ) {
		this.diet = input;
		this.age = 0;
		this.x = 0;
		this.y = 0;
	}
	
	//--------get&set-------//
	
	public int get_age() {
		return age;
	}
	public int get_y() {
		return y;
	}
	public int get_x() {
		return x;
	}


	
	//--------method-------//

	public void update() {
		if( this.x > 100 ) {
			this.x = this.x - 100;
		}
		if (this.x < 100) {
			this.x = this.x + 100;
		}
		if( this.y > 100 ) {
			this.y = this.y - 100;
		}
		if (this.y < 100) {
			this.y = this.y + 100;
		}

		// grow();

		// graw();

	}
	
	public void move_X(int min, int max) {
		
		this.x += ((Math.random()*(max-min))+min);
	}
	public void move_Y(int min, int max) {
		this.y += ((Math.random()*(max-min))+min);
	}
	
	
}
