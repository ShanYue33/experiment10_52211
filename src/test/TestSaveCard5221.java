package test;

import com.CardEO5221;
import dao.CardDao5221;

import java.math.BigDecimal;

/**
 * @author ys
 * @version 1.0.0
 */
public class TestSaveCard5221 {
    public static void main(String[] args) {
        String[][] datas = {{"4888", "201910604226", "33", "在用"},
                {"2220", "201910305230", "0", "注销"},
                {"3340", "201810605225", "200", "冻结"}};
        //将数据保存到数据库中
        CardEO5221 crd = null;
        for (String[] data : datas) {
            crd = new CardEO5221();
            crd.setId(Integer.parseInt(data[0]));
            crd.setCode(data[1]);
            crd.setBalance(new BigDecimal(data[2]));
            crd.setState(data[3]);
            CardDao5221.save(crd);
        }
    }
}
