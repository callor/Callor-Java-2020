package com.callor.files.service;

import com.callor.files.domain.AddrVO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddrService {

    List<AddrVO> addrList = null;
    public AddrService() {
        addrList = new ArrayList<AddrVO>();
    }

    public void readAddr(String addrFile) throws IOException {

        FileReader fileReader = null;
        BufferedReader buffer = null;

        fileReader = new FileReader(addrFile);
        buffer = new BufferedReader(fileReader);

        String reader = new String();
        while(true){
            reader = buffer.readLine();
            if(reader == null) break;

            String[] adders = reader.split(":");
            AddrVO aVO = new AddrVO();
            aVO.setName(adders[0]);
            aVO.setCity(adders[1]);
            aVO.setAddr(adders[2]);
            aVO.setZipcode(adders[3]);
            aVO.setTel(adders[4] +"-" +adders[5]);
            aVO.setHomepage(adders[6]);
            addrList.add(aVO);
        }
        
        buffer.close();
        fileReader.close();
    }

    public void makeAddr(String addrFile) throws FileNotFoundException {

        PrintWriter fileOut = null;
        fileOut = new PrintWriter(addrFile);

        for(AddrVO vo : addrList) {
            String[] strAddrs = vo.getAddr().split(" ");
            String strAddr = "";
            for(int i = 1 ; i< strAddrs.length ;i++) {
                strAddr += strAddrs[i];
            }
            System.out.println(vo.getCity() + " " +strAddr);

            //      name,city,zipcode,addr,tel,email
            fileOut.printf("%s청:%s:%s %s:%s:https://www.%s%n",
                    vo.getCity(),
                    vo.getZipcode(),
                    vo.getCity(),
                    strAddr,
                    vo.getTel(),
                    vo.getHomepage());
        }
        fileOut.close();


    }


}
