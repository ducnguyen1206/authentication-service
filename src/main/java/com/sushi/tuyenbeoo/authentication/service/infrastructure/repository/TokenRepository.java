package com.sushi.tuyenbeoo.authentication.service.infrastructure.repository;

import com.sushi.tuyenbeoo.authentication.service.domain.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<UserToken, Long> {

  @Query(value = """
      select t from user_token t inner join user u\s
      on t.user_id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """, nativeQuery = true)
  List<UserToken> findAllValidTokenByUser(Long id);

  Optional<UserToken> findByToken(String token);
}
