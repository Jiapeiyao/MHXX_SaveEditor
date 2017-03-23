
public class Main {
	public final static int bufferSize = 295385 * 16 - 8;
	public final static byte[] buffer = new byte[bufferSize];
	public static int user1offset;
	public static int user2offset;
	public static int user3offset;
	public static int equipmentBoxOffset;
	public static int emptySpaceInEquipBoxOffset = 0;

	public static void main(String [ ] args)
	{
		View1 v = new View1();
		v.main();
	}
}

