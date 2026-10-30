package App.receipts;

public class EmailReceiptPrinter implements ReceiptPrinter {
    public void print() {
        System.out.println("📱 [Приложение] Электронный чек отправлен на Email");
    }
}
