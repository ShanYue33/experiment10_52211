package test;

import com.CardEO5221;
import dao.CardDao5221;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author ys
 * @version 1.0.0
 */
public class TestUpdate5221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你需要更新的卡号：");
        int id = sc.nextInt();
        CardEO5221 card = CardDao5221.findById(id);
        card.setId(id);
        System.out.println("请输入你更新的学号：");
        String code = sc.next();
        card.setCode(code);
        System.out.println("请输入你更新的余额：");
        BigDecimal balance = sc.nextBigDecimal();
        card.setBalance(balance);
        System.out.println("请输入你更新的状态：");
        String state = sc.next();
        card.setState(state);
        CardDao5221.update(card);
    }
}
