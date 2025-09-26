package com.jongkeun.backend.service;

import com.jongkeun.backend.dto.PostResponse;
import com.jongkeun.backend.entity.Bookmark;
import com.jongkeun.backend.entity.Post;
import com.jongkeun.backend.entity.User;
import com.jongkeun.backend.exception.ResourceNotFoundException;
import com.jongkeun.backend.repository.BookmarkRepository;
import com.jongkeun.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final PostRepository postRepository;
    private final AuthenticationService authenticationService;

    public void toggleBookmark(Long postId) {
        User currentUser = authenticationService.getCurrentUser();
        Post post = postRepository.findByIdAndNotDeleted(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));

        bookmarkRepository.findByUserAndPost(currentUser, post)
                .ifPresentOrElse(
                        bookmarkRepository::delete,
                        () -> bookmarkRepository.save(Bookmark.builder()
                                .user(currentUser)
                                .post(post)
                                .build()
                        )
                );
    }

    @Transactional(readOnly = true)
    public boolean isBookmarked(Long postId) {
        User currentUser = authenticationService.getCurrentUser();
        Post post = postRepository.findByIdAndNotDeleted(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));

        return bookmarkRepository.existsByUserAndPost(currentUser, post);
    }

    @Transactional(readOnly = true)
    public Page<PostResponse> getBookmarkedPosts(Pageable pageable) {
        User currentUser = authenticationService.getCurrentUser();
        Page<Post> bookmarkedPosts = bookmarkRepository.findBookmarkedPostsByUser(currentUser, pageable);

        return bookmarkedPosts.map(PostResponse::fromEntity);
    }
}
