package by.itstep.roman.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Reader")
public class Reader {
	
	@Id
	@Column(name="reader_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int readerId;
	
	@Column(name="reader_name")
	private String readerName;
	
	@Column(name="reader_age")
	private int readerAge;
	
	@ManyToMany(fetch = FetchType.LAZY) //
	@JoinTable(name = "reader_books", joinColumns = { @JoinColumn(name = "reader_id") },
	inverseJoinColumns = {@JoinColumn(name = "book_id") })
	private List<Book> readerBooks = new ArrayList<Book>();
	
	public int getReaderId() {
		return readerId;
	}
	public List<Book> getReaderBooks() {
		return readerBooks;
	}
	public void setReaderBooks(List<Book> readerBooks) {
		this.readerBooks = readerBooks;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public int getReaderAge() {
		return readerAge;
	}
	public void setReaderAge(int readerAge) {
		this.readerAge = readerAge;
	}
	
	
	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", readerName=" + readerName + ", readerAge=" + readerAge
				+ ", readerBooks=" + readerBooks + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + readerAge;
		result = prime * result + ((readerBooks == null) ? 0 : readerBooks.hashCode());
		result = prime * result + readerId;
		result = prime * result + ((readerName == null) ? 0 : readerName.hashCode());
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
		Reader other = (Reader) obj;
		if (readerAge != other.readerAge)
			return false;
		if (readerBooks == null) {
			if (other.readerBooks != null)
				return false;
		} else if (!readerBooks.equals(other.readerBooks))
			return false;
		if (readerId != other.readerId)
			return false;
		if (readerName == null) {
			if (other.readerName != null)
				return false;
		} else if (!readerName.equals(other.readerName))
			return false;
		return true;
	}
	public Reader() {
		// TODO Auto-generated constructor stub
	}
	

}
