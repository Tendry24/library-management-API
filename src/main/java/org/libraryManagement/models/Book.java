package org.libraryManagement.models;

import lombok.*;


import java.sql.Timestamp;
import java.time.LocalDateTime;


@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString

public class Book {
    private int id;
    private String bookName;
    private Integer pageNumbers;
    private String topic;
    private Timestamp releaseDate;
    private String authorId;
}
