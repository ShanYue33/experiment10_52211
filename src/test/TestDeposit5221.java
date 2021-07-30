package test;

import com.CardEO5221;
import dao.CardDao5221;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author ys
 */
public class TestDeposit5221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要充值的卡号：");
        int id = sc.nextInt();
        CardEO5221 card = CardDao5221.findById(id);
        System.out.println("请输入你要充值的金额：");

        BigDecimal amount = sc.nextBigDecimal();
        card.deposit(amount);
        if (card.deposit(amount)) {
            CardDao5221.update(card);
        }
             System.out.println("充值后，该用户卡余额为：" + card.getBalance());
    }
}
