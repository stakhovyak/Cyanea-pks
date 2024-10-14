package com.weuoimi.cyanea.service;

import com.weuoimi.cyanea.entity.Noteable;

import java.util.Optional;

public interface NotesService {

    Optional<Noteable> saveNote(Noteable note);

    Optional<Noteable> deleteNote(Noteable note);

    Optional<Noteable> updateNote(Noteable note);
}
