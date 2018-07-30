package java.factory.abstracts;

public class WindowsText implements Text {

  @Override
  public void getWholeText() {
    System.out.println("Inside WindowsText::getWholeText() method.");
  }

}
