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
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author oldman96
 */
public class ProductList extends javax.swing.JFrame {
    private ProductTableModel productTableModel;
    private int filterByColumn;
    private List<Product> productsToCart;
    /**
     * Creates new form ProductList
     * 
     * @param tableModel
     */
    public ProductList(){
        initComponents();
        createProductTableModel();
//        productTableModel = tableModel;
        
        productListTable.setModel(productTableModel);
        
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        productListTable.getColumn("Add to Cart").setCellRenderer(buttonRenderer);
        productListTable.getColumn("Wishlist").setCellRenderer(buttonRenderer);
        productListTable.addMouseListener(new JTableButtonMouseListener(productListTable));
//        jTable1.getColumnModel().getColumn(0).setPreferredWidth(415);
        productListTable.getColumnModel().getColumn(0).setMinWidth(415);
        //jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        productListTable.getColumnModel().getColumn(2).setMinWidth(150);
        productListTable.getColumnModel().getColumn(1).setMinWidth(100);
        productListTable.getColumnModel().getColumn(3).setMinWidth(100);
        productListTable.getColumnModel().getColumn(4).setMinWidth(100);
        productListTable.getColumnModel().getColumn(5).setMinWidth(100);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        productListTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        productListTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        productListTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        filterComboBox.setSelectedIndex(0);
    }
    
    private void tableFilter(String filterText){
        
        TableRowSorter<ProductTableModel> sorter = new TableRowSorter<>(productTableModel);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filterText, filterByColumn));
        if(filterTextField.getText().length()==0){
            productListTable.setRowSorter(null);
        }
        productListTable.setRowSorter(sorter);
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
        productListTable = new javax.swing.JTable();
        headerPanel = new javax.swing.JPanel();
        webshopLabel1 = new javax.swing.JLabel();
        filterByLabel = new javax.swing.JLabel();
        filterComboBox = new javax.swing.JComboBox<>();
        filterTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product list");

        productListTable.setAutoCreateRowSorter(true);
        productListTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        productListTable.setFillsViewportHeight(true);
        productListTable.setFocusable(false);
        productListTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        productListTable.setRowHeight(45);
        productListTable.setRowSelectionAllowed(false);
        productListTable.setShowVerticalLines(false);
        productListTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productListTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        headerPanel.setBackground(new java.awt.Color(102, 112, 123));

        webshopLabel1.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
        webshopLabel1.setForeground(new java.awt.Color(243, 237, 237));
        webshopLabel1.setText(" Webshop");

        filterByLabel.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        filterByLabel.setForeground(new java.awt.Color(243, 237, 237));
        filterByLabel.setText("Filter by:");

        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Product name", "Price", "Category", "Quantity" }));
        filterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterComboBoxItemStateChanged(evt);
            }
        });

        filterTextField.setBackground(new java.awt.Color(243, 237, 237));
        filterTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterTextFieldKeyReleased(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-arrow-pointing-left-32.png"))); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(webshopLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filterByLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(18, 18, 18))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(webshopLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(filterByLabel)
                .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(filterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(backButton)
                .addComponent(jButton1))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void filterTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTextFieldKeyReleased
        String filterText = Pattern.quote(filterTextField.getText());
        tableFilter(filterText);
    }//GEN-LAST:event_filterTextFieldKeyReleased

    private void filterComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterComboBoxItemStateChanged
        filterByColumn = filterComboBox.getSelectedIndex();  
    }//GEN-LAST:event_filterComboBoxItemStateChanged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createCartTableModel();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart(cartTableModel).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void createCartTableModel(){
        try {
            cartTableModel = new CartAndWishlistTableModel(productsToCart);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                                          "Product data cannot be loaded!\n"
                                          + "File not found.",
                                          "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
        
    }
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
    private void createProductTableModel(){
        try {
            productTableModel = new ProductTableModel();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                                          "Product data cannot be loaded!\n"
                                          + "File not found.",
                                          "Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private CartAndWishlistTableModel cartTableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel filterByLabel;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JTextField filterTextField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productListTable;
    private javax.swing.JLabel webshopLabel1;
    // End of variables declaration//GEN-END:variables

public class ProductTableModel extends AbstractTableModel{
        private final String DEFAULT_INPUT_FILENAME = "products";
        private final String[] columnNames;
        private final List<Product> products;
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
                            productsToCart.add(products.get(rowIndex));
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
    
}
