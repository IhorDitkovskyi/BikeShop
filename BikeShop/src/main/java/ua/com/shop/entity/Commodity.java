package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import ua.com.shop.entity.Cart;

@Entity
public class Commodity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double price;

	@ManyToOne(fetch = FetchType.LAZY)
	private Material material;
	
	@ManyToMany
	@JoinTable(name="cart_commodity", joinColumns=@JoinColumn(name="id_commodity"), inverseJoinColumns=@JoinColumn(name="id_cart"))
	private List<Cart> carts;

	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	private Color color;

	@ManyToOne(fetch = FetchType.LAZY)
	private Brand brand;

	private int version;

	public Commodity() {
	}

	public Commodity(double price, Material material, Category category, Color color, Brand brand) {
		super();
		this.price = price;
		this.material = material;
		this.category = category;
		this.color = color;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public List<Cart> getCarts() {
		return carts;
	}


	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
