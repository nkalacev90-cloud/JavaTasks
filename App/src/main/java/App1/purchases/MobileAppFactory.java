package App1.purchases;

import App1.receipts.EmailReceiptPrinter;
import App1.receipts.ReceiptPrinter;
import App1.screens.AppPaymentScreen;
import App1.screens.PaymentScreen;

public class MobileAppFactory implements PurchaseInterfaceFactory {
    public PaymentScreen createScreen() { return new AppPaymentScreen(); }
    public ReceiptPrinter createPrinter() { return new EmailReceiptPrinter(); }
}
