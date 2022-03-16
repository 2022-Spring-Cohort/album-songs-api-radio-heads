package org.wcci.apimastery.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.Model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
