package net.dilwit.test.repo;

import net.dilwit.test.model.Move;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {

}
