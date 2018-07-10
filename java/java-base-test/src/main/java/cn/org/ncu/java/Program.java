package cn.org.ncu.java;

public class Program {
	public static void main(String[] args) {
		String path = Program.class.getResource("/").getPath();
		System.out.println(path);
		path = path.replaceAll("target/classes/", "src/main/java");
		System.out.println(path);
	}
}
