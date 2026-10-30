package App.purchases;

import App.receipts.ReceiptPrinter;
import App.screens.PaymentScreen;

public interface PurchaseInterfaceFactory {
PaymentScreen createScreen();
ReceiptPrinter createPrinter();
}
