
public class Particella extends Thread {

	private int x, y;
	
	private int age;
	private boolean die;
	private int die_age;
	private boolean diet;
	private double energy;
	private int Min = 50;
	private int Max = 100;

	public void run () {
		
		while ( ageCheck() == true ) {
			System.out.println("X: " + WhereX() + "  Y: " +WhereY() + " age: " + getAge());
			
			update();
			
		}
		die = true;
		
	}
	
	
	public Particella () {
		RandomPos(0, 1000);
		this.age = 0;
		this.die = false;
		this.die_age = Min + (int)(Math.random() * ((Max - Min) + 1));
		this.start();

	}

	
	public Particella ( int x, int y ) {
		this.x = x;
		this.y = y;
		this.age = 0;
		this.die = false;
		this.die_age = Min + (int)(Math.random() * ((Max - Min) + 1));
		this.start();

	}
	
	
	//--------method-------//

	public void update() {

		Grow();

		Move();
	
		// Draw();

		
		if( this.x > 1000 ) {
			this.x = this.x - 1000;
		}
		if (this.x < 0) {
			this.x = this.x + 1000;
		}
		if( this.y > 1000 ) {
			this.y = this.y - 1000;
		}
		if (this.y < 0) {
			this.y = this.y + 1000;
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

	/*
	public boolean SetX ( int x ) {
		if ( x >= 0 && x < 1920 ) {
			this.x = x;
			return true;
		}
		return false;
	}

	public boolean SetY ( int y ) {
		if ( y >= 0 && y < 1080 ) {
			this.y = y;
			return true;
		}
		return false;
	}
	
	public void Reset ( int x, int y ) {
		this.x = x;
		this.y = y;
	}
	*/

	public int WhereX () {
		return x;
	}

	public int WhereY () {
		return y;
	}
	
	public int getAge () {
		return age;
	}


	private void RandomPos ( int Min, int Max ) {
		if ( Max > Min ) {
			this.x = Min + (int)(Math.random() * ((Max - Min) + 1));
			this.y = Min + (int)(Math.random() * ((Max - Min) + 1));
		}
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
	
	private boolean ageCheck () {
		return age < die_age ;
	}
	
	public boolean dieCheck () {
		return die;
	}
	
	

}
