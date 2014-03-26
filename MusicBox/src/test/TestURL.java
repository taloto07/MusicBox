package test;

public class TestURL {

	public static void main(String[] args) {
		String url = "/musicbox/test/";
		int beginIndex = url.lastIndexOf("/") + 1;
		int lastIndex = url.length();
		
		System.out.println("beginIndex: " + beginIndex);
		System.out.println("lastIndex: " + lastIndex);
		System.out.println("substring: " + url.substring(beginIndex, lastIndex));
	}

}
