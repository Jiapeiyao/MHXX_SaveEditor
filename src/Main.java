import java.io.InputStream;

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
	public static int windowWidth = 450;
	public static int windowHeight = 300;
	
	public static String getOS() {
	    String os = System.getProperty("os.name").toLowerCase();

	    if(os.indexOf("mac") >= 0){
	       return "MAC";
	    }
	    else if(os.indexOf("win") >= 0){
	    	windowWidth = 480;
	    	windowHeight = 330;
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
		getOS();
	
		View1.main();
	}
}

