package com.weuoimi.cyanea.parsers;

import com.weuoimi.cyanea.factory.NoteType;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TypeDefiner {

    private static final Map<String, NoteType> typeMap = new HashMap<>();

    static {
        typeMap.put("txt", NoteType.TXT_NOTE);
        typeMap.put("md", NoteType.MD_NOTE);
        typeMap.put("org", NoteType.ORG_NOTE);
    }

    public static NoteType determineType(File file) {
        String extension = getFileExtension(file.getName());
        return Optional.ofNullable(typeMap.get(extension))
                .orElseThrow(() -> new UnsupportedOperationException("Unsupported file type"));
    }

    private static String getFileExtension(String fileName) {
        int lastIndexOfDot = fileName.lastIndexOf(".");
        return (lastIndexOfDot == -1) ? "" : fileName.substring(lastIndexOfDot + 1).toLowerCase();
    }
}
