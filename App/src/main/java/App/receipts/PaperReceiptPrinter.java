package App.receipts;

public class PaperReceiptPrinter implements ReceiptPrinter {
    public void print() {
        System.out.println("🖥️ [Терминал] Печать бумажного чека...");
    }
}
