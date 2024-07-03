package likelion.srping.data.enumType;

public enum OrderStatus {

    PENDING("PENDING"),
    DELIVERED("DELIVERED"),
    CANCELED("CANCELED");

    public String value;

    OrderStatus(String value) {
        this.value = value;
    }


}
