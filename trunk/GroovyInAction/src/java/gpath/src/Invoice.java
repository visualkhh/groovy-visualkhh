import java.util.List;
import java.util.Date;

public class Invoice {
    private List items;
    private Date date;

    public List getItems() {
        return items;
    }
    public void setItems(List items) {
        this.items = items;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
