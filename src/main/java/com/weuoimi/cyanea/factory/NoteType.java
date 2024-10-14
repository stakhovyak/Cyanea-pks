package com.weuoimi.cyanea.factory;

import com.weuoimi.cyanea.params.NoteBuilderParams;
import com.weuoimi.cyanea.entity.Noteable;
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
