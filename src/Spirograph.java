import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Spirograph {

	public static void main(String[] args) throws FileNotFoundException{
		double R = 5, r =1 , a = 4;
		
		double latBegin = 34.021108;
		double longBegin = -118.289100;
		
		double pi = Math.PI;
		double numRevolutions = 10;
		
		PrintWriter writer = new PrintWriter("output.txt");	
		
		for(double t = 0; t< pi *numRevolutions ;t+=.01){
			double x = (R+r)*Math.cos((r/R)*t) - a*Math.cos((1+r/R)*t);
			double y = (R+r)*Math.sin((r/R)*t) - a*Math.sin((1+r/R)*t);
			
			double latNew = latBegin + x;
			double longNew = longBegin + y;
			writer.println(longNew + "," + latNew);
		}
		writer.close();
	}

}
