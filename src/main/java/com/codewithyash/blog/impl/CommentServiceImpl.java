package com.codewithyash.blog.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithyash.blog.entities.Comment;
import com.codewithyash.blog.entities.Post;
import com.codewithyash.blog.exceptions.ResourceNotFoundException;
import com.codewithyash.blog.payloads.CommentDto;
import com.codewithyash.blog.repositories.CommentRepo;
import com.codewithyash.blog.repositories.PostRepo;
import com.codewithyash.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", " Post Id ", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment createdComment = this.commentRepo.save(comment);
		return this.modelMapper.map(createdComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", " Comment Id ", commentId));
		this.commentRepo.delete(comment);

	}

}
