package pep.distribuidos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import pep.distribuidos.entidades.Permiso;

public interface PermisoRepositorio extends JpaRepository<Permiso, Integer> {
    Permiso findPermisoByIdPermiso(int idPermiso);
    Permiso findPermisoByCodigo(int codigo);
}
