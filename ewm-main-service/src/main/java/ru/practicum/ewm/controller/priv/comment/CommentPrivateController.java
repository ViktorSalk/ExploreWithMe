package ru.practicum.ewm.controller.priv.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.dto.comment.CommentDto;
import ru.practicum.ewm.dto.comment.NewCommentDto;
import ru.practicum.ewm.dto.comment.UpdateCommentDto;
import ru.practicum.ewm.model.comment.Comment;
import ru.practicum.ewm.service.comment.CommentService;

import java.util.List;

@RestController
@RequestMapping(path = "/comments")
@RequiredArgsConstructor
@Slf4j
public class CommentPrivateController {
    private final CommentService commentService;

    @PostMapping("/users/{userId}/events/{eventId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addComment(@PathVariable Long userId,
                                 @PathVariable Long eventId,
                                 @Valid @RequestBody NewCommentDto newCommentDto) {
        log.info("POST запрос на добавление комментария: {}", newCommentDto);
        return commentService.createComment(userId, eventId, newCommentDto);
    }

    @PatchMapping("/users/{userId}/{commentId}")
    public CommentDto patchRequestByUser(@PathVariable Long userId, @PathVariable Long commentId,
                                         @Valid @RequestBody UpdateCommentDto updateCommentDto) {

        log.info("PATCH запрос на обновление пользователем с userId = {}  комментария с commentId = {} ", userId, commentId);
        return commentService.patchByUser(userId, commentId, updateCommentDto);
    }

    @GetMapping("/users/{userId}/comments")
    public List<CommentDto> getRequestListUser(@PathVariable Long userId) {
        log.info("GET запрос на получение комментариев пользователя с userId = {} ", userId);
        return commentService.getCommentUser(userId);
    }

    @DeleteMapping("/users/{userId}/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long userId, @PathVariable Long commentId) {
        log.info("DELETE запрос на удаление комментария id = {} пользователем id = {} ", userId, commentId);
        commentService.deleteComment(userId, commentId);
    }

    @GetMapping("/users/{userId}/{commentId}")
    public Comment getComment(@PathVariable Long userId, @PathVariable Long commentId) {
        log.info("GET запрос на получения комментария id = {} пользователем id = {} ", commentId, userId);
        return commentService.getUserCommentByUserAndCommentId(userId, commentId);
    }
}