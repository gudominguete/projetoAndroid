package app.repository.base;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomBaseRepository<T, ID> {

	// Declarar aqui métodos genéricos a serem disponibilizados na BaseRepository.
}
