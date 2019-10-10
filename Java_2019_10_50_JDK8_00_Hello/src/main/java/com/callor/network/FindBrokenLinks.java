package com.callor.network;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
*/


/*
 * 
 * XML 파싱
 * 
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FindBrokenLinks {
	
	  // Not Xml
	  private static String HOST = "http://int.bizpoll.net";
	  private static String HOST_FILE = "http://int.bizpoll.net/main.php";

	    public static void main(String[] args) throws IOException {
	        HashSet<String> readSitemap = readSitemap(HOST_FILE);
	        for (String href : readSitemap) {
	            HashSet<String> linksSet = findHreflinks(new URL(href));
	            for (String link : linksSet) {
	                URL url = new URL(link);
	                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	                connection.setRequestMethod("GET");
	                connection.connect();
	                if(connection.getResponseCode()!=200){
	                    System.out.println(url + ": "+ connection.getResponseCode());
	                }
	            }
	        }
	    }

	    private static HashSet<String> readSitemap(String sitemapURL) {
	        HashSet<String> set = new HashSet<String>();
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        try {
	            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
	            InputSource inputStream = new InputSource(sitemapURL);
	            Document document = documentBuilder.parse(inputStream);
	            NodeList studentNodeList = document.getElementsByTagName("url");
	            for (int index = 0; index < studentNodeList.getLength(); index++) {
	                Node node = studentNodeList.item(index);
	                if (node.getNodeType() == Node.ELEMENT_NODE) {
	                    Element element = (Element) node;
	                    NodeList nameNodeList = element.getElementsByTagName("loc");
	                    for (int eIndex = 0; eIndex < nameNodeList.getLength(); eIndex++) {
	                        if (nameNodeList.item(eIndex).getNodeType() == Node.ELEMENT_NODE) {
	                            Element nameElement = (Element) nameNodeList.item(eIndex);
	                            set.add(nameElement.getFirstChild().getNodeValue().trim());
	                        }
	                    }
	                }
	            }
	        } catch (ParserConfigurationException e) {
	            e.printStackTrace();
	        } catch (SAXException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return set;
	    }

	    private static HashSet<String> findHreflinks(URL url) {
	        HashSet<String> set = new HashSet<String>();
	        try {
	            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	            StringBuilder sb = new StringBuilder();
	            String str;
	            while ((str = in.readLine()) != null) {
	                sb.append(str).append("\n");
	            }
	            in.close();
	            Pattern p = Pattern.compile("href=\"(.*?)\"");
	            Matcher m = p.matcher(sb);

	            String changedURL = "";
	            while (m.find()) {
	                if (m.group(1).startsWith("//")) {
	                    changedURL = m.group(1).replace("//", "");
	                    set.add(changedURL);
	                } else if (m.group(1).startsWith("/")) {
	                    changedURL = m.group(1).replaceFirst("/", HOST);
	                    set.add(changedURL);
	                }
	            }
	            p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
	            m = p.matcher(sb);
	            while (m.find()) {
	                if (m.group(1).startsWith("/")) {
	                    changedURL = m.group(1).replaceFirst("/", HOST);
	                    set.add(changedURL);
	                } else {
	                    changedURL = m.group(1);
	                    set.add(changedURL);
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Link " + url + " failed");
	        }
	        return set;
	    }

}
