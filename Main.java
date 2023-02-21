import java.util.*;

public class Main {
	
	private static ArrayList<Particella> particleList = new ArrayList<Particella>();
	
	public static void main (String[] args) {
		
		for (int i = 0 ; i < 1 ; i += 1) {
			particleList.add(new Particella());
		}
		
		while ( true ) {
			for (int i = 0 ; i < particleList.size() ; i += 1) {
				//System.out.println(i + ") X: " + particleList.get(i).WhereX() + "  Y: " + particleList.get(i).WhereX() + " age: " + particleList.get(i).getAge());
				if (particleList.get(i).dieCheck() == true ) {
					particleList.remove(i);
				}
			}
		
		
		

		
		}
	}
	
}

