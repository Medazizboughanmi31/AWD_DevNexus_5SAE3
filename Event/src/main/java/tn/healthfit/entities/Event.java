package tn.healthfit.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int id ;

    String name ;

    @Temporal(TemporalType.DATE)
    Date dateEvent ;

    String place ;
    String description ;
    int nbMaxParticipants ;
    @ElementCollection
    private Set<Integer> EventTickets = new HashSet<>();

}
