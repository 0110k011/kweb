package com.api.kweb.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.webcohesion.ofx4j.domain.data.banking.BankTransactionList;
import com.webcohesion.ofx4j.domain.data.common.Transaction;

import java.io.InputStream;
import java.util.ArrayList;

@Service
public class FileService {

    public OfxDataDto processOfxFile(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();

        OfxParser parser = new OfxParser();
        OfxData ofxData = parser.parse(inputStream);

        OfxDataDto dto = new OfxDataDto();
        dto.setBankName(ofxData.getBankName());
        dto.setAccountNumber(ofxData.getAccountNumber());

        List<TransactionDto> transactions = new ArrayList<>();
        for (Transaction transaction : ofxData.getTransactions()) {
            TransactionDto transactionDto = new TransactionDto();
            transactionDto.setTransactionId(transaction.getId());
        }
    }
}
