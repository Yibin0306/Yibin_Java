package 第七章抽象类和接口;

public class UsbPrinter implements usb{
    @Override
    public void run() {
        System.out.println("usb连接中，打印机连接中，开始工作");
    }
}
