package com.jongkeun.backend.controller;

import com.jongkeun.backend.dto.PostResponse;
import com.jongkeun.backend.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> toggleBookmark(@PathVariable Long postId) {
        bookmarkService.toggleBookmark(postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}/status")
    public ResponseEntity<Boolean> isBookmarked(@PathVariable Long postId) {
        return ResponseEntity.ok(bookmarkService.isBookmarked(postId));
    }

    @GetMapping
    public ResponseEntity<Page<PostResponse>> getBookmarkedPosts(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        return ResponseEntity.ok(bookmarkService.getBookmarkedPosts(pageable));
    }
}