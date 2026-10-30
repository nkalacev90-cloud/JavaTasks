package App.purchases;

import App.receipts.PaperReceiptPrinter;
import App.receipts.ReceiptPrinter;
import App.screens.KioskPaymentScreen;
import App.screens.PaymentScreen;

public class KioskFactory implements PurchaseInterfaceFactory {
    public PaymentScreen createScreen() { return new KioskPaymentScreen(); }
    public ReceiptPrinter createPrinter() { return new PaperReceiptPrinter(); }
}
