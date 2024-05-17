package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PurchaseTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Name", "Price", "Quantity"};
    private List<Object[]> purchases;

    public PurchaseTableModel(List<Object[]> purchases) {
        this.purchases = purchases;
    }

    @Override
    public int getRowCount() {
        return purchases.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return purchases.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
