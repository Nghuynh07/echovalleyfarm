package echovalley.farm.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="carts")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private Date date;
	private String cartSession;
	private Double totalCartPrice;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CartItem> items = new ArrayList<>();

	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	public Cart() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDate() {
		return date;
	}

	public int getItemsNumber() {
		return this.items.size();
	}
	public List<CartItem> getItems() {
		return items;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}


	public void setTotalCartPrice(Double totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}
	public String getCartSession() {
		return cartSession;
	}
	public void setCartSession(String cartSession) {
		this.cartSession = cartSession;
	}
	public Double getTotalCartPrice() {
		Double total = 0.0;
		for(CartItem item : items ) {
			total+= item.getProduct().getPrice() * item.getQuantity();
		}
		this.totalCartPrice = total;
		return this.totalCartPrice;
	}


}
