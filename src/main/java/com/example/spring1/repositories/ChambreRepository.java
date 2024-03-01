package com.example.spring1.repositories;


import com.example.spring1.entities.Chambre;
import com.example.spring1.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findByNumeroChambre(long num);
    List<Chambre> findByBlocNomBloc(String nomBloc);
    long countByTypeCAndBlocIdBloc(TypeChambre typeC, long idBloc);

    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "LEFT JOIN c.reservations r " +
            "WHERE f.nomFoyer = :nomFoyer " +
            "AND c.typeC = :type " +
            "AND r IS NULL")

    List<Chambre> findChambresNonReserveesByNomFoyerAndType(@Param("nomFoyer")String nomFoyer, @Param("type") TypeChambre type);

}
