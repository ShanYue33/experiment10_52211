package com;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ys
 * @version 1.0.0
 */
@Entity
@Table(name = "tb_code", schema = "dbo", catalog = "study2")
public class CardEO5221 implements Serializable {
    private int id;
    private String code;
    private BigDecimal balance;
    private String state;

    public CardEO5221() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "c_code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "c_balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "c_state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public boolean deposit(BigDecimal amount) {
        int i = amount.compareTo(BigDecimal.ZERO);
        if (i == 1 || i == 0) {
            this.balance = balance.add(amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean pay(BigDecimal amount) {
        if (("在用".equals(state)) && (amount.compareTo(BigDecimal.ZERO) == 1)
                && (amount.compareTo(balance) != 1)) {
            this.balance = balance.subtract(amount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "CardEO5221{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", balance=" + balance +
                ", state='" + state + '\'' +
                '}';
    }
}




