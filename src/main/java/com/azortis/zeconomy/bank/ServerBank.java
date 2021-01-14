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

package com.azortis.zeconomy.bank;

import com.azortis.zeconomy.api.Bank;
import com.azortis.zeconomy.api.Currency;
import com.azortis.zeconomy.api.EconomyEntity;
import com.azortis.zeconomy.api.transaction.Transaction;
import org.bukkit.Server;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ServerBank implements Bank {


    @Override
    public UUID getBankId() {
        return null;
    }

    @Override
    public EconomyEntity<Server> getHolder() {
        return null;
    }

    @Override
    public List<EconomyEntity<?>> getMembers() {
        return null;
    }

    @Override
    public Currency getCurrency() {
        return null;
    }

    @Override
    public BigDecimal getBalance() {
        return BigDecimal.ONE;
    }

    @Override
    public Transaction sendTransaction(Bank recipient, EconomyEntity<?> sender, BigDecimal amount, Transaction.Reason reason) {
        return null;
    }

    @Override
    public void receiveTransaction(Transaction transaction) {

    }

    @Override
    public boolean hasEnough(BigDecimal amount) {
        return true;
    }

    @Override
    public boolean hasMore(BigDecimal amount) {
        return true;
    }

    @Override
    public boolean hasLess(BigDecimal amount) {
        return false;
    }
}
