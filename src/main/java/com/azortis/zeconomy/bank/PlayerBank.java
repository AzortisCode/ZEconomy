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
import org.bukkit.OfflinePlayer;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class PlayerBank implements Bank {

    private final EconomyEntity<OfflinePlayer> playerEntity;
    private final Currency currency;
    private BigDecimal balance;

    public PlayerBank(EconomyEntity<OfflinePlayer> playerEntity, Currency currency) {
        this.playerEntity = playerEntity;
        this.currency = currency;
    }

    @Override
    public UUID getBankId() {
        return playerEntity.getEntity().getUniqueId();
    }

    @Override
    public EconomyEntity<OfflinePlayer> getHolder() {
        return playerEntity;
    }

    @Override
    public List<EconomyEntity<?>> getMembers() {
        return null;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
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
        return false;
    }

    @Override
    public boolean hasMore(BigDecimal amount) {
        return false;
    }

    @Override
    public boolean hasLess(BigDecimal amount) {
        return false;
    }
}
