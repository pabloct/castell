package com.tecsup.castell.controller.archivo;

import com.tecsup.castell.model.ArchivoPrueba;
import java.util.List;

public interface ArchivoService {
    List<ArchivoPrueba> allArchivo();
    
    ArchivoPrueba findArchivo(Long id);
    
    void save(ArchivoPrueba archivo);
    
    void delete(Long id);
    
    void changeEstado(Long id);
}


