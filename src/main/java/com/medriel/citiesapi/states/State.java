package com.medriel.citiesapi.states;


import com.medriel.citiesapi.Country;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

  // 1st
  @Column(name = "pais")
  private Integer countryId;

    // 2nd - @ManyToOne
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public List<Integer> getDdd() {
        return ddd;
    }


  public Integer getCountryId() {
      return countryId;
  }
}
