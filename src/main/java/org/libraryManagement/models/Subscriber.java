package org.libraryManagement.models;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString

public class Subscriber extends User{
    private String reference;

    public Subscriber(int id, String name, String reference) {
        super(id, name);
        this.reference = reference;
    }
}
