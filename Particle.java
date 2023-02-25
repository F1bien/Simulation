
public class Particella extends Thread {

	
	// 	world properties
	private int length;
	private int width;
	
	
	// 	particle state
	private int x, y;
	private int age;
	private boolean die;
	//private double energy;
	
	
	// 	particle properties 
	private int die_age;
	//private boolean diet;
	private int Min = 10;
	private int Max = 15;


	
	
	public Particella ( int length, int width ) {
		this.length = length;
		this.width = width;
		RandomPos();
		this.age = 0;
		this.die = false;
		this.die_age = Min + (int)(Math.random() * ((Max - Min) + 1));
		this.start();

	}

	
	public Particella ( int length, int width,
						int x, int y ) {
		this.length = length;
		this.width = width;
		this.x = x;
		this.y = y;
		this.age = 0;
		this.die = false;
		this.die_age = Min + (int)(Math.random() * ((Max - Min) + 1));
		this.start();

	}
	
	
	// -------- LIVE --------

	public void run () {
		
		while ( ageCheck() == true ) {
			System.out.println("X: " + WhereX() + "  Y: " + WhereY() + " age: " + getAge());
			
			update();
			
			try {
				sleep(100);
			}
			catch ( InterruptedException e ) {
				break;
			}
			
		}
		die = true;
		System.out.println("Tread Arrestato");
		
	}
	
	public void update() {

		Grow();

		Move();
	
		// Draw();

		
		if( this.x > length ) {
			this.x = this.x - (length*2);
		}
		if (this.x < - length) {
			this.x = this.x + (length*2);
		}
		if( this.y > width ) {
			this.y = this.y - (width*2);
		}
		if (this.y < - width) {
			this.y = this.y + (width*2);
		}

	}
	
	
	
	
	
	private void Grow() {
		age += 1;
		
	}


	public void Move () {
		int Min = -10;
		int Max = 10;
		if ( (int)(Math.random() * ((1 - 0) + 1)) == 0 ) {
			this.x += Min + (int)(Math.random() * ((Max - Min) + 1));
		}
		else {
			this.y += Min + (int)(Math.random() * ((Max - Min) + 1));
			
		}

	}
	
	
	// -------- SET-UP --------
	
	private void RandomPos () {
		this.x = - length + (int)(Math.random() * ((length - - length) + 1));
		this.y = - width + (int)(Math.random() * ((width - - width) + 1));
		
	}


	
	// -------- GET --------
	public int WhereX () {
		return x;
	}

	public int WhereY () {
		return y;
	}
	
	public int getAge () {
		return age;
	}




	/*
	private boolean Collision ( Particella P ) {
		if ( P.WhereX() == this.x && P.WhereY() == this.y ) {
			return true;
		}
		return false;
	}
	*/

	public double Distance ( Particella P ) {
		return Math.sqrt(Math.pow((this.x - P.WhereX()), 2) + 
			Math.pow((this.y - P.WhereY()), 2));

	}
	
	
	// -------- CHECK --------
	
	private boolean ageCheck () {
		return age < die_age ;
		
	}
	
	public boolean dieCheck () {
		return die;
	}
	
	

}
