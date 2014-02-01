import java.util.*;

public class GPathReplacement {
    public static void main(String[] args) {
        Product ulc = new Product();
        ulc.setName("ULC");
        ulc.setDollar(1499);
        Product ve = new Product();
        ve.setName("Visual Editor");
        ve.setDollar(499);

        Invoice invoiceOne = new Invoice();
        invoiceOne.setDate(new Date(105,0,1));
        List lineItems = new LinkedList();
        LineItem item = new LineItem();
        item.setCount(5);
        item.setProduct(ulc);
        lineItems.add(item);
        item = new LineItem();
        item.setCount(1);
        item.setProduct(ve);
        lineItems.add(item);
        invoiceOne.setItems(lineItems);

        Invoice invoiceTwo = new Invoice();
        invoiceTwo.setDate(new Date(105,1,2));
        lineItems = new LinkedList();
        item = new LineItem();
        item.setCount(4);
        item.setProduct(ve);
        lineItems.add(item);
        invoiceTwo.setItems(lineItems);

        Invoice[] invoices = {invoiceOne, invoiceTwo};

        List expected = new LinkedList();
        expected.add(new Integer(5*1499));
        expected.add(new Integer(499));
        expected.add(new Integer(4*499));
        System.out.println("all item totals: " +
                (expected.equals(getAllItemTotals(invoices))));

        expected = new LinkedList();
        expected.add("ULC");
        System.out.println("name for items > 7000 :" +
                (expected.equals(getProductNamesWithItemTotal(invoices))));

        expected = new LinkedList();
        expected.add("Sat Jan 01 00:00:00 CET 2005");
        System.out.println("dates for ulc sales: " +
                (expected.equals(getProductSellingDates(invoices, ulc))));
    }

    private static List getAllItemTotals(Invoice[] invoices) {
        List result = new LinkedList();
        for (int i = 0; i < invoices.length; i++) {
            List items = invoices[i].getItems();
            for (Iterator iter = items.iterator(); iter.hasNext();) {
                LineItem lineItem = (LineItem) iter.next();
                result.add(new Integer(lineItem.total()));
            }
        }
        return result;
    }

    private static List getProductNamesWithItemTotal(Invoice[] invoices) {
        List result = new LinkedList();
        for (int i = 0; i < invoices.length; i++) {
            List items = invoices[i].getItems();
            for (Iterator iter = items.iterator(); iter.hasNext();) {
                LineItem lineItem = (LineItem) iter.next();
                if (lineItem.total() > 7000){
                    result.add(lineItem.getProduct().getName());
                }
            }
        }
        return result;
    }

    private static List getProductSellingDates(Invoice[] invoices, Product ulc) {
        List result = new LinkedList();
        for (int i = 0; i < invoices.length; i++) {
            Invoice invoice = invoices[i];
            List items = invoice.getItems();
            for (Iterator itemIter = items.iterator(); itemIter.hasNext();) {
                LineItem lineItem = (LineItem) itemIter.next();
                if (lineItem.getProduct().equals(ulc)){
                    result.add(invoice.getDate().toString());
                    break; // tricky :-)
                }
            }
        }
        return result;
    }
}
