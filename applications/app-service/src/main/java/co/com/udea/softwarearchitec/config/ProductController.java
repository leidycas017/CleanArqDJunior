package co.com.udea.softwarearchitec.config;
import co.com.udea.softwarearchitec.model.product.Product;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductController {

    Connection con;
    PreparedStatement pst;
    Product pro;

    public void createProduct(Product pro) {
        String name, price, qty;
        name=pro.getName();
        price=pro.getPrice();
        qty=pro.getQty();

        try {
            pst = con.prepareStatement("insert into products(pname,price,qty)values(?,?,?)");
            pst.setString(1, name);
            pst.setString(2, price);
            pst.setString(3, qty);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Producto creado correctamente");

        }

        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    public Product searchProduct(String pid) {
        Product prodFind = new Product();
        try {
            pst = con.prepareStatement("select pname,price,qty from products where pid = ?");
            pst.setString(1, pid);
            ResultSet rs = pst.executeQuery();

            if(rs.next()==true)
            {
                String name = rs.getString(1);
                String price = rs.getString(2);
                String qty = rs.getString(3);

                prodFind.setName(name);
                prodFind.setPrice(price);
                prodFind.setQty(qty);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Product ID");
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return prodFind;
    }

    public void updateProduct(Product pro, String pid) {
        String name, price, qty;
        name=pro.getName();
        price=pro.getPrice();
        qty=pro.getQty();

        try {
            pst = con.prepareStatement("update products set pname = ?,price = ?,qty = ? where pid = ?");
            pst.setString(1, name);
            pst.setString(2, price);
            pst.setString(3, qty);
            pst.setString(4, pid);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");

        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }

    public void deleteProduct(String bid) {

        try {
            pst = con.prepareStatement("delete from products  where pid = ?");
            pst.setString(1, bid);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto Borrado");
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
    }



}
