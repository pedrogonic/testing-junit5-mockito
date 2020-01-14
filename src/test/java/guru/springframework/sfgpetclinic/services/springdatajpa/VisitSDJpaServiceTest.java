package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService visitSDJpaService;

    @Test
    void findAll() {
        Visit visit = new Visit();

        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = visitSDJpaService.findAll();

        verify(visitRepository).findAll();

        assertEquals(1, foundVisits.size());

    }

    @Test
    void findById() {
        Visit visit = new Visit();

        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

        Visit foundVisit = visitSDJpaService.findById(1L);

        verify(visitRepository).findById(anyLong());

        assertNotNull(foundVisit);
    }

    @Test
    void save() {
        Visit visit = new Visit();

        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = visitSDJpaService.save(visit);

        verify(visitRepository).save(any(Visit.class));

        assertNotNull(savedVisit);
    }

    @Test
    void delete() {
        visitSDJpaService.delete(new Visit());

        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        visitSDJpaService.deleteById(1L);

        verify(visitRepository).deleteById(anyLong());
    }
}