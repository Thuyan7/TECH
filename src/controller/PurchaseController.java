/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;

import java.util.List;

public class PurchaseController {
    private PurchaseTableModel purchaseModel;
    private PurchaseXMLReader xmlReader;

    public PurchaseController() {
        xmlReader = new PurchaseXMLReader();
        List<Object[]> purchases = xmlReader.readPurchasesFromXML("C:\\SQL2022/puschase.xml");
        purchaseModel = new PurchaseTableModel(purchases);
    }

    public PurchaseTableModel getPurchaseTableModel() {
        return purchaseModel;
    }
}
