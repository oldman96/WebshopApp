/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webshopapp;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author oldman96
 */
public class ProductList extends javax.swing.JFrame {
    
    private final String DEFAULT_INPUT_FILENAME = "products";
    private final List<Product> productList;

    /**
     * Creates new form ProductList
     * @throws java.io.FileNotFoundException
     */
    public ProductList() throws FileNotFoundException {
        productList = new ArrayList<>();
        initComponents();
        loadProductDataFromInputFile();
        myTableModel = new myProductTableModel();
        jTable1.setModel(myTableModel);
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        jTable1.getColumn("Add to Cart").setCellRenderer(buttonRenderer);
        jTable1.addMouseListener(new JTableButtonMouseListener(jTable1));
        
        
        
        
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

                productList.add(product);
                line = reader.readLine();
            }
            reader.close();
        }catch(FileNotFoundException e){
            throw new FileNotFoundException();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    //custom tablemodel osztaly
    private class myProductTableModel extends AbstractTableModel{
        private final String[] columnNames;
        private final Object [][] data;

        public myProductTableModel() {

            String[] columnNamesInit = {"Product name",
                            "Price ($)",
                            "Category",
                            "Quantity (pcs)",
                            "Add to Cart"};

            this.columnNames = columnNamesInit;
            this.data = loadDataIntoTable().toArray(new Object[][] {});
        }


        private List<Object[]> loadDataIntoTable(){
            List<Object[]> list = new ArrayList<>();
            if (!productList.isEmpty()) {
                for(int i=0; i<productList.size(); i++) {
                    list.add(new Object[]{
                        productList.get(i).getProductName(),
                        productList.get(i).getPrice(),
                        productList.get(i).getCategory(),
                        productList.get(i).getQuantity(),
                        //getAddToCartButton()
                    });
                }
            }
            return list;
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
            JButton button = new JButton(columnNames[columnIndex]);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
                            "Button clicked for row "+rowIndex);
                }
            });
            
        
            
            //return data[rowIndex][columnIndex];
            switch (columnIndex) {
                
               /*Adding button and creating click listener*/
                case 4: return button;
                default: return data[rowIndex][columnIndex];
            }
        }
        
//        @Override
//        public void setValueAt(Object aValue, int row, int col) {
//            list.get(row).name = (String) aValue;
//            fireTableCellUpdated(row, col);
//        }

        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        private Object getAddToCartButton() {
             JButton button =new JButton("Add to Cart");
             return button;
        }

    }
    
    private static class JTableButtonRenderer implements TableCellRenderer {        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;  
        }
    }
    
    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button

                    /*Checking the row or column is valid or not*/
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    /*perform a click event*/
                    ((JButton)value).doClick();
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        headerPanel = new javax.swing.JPanel();
        webshopLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        headerPanel.setBackground(new java.awt.Color(102, 112, 123));

        webshopLabel.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
        webshopLabel.setForeground(new java.awt.Color(243, 237, 237));
        webshopLabel.setText(" Webshop");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(webshopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 685, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(webshopLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ProductList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ProductList().setVisible(true);
//            }
//        });
//    }
    
    private final myProductTableModel myTableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel webshopLabel;
    // End of variables declaration//GEN-END:variables
}
