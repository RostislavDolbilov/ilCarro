package ilcarro.model.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import ilcarro.dto.Status;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/* @author Rostislav Dolbilov */

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyMMMdd")
    @Column(name = "created")
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyMMMdd")
    @Column(name = "updated")
    private LocalDateTime updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
