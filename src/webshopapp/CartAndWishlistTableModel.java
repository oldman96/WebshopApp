/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopapp;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//import javax.swing.table.AbstractTableModel;
//
///**
// *
// * @author oldman96
// */
//public class CartAndWishlistTableModel extends AbstractTableModel{
//        private final String[] columnNames;
//        private final List<Product> productsInCart;
//        //private Object [][] data;
//
//        public CartAndWishlistTableModel(List<Product> products) throws FileNotFoundException {
//            this.columnNames = new String[]{"Product name", "Price ($)", "Remove"};
//            productsInCart = new ArrayList<>(products);
//           
//        }
//       
//
//        
//        @Override
//        public int getRowCount() {
//              return productsInCart.size();
//        }
//
//        @Override
//        public int getColumnCount() {
//             return columnNames.length;
//        }
//
//        @Override
//        public String getColumnName(int col) {
//            return columnNames[col];
//        }
//
//        @Override
//        public Object getValueAt(int rowIndex, int columnIndex) {
//            JButton removeButton = new JButton(columnNames[columnIndex]);
//            removeButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(removeButton), 
//                            productsInCart.get(rowIndex).getProductName()+ "\n\nRemoved!");
//                    productsInCart.remove(rowIndex);
//                    fireTableDataChanged();
//                            
//                }
//            });
//
//            Product product = productsInCart.get(rowIndex);
//            switch (columnIndex)
//                {
//                    case 0: return product.getProductName();
//                    case 1: return product.getPrice();
//                    case 2: return removeButton;
//                    default: return null;
//                }
//        }
//        
//        @Override
//        public void setValueAt(Object value, int rowIndex, int columnIndex)
//        {
//            Product product = productsInCart.get(rowIndex);
//
//            switch (columnIndex)
//                {
//                    case 0: product.setProductName((String)value);
//                    case 1: product.setPrice((Float)value);
//                }
//
//            fireTableCellUpdated(rowIndex, columnIndex);
//        }
//
//        @Override
//        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }
//}
