package org.libraryManagement.models;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString

public class Author  {
        private Integer id;
        private String name;
        private String gender;
}


