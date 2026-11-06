package App1.purchases;

import App1.receipts.EmailReceiptPrinter;
import App1.receipts.PaperReceiptPrinter;
import App1.screens.AppPaymentScreen;
import App1.screens.KioskPaymentScreen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void kioskFactoryProducesKioskProducts() {
        PurchaseInterfaceFactory f = new KioskFactory();

        assertInstanceOf(KioskPaymentScreen.class, f.createScreen());
        assertInstanceOf(PaperReceiptPrinter.class, f.createPrinter());
    }

    @Test
    void mobileFactoryProducesMobileProducts() {
        PurchaseInterfaceFactory f = new MobileAppFactory();

        assertInstanceOf(AppPaymentScreen.class, f.createScreen());
        assertInstanceOf(EmailReceiptPrinter.class, f.createPrinter());
    }
}