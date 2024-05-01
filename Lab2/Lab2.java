package labs;
import java.util.Arrays;

public class Lab2 {
	public static void main(String[] args)
	{
		Lab2 instance = new Lab2();
		System.out.println(instance.isAnagram("Bruh", "rBhu"));
		System.out.println(instance.isAnagram("zog", "gozo"));
		System.out.println(instance.isAnagram("", ""));
	}
	
	public boolean isAnagram(String s, String t)
	{		
		if(s.length() != t.length()) return false;
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		
		Arrays.sort(sChar);
		Arrays.sort(tChar);
		
		for(int i = 0; i < sChar.length; i++)
		{
			System.out.println(sChar[i] + " " + tChar[i]);
			if(sChar[i] != tChar[i])
			{
				return false;
			}
		}
		
		return true;
	}
}
