package 第七章抽象类和接口;

public class test {
    public static void main(String[] args) {
        usb Printer = new UsbPrinter();
        usb Mouse = new UsbMouse();
        Printer.run();
        Mouse.run();
    }
}
