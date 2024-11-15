/*
package com.api.kweb.services;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.ByteArrayInputStream;

public class XMLReader {
    public static void main(String[] args) {
        try {
            // Caminho para o arquivo OFX
            String filePath = "/home/k/Downloads/teste.ofx";

            // Lê o conteúdo do arquivo como uma string
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Remove linhas de cabeçalho antes da tag <OFX>
            int startIndex = content.indexOf("<OFX>");
            if (startIndex != -1) {
                content = content.substring(startIndex); // Mantém apenas o conteúdo XML
            } else {
                throw new Exception("Tag <OFX> não encontrada no arquivo.");
            }

            // Converter a string de conteúdo para um InputStream
            ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());

            // Parse do conteúdo XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            System.out.println("Elemento Raiz: " + doc.getDocumentElement().getNodeName());

            // Processamento adicional do arquivo OFX (similar ao exemplo anterior)
            NodeList transactionList = doc.getElementsByTagName("STMTTRN");

            for (int i = 0; i < transactionList.getLength(); i++) {
                Node transactionNode = transactionList.item(i);

                if (transactionNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element transactionElement = (Element) transactionNode;

                    // Exibe informações de transação
                    String tipo = transactionElement.getElementsByTagName("TRNTYPE").item(0).getTextContent();
                    String data = transactionElement.getElementsByTagName("DTPOSTED").item(0).getTextContent();
                    String valor = transactionElement.getElementsByTagName("TRNAMT").item(0).getTextContent();
                    String id = transactionElement.getElementsByTagName("FITID").item(0).getTextContent();

                    System.out.println("Tipo: " + tipo);
                    System.out.println("Data: " + data);
                    System.out.println("Valor: " + valor);
                    System.out.println("ID: " + id);
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
