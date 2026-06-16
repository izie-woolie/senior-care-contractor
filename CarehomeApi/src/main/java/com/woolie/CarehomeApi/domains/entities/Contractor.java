package com.woolie.CarehomeApi.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Contractor extends User{
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String companyName;

    @ElementCollection
//    @CollectionTable(
//            name = "contractor_skills",
//            joinColumns = @JoinColumn(
//                    name = "contractor_id",
//                    referencedColumnName = "id",
//                    foreignKey = @ForeignKey(name = "fk_contractor_skills_users")
//            )
//    )
    private List<String> skills;

    @OneToMany(mappedBy = "contractor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Contractor that = (Contractor) o;
        return Objects.equals(description, that.description) && Objects.equals(companyName, that.companyName) && Objects.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, companyName, skills);
    }
}
