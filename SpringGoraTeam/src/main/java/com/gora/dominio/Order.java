package com.gora.dominio;

import javax.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by IntelliJ IDEA.
 * Author : Taras Lehinevych  .
 * Date : 3/12/14 ,
 * Time : 6:32 PM
 * com.gora.dominio
 */

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
   	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	
    private Integer id;

    private String nameOfTheProduct;
    private Double price;
    private Double priceWithTax;
    private Date date;

    public Order() {
    }

    public Order(String name, Double price, Double pricetax, Date date) {
        this.nameOfTheProduct = name;
        this.price = price;
        this.priceWithTax = pricetax;
        this.setDate(date);
    }

    public Integer getId() {
        return id;
    }

    // Only for testing
    protected void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfTheProduct() {
        return nameOfTheProduct;
    }

    public void setNameOfTheProduct(String nameOfTheProduct) {
        this.nameOfTheProduct = nameOfTheProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(Double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public String getDate() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        return dt.format(this.date);
    }

    // This code avoids a reference to an externally mutable object into the internal representation of the object.
    public void setDate(Date date) {
        if (date == null) {
            this.date = null;
        } else{
            this.date = new Date(date.getTime());
        }
    }


    @Override
    public String toString() {
        return "Order [id=" + id + ", nameOfTgeProduct=" + this.getNameOfTheProduct() + ", price=" + this.getPrice() +
                ", priceWithTax=" + this.getPriceWithTax() + ", data=" + this.getDate() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
