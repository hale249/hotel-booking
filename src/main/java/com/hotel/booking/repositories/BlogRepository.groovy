package com.hotel.booking.repositories

import com.hotel.booking.entities.Blog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BlogRepository  extends JpaRepository<Blog, Long> {
    @Modifying
    @Query("update User u set u.deleted=true where u.id = ?1")
    void deleteById(Long id);
}
