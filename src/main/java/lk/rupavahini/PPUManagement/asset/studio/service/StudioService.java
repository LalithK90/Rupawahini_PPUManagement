package lk.rupavahini.PPUManagement.asset.studio.service;

import lk.rupavahini.PPUManagement.asset.episode.dao.EpisodeDao;
import lk.rupavahini.PPUManagement.asset.episode.entty.Episode;
import lk.rupavahini.PPUManagement.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "studio" )
public class StudioService implements AbstractService<Episode, Integer> {
    private final EpisodeDao studiodao;

    public StudioService(EpisodeDao studiodao) {
        this.studiodao = studiodao;
    }


    public List<Episode> findAll() {
        return studiodao.findAll();
    }

    public Episode findById(Integer id) {
        return studiodao.getOne(id);
    }

    public Episode persist(Episode episode) {
        return studiodao.save(episode);
    }

    public boolean delete(Integer id) {
        studiodao.deleteById(id);
        return false;
    }

    public List<Episode> search(Episode episode) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Episode> SponserExample = Example.of(episode, matcher);
        return studiodao.findAll(SponserExample);
    }

    public Episode lastSponsor(){
        return studiodao.findFirstByOrderByIdDesc();
    }
}
