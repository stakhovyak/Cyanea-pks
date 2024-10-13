package com.weuoimi.cyanea.factory;

import com.weuoimi.cyanea.NoteBuilderParams;
import com.weuoimi.cyanea.NoteCreators;
import com.weuoimi.cyanea.Noteable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum NoteType {
    TXT_NOTE,
    MD_NOTE,
    ORG_NOTE;

    public Noteable create(NoteBuilderParams params) {
        return NoteCreators.getNoteCreator(this).apply(params);
    }
}
