package security.model.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import security.dto.Status;

import javax.persistence.*;
import java.time.LocalDate;

/* @author Rostislav Dolbilov */

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyMMMdd")
    @Column(name = "created")
    private LocalDate created;

    @JsonFormat(pattern = "yyyMMMdd")
    @Column(name = "updated")
    private LocalDate updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
