package ilcarro.model.app.car;

import ilcarro.dto.car.Comments;
import ilcarro.model.Base;
import ilcarro.model.app.user.UserEntity;
import lombok.*;

import javax.persistence.*;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "comment")

public class CommentsEntity extends Base {
    @OneToOne
    private UserEntity user;

    private String comment;

    @ManyToOne
    private CarEntity car;

    public CommentsEntity(Comments comments) {
        this.user = comments.getUser().toUserEntity();
        this.comment = comments.getComment();
    }

    public Comments toComments(){
        return new Comments(user.toUserDto(), comment);
    }
}
