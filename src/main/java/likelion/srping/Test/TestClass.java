package likelion.srping.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TestClass {

    int a;
    int b;


    public static void main(String[] args) {
        TestClass t = new TestClass(1,2);
        System.out.println(t.getA() + t.getB());
    }
}
