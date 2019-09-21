package com.callor.files.exec;

import com.callor.files.service.AddrService;

import java.io.IOException;

public class AddrEx_01 {

    public static void main(String[] args) {

        AddrService as = new AddrService();
        String addrFile = "src/com/callor/files/지방자치단체주소록(2016).txt";
        String saveAddrFile = "src/com/callor/files/지방자치단체주소.txt";

        try {
            as.readAddr(addrFile);
            as.makeAddr(saveAddrFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
