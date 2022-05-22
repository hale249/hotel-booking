package com.hotel.booking.repositories;

import com.hotel.booking.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface CommentRepository extends JpaRepository<Comment, Long> {
    @Modifying
    @Query("update User u set u.deleted=true where u.id = ?1")
    void deleteById(Long id);
}
