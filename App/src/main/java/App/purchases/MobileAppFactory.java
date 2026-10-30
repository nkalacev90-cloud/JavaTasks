package App.purchases;

import App.receipts.EmailReceiptPrinter;
import App.receipts.ReceiptPrinter;
import App.screens.AppPaymentScreen;
import App.screens.PaymentScreen;

public class MobileAppFactory implements PurchaseInterfaceFactory {
    public PaymentScreen createScreen() { return new AppPaymentScreen(); }
    public ReceiptPrinter createPrinter() { return new EmailReceiptPrinter(); }
}
