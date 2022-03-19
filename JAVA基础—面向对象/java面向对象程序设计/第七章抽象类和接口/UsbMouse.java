package 第七章抽象类和接口;

public class UsbMouse implements usb{
    @Override
    public void run() {
        System.out.println("usb连接中，鼠标连接中，开始工作");
    }
}
