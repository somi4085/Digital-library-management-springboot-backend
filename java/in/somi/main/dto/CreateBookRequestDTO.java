package in.somi.main.dto;

import in.somi.main.entity.Author;
import in.somi.main.entity.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequestDTO {
	
	private String title;
	private String description;
	private String isbn;
	private Integer publicationYear;
	private Integer copiesTotal;
	private Author author;
	private Category category;
	private Integer copiesAvaiable;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategoryId(Category category) {
		this.category = category;
	}
	public Integer getCopiesAvaiable() {
		return copiesAvaiable;
	}
	public void setCopiesAvaiable(Integer copiesAvaiable) {
		this.copiesAvaiable = copiesAvaiable;
	}
	
	
}
