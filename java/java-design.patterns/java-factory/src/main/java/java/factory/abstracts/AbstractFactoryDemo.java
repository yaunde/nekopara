package java.factory.abstracts;

public class AbstractFactoryDemo {
	
	public static void main(String[] args) {
		AbstractFactory linuxFactory = new LinuxFactory();
		linuxFactory.createButton().processEvent();
		linuxFactory.createText().getWholeText();
		AbstractFactory windowsFactory = new WindowsFactory();
		windowsFactory.createButton().processEvent();
		windowsFactory.createText().getWholeText();
	}
 
}
