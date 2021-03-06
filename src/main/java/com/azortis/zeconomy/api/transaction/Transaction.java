/*
 * MIT License
 *
 * Copyright (c) 2021 Azortis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.azortis.zeconomy.api.transaction;

import com.azortis.zeconomy.api.Bank;
import com.azortis.zeconomy.api.EconomyEntity;

import java.math.BigDecimal;

public class Transaction {

    private final Bank sender;
    private final EconomyEntity<?> senderEntity;
    private final Bank receiver;
    private final BigDecimal amount;
    private final Reason reason;

    private Status status;

    public Transaction(Bank sender, EconomyEntity<?> senderEntity, Bank receiver, BigDecimal amount, Reason reason) {
        this.sender = sender;
        this.senderEntity = senderEntity;
        this.receiver = receiver;
        this.amount = amount;
        this.reason = reason;
        this.status = Status.PENDING;
    }

    public Bank getSender() {
        return sender;
    }

    public EconomyEntity<?> getSenderEntity() {
        return senderEntity;
    }

    public Bank getReceiver() {
        return receiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Reason getReason() {
        return reason;
    }

    public void setStatus(Status status){
        if(this.status == Status.PENDING)this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        FINISHED,
        PENDING,
        DENIED,
        ERROR
    }

    public enum Reason {
        PURCHASE,
        WITHDRAWAL,
        DEPOSIT,
        ADMIN,
        CUSTOM
    }

}
