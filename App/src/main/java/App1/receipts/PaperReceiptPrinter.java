package App1.receipts;

public class PaperReceiptPrinter implements ReceiptPrinter {
    public void print() {
        System.out.println("🖥️ [Терминал] Печать бумажного чека...");
    }
}
