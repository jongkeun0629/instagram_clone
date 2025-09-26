package com.jongkeun.backend.repository;

import com.jongkeun.backend.entity.Bookmark;
import com.jongkeun.backend.entity.Post;
import com.jongkeun.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByUserAndPost(User user, Post post);

    boolean existsByUserAndPost(User user, Post post);

    @Query("SELECT b.post FROM Bookmark b WHERE b.user = :user ORDER BY b.createdAt DESC")
    Page<Post> findBookmarkedPostsByUser(@Param("user") User user, Pageable pageable);
}