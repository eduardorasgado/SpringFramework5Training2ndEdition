package com.eduardocode.jasonviewerapi.services;

import com.eduardocode.jasonviewerapi.model.Chapter;
import com.eduardocode.jasonviewerapi.repository.ChapterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * <h1>ChapterServiceImpl</h1>
 * Implementacion de la interfaz de capitulos para realizar transacciones entre el repositorio de
 * capitulos y el frontend
 *
 * @author Eduardo Rasgado Ruiz
 * @version 1.0
 * @since april/2019
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ChapterServiceImpl implements IChapterService {

    private ChapterRepository chapterRepository;

    public ChapterServiceImpl(ChapterRepository chapterRepository){
        this.chapterRepository = chapterRepository;
    }
    /**
     * Metodo que permite la creacion de un capitulo nuevo
     *
     * @param chapter capitulo a crear
     * @return Capitulo creado
     */
    @Override
    public Chapter create(Chapter chapter) {
        return this.chapterRepository.save(chapter);
    }

    /**
     * Metodo para actualizar un capitulo ya existente
     *
     * @param chapter Capitulo a actualizar
     * @return Capitulo ya actualizado
     */
    @Override
    public Chapter update(Chapter chapter) {
        return this.chapterRepository.save(chapter);
    }

    /**
     * Metodo para eliminar un capitulo a partir de una instancia de este
     *
     * @param chapter capitulo a eliminar
     * @return booleano que representa si ya se ha eliminado o no el capitulo
     */
    @Override
    public boolean delete(Chapter chapter) {
        if(this.chapterRepository.findById(chapter.getId()).isPresent()) {
            this.chapterRepository.delete(chapter);
            return true;
        }
        return false;
    }

    /**
     * Metodo para devolver todos los capitulos existentes en la aplicacion
     *
     * @return Devuelve una lista de capitulos {@code List<Chapter>}
     */
    @Override
    public List<Chapter> getAll() {
        return this.chapterRepository.findAll();
    }

    /**
     * Metodo para buscar y devolver un capitulo dado su id
     *
     * @param id string con el id del capitulo deseado
     * @return Un capitulo de una serie
     */
    @Override
    public Chapter findById(String id) {
        Optional<Chapter> chapterContainer = this.chapterRepository.findById(id);
        if(chapterContainer.isPresent()) {
            return chapterContainer.get();
        }
        return null;
    }
}
