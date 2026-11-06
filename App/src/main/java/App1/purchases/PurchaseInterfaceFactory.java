package App1.purchases;

import App1.receipts.ReceiptPrinter;
import App1.screens.PaymentScreen;

public interface PurchaseInterfaceFactory {
PaymentScreen createScreen();
ReceiptPrinter createPrinter();
}
