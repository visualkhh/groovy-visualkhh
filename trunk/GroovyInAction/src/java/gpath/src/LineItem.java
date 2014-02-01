public class LineItem {
    private Product product;
    private int count;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int total() {
        return getProduct().getDollar() * count;
    }
}
