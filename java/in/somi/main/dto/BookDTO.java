package in.somi.main.dto;

import in.somi.main.entity.Author;
import in.somi.main.entity.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	private Long id;
	private String titile;
	private String isbn;
	private Integer publicationYear;
	private Integer copiesTotal;
	private Integer copiesAvailble;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	private String descriprion;
	
	public String getDescriprion() {
		return descriprion;
	}
	public void setDescriprion(String descriprion) {
		this.descriprion = descriprion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	public Integer getCopiesTotal() {
		return copiesTotal;
	}
	public void setCopiesTotal(Integer copiesTotal) {
		this.copiesTotal = copiesTotal;
	}
	public Integer getCopiesAvailble() {
		return copiesAvailble;
	}
	public void setCopiesAvailble(Integer copiesAvailble) {
		this.copiesAvailble = copiesAvailble;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
