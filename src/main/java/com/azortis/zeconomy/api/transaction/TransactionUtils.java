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
import com.azortis.zeconomy.api.Currency;
import com.azortis.zeconomy.api.EconomyEntity;
import org.bukkit.Server;

import java.math.BigDecimal;

public class TransactionUtils {

    private static EconomyEntity<Server> serverEntity;

    private TransactionUtils(){}

    public static void setServerEntity(EconomyEntity<Server> entity){
        serverEntity = entity;
    }

    public static Transaction setBalance(final Bank bank, final BigDecimal amount, final Transaction.Reason reason){
        final BigDecimal currentBalance = bank.getBalance();
        int res = currentBalance.compareTo(amount);
        BigDecimal finalAmount;
        if(res == 0){
            finalAmount = amount;
        } else{
            finalAmount = amount.subtract(currentBalance);
        }
        Currency currency = bank.getCurrency();
        Bank serverBank = serverEntity.getPrimaryBank(currency);
        return serverBank.sendTransaction(bank, serverEntity, finalAmount, reason);
    }

    public static Transaction addBalance(final Bank bank, final BigDecimal amount, final Transaction.Reason reason){
        Currency currency = bank.getCurrency();
        Bank serverBank = serverEntity.getPrimaryBank(currency);
        return serverBank.sendTransaction(bank, serverEntity, amount, reason);
    }

    public static Transaction subtractBalance(final Bank bank, final BigDecimal amount, final Transaction.Reason reason){
        Currency currency = bank.getCurrency();
        Bank serverBank = serverEntity.getPrimaryBank(currency);
        final BigDecimal finalAmount = amount.multiply(new BigDecimal(-1));
        return null;
    }

    public static Transaction multiplyBalance(final Bank bank, final BigDecimal amount, final Transaction.Reason reason){
        return null;
    }

    public static Transaction divideBalance(final Bank bank, final BigDecimal amount, final Transaction.Reason reason){
        return null;
    }

}
