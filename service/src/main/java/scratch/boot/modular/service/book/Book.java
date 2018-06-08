package scratch.boot.modular.service.book;

import lombok.*;
import scratch.boot.modular.service.audit.AuditEnabledEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * @author Rashidi Zin
 */
@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Book extends AuditEnabledEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @NotBlank
    private String author;

    @NonNull
    @NotBlank
    private String title;

}
