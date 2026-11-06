package App1.purchases;

import App1.receipts.PaperReceiptPrinter;
import App1.receipts.ReceiptPrinter;
import App1.screens.KioskPaymentScreen;
import App1.screens.PaymentScreen;

public class KioskFactory implements PurchaseInterfaceFactory {
    public PaymentScreen createScreen() { return new KioskPaymentScreen(); }
    public ReceiptPrinter createPrinter() { return new PaperReceiptPrinter(); }
}
