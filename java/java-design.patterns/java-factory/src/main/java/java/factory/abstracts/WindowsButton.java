package java.factory.abstracts;

public class WindowsButton implements Button {

  @Override
  public void processEvent() {
    System.out.println("Inside WindowsButton::processEvent() method.");
  }

}
