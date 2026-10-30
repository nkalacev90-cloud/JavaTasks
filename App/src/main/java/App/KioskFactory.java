package App;

public class KioskFactory implements PurchaseInterfaceFactory {
    public PaymentScreen createScreen() { return new KioskPaymentScreen(); }
    public ReceiptPrinter createPrinter() { return new PaperReceipt(); }
}
