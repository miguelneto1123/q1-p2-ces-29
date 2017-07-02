package ita;

import java.util.Collections;
import java.util.List;

/**
 * Created by miguel on 7/1/17.
 */
public class StoreEngine {
    private List<DBEntry> stock;

    public StoreEngine(List<DBEntry> entries) {
        stock = entries;
    }

    public List<DBEntry> getStock() {
        return Collections.unmodifiableList(stock);
    }

    public void setStock(List<DBEntry> stock) {
        this.stock = stock;
    }

    public boolean checkStockFor(String title) {
        for (DBEntry book : stock){
            if (book.getTitle().equals(title) && book.getQuantity() > 0)
                return true;
        }
        return false;
    }
}
