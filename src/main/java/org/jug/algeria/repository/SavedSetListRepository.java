package org.jug.algeria.repository;

import org.jug.algeria.domain.SavedSetList;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface SavedSetListRepository extends CrudRepository<SavedSetList, Long> {
		@Query(value = "SELECT * FROM public.saved_set_list where key_saved_set=?1", nativeQuery = true)
		List<SavedSetList> findByKeySavedSet(long id);
}


