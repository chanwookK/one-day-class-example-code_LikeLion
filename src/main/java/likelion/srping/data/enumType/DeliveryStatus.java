package likelion.srping.data.enumType;


public enum DeliveryStatus {
    PENDING("PENDING"), // 배달 차량에 탑재됨
    DELIVERED("DELIVERED"),      // 배달 완료됨
    FAILED("FAILED"); // 배달 실패

    public String value;

    DeliveryStatus(String value){
        this.value = value;
    }
}
