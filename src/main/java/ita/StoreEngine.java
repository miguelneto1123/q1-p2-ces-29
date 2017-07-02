package ita;

import java.util.ArrayList;
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

    public List<String> getSuggestions(String title) {
        List<String> keywords = new ArrayList<>();
        List<String> suggestions = new ArrayList<>();
        for (String word : title.split(" ")){
            if (!word.matches("^by|and|an|a|the$"))
                keywords.add(word);
        }
        for (DBEntry entry : stock){
            for (String keyword :  keywords){
                if (entry.getTitle().contains(keyword) && !entry.getTitle().equals(title)) {
                    suggestions.add(entry.getTitle());
                    break;
                }
            }
        }
        return suggestions;
    }

    public List<String> getSuggestionsForTopic(String topic) {
        List<String> suggestions = new ArrayList<>();
        for (DBEntry entry : stock) {
            if(entry.getTitle().toLowerCase().contains(topic.toLowerCase()))
                suggestions.add(entry.getTitle());
        }
        return suggestions;
    }

    public String buyBook(String title) {
        DBEntry check = null;
        for (DBEntry entry : stock) {
            if(entry.getTitle().equals(title)) {
                check = entry;
                break;
            }
        }
        if (check != null) {
            if (check.getQuantity() > 0) {
                check.decreaseQuantity();
                return "You just bought \"" + title + "\".";
            } else {
                return "Sorry, \"" + title + "\"is not on stock.";
            }
        } else {
            return "We don't have \""+title+"\" on our database.";
        }
    }

    public int getStockQuantity(String title) {
        DBEntry check = null;
        for (DBEntry entry : stock) {
            if(entry.getTitle().equals(title)) {
                check = entry;
                break;
            }
        }
        if (check != null) {
            return check.getQuantity();
        } else {
            return -1;
        }
    }
}
