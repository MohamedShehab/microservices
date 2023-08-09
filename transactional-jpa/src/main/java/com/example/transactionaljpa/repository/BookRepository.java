package com.example.transactionaljpa.repository;

import com.example.transactionaljpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "delete from book b where b.book_id = ?1", nativeQuery = true)
    void deleteBook(Long id);

    @Modifying
    @Query(value = "insert into book(book_name,auther_name,price)"
            + " values (?1,?2,?3)", nativeQuery = true)
    void insert(String bookName, String authorName, int price);

    @Modifying
    @Query(value = "update book b set b.auther_name = :authorName where b.book_id = :id", nativeQuery = true)
    void update(@Param("authorName") String authorName, @Param("id") Long id);
}
