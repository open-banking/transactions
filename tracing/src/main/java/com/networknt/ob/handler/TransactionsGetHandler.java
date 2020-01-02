package com.networknt.ob.handler;

import com.networknt.handler.LightHttpHandler;
import com.networknt.httpstring.AttachmentConstants;
import com.networknt.utility.Constants;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import java.util.HashMap;
import java.util.Map;

public class TransactionsGetHandler implements LightHttpHandler {
    
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        Map<String, Object> auditInfo = exchange.getAttachment(AttachmentConstants.AUDIT_INFO);
        String userId = (String)auditInfo.get(Constants.USER_ID_STRING);
        String responseBody = null;
        if("stevehu".equals(userId)) {
            responseBody = "{\"Data\":{\"Transaction\":[{\"AccountId\":\"22289\",\"TransactionId\":\"123\",\"TransactionReference\":\"Ref 123\",\"Amount\":{\"Amount\":\"10.00\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Credit\",\"Status\":\"Booked\",\"BookingDateTime\":\"2017-04-05T10:43:07+00:00\",\"ValueDateTime\":\"2017-04-05T10:45:22+00:00\",\"TransactionInformation\":\"Cash from Aubrey\",\"BankTransactionCode\":{\"Code\":\"ReceivedCreditTransfer\",\"SubCode\":\"DomesticCreditTransfer\"},\"ProprietaryBankTransactionCode\":{\"Code\":\"Transfer\",\"Issuer\":\"AlphaBank\"},\"Balance\":{\"Amount\":{\"Amount\":\"230.00\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Credit\",\"Type\":\"InterimBooked\"}},{\"AccountId\":\"31820\",\"TransactionId\":\"567\",\"TransactionReference\":\"Ref 124\",\"Amount\":{\"Amount\":\"100.00\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Debit\",\"Status\":\"Booked\",\"BookingDateTime\":\"2017-05-02T14:22:09+00:00\",\"ValueDateTime\":\"2017-05-02T14:22:09+00:00\",\"TransactionInformation\":\"Paid the gas bill\",\"AddressLine\":\"Coventry\",\"BankTransactionCode\":{\"Code\":\"IssuedCreditTransfer\",\"SubCode\":\"AutomaticTransfer\"},\"ProprietaryBankTransactionCode\":{\"Code\":\"DirectDebit\",\"Issuer\":\"AlphaBank\"},\"Balance\":{\"Amount\":{\"Amount\":\"57.36\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Debit\",\"Type\":\"InterimBooked\"}}]},\"Links\":{\"Self\":\"https://api.alphabank.com/transactions\"},\"Meta\":{\"TotalPages\":1,\"FirstAvailableDateTime\":\"2017-05-03T00:00:00+00:00\",\"LastAvailableDateTime\":\"2017-12-03T00:00:00+00:00\"}}";
        } else if("ericbroda".equals(userId)) {
            responseBody = "{\"Data\":{\"Transaction\":[{\"AccountId\":\"42281\",\"TransactionId\":\"123\",\"TransactionReference\":\"Ref 123\",\"Amount\":{\"Amount\":\"10.00\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Credit\",\"Status\":\"Booked\",\"BookingDateTime\":\"2017-04-05T10:43:07+00:00\",\"ValueDateTime\":\"2017-04-05T10:45:22+00:00\",\"TransactionInformation\":\"Cash from Aubrey\",\"BankTransactionCode\":{\"Code\":\"ReceivedCreditTransfer\",\"SubCode\":\"DomesticCreditTransfer\"},\"ProprietaryBankTransactionCode\":{\"Code\":\"Transfer\",\"Issuer\":\"AlphaBank\"},\"Balance\":{\"Amount\":{\"Amount\":\"230.00\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Credit\",\"Type\":\"InterimBooked\"}},{\"AccountId\":\"41221\",\"TransactionId\":\"567\",\"TransactionReference\":\"Ref 124\",\"Amount\":{\"Amount\":\"100.00\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Debit\",\"Status\":\"Booked\",\"BookingDateTime\":\"2017-05-02T14:22:09+00:00\",\"ValueDateTime\":\"2017-05-02T14:22:09+00:00\",\"TransactionInformation\":\"Paid the gas bill\",\"AddressLine\":\"Coventry\",\"BankTransactionCode\":{\"Code\":\"IssuedCreditTransfer\",\"SubCode\":\"AutomaticTransfer\"},\"ProprietaryBankTransactionCode\":{\"Code\":\"DirectDebit\",\"Issuer\":\"AlphaBank\"},\"Balance\":{\"Amount\":{\"Amount\":\"57.36\",\"Currency\":\"GBP\"},\"CreditDebitIndicator\":\"Debit\",\"Type\":\"InterimBooked\"}}]},\"Links\":{\"Self\":\"https://api.alphabank.com/transactions\"},\"Meta\":{\"TotalPages\":1,\"FirstAvailableDateTime\":\"2017-05-03T00:00:00+00:00\",\"LastAvailableDateTime\":\"2017-12-03T00:00:00+00:00\"}}";
        }
        if(responseBody != null) {
            exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
            exchange.getResponseSender().send(responseBody);
        } else {
            exchange.setStatusCode(404);
            exchange.getResponseSender().send("");
        }
    }
}
