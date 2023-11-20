package com.spark.lms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.lms.model.Book;
import com.spark.lms.model.Category;
import com.spark.lms.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private IssuedBookService issuedBookService;
	
	public Long getTotalCount() {
		return bookRepository.count();
	}

	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	
	public Book get(Long id) {
		return bookRepository.findById(id).get();
	}
	
	public Book getByTag(String tag) {
		return bookRepository.findByTag(tag);
	}
	
	public List<Book> get(List<Long> ids) {
		return bookRepository.findAllById(ids);
	}
	
	public List<Book> getByCategory(Category category) {
		return bookRepository.findByCategory(category);
	}

	public List<Book> getAvailableBookByCategory(Category category) {
		return bookRepository.findByCategoryAndRemainGreaterThan(category, 0);
	}
	
	public Book addNew(Book book) {
		book.setCreateDate(new Date());
		book.setRemain(25);
		return bookRepository.save(book);
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	public boolean hasUsage(Book book) {
		return issuedBookService.getCountByBook(book)>0;
	}
}
