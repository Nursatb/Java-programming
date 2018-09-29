public enum Product {
    FORCEMEAT("фарш");
    String name_of_product;
    Product(String name_of_product) {
        this.name_of_product=name_of_product;
    }

    public String getName_of_product() {
        return name_of_product;
    }

}
