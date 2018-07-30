package java.factory.abstracts;

public class LinuxText implements Text {

  @Override
  public void getWholeText() {
    System.out.println("Inside LinuxText::getWholeText() method.");
  }

}
