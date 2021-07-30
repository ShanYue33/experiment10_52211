package test;

import com.CardEO5221;
import dao.CardDao5221;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author ys
 * @version 测试支付方法
 */
public class TestPay5221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要消费的卡号：");
        int id = sc.nextInt();
        CardEO5221 card = CardDao5221.findById(id);
        System.out.println("选择你消费的金额：");
        BigDecimal amount = sc.nextBigDecimal();
        card.pay(amount);
        if (!card.pay(amount)) {
            System.out.println("该校园卡已被冻结或注销，无法进行支付！");
        }
        CardDao5221.update(card);
        System.out.println("该卡余额为：" + card.getBalance());
    }
}
