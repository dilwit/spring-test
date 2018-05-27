package net.dilwit.test.repo;

import net.dilwit.test.model.Move;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveRepo extends JpaRepository<Move, Long> {

}
