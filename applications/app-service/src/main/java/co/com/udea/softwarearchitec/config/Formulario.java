package co.com.udea.softwarearchitec.config;
import co.com.udea.softwarearchitec.model.product.Product;
import co.com.udea.softwarearchitec.usecase.database.Persistencia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Formulario {
    private JPanel Main;
    private JTextField textName;
    private JTextField textPrice;
    private JTextField textQty;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTextField textpid;
    private JButton searchButton;

    public ProductController inventario;
    public Persistencia BD;

    public Product pro;



    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventario de Productos");
        frame.setContentPane(new Formulario().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public Formulario() {
        BD.Connect();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pro.setName(textName.getText());
                pro.setPrice(textPrice.getText());
                pro.setQty(textQty.getText());
                inventario.createProduct(pro);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pid = textpid.getText();
                pro = inventario.searchProduct(pid);

                try {
                    if(pro!=null)
                    {
                        textName.setText(pro.getName());
                        textPrice.setText(pro.getPrice());
                        textQty.setText(pro.getQty());
                    }
                    else
                    {
                        textName.setText("");
                        textPrice.setText("");
                        textQty.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid Product ID");
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pro.setName(textName.getText());
                pro.setPrice(textPrice.getText());
                pro.setQty(textQty.getText());
                String pid = textpid.getText();
                inventario.updateProduct(pro, pid);

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bid;
                bid = textpid.getText();
                inventario.deleteProduct(bid);

            }
        });
    }


}
