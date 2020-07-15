package lk.rupavahini.PPUManagement.asset.sponser.dao;


import lk.rupavahini.PPUManagement.asset.sponser.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorDao extends JpaRepository<Sponsor, Integer> {
    Sponsor findFirstByOrderByIdDesc();
}
