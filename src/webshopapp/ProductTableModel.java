/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopapp;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oldman96
 */
public class ProductTableModel extends AbstractTableModel{
    private String[] columnNames;
    private Object data[][];

    public ProductTableModel() {
        
        String[] columnNames2 = {"First Name",
                        "Last Name",
                        "Sport",
                        "# of Years",
                        "Vegetarian"};
        
        Object[][] data2 = {
            {"Kathy", "Smith",
             "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
             "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
             "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
             "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
             "Pool", new Integer(10), new Boolean(false)}
        };
        
        this.columnNames = columnNames2;
        this.data = data2;
    }
    
    


    @Override
    public int getRowCount() {
          return data.length;
    }

    @Override
    public int getColumnCount() {
         return columnNames.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
}
