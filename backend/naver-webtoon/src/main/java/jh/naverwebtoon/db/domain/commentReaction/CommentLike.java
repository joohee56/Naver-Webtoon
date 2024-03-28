package jh.naverwebtoon.db.domain.commentReaction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jh.naverwebtoon.db.domain.Comment;
import jh.naverwebtoon.db.domain.Member;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@IdClass(CommentReactionPK.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLike {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public static CommentLike create(Member member, Comment comment) {
        CommentLike commentLike = new CommentLike();
        commentLike.member = member;
        commentLike.comment = comment;
        return commentLike;
    }
}