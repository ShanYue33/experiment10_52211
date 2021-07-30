package test;

import com.CardEO5221;
import dao.CardDao5221;

import java.util.List;

/**
 * @author ys
 * @version 1.0.0
 */
public class TestFindAll5221 {
    public static void main(String[] args) {
        List<CardEO5221> cards = CardDao5221.findAll();
        System.out.println("查询的结果为：");
        for (CardEO5221 c : cards) {
            System.out.println(c);
        }
    }
}
