package io.github.seondongpyo.springboard.web.entity;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    private String createdBy;
    private String lastModifiedBy;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
