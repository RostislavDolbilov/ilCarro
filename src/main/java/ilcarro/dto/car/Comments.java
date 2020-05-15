package ilcarro.dto.car;

import ilcarro.dto.user.UserDto;
import ilcarro.model.app.car.CommentsEntity;
import lombok.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode

public class Comments {
    private UserDto user;
    private String comment;

    public CommentsEntity toCommentsEntity(){
        CommentsEntity commentsEntity = new CommentsEntity();
        commentsEntity.setUser(user.toUserEntity());
        commentsEntity.setComment(comment);
        return commentsEntity;
    }
}
