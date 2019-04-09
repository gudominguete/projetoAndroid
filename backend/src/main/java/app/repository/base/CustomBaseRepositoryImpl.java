package app.repository.base;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class CustomBaseRepositoryImpl<T, ID> implements CustomBaseRepository<T, ID> {

	// Implementar aqui métodos genéricos a serem disponibilizados na BaseRepository.
}
