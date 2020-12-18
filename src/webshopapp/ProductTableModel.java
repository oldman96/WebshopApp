/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oldman96
 */
    public class ProductTableModel extends AbstractTableModel{
        private final String DEFAULT_INPUT_FILENAME = "products";
        private final String[] columnNames;
        private final List<Product> products;
        private List<Product> productsToCart;
        //private Object [][] data;

    

    

        public ProductTableModel() throws FileNotFoundException {
            this.columnNames = new String[]{"Product name", "Price ($)", "Category", "Quantity (pcs)", "Add to Cart", "Wishlist"};
            products = new ArrayList<>();
            productsToCart = new ArrayList<>();
            loadProductDataFromInputFile();       
        }

        public List<Product> getProductsToCart() {
        return productsToCart;
    }
        
        @Override
        public int getRowCount() {
              return products.size();
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
            JButton addToCartButton = new JButton(columnNames[columnIndex]);
            addToCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(
                            addToCartButton), 
                            products.get(rowIndex).getProductName()+ "\n\nAdded to Cart!");
                    
                }
            });
            
            JButton addToWishListButton = new JButton(columnNames[columnIndex]);
            addToWishListButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(
                            addToWishListButton), 
                            products.get(rowIndex).getProductName()+ "\n\nAdded to Wishlist!");                 
                }
            });

            Product product = products.get(rowIndex);
            switch (columnIndex)
                {
                    case 0: return product.getProductName();
                    case 1: return product.getPrice();
                    case 2: return product.getCategory();
                    case 3: return product.getQuantity();
                    case 4: return addToCartButton;
                    case 5: return addToWishListButton;
                    default: return null;
                }
        }
        
        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex)
        {
            Product product = products.get(rowIndex);

            switch (columnIndex)
                {
                    case 0: product.setProductName((String)value);
                    case 1: product.setPrice((Float)value);
                    case 2: product.setCategory((String)value);
                    case 3: product.setQuantity((Integer)value);
                }

            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        //Termeklista feltoltese fajlbol
        private void loadProductDataFromInputFile() throws FileNotFoundException{
            BufferedReader reader;
            try{
                reader = new BufferedReader(new FileReader(DEFAULT_INPUT_FILENAME + ".txt"));
                String line = reader.readLine();
                while(line != null){
                    String [] lineArray = line.split(";");
                    Product product = new Product();
                    Float price = Float.parseFloat(lineArray[1]);
                    Integer quantity = Integer.parseInt(lineArray[3]);

                    product.setProductName(lineArray[0]);
                    product.setPrice(price);
                    product.setCategory(lineArray[2]);
                    product.setQuantity(quantity);

                    products.add(product);
                    line = reader.readLine();
                }
                reader.close();
            }catch(FileNotFoundException e){
                throw new FileNotFoundException();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    //        private void loadDataIntoTable(){
//            Object rowData[] = new Object[productList.size()];
//            
//            for(int i=0; i<productList.size(); i++){
//            rowData[0] = productList.get(i).getProductName();
//            rowData[1] = productList.get(i).getPrice();
//            rowData[2] = productList.get(i).getCategory();
//            rowData[3] = productList.get(i).getQuantity();
//            //data[i]=rowData;
//            jTable1.addRow(rowData);
//            }
//        }
    }