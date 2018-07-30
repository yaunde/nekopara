package java.factory.abstracts;

public class WindowsFactory implements AbstractFactory {
 
	@Override
	public Button createButton() {
		return new WindowsButton();
	}
 
	@Override
	public Text createText() {
		return new WindowsText();
	}
 
}
