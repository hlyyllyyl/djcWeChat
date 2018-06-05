package com.decisioncustom.query;

public class CustomerStockQuery extends BaseQuery{

    private String stockName;
    private String stockCode;

    private Long customerId;

    private Long history;
    private Long profitLoss;

    public Long getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(Long profitLoss) {
        this.profitLoss = profitLoss;
    }

    public Long getHistory() {
        return history;
    }

    public void setHistory(Long history) {
        this.history = history;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
}
