package ilcarro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import ilcarro.dto.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/* @author Rostislav Dolbilov */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

@MappedSuperclass
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyMMMdd")
    @Column(name = "created")
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyMMMdd")
    @Column(name = "updated")
    private LocalDateTime updated;


}
