package com.weuoimi.cyanea;

import com.weuoimi.cyanea.entity.Note;
import com.weuoimi.cyanea.factory.NoteType;
import com.weuoimi.cyanea.parsers.MdParser;
import com.weuoimi.cyanea.parsers.OrgParser;
import com.weuoimi.cyanea.parsers.TxtParser;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class NoteCreators {

    private static final Map<NoteType, Function<NoteBuilderParams, Noteable>> noteCreationMap = new EnumMap<>(NoteType.class);

    static {
        noteCreationMap.put(NoteType.TXT_NOTE, params -> {
            var parser = new TxtParser();
            return Note.builder()
                    .title(Optional.ofNullable(params.getTitle()).orElseGet(() -> parser.getTitle()))
                    .filePath(params.getFilePath())
                    .contents(parser.getContents()) // TODO: add convertion to html logic
                    .group(params.getGroup())
        });
        noteCreationMap.put(NoteType.MD_NOTE, params -> new MdParser().parse(params));
        noteCreationMap.put(NoteType.ORG_NOTE, params -> new OrgParser().parse(params));
    }

    public static Function<NoteBuilderParams, Noteable> getNoteCreator(NoteType noteType) {
        return noteCreationMap.getOrDefault(noteType, params -> {
           throw new UnsupportedOperationException("Unsupported note type: " + params);
        });
    }
}
