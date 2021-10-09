package echovalley.farm.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name="cartitems")
public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	private Double totalProductPrice;

	private Double totalCartPrice;
	private String itemNumber;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cart_id")
	private Cart cart;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id", nullable=false, updatable=false)
	private Product product;

	public Long getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Double getTotalProductPrice() {
		return totalProductPrice;
	}

	public void setTotalProductPrice(Double totalProductPrice) {

		this.totalProductPrice = totalProductPrice;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Double getTotalCartPrice() {
		return totalCartPrice;
	}

	public void setTotalCartPrice(Double totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}


	
}
