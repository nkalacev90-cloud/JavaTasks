package App;

public class MobileAppFactory implements PurchaseInterfaceFactory {
    public PaymentScreen createScreen() { return new AppPaymentScreen(); }
    public ReceiptPrinter createPrinter() { return new EmailReceipt(); }
}
