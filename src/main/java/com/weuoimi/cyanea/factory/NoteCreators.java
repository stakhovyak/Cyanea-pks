package com.weuoimi.cyanea.factory;

import com.weuoimi.cyanea.entity.Group;
import com.weuoimi.cyanea.entity.Note;
import com.weuoimi.cyanea.entity.Noteable;
import com.weuoimi.cyanea.params.NoteBuilderParams;
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
                    .title(Optional.ofNullable(params.getTitle()).orElseGet(() -> parser.parseTitle(params.getFilePath())))
                    .filePath(params.getFilePath().toString())
                    .contents(parser.parseContents(params.getFilePath())) // TODO: add conversion to html logic
                    .group(params.getGroup().orElseGet(() -> Group.builder().name("empty group").build())) // TODO: handle empty group!
                    .build();
        });
        noteCreationMap.put(NoteType.MD_NOTE, params -> {
            var parser = new MdParser();
            return Note.builder()
                    .title(Optional.ofNullable(params.getTitle()).orElseGet(() -> parser.parseTitle(params.getFilePath())))
                    .filePath(params.getFilePath().toString())
                    .contents(parser.parseContents(params.getFilePath()))
                    .group(params.getGroup().orElseGet(() -> Group.builder().name("empty group").build()))
                    .build();
        });
        noteCreationMap.put(NoteType.ORG_NOTE, params -> {
            var parser = new OrgParser();
            return Note.builder()
                    .title(Optional.ofNullable(params.getTitle()).orElseGet(() -> parser.parseTitle(params.getFilePath())))
                    .filePath(params.getFilePath().toString())
                    .contents(parser.parseContents(params.getFilePath()))
                    .group(params.getGroup().get())
                    .build();
        });
    }

    public static Function<NoteBuilderParams, Noteable> getNoteCreator(NoteType noteType) {
        return noteCreationMap.getOrDefault(noteType, params -> {
           throw new UnsupportedOperationException("Unsupported note type: " + params);
        });
    }
}
