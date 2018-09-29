public enum Location {
    SOFA(" диван "),ROOF(" дом на крыше ");


    private String location;
    Location(String location) {
        this.location=location;
    }

    public String getLocation() {
        return location;
    }


}
