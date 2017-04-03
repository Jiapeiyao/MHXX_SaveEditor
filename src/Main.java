import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;

public class Main {
	public final static int bufferSize = 295385 * 16 - 8;
	public final static byte[] buffer = new byte[bufferSize];
	public static int user1offset;
	public static int user2offset;
	public static int user3offset;
	public static int equipmentBoxOffset = 25326;
	public static int emptySpaceInEquipBoxOffset = 0;
	public static int useroffset;
	public static int itemBoxOffset = 632;
	public static int windowWidth = 480;
	public static int windowHeight = 330;
	public static JFileChooser f = new JFileChooser();
	
	public static String getOS() {
	    String os = System.getProperty("os.name").toLowerCase();

	    if(os.indexOf("mac") >= 0){
	       return "MAC";
	    }
	    else if(os.indexOf("win") >= 0){
	    	windowWidth = 520;
	    	windowHeight = 360;
	       return "WIN";
	    }
	    else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0){
	       return "LINUX/UNIX";
	    }
	    else if(os.indexOf("sunos") >= 0){
	       return "SOLARIS";
	    }
		return "";
	}
	   
	public static void main(String [ ] args)
	{
//		try(BufferedReader br = new BufferedReader(new FileReader("db/skill_limits_mhxx.csv"))) {
//		    StringBuilder sb = new StringBuilder();
//		    String line = br.readLine();
//		    String str = "";
//		    while (line != null) {
//		        sb.append(line);
//		        sb.append(System.lineSeparator());
//		    }
//		    System.out.print(str);
//		    //String everything = sb.toString();  
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		getOS();
		View1.main();
	}
}

